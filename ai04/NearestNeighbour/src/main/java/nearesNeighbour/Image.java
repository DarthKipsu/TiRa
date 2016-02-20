package nearesNeighbour;

public class Image implements Comparable<Image> {

    public double[] vec;
    public int characterClass;

    public int compareTo(Image i1) {
        return this.characterClass - i1.characterClass;
    }

    public int distanceTo(Image il) {
        int diff = 0;
        for (int i=0; i<vec.length; i++) {
            if (il.vec[i] != vec[i]) diff++;
        }
        return diff;
    }
}
