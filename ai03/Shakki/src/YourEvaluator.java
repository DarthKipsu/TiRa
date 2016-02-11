public class YourEvaluator extends Evaluator {

    private static final double QUEEN_SYNERGY_BONUS = 7;
    private Piece[] pieces;

    @Override
    public double eval(Position p) {
		double ret = 0;
        pieces = createNewEmptyPieceVector(p);
		scanBoardAndAssign(pieces, p);
        for (Piece ps : pieces) {
            if (ps != null) {
                ret += ps.getScore();
            }
        }
        ret += crossPieceSynergies(pieces[2], pieces[3], pieces[5]);
        ret -= crossPieceSynergies(pieces[8], pieces[9], pieces[11]);
        return ret;
    }

    private Piece[] createNewEmptyPieceVector(Position p) {
        return new Piece[] {
            null, new King(1, p), new Queen(1, p), new Rook(1, p), null,
            new Knight(1, p), new Pawn(1, p),
            new King(-1, p), new Queen(-1, p), new Rook(-1, p), null,
            new Knight(-1, p), new Pawn(-1, p)
        };
    }

    private void scanBoardAndAssign(Piece[] pieces, Position p) {
		for(int x = 0; x < p.board.length; ++x) {
			for(int y = 0; y < p.board[x].length; ++y) {
                int position = p.board[x][y];
                if(position == Position.Empty) continue;
                pieces[position].addPiece(x, y);
			}
		}
    }

    private double crossPieceSynergies(Piece q, Piece r, Piece k) {
        Queen qs = (Queen)q;
        double score = 0;
        if (qs.hasQueen()) {
            Rook rs = (Rook)r;
            Knight ks = (Knight)k;
            if (rs.hasRook()) score += 2 * QUEEN_SYNERGY_BONUS;
            if (ks.hasKnight()) score += QUEEN_SYNERGY_BONUS;
            score += (qs.queenCount() - 1) * 3 * QUEEN_SYNERGY_BONUS;
        }
        return score;
    }
}

