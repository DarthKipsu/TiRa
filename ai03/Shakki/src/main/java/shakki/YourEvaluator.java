package shakki;
import position.Evaluator;
import position.Position;



public class YourEvaluator extends Evaluator{

    boolean[] doubleExists;

    @Override
    public double eval(Position p) {
		double ret = 0;
        doubleExists = new boolean[12];
		for(int x = 0; x < p.board.length; ++x) {
			for(int y = 0; y < p.board[x].length; ++y) {
				ret += addMaterialCost(p.board[x][y]);
			}
		}
		return ret;
    }

    private double addMaterialCost(int position) {
        if(position == Position.Empty) return 0;
        if(position == Position.WKing) return 1000;
        if(position == Position.WQueen) return 9;
        if(position == Position.WRook)  return withSynergeticBonus(5, position);
        if(position == Position.WKnight) return withSynergeticBonus(3, position);
        if(position == Position.WPawn) return 1;
        if(position == Position.BKing) return -1000;
        if(position == Position.BQueen) return -9;
        if(position == Position.BRook) return withSynergeticBonus(-5, position);
        if(position == Position.BKnight) return withSynergeticBonus(-3, position);
        if(position == Position.BPawn) return -1;
        return 0;
    }

    private double withSynergeticBonus(double cost, int piece) {
        if (doubleExists[piece]) return 2 * cost;
        doubleExists[piece] = true;
        return cost;
    }
}
