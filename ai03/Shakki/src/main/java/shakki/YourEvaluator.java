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

    private PieceScore[] pieceScores;
    boolean[] doubleExists;
    double blackMaterialScore;

    @Override
    public double eval(Position p) {
		double ret = 0;
        pieceScores = new PieceScore[] {
            null,
            new KingScore(),
            new QueenScore(),
            new RookScore(),
            null,
            new KnightScore(),
            new PawnScore()
        };
        doubleExists = new boolean[12];
        blackMaterialScore = 0;
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
		return ret + blackMaterialScore;
    }

    private void addPieceAt(Position p, int x, int y) {
        int position = p.board[x][y];
        if(position == Position.Empty) return;
        if(position < 7) pieceScores[position].addPiece(x, y);
        if(position == Position.BPawn) blackMaterialScore -= 1;
        if(position == Position.BKing) blackMaterialScore -= 1000;
        if(position == Position.BQueen) blackMaterialScore -= 9;
        if(position == Position.BRook) {
            blackMaterialScore -= withSynergeticBonus(5, position);
        }
        if(position == Position.BKnight) {
            blackMaterialScore -= withSynergeticBonus(3, position);
        }
    }

    private double withSynergeticBonus(double cost, int piece) {
        if (doubleExists[piece]) return 2 * cost;
        doubleExists[piece] = true;
        return cost;
    }
}
