package perceptron;

import java.util.List;
import java.util.Random;

/**
 *
 * @author mikko
 */
public class Perceptron {

    private final List<Image> images;

    public Perceptron(List<Image> images) {
        this.images = images;
    }

    /**
     * Täydennä perseptroni-toteutus tähän.
     * @param targetChar
     * @param oppositeChar
     * @param steps
     * @return 
     */
    public double[] train(int targetChar, int oppositeChar, int steps) {
        Random rand = new Random();
        double[] w = new double[28 * 28];

        for (int step = 0; step < steps;) {
            int example = rand.nextInt(5000); // pick random example

            // only care about the two classes
            if (images.get(example).characterClass != targetChar
                    && images.get(example).characterClass != oppositeChar) {
                continue;
            }
            step++;

            //...
        }
        return w;
    }
}
