
package scoring;

import junit.framework.TestCase;
import position.Position;
import static scoring.Pawn.BASE_SCORE;
import static scoring.Pawn.NEIGHBOUR_PENALTY;
import static scoring.Piece.MOBILITY_BONUS;
import static scoring.Piece.PAWN_VALUE;
import static scoring.Piece.THREAT_MULTIPLIER;

public class PawnScoreTest extends TestCase {
    
    private Pawn psw;
    private Pawn psb;
    private Position p;
    
    public PawnScoreTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        p = new Position();
        psw = new Pawn(1, p);
        psb = new Pawn(-1, p);
    }

    public void testWithNoPawn() {
        assertEquals(0.0, psw.getScore());
        assertEquals(-0.0, psb.getScore());
    }

    public void testWithWhitePawn() {
        psw.addPiece(2, 2);
        assertEquals(BASE_SCORE + MOBILITY_BONUS, psw.getScore());
    }

    public void testWithBlackPawn() {
        psb.addPiece(2, 3);
        assertEquals(-BASE_SCORE - MOBILITY_BONUS, psb.getScore());
    }

    public void testWhitePawnAdvancement() {
        p.board[2][2] = Position.WPawn;
        psw.addPiece(2, 2);
        assertEquals(BASE_SCORE + MOBILITY_BONUS, psw.getScore());
        p.board[2][3] = Position.WPawn;
        psw.addPiece(2, 3);
        assertEquals(3 * BASE_SCORE + MOBILITY_BONUS, psw.getScore());
        p.board[2][4] = Position.WPawn;
        psw.addPiece(2, 4);
        assertEquals(6 * BASE_SCORE + MOBILITY_BONUS, psw.getScore());
    }

    public void testWhitePawnWithProtectedPawn() {
        psw.addPiece(2, 1);
        assertEquals(BASE_SCORE + MOBILITY_BONUS, psw.getScore());
        p.board[3][2] = Position.WPawn;
        assertEquals(BASE_SCORE + MOBILITY_BONUS + PAWN_VALUE, psw.getScore());
        p.board[1][2] = Position.WPawn;
        assertEquals(BASE_SCORE + MOBILITY_BONUS + PAWN_VALUE + PAWN_VALUE, psw.getScore());
    }

    public void testWhitePawnWithProtectedPawnOutOfReach() {
        psw.addPiece(2, 1);
        assertEquals(BASE_SCORE + MOBILITY_BONUS, psw.getScore());
        p.board[2][2] = Position.WPawn;
        assertEquals(BASE_SCORE, psw.getScore());
    }

    public void testWhitePawnWithProtectedPawnEnemyUnit() {
        psw.addPiece(2, 1);
        assertEquals(BASE_SCORE + MOBILITY_BONUS, psw.getScore());
        p.board[1][2] = Position.BPawn;
        assertEquals(BASE_SCORE + MOBILITY_BONUS + THREAT_MULTIPLIER, psw.getScore());
    }

    public void testWhitePawnThreatningEnemyQueen() {
        psw.addPiece(2, 2);
        p.board[3][3] = Position.BQueen;
        assertEquals(BASE_SCORE + MOBILITY_BONUS + (Position.WPawn - Position.WQueen) * THREAT_MULTIPLIER, psw.getScore());
    }

    public void testItsMoreProfitableToEatQueenThanThreatIt() {
        psw.addPiece(2, 2);
        p.board[3][3] = Position.BQueen;
        double scoreWhenThreatning = psw.getScore() - Queen.BASE_SCORE;
        p.board[3][3] = Position.Empty;
        double scoreAfterQueenBeenEaten = psw.getScore();
        assertTrue(scoreWhenThreatning < scoreAfterQueenBeenEaten);
    }

    public void testNeighbouringPawnsPenalty() {
        psw.addPiece(2, 2);
        p.board[3][2] = Position.WPawn;
        assertEquals(BASE_SCORE + MOBILITY_BONUS - NEIGHBOUR_PENALTY, psw.getScore());
        p.board[1][2] = Position.WPawn;
        assertEquals(BASE_SCORE + MOBILITY_BONUS - NEIGHBOUR_PENALTY - NEIGHBOUR_PENALTY, psw.getScore());
    }
    
}
