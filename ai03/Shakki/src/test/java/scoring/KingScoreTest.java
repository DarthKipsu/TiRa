/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoring;

import junit.framework.TestCase;
import position.Position;
import static scoring.KingScore.BASE_SCORE;
import static scoring.PieceScore.PAWN_VALUE;
import static scoring.PieceScore.THREAT_MULTIPLIER;

/**
 *
 * @author kipsu
 */
public class KingScoreTest extends TestCase {
    
    public KingScoreTest(String testName) {
        super(testName);
    }
    
    private KingScore ksw;
    private KingScore ksb;
    private Position p;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        p = new Position();
        ksw = new KingScore(1, p);
        ksb = new KingScore(-1, p);
    }

    public void testScoreWithOneKing() {
        ksw.addPiece(2, 2);
        assertEquals(BASE_SCORE, ksw.getScore());
    }

    public void testScoreWithOneBlackKing() {
        ksb.addPiece(2, 2);
        assertEquals(-BASE_SCORE, ksb.getScore());
    }

    public void testScoreWithNoKing() {
        assertEquals(0.0, ksw.getScore());
    }

    public void testProtectionScoreWithOneProtectedPiece1() {
        p.board[2][3] = Position.WPawn;
        ksw.addPiece(2, 2);
        assertEquals(BASE_SCORE + PAWN_VALUE, ksw.getScore());
    }

    public void testProtectionScoreWithOneProtectedPiece2() {
        p.board[3][3] = Position.WPawn;
        ksw.addPiece(2, 2);
        assertEquals(BASE_SCORE + PAWN_VALUE, ksw.getScore());
    }

    public void testProtectionScoreWithOneProtectedPiece3() {
        p.board[1][2] = Position.WPawn;
        ksw.addPiece(2, 2);
        assertEquals(BASE_SCORE + PAWN_VALUE, ksw.getScore());
    }

    public void testProtectionScoreWithBlackProtectedPiece() {
        p.board[2][3] = Position.BPawn;
        ksb.addPiece(2, 2);
        assertEquals(-BASE_SCORE - PAWN_VALUE, ksb.getScore());
    }

    public void testProtectionScoreWithProtectedPieceOutOfReach() {
        p.board[0][2] = Position.WPawn;
        ksw.addPiece(2, 2);
        assertEquals(BASE_SCORE, ksw.getScore());
    }

    public void testProtectionScoreWithTwoProtectedPieces() {
        p.board[3][1] = Position.WPawn;
        p.board[1][3] = Position.WPawn;
        ksw.addPiece(2, 2);
        assertEquals(BASE_SCORE + PAWN_VALUE + PAWN_VALUE, ksw.getScore());
    }

    public void testScoreWhenKingOnTheEdge() {
        ksw.addPiece(0, 5);
        assertEquals(BASE_SCORE, ksw.getScore());
    }

    public void testwithEnemyPawn() {
        p.board[1][2] = Position.BPawn;
        ksw.addPiece(2, 2);
        assertEquals(BASE_SCORE + THREAT_MULTIPLIER, ksw.getScore());
    }

    public void testThreatScoreWithEnemyUnitNotBeingThreat() {
        p.board[2][3] = Position.BPawn;
        ksw.addPiece(2, 2);
        assertEquals(BASE_SCORE + THREAT_MULTIPLIER, ksw.getScore());
    }
}
