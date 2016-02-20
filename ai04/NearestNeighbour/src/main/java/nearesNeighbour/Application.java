package nearesNeighbour;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    /**
     * Toteuta perseptronialgoritmi luokkaan Perceptron. Sen jälkeen voit
     * kokeilla eri numeroparien erottelua muuttamalla main-metodissa muuttujien
     * targetChar ja oppositeChar arvoja.
     *
     * @param args
     */
    public static void main(String[] args) {
        int steps = 4000;

        if (args.length > 0) {
            steps = Integer.parseInt(args[0]);
        }

        System.out.println("Reading images...");
        List<Image> images = readImages();
        testInput(images); //tekee testikuvan (test100.bmp) projektin juureen 

        NearestNeighbour nn = new NearestNeighbour(images);
        System.out.println("Nearest neighbour learning algorithm, " + steps + " iterations...");
        double error = nn.testClassifier();
        System.out.println("Failure rate (all digits): " + ((1-error) * 100) + " %");
        System.out.println("Failure with 3,5: " + ((1-nn.testClassifierWith(3, 5)) * 100) + " %");
    }

    // lukee x- ja y-tiedostot
    static List<Image> readImages() {
        String xfilename = "mnist-x.data";
        String yfilename = "mnist-y.data";
        List<Image> images = new ArrayList<Image>();
        try {
            File xfile = new File(NearestNeighbour.class.getClassLoader().getResource(xfilename).getFile());
            File yfile = new File(NearestNeighbour.class.getClassLoader().getResource(yfilename).getFile());
            //Scanner xscanner = new Scanner(new File(xfilename));
            //Scanner yscanner = new Scanner(new File(yfilename));
            Scanner xscanner = new Scanner(xfile);
            Scanner yscanner = new Scanner(yfile);
            while (xscanner.hasNextLine()) {
                Image i = new Image();
                String line = xscanner.nextLine();
                int characterClass = yscanner.nextInt();
                String splitarr[] = line.split(",");
                i.vec = new double[28 * 28];
                int j = 0;
                for (String s : splitarr) {
                    if (s.equals("1")) {
                        i.vec[j++] = 1.0;
                    } else {
                        i.vec[j++] = -1.0;
                    }
                }
                i.characterClass = characterClass;
                images.add(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return images;
    }

    /**
     * Otetaan sata ensimmäistä, järjestetään characterClassin mukaan, ja
     * piirretään iso kuva, josta voi tarkistaa, että samat numeroa esittavat
     * kuvat tulevat peräkkäin.
     *
     * @param images
     */
    static void testInput(List<Image> images) {

        List<Image> i100 = new ArrayList<Image>();
        for (int i = 0; i < 100; ++i) {
            i100.add(images.get(i));
        }

        Collections.sort(i100);

        BufferedImage bi = new BufferedImage(28 * 100, 28,
                BufferedImage.TYPE_3BYTE_BGR);

        for (int i = 0; i < 100; ++i) {
            for (int y = 0; y < 28; ++y) {
                for (int x = 0; x < 28; ++x) {
                    int ind = y * 28 + x;
                    bi.setRGB(x + i * 28, y,
                            (i100.get(i).vec[ind] > 0.5
                            ? 0 : 0xffffff));
                }
            }
        }
        try {
            ImageIO.write(bi, "BMP", new File("test100.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Piirretään kuva, jossa 28 x 28 painovektorin arvot kuvataan
     * harmaasavyiksi.
     *
     * @param w
     */
    static void visualizeWeights(double[] w) {

        BufferedImage bi = new BufferedImage(28, 28,
                BufferedImage.TYPE_3BYTE_BGR);

        for (int y = 0; y < 28; ++y) {
            for (int x = 0; x < 28; ++x) {
                int ind = y * 28 + x;
                float w01 = .01f + .98f / (1.0f + (float) Math.exp(-w[ind]));
                bi.setRGB(x, y, (new Color(w01, w01, w01)).getRGB());
            }
        }
        try {
            ImageIO.write(bi, "BMP", new File("weights.bmp"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
};
