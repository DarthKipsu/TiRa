
package scoring;

import junit.framework.TestCase;
import position.Position;
import static scoring.Piece.PAWN_VALUE;
import static scoring.Piece.THREAT_MULTIPLIER;
import static scoring.Rook.BASE_SCORE;
import static scoring.Rook.SYNERGETIC_BONUS;

public class RookScoreTest extends TestCase {
    
    private Rook rsw;
    private Rook rsb;
    private Position p;
    
    public RookScoreTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        p = new Position();
        rsw = new Rook(1, p);
        rsb = new Rook(-1, p);
    }

    public void testNoRooksOnBoard() {
        assertEquals(0.0, rsw.getScore());
        assertEquals(-0.0, rsb.getScore());
    }

    public void testOneWhiteRook() {
        rsw.addPiece(2, 2);
        assertEquals(BASE_SCORE, rsw.getScore());
    }

    public void testOneBlackRook() {
        rsb.addPiece(2, 2);
        assertEquals(-BASE_SCORE, rsb.getScore());
    }

    public void testTwoWhiteRooks() {
        rsw.addPiece(2, 2);
        rsw.addPiece(3, 2);
        assertEquals(2 * BASE_SCORE + SYNERGETIC_BONUS, rsw.getScore());
    }

    public void testWhiteRookWithHorizontalPawns() {
        rsw.addPiece(2, 2);
        p.board[0][2] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE, rsw.getScore());
        p.board[4][2] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE + PAWN_VALUE, rsw.getScore());
    }

    public void testWhiteRookWithVerticalPawns() {
        rsw.addPiece(2, 2);
        p.board[2][1] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE, rsw.getScore());
        p.board[2][5] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE + PAWN_VALUE, rsw.getScore());
    }

    public void testWhiteRookWithVerticalEnemyPawns() {
        rsw.addPiece(2, 2);
        p.board[2][1] = Position.BPawn;
        assertEquals(BASE_SCORE + THREAT_MULTIPLIER, rsw.getScore());
        p.board[2][5] = Position.BPawn;
        assertEquals(BASE_SCORE + THREAT_MULTIPLIER + THREAT_MULTIPLIER, rsw.getScore());
    }

    public void testWhiteRookWithVerticalPawnsBlockedByEnemy() {
        rsw.addPiece(2, 2);
        p.board[2][5] = Position.WPawn;
        assertEquals(BASE_SCORE + PAWN_VALUE, rsw.getScore());
        p.board[2][4] = Position.BPawn;
        assertEquals(BASE_SCORE + THREAT_MULTIPLIER, rsw.getScore());
    }

    public void testWhiteRookWithPawnsOutOfReach() {
        rsw.addPiece(2, 2);
        p.board[1][0] = Position.WPawn;
        assertEquals(BASE_SCORE, rsw.getScore());
        p.board[5][1] = Position.WPawn;
        assertEquals(BASE_SCORE, rsw.getScore());
    }

    public void testTwoWhiteRooksWithPawnsInReach() {
        rsw.addPiece(2, 2);
        rsw.addPiece(1, 1);
        p.board[1][0] = Position.WPawn;
        assertEquals(2 * BASE_SCORE + SYNERGETIC_BONUS + PAWN_VALUE, rsw.getScore());
        p.board[5][1] = Position.WPawn;
        assertEquals(2 * BASE_SCORE + SYNERGETIC_BONUS + PAWN_VALUE + PAWN_VALUE, rsw.getScore());
        p.board[2][5] = Position.WPawn;
        assertEquals(2 * BASE_SCORE + SYNERGETIC_BONUS + PAWN_VALUE + PAWN_VALUE + PAWN_VALUE, rsw.getScore());
    }

    public void testTwoBlackRooksWithPawnsInReach() {
        rsb.addPiece(2, 2);
        rsb.addPiece(1, 1);
        p.board[1][0] = Position.BPawn;
        assertEquals(2 * -BASE_SCORE - SYNERGETIC_BONUS - PAWN_VALUE, rsb.getScore());
        p.board[5][1] = Position.BPawn;
        assertEquals(2 * -BASE_SCORE - SYNERGETIC_BONUS - PAWN_VALUE - PAWN_VALUE, rsb.getScore());
        p.board[2][5] = Position.BPawn;
        assertEquals(2 * -BASE_SCORE - SYNERGETIC_BONUS - PAWN_VALUE - PAWN_VALUE - PAWN_VALUE, rsb.getScore());
    }

    public void testWhiteRookThreatensEnemyKing() {
        rsw.addPiece(2, 2);
        p.board[2][1] = Position.BKing;
        assertEquals(BASE_SCORE + (Position.WRook - Position.WKing) * THREAT_MULTIPLIER, rsw.getScore());
    }

    public void testWhiteRookThreatensEnemyQueen() {
        rsw.addPiece(2, 2);
        p.board[2][1] = Position.BQueen;
        assertEquals(BASE_SCORE + (Position.WRook - Position.WQueen) * THREAT_MULTIPLIER, rsw.getScore());
    }

    public void testWhiteRookThreatensEnemyRook() {
        rsw.addPiece(2, 2);
        p.board[2][1] = Position.BRook;
        assertEquals(BASE_SCORE + THREAT_MULTIPLIER, rsw.getScore());
    }
    
}
