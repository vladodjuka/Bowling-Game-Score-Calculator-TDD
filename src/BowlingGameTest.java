
/** BowlingGameTest 
 *
 * @author CDT414 Student:
 * @version 1.0 
 * @date 2016-11-24
 */
import junit.framework.TestCase;

/**
 * BowlingGame Score calculator test cases
 * 
 */
public class BowlingGameTest extends TestCase {

	/**
	 * test01
	 * 
	 * If no game is provided, score should be -1 (error)
	 */
	public void test01() {
		BowlingGame bowlingGame = new BowlingGame("");
		assertEquals(-1, bowlingGame.getScore());
	}

	// TODO: Add more test cases below...

	public void testIfObjectVariableIsInitialized() {
		// testing if object is initialized.
		// After it results in failure,
		// we make a small code change and fix it.
		BowlingGame bowlingGame = new BowlingGame("");
		assertNotNull(bowlingGame);
	}

	public void testConstructorValue() {
		// testing if constructor argument is passed to any global variable so
		// we could use it in a method.
		// After it results in failure,
		// we make a small code change and fix it.
		BowlingGame bowlingGame = new BowlingGame();
		bowlingGame.setGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]", bowlingGame.getGame());
	}

	public void testArgumentMinimumSet() {
		// testing if constructor argument contains minimum 10 frames
		// After it results in failure,
		// we make a small code change and fix it.
		BowlingGame bowlingGame = new BowlingGame("[3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testSecondValueInFrameValidity() {
		// testing what is returned if second frame value is 10 which is not
		// possible.
		// After it results in failure,
		// we make a small code change and fix it.
		BowlingGame bowlingGame = new BowlingGame("[0,10][7,10][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(-1, bowlingGame.getScore());
	}

	public void testOpenFrames() {
		// testing if game works for open frames. After it results in failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(81, bw.getScore());
	}

	public void testCalculationIfNumberIsMistakenWithString() {
		// testing if -1 is returned if one of numbers is mistaken as a string.
		// After it doesn't do what is supposed then
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[5,1][6,1][7,j][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(-1, bw.getScore());
	}

	public void testOneStrike() {
		// testing if game works for calculating one strike. After it results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[10,0][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(94, bw.getScore());
	}

	public void testMultipleStrikesNotInARow() {
		// testing if game works for calculating multiple strikes which are not
		// in a row. After it results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[10,0][3,6][7,2][3,6][4,4][5,3][3,3][4,5][10,0][2,3]");
		assertEquals(97, bw.getScore());
	}

	public void testMultipleStrikesInARow() {
		// testing if game works for calculating multiple strikes in a row.
		// After it
		// results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[10,0][10,0][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(112, bw.getScore());
	}

	public void testOneSpare() {
		// testing if game works for calculating one spare.
		// After it
		// results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[1,9][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(88, bw.getScore());
	}

	public void testMultipleSpares() {
		// testing if game works for calculating multiple spares.
		// After it
		// results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[1,9][5,5][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(98, bw.getScore());
	}

	public void testStrikeFollowedBySpare() {
		// testing if game works for calculating a case when strike is followed
		// by spare.
		// After it
		// results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[10,0][4,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,6]");
		assertEquals(103, bw.getScore());
	}

	public void testStrikeInTheLastFrame() {
		// testing if game works for calculating a case when strike is in last
		// frame.
		// After it
		// results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][10,0][7,2]");
		assertEquals(92, bw.getScore());
	}

	public void testSpareInTheLastFrame() {
		// testing if game works for calculating a case when spare is in last
		// frame.
		// After it
		// results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[1,5][3,6][7,2][3,6][4,4][5,3][3,3][4,5][8,1][2,8][7]");
		assertEquals(90, bw.getScore());
	}

	public void testPerfectGame() {
		// testing if game works for calculating a case of perfect game.
		// After it
		// results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
		assertEquals(300, bw.getScore());
	}
	
	public void testInvalidStrike() {
		// Testing if game works for checking invalid strike and returns -1.
		// After it
		// results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[10,2][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
		assertEquals(-1, bw.getScore());
	}
	public void testInvalidStrike2() {
		// Testing if game works for checking invalid strike and returns -1.
		// After it
		// results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[10,0][j,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
		assertEquals(-1, bw.getScore());
	}
	public void testInvalidStrike3() {
		// Testing if game works for checking invalid strike and returns -1.
		// After it
		// results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[10,0][10,0][j,j][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
		assertEquals(-1, bw.getScore());
	}
	
	public void testInvalidSpare() {
		// Testing if game works for checking invalid spare and returns -1.
		// After it
		// results in
		// failure,
		// we make a small code change and fix it.
		BowlingGame bw = new BowlingGame("[8,2][j,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,0][10,10]");
		assertEquals(-1, bw.getScore());
	}


}