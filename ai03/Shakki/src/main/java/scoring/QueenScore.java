
package scoring;

import position.Position;

public class QueenScore extends PieceScore {
    
    private static final double BASE_SCORE = 9;
    private static final int[][] X_MOVES = {
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {1, 2, 3, 4, 5, 6, 7},
        {-1, -2, -3, -4, -5, -6, -7},
        {1, 2, 3, 4, 5, 6, 7},
        {1, 2, 3, 4, 5, 6, 7},
        {-1, -2, -3, -4, -5, -6, -7},
        {-1, -2, -3, -4, -5, -6, -7}};
    private static final int[][] Y_MOVES = {
        {1, 2, 3, 4, 5, 6, 7},
        {-1, -2, -3, -4, -5, -6, -7},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {1, 2, 3, 4, 5, 6, 7},
        {-1, -2, -3, -4, -5, -6, -7},
        {1, 2, 3, 4, 5, 6, 7},
        {-1, -2, -3, -4, -5, -6, -7}};
    
    private int queenCount = 0;
    private Coordinate[] coordinates = new Coordinate[7];

    public QueenScore(int sideCoefficient, Position p) {
        super(sideCoefficient, p);
    }

    public void addPiece(int x, int y) {
        queenCount++;
        coordinates[queenCount] = new Coordinate(x, y);
    }

    public double getScore() {
        double score = 0;
        score += queenCount * BASE_SCORE;
        for (int i = 1; i <= queenCount; i++) {
            if (i > 1) score += BASE_SCORE;
            score += protectionBonus(coordinates[i]);
        }
        return this.sideCoefficient * score;
    }

    private double protectionBonus(Coordinate coordinate) {
        double protectionScore = 0;
        for (int i = 0; i < X_MOVES.length; i++) {
            for (int j = 0; j < X_MOVES[0].length; j++) {
                int x = coordinate.getX() + X_MOVES[i][j];
                int y = coordinate.getY() + Y_MOVES[i][j];
                if (isOutsideBoard(x, y)) break;
                protectionScore += friendlyPieceProtectionValue(x, y);
                if (slidedAsFarAsPossible(x, y)) break;
            }
        }
        return protectionScore;
    }
}
