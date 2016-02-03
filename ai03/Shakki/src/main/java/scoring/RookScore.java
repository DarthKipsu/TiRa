
package scoring;

public class RookScore implements PieceScore {
    
    private static final double BASE_SCORE = 5;
    private static final double SYNERGETIC_BONUS = 5;
    
    private boolean[] hasRook = new boolean[3];
    private Coordinate[] coordinates = new Coordinate[3];

    public void addPiece(int x, int y) {
        int id = hasRook[1] ? 2 : 1;
        addRook(id, x, y);
    }

    public double getScore() {
        double score = 0;
        if (hasRook[1]) score += BASE_SCORE;
        if (hasRook[2]) score += BASE_SCORE + SYNERGETIC_BONUS;
        return score;
    }

    private void addRook(int id, int x, int y) {
        hasRook[id] = true;
        coordinates[id] = new Coordinate(x, y);
    }
}
