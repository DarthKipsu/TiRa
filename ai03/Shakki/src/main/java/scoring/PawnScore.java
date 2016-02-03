
package scoring;

public class PawnScore extends PieceScore {
    
    private static final double BASE_SCORE = 1;
    
    private int rookCount = 0;
    private Coordinate[] coordinates = new Coordinate[7];
    private double advancementScore = 0;

    public PawnScore(int sideCoefficient) {
        super(sideCoefficient);
    }

    public void addPiece(int x, int y) {
        addPawn(++rookCount, x, y);
    }

    public double getScore() {
        double score = rookCount * BASE_SCORE;
        score += advancementScore;
        return this.sideCoefficient * score;
    }

    private void addPawn(int id, int x, int y) {
        coordinates[id] = new Coordinate(x, y);
        advancementScore += scoreAdvancement(x);
    }

    private double scoreAdvancement(int x) {
        if (x==5) return 8;
        if (x==4) return 4;
        if (x==3) return 2;
        if (x==2) return 1;
        else return 0;
    }
}
