
package scoring;

public class QueenScore implements PieceScore {
    
    private static final double BASE_SCORE = 9;
    
    private boolean hasQueen = false;
    private Coordinate coordinate = null;

    public void addPiece(int x, int y) {
        hasQueen = true;
        coordinate = new Coordinate(x, y);
    }

    public double getScore() {
        double score = 0;
        if (hasQueen) score += BASE_SCORE;
        return score;
    }
}
