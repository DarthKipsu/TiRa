
package scoring;

import position.Position;

public abstract class PieceScore {

    protected static final double PAWN_VALUE = 1;
    protected static final double REST_VALUE = 3;
    protected static final double THREAT_MULTIPLIER = 1.5;
    int sideCoefficient;
    Position p;

    public PieceScore(int sideCoefficient, Position p) {
        this.sideCoefficient = sideCoefficient;
        this.p = p;
    }

    abstract public void addPiece(int x, int y);
    abstract public double getScore();

    boolean isOutsideBoard(int x, int y) {
        if (x < 0 || x >= Position.bCols) return true;
        if (y < 0 || y >= Position.bRows) return true;
        return false;
    }

    boolean isInsideBoard(int x, int y) {
        return !isOutsideBoard(x, y);
    }

    boolean slidedAsFarAsPossible(int x, int y) {
        return p.board[x][y] != Position.Empty;
    }

    double friendlyPieceProtectionValue(int x, int y) {
        int piece = p.board[x][y];
        if (piece == Position.Empty) return 0;
        if ((sideCoefficient == 1 && Position.isWhitePiece(piece)) ||
                (sideCoefficient == -1 && Position.isBlackPiece(piece))) {
            if (isPawn(piece)) return PAWN_VALUE;
            if (isKing(piece)) return 0;
            return REST_VALUE;
        }
        return 0;
    }

    double threatensEnemyValue(int x, int y, int self) {
        int piece = p.board[x][y];
        if (piece == Position.Empty) return 0;
        if ((sideCoefficient == 1 && Position.isBlackPiece(piece)) ||
                (sideCoefficient == -1 && Position.isWhitePiece(piece))) {
            if (piece > 6) piece -= 6;
            if (self > piece) {
                return (self - piece) * THREAT_MULTIPLIER;
            }
            return THREAT_MULTIPLIER;
        }
        return 0;
    }

    private boolean isPawn(int piece) {
        return (piece == Position.BPawn || piece == Position.WPawn);
    }

    private boolean isKing(int piece) {
        return (piece == Position.BKing || piece == Position.WKing);
    }
}
