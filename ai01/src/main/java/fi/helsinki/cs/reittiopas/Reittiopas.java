package fi.helsinki.cs.reittiopas;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class Reittiopas {

    /**
     * Toteuta leveyssuuntainen haku. Palauta reitti taaksepäin linkitettynä
     * listana Tila-olioita, joista ensimmäinen osoittaa maalipysäkkiin ja
     * jokainen tuntee pysäkin ja tilan, josta kyseiseen tilaan päästiin
     * (viimeisen solmun Pysäkki on lähtöpysäkki ja edellinen tila on null).
     *
     * Voit selvittää pysäkin naapuripysäkit, eli pysäkit joihin pysäkiltä on
     * suora yhteys, kutsumalla pysäkin getNaapurit() -metodia.
     *
     * @param lahto Lahtopysakin koodi
     * @param maali Maalipysakin koodi
     * @return Tila-olioista koostuva linkitetty lista maalista lähtötilaan
     */
    public Tila haku(Pysakki lahto, Pysakki maali) {
        Deque<Tila> tilat = new ArrayDeque<>();
        tilat.addLast(new Tila(lahto, null));
        while (tilat.peekFirst() != null) {
            Tila tila = tilat.pollFirst();
            Pysakki pysakki = tila.getPysakki();
            if (pysakki.isNotVisited()) {
                pysakki.visit();
                if (pysakki.equals(maali)) {
                    return tila;
                }
                Collection<Pysakki> naapurit = pysakki.getNaapurit();
                for (Pysakki naapuri : naapurit) {
                    if (naapuri.isNotVisited()) {
                        tilat.addLast(new Tila(naapuri, tila));
                    }
                }
            }
        }
        return null;
    }
}
