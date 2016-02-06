
package scoring;

import junit.framework.TestCase;
import position.Position;
import static scoring.Piece.MOBILITY_BONUS;
import static scoring.Piece.PAWN_VALUE;
import static scoring.Piece.REST_VALUE;
import static scoring.Piece.THREAT_MULTIPLIER;
import static scoring.Queen.BASE_SCORE;

public class QueenScoreTest extends TestCase {
    
    private Queen qsw;
    private Queen qsb;
    private Position p;
    
    public QueenScoreTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        p = new Position();
        qsw = new Queen(1, p);
        qsb = new Queen(-1, p);
    }

    public void testScoreWithNoQueen() {
        assertEquals(0.0, qsw.getScore());
    }

    public void testScoreWithOneQueen() {
        qsw.addPiece(0, 0);
        assertEquals(BASE_SCORE + 15*MOBILITY_BONUS, qsw.getScore());
    }

    public void testScoreWithBlackQueen() {
        qsb.addPiece(0, 0);
        assertEquals(-BASE_SCORE - 15*MOBILITY_BONUS, qsb.getScore());
    }

    public void testScoreWithOneProtectedPawnLeftDownCorner() {
        qsw.addPiece(2, 2);
        p.board[1][1] = Position.WPawn;
        assertEquals(BASE_SCORE + 17*MOBILITY_BONUS + PAWN_VALUE, qsw.getScore());
    }

    public void testScoreWithOneProtectedPawnLeftUpCorner() {
        qsw.addPiece(2, 2);
        p.board[1][3] = Position.WPawn;
        assertEquals(BASE_SCORE + 17*MOBILITY_BONUS + PAWN_VALUE, qsw.getScore());
    }

    public void testScoreWithOneProtectedPawnRightDownCorner() {
        qsw.addPiece(2, 2);
        p.board[4][0] = Position.WPawn;
        assertEquals(BASE_SCORE + 18*MOBILITY_BONUS + PAWN_VALUE, qsw.getScore());
    }

    public void testScoreWithOneProtectedPawnRightUpCorner() {
        qsw.addPiece(2, 2);
        p.board[4][4] = Position.WPawn;
        assertEquals(BASE_SCORE + 17*MOBILITY_BONUS + PAWN_VALUE, qsw.getScore(), 0.001);
    }

    public void testScoreWithOneProtectedPawnHorizontallyRight() {
        qsw.addPiece(2, 2);
        p.board[4][2] = Position.WPawn;
        assertEquals(BASE_SCORE + 17*MOBILITY_BONUS + PAWN_VALUE, qsw.getScore(), 0.001);
    }

    public void testScoreWithOneProtectedPawnHorizontallyLeft() {
        qsw.addPiece(2, 2);
        p.board[0][2] = Position.WPawn;
        assertEquals(BASE_SCORE + 18*MOBILITY_BONUS + PAWN_VALUE, qsw.getScore());
    }

    public void testScoreWithOneProtectedPawnVerticallyUp() {
        qsw.addPiece(2, 2);
        p.board[2][5] = Position.WPawn;
        assertEquals(BASE_SCORE + 18*MOBILITY_BONUS + PAWN_VALUE, qsw.getScore());
    }

    public void testScoreWithOneProtectedPawnVerticallyDown() {
        qsw.addPiece(2, 2);
        p.board[2][1] = Position.WPawn;
        assertEquals(BASE_SCORE + 17*MOBILITY_BONUS + PAWN_VALUE, qsw.getScore(), 0.001);
    }

    public void testScoreWithTwoProtectedPawn() {
        qsw.addPiece(2, 2);
        p.board[2][1] = Position.WPawn;
        p.board[4][2] = Position.WPawn;
        assertEquals(BASE_SCORE + 15*MOBILITY_BONUS + PAWN_VALUE + PAWN_VALUE, qsw.getScore());
    }

    public void testScoreWithThreeProtectedPawn() {
        qsw.addPiece(2, 2);
        p.board[2][5] = Position.WPawn;
        p.board[4][2] = Position.WPawn;
        p.board[1][1] = Position.WPawn;
        assertEquals(BASE_SCORE + 14*MOBILITY_BONUS + PAWN_VALUE + PAWN_VALUE + PAWN_VALUE, qsw.getScore());
    }

    public void testScoreWithEnemyPawnAsProtected() {
        qsw.addPiece(2, 2);
        p.board[2][5] = Position.BPawn;
        assertEquals(BASE_SCORE + 18*MOBILITY_BONUS + THREAT_MULTIPLIER, qsw.getScore());
    }

    public void testScoreWithOneProtectedPawnRightDownCornerButEnemyInTheWay() {
        qsw.addPiece(2, 2);
        p.board[4][0] = Position.WPawn;
        p.board[3][1] = Position.BPawn;
        assertEquals(BASE_SCORE + 17*MOBILITY_BONUS + THREAT_MULTIPLIER, qsw.getScore());
    }

    public void testScoreWherePawnNotInReach() {
        qsw.addPiece(2, 2);
        p.board[3][0] = Position.WPawn;
        assertEquals(BASE_SCORE + 19*MOBILITY_BONUS, qsw.getScore());
    }

    public void testScoreWithTwoQueens() {
        qsw.addPiece(4, 5);
        qsw.addPiece(2, 2);
        assertEquals(3 * BASE_SCORE + 19*MOBILITY_BONUS + 15*MOBILITY_BONUS, qsw.getScore(), 0.001);
    }

    public void testScoreWithThreeQueens() {
        p.board[2][5] = Position.WQueen;
        qsw.addPiece(2, 5);
        p.board[4][5] = Position.WQueen;
        qsw.addPiece(4, 5);
        p.board[2][2] = Position.WQueen;
        qsw.addPiece(2, 2);
        assertEquals(5 * BASE_SCORE + 18*MOBILITY_BONUS + 12*MOBILITY_BONUS + 10*MOBILITY_BONUS + 4 * REST_VALUE, qsw.getScore(), 0.001);
    }

    public void testScoreWithThreatToEnemyKing() {
        qsw.addPiece(2, 2);
        p.board[0][2] = Position.BKing;
        assertEquals(BASE_SCORE + 19*MOBILITY_BONUS + (Position.WQueen - Position.WKing) * THREAT_MULTIPLIER, qsw.getScore(), 0.001);
    }

    public void testScoreWithThreatToEnemyQueen() {
        qsw.addPiece(2, 2);
        p.board[0][2] = Position.BQueen;
        assertEquals(BASE_SCORE + 18*MOBILITY_BONUS + THREAT_MULTIPLIER, qsw.getScore(), 0.001);
    }
}
