
package scoring;

public class KnightScore implements PieceScore {
    
    private static final double BASE_SCORE = 3;
    private static final double SYNERGETIC_BONUS = 3;
    
    private boolean[] hasKnight = new boolean[3];
    private Coordinate[] coordinates = new Coordinate[3];

    public void addPiece(int x, int y) {
        int id = hasKnight[1] ? 2 : 1;
        addKnight(id, x, y);
    }

    public double getScore() {
        double score = 0;
        if (hasKnight[1]) score += BASE_SCORE;
        if (hasKnight[2]) score += BASE_SCORE + SYNERGETIC_BONUS;
        return score;
    }

    private void addKnight(int id, int x, int y) {
        hasKnight[id] = true;
        coordinates[id] = new Coordinate(x, y);
    }
}
