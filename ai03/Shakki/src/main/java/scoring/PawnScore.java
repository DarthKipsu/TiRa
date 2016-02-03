
package scoring;

public class PawnScore implements PieceScore {
    
    private static final double BASE_SCORE = 1;
    
    private int rookCount = 0;
    private Coordinate[] coordinates = new Coordinate[7];

    public void addPiece(int x, int y) {
        addRook(++rookCount, x, y);
    }

    public double getScore() {
        double score = rookCount * BASE_SCORE;
        return score;
    }

    private void addRook(int id, int x, int y) {
        coordinates[id] = new Coordinate(x, y);
    }
}
