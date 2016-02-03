
package scoring;

import position.Position;

public abstract class PieceScore {

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

    boolean slidedAsFarAsPossible(int x, int y) {
        return p.board[x][y] != Position.Empty;
    }

    int friendlyPieceProtectionValue(int x, int y) {
        int piece = p.board[x][y];
        if ((sideCoefficient == 1 && Position.isWhitePiece(piece)) ||
                (sideCoefficient == -1 && Position.isBlackPiece(piece))) {
            if (isPawn(piece)) return 1;
            if (isKing(piece)) return 0;
            return 2;
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
