package shakki;
import position.Evaluator;
import position.Position;



public class YourEvaluator extends Evaluator{

    /**
     * Toteuta tähän evaluointifunktio.
     * @param p
     * @return 
     */
    @Override
    public double eval(Position p) {
		double ret = 0;
		for(int x = 0; x < p.board.length; ++x) {
			for(int y = 0; y < p.board[x].length; ++y) {
				if(p.board[x][y] == Position.Empty) continue;
				if(p.board[x][y] == Position.WKing) ret += 1000;
				if(p.board[x][y] == Position.WQueen) ret += 1;
				if(p.board[x][y] == Position.WRook) ret += 1;
				if(p.board[x][y] == Position.WBishop) ret += 1;
				if(p.board[x][y] == Position.WKnight) ret += 1;
				if(p.board[x][y] == Position.WPawn) ret += 1;
				if(p.board[x][y] == Position.BKing) ret -= 1000;
				if(p.board[x][y] == Position.BQueen) ret -= 1;
				if(p.board[x][y] == Position.BRook) ret -= 1;
				if(p.board[x][y] == Position.BBishop) ret -= 1;
				if(p.board[x][y] == Position.BKnight) ret -= 1;
				if(p.board[x][y] == Position.BPawn) ret -= 1;
			}
		}
		return ret;
    }
    
}
