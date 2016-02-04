
package scoring;

import junit.framework.TestCase;
import position.Position;
import static scoring.KnightScore.BASE_SCORE;
import static scoring.KnightScore.SYNERGETIC_BONUS;
import static scoring.PieceScore.PAWN_VALUE;
import static scoring.PieceScore.THREAT_MULTIPLIER;

public class KnightScoreTest extends TestCase {
    
    private KnightScore ksw;
    private KnightScore ksb;
    private Position p;
    
    public KnightScoreTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        p = new Position();
        ksw = new KnightScore(1, p);
        ksb = new KnightScore(-1, p);
    }

    public void testWithNoKnight() {
        assertEquals(0.0, ksw.getScore());
        assertEquals(-0.0, ksb.getScore());
    }

    public void testWithWhiteKnight() {
        ksw.addPiece(2, 2);
        assertEquals(BASE_SCORE, ksw.getScore());
    }

    public void testWithBlackKnight() {
        ksb.addPiece(2, 2);
        assertEquals(-BASE_SCORE, ksb.getScore());
    }

    public void testWithTwoWhiteKnihts() {
        ksw.addPiece(2, 2);
        ksw.addPiece(1, 1);
        assertEquals(2 * BASE_SCORE + SYNERGETIC_BONUS, ksw.getScore());
    }

    public void testWithWhiteKnightAndPawnAboveKnight() {
        ksw.addPiece(2, 2);
        p.board[3][4] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE, ksw.getScore());
        p.board[1][4] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE + PAWN_VALUE, ksw.getScore());
        p.board[4][3] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE + PAWN_VALUE + PAWN_VALUE, ksw.getScore());
        p.board[0][3] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE + PAWN_VALUE + PAWN_VALUE + PAWN_VALUE, ksw.getScore());
    }

    public void testWithWhiteKnightAndPawnBelowKnight() {
        ksw.addPiece(2, 2);
        p.board[3][0] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE, ksw.getScore());
        p.board[1][0] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE + PAWN_VALUE, ksw.getScore());
        p.board[4][1] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE + PAWN_VALUE + PAWN_VALUE, ksw.getScore());
        p.board[0][1] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE + PAWN_VALUE + PAWN_VALUE + PAWN_VALUE, ksw.getScore());
    }

    public void testWithWhiteKnightWhenProtectedPieceIsEnemy() {
        ksw.addPiece(2, 2);
        p.board[3][0] = Position.BPawn;
        assertEquals(BASE_SCORE + THREAT_MULTIPLIER, ksw.getScore());
        p.board[1][0] = Position.BPawn;
        assertEquals(BASE_SCORE + THREAT_MULTIPLIER + THREAT_MULTIPLIER, ksw.getScore());
    }

    public void testWithWhiteKnightAndPawnOutOfReachKnight() {
        ksw.addPiece(2, 2);
        p.board[2][3] = Position.WPawn;
        assertEquals(BASE_SCORE, ksw.getScore());
        p.board[1][2] = Position.WPawn;
        assertEquals(BASE_SCORE, ksw.getScore());
        p.board[3][3] = Position.WPawn;
        assertEquals(BASE_SCORE, ksw.getScore());
    }

    public void testWithTwoWhiteKnightWithBothProtecting() {
        ksw.addPiece(2, 2);
        ksw.addPiece(5, 4);
        p.board[1][4] = Position.WPawn;
        assertEquals(2 * BASE_SCORE + SYNERGETIC_BONUS + PAWN_VALUE, ksw.getScore());
        p.board[4][1] = Position.WPawn;
        assertEquals(2 * BASE_SCORE + SYNERGETIC_BONUS + PAWN_VALUE + PAWN_VALUE, ksw.getScore());
        p.board[3][3] = Position.WPawn;
        assertEquals(2 * BASE_SCORE + SYNERGETIC_BONUS + PAWN_VALUE + PAWN_VALUE + PAWN_VALUE, ksw.getScore());
    }

    public void testWithTwoBlackKnightWithBothProtecting() {
        ksb.addPiece(2, 2);
        ksb.addPiece(5, 4);
        p.board[1][4] = Position.BPawn;
        assertEquals(2 * -BASE_SCORE - SYNERGETIC_BONUS - PAWN_VALUE, ksb.getScore());
        p.board[4][1] = Position.BPawn;
        assertEquals(2 * -BASE_SCORE - SYNERGETIC_BONUS - PAWN_VALUE - PAWN_VALUE, ksb.getScore());
        p.board[3][3] = Position.BPawn;
        assertEquals(2 * -BASE_SCORE - SYNERGETIC_BONUS - PAWN_VALUE - PAWN_VALUE - PAWN_VALUE, ksb.getScore());
    }

    public void testWithWhiteKnightThreatningEnemyRook() {
        ksw.addPiece(2, 2);
        p.board[3][4] = Position.BRook;
        assertEquals(BASE_SCORE + (Position.WKnight - Position.WRook) * THREAT_MULTIPLIER, ksw.getScore());
    }

    public void testWithWhiteKnightThreatningEnemyKnight() {
        ksw.addPiece(2, 2);
        p.board[3][4] = Position.BKnight;
        assertEquals(BASE_SCORE + THREAT_MULTIPLIER, ksw.getScore());
    }
    
}
