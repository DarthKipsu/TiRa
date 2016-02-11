
import java.util.Arrays;


public class Features {
    
    private final double[] features;
    private final Position p;

    public Features(Position p) {
        this.p = p;
        features = new double[211];
        addPositionFeatures();
//        System.out.println(Arrays.toString(features));
    }

    private void addPositionFeatures() {
        if (p.whiteToMove) features[1] = 1;
        else features[2] = 1;
        
		for(int x = 0; x < p.board.length; ++x) {
			for(int y = 0; y < p.board[x].length; ++y) {
                int piece = p.board[x][y];
                if(piece == Position.Empty) continue;
                addFeature(piece, x, y);
			}
		}
    }

    private void addFeature(int piece, int x, int y) {
        switch (piece) {
            case Position.WKing: addKing(Side.WHITE, x, y); break;
            case Position.BKing: addKing(Side.BLACK, x, y); break;
            case Position.WQueen: addQueen(Side.WHITE, x, y); break;
            case Position.BQueen: addQueen(Side.BLACK, x, y); break;
            case Position.WRook: addRook(Side.WHITE, x, y); break;
            case Position.BRook: addRook(Side.BLACK, x, y); break;
            case Position.WKnight: addKnight(Side.WHITE, x, y); break;
            case Position.BKnight: addKnight(Side.BLACK, x, y); break;
            case Position.WPawn: addPawn(Side.WHITE, x, y); break;
            case Position.BPawn: addPawn(Side.BLACK, x, y); break;
        }
    }

    private void addKing(Side side, int x, int y) {
        features[side == Side.WHITE ? 3 : 8] = 1;
        features[side == Side.WHITE ? 13 : 37] = x;
        features[side == Side.WHITE ? 14 : 38] = y;

        int[] xMoves = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] yMoves = {1, 0, -1, 1, -1, 1, 0, -1};
        attackAndDefenceForNonSlidingPieces(xMoves, yMoves, x, y, side, 1);
    }

    private void addQueen(Side side, int x, int y) {
        features[side == Side.WHITE ? 4 : 9] = 1;
        features[side == Side.WHITE ? 15 : 39] = x;
        features[side == Side.WHITE ? 16 : 40] = y;

        int[][] xMoves = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0},
            {1, 2, 3, 4, 5, 6, 7}, {-1, -2, -3, -4, -5, -6, -7}, {1, 2, 3, 4, 5, 6, 7},
            {1, 2, 3, 4, 5, 6, 7}, {-1, -2, -3, -4, -5, -6, -7}, {-1, -2, -3, -4, -5, -6, -7}};
        int[][] yMoves = {{1, 2, 3, 4, 5, 6, 7}, {-1, -2, -3, -4, -5, -6, -7},
            {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {1, 2, 3, 4, 5, 6, 7},
            {-1, -2, -3, -4, -5, -6, -7}, {1, 2, 3, 4, 5, 6, 7}, {-1, -2, -3, -4, -5, -6, -7}};
        attackAndDefenceForSlidingPieces(xMoves, yMoves, x, y, side, 2);
    }

    private void addRook(Side side, int x, int y) {
        if (side == Side.WHITE) {
            features[5] += 1;
            features[features[5] > 1 ? 19 : 17] = x;
            features[features[5] > 1 ? 20 : 18] = y;
        } else {
            features[10] += 1;
            features[features[10] > 1 ? 43 : 41] = x;
            features[features[10] > 1 ? 44 : 42] = y;
        }

        int[][] xMoves = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0},
            {1, 2, 3, 4, 5, 6, 7}, {-1, -2, -3, -4, -5, -6, -7}};
        int[][] yMoves = {{1, 2, 3, 4, 5, 6, 7}, {-1, -2, -3, -4, -5, -6, -7},
            {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
        attackAndDefenceForSlidingPieces(xMoves, yMoves, x, y, side, 3);
    }

    private void addKnight(Side side, int x, int y) {
        if (side == Side.WHITE) {
            features[6] += 1;
            features[features[6] > 1 ? 23 : 21] = x;
            features[features[6] > 1 ? 24 : 22] = y;
        } else {
            features[11] += 1;
            features[features[11] > 1 ? 47 : 45] = x;
            features[features[11] > 1 ? 48 : 46] = y;
        }

        int[] xMoves = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] yMoves = {1, -1, 2, -2, 2, -2, 1, -1};
        attackAndDefenceForNonSlidingPieces(xMoves, yMoves, x, y, side, 5);
    }

    private void addPawn(Side side, int x, int y) {
        if (side == Side.WHITE) {
            if (features[7] < 6) {
                features[25 + 2 * (int)features[7]] = x;
                features[26 + 2 * (int)features[7]] = y;
            }
            features[7] += 1;
        } else {
            if (features[12] < 6) {
                features[50 + 2 * (int)features[12]] = x;
                features[51 + 2 * (int)features[12]] = y;
            }
            features[12] += 1;
        }

        int[] xMoves = {1, -1};
        int[] yMoves = {1, 1};
        attackAndDefenceForNonSlidingPieces(xMoves, yMoves, x, y, side, 6);
    }

    private void attackAndDefenceForNonSlidingPieces(
            int[] xMoves, int[] yMoves, int x, int y, Side side, int value) {
        for (int i = 0; i < xMoves.length; i++) {
            int x2 = x + xMoves[i];
            int y2 = y + yMoves[i];
            if (isOutsideBoard(x2, y2)) continue;
            setAttackAndDefenceFeatures(value, side, x2, y2);
        }
    }

    private void attackAndDefenceForSlidingPieces(
            int[][] xMoves, int[][] yMoves, int x, int y, Side side, int value) {
        for (int i = 0; i < xMoves.length; i++) {
            for (int j = 0; j < xMoves[0].length; j++) {
                int x2 = x + xMoves[i][j];
                int y2 = y + yMoves[i][j];
                if (isOutsideBoard(x2, y2)) break;
                setAttackAndDefenceFeatures(5, side, x2, y2);
                if (slidedAsFarAsPossible(x, y)) break;
            }
        }
    }

    boolean slidedAsFarAsPossible(int x, int y) {
        return p.board[x][y] != Position.Empty;
    }

    private boolean isOutsideBoard(int x, int y) {
        if (x < 0 || x >= Position.bCols) return true;
        if (y < 0 || y >= Position.bRows) return true;
        return false;
    }

    private void setAttackAndDefenceFeatures(int value, Side side, int x, int y) {
        int offset = x * 6 + y;
        if (side == Side.WHITE) {
            offset += 67; // White attackers
            if (features[offset] < value) features[offset] = value;
            offset += 36; // White defenders
            if (features[offset] < value) features[offset] = value;
        } else {
            offset += 139; // Black attackers
            if (features[offset] < value) features[offset] = value;
            offset += 36; // Black defenders
            if (features[offset] < value) features[offset] = value;
        }
    }

    private enum Side {
        WHITE,
        BLACK
    }
}
