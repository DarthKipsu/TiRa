package shakki;
import position.Evaluator;
import position.Position;
import scoring.KingScore;
import scoring.KnightScore;
import scoring.PawnScore;
import scoring.PieceScore;
import scoring.QueenScore;
import scoring.RookScore;

public class YourEvaluator extends Evaluator{

    private static final double QUEEN_SYNERGY_BONUS = 5;
    private PieceScore[] pieceScores;

    @Override
    public double eval(Position p) {
		double ret = 0;
        pieceScores = new PieceScore[] {
            null,
            new KingScore(1, p),
            new QueenScore(1, p),
            new RookScore(1, p),
            null,
            new KnightScore(1, p),
            new PawnScore(1, p),
            new KingScore(-1, p),
            new QueenScore(-1, p),
            new RookScore(-1, p),
            null,
            new KnightScore(-1, p),
            new PawnScore(-1, p)
        };
		for(int x = 0; x < p.board.length; ++x) {
			for(int y = 0; y < p.board[x].length; ++y) {
				addPieceAt(p, x, y);
			}
		}
        for (PieceScore ps : pieceScores) {
            if (ps != null) {
                ret += ps.getScore();
            }
        }
        return ret;
    }

    private void addPieceAt(Position p, int x, int y) {
        int position = p.board[x][y];
        if(position == Position.Empty) return;
        pieceScores[position].addPiece(x, y);
    }

    private double croosPieceSynergies(PieceScore q, PieceScore r, PieceScore k) {
        QueenScore qs = (QueenScore)q;
        double score = 0;
        if (qs.hasQueen()) {
            RookScore rs = (RookScore)r;
            KnightScore ks = (KnightScore)k;
            if (rs.hasRook()) score += 2 * QUEEN_SYNERGY_BONUS;
            if (ks.hasKnight()) score += QUEEN_SYNERGY_BONUS;
        }
        return score;
    }
}
