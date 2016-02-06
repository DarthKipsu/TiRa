
public class Rook extends Piece {
    
    protected static final double BASE_SCORE = 10;
    protected static final double SYNERGETIC_BONUS = 6;
    private static final int[][] X_MOVES = {
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {1, 2, 3, 4, 5, 6, 7},
        {-1, -2, -3, -4, -5, -6, -7}};
    private static final int[][] Y_MOVES = {
        {1, 2, 3, 4, 5, 6, 7},
        {-1, -2, -3, -4, -5, -6, -7},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0}};
    
    private boolean[] hasRook = new boolean[3];
    private Coordinate[] coordinates = new Coordinate[3];

    public Rook(int sideCoefficient, Position p) {
        super(sideCoefficient, p);
    }

    public void addPiece(int x, int y) {
        int id = hasRook[1] ? 2 : 1;
        addRook(id, x, y);
        }

    public boolean hasRook() {
        return hasRook[1];
    }

    public double getScore() {
        double score = 0;
        if (hasRook[1]) {
            score += BASE_SCORE;
            score += protectionAndThreatBonuses(coordinates[1]);
        }
        if (hasRook[2]) {
            score += BASE_SCORE + SYNERGETIC_BONUS;
            score += protectionAndThreatBonuses(coordinates[2]);
        }
        return this.sideCoefficient * score;
    }

    private void addRook(int id, int x, int y) {
        hasRook[id] = true;
        coordinates[id] = new Coordinate(x, y);
    }

    private double protectionAndThreatBonuses(Coordinate coordinate) {
        double score = 0;
        for (int i = 0; i < X_MOVES.length; i++) {
            for (int j = 0; j < X_MOVES[0].length; j++) {
                int x = coordinate.getX() + X_MOVES[i][j];
                int y = coordinate.getY() + Y_MOVES[i][j];
                if (isOutsideBoard(x, y)) break;
                score += friendlyPieceProtectionValue(x, y);
                score += threatensEnemyValue(x, y, 3);
                score += mobilityValue(x, y, 3);
                if (slidedAsFarAsPossible(x, y)) break;
            }
        }
        return score;
    }
}
