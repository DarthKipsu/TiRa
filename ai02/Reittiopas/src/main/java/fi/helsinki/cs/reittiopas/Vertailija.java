package fi.helsinki.cs.reittiopas;

import fi.helsinki.cs.reittiopas.logiikka.Pysakki;
import fi.helsinki.cs.reittiopas.logiikka.Tila;
import java.util.Comparator;

/**
 *
 * @author kumikumi
 */
public class Vertailija implements Comparator<Tila> {

    private final Pysakki maali;
    private final int x1;
    private final int y1;

    public Vertailija(Pysakki maaliPysakki) {
        this.maali = maaliPysakki;
        x1 = maali.getX();
        y1 = maali.getY();
    }

    /**
     * Toteuta metodi heuristiikka siten, että se palauttaa parametrina annetun
     * pysäkin ja tämän luokan sisällä määritellyn maalipysäkin koordinaattien
     * välisen euklidisen etäisyyden jaettuna luvulla 260. Oletamme siis, että
     * ratikka liikkuu keskimäärin 260 koordinaattipistettä minuutissa, ja
     * arvioimme tässä metodissa maalipisteeseen jäljellä olevan ajan.
     *
     * @param pysakki
     * @return Arvioitu jäljelläoleva aika
     */
    public double heuristiikka(Pysakki pysakki) {
        int x2 = pysakki.getX();
        int y2 = pysakki.getY();
        double etaisyys = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return etaisyys / 260;
    }

    /**
     * Toteuta metodi compare siten, että se palauttaa jonkin positiivisen luvun
     * silloin kun Tilan t1 aika+heuristiikka on suurempi kuin Tilan t2
     * aika+heuristiikka, ja vastaavasti jonkin negatiivisen luvun, kun Tilan t2
     * aika+heuristiikka on suurempi kuin Tilalla t1. Palauta 0 jos molemmilla
     * solmuista aika+heuristiikka on yhtä suuri.
     *
     * Tätä metodia käytetään tilojen järjestämiseen A*-haussa käytettävän
     * prioriteettijonon sisällä, jolloin jonosta saadaan ulos aina se tila,
     * joka todennäköisimmin on osa lyhintä reittiä maaliin.
     *
     * @param t1
     * @param t2
     * @return vertailun tulos
     */
    @Override
    public int compare(Tila t1, Tila t2) {
        double t1Aika = t1.getNykyinenAika() + heuristiikka(t1.getPysakki());
        double t2Aika = t2.getNykyinenAika() + heuristiikka(t2.getPysakki());
        return (int)(t1Aika - t2Aika);
    }

}
