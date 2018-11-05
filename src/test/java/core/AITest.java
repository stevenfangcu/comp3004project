package core;

import java.util.ArrayList;
import java.util.Collections;

import junit.framework.TestCase;

public class AITest extends TestCase{
	public void testAddToField() { //tests if adding given tiles to the board could have a valid board
		
	}
	public void testValidField() { //checks if the board contains all valid melds without extra tiles
		
	}
	public void testAIPlayer1() {
		TileRummyMain result = new TileRummyMain();
		result.initialize();
		System.out.println("Player1 Hand: ");
		result.player1.showHand();
		System.out.println("Field: ");
		result.showField();
		
		result.player1.playTurn();
		
		System.out.println("Player1 Hand: ");
		result.player1.showHand();
		System.out.println("Field: ");
		result.showField();
	}
	
	public void test2AIPlayer1() {
		TileRummyMain result = new TileRummyMain();
		result.resetStaticVars();
		Tile t1 = new Tile("B", 9);
		result.player1.addTile(t1);
		Tile t2 = new Tile("B", 10);
		result.player1.addTile(t2);
		Tile t3 = new Tile("B", 11);
		result.player1.addTile(t3);
		Tile t4 = new Tile("B", 12);
		result.player1.addTile(t4);
		
		result.player1.playTurn();
		System.out.println("Field: ");
		result.showField();
		assertNotNull(result.field.get(0));
		
		result.player1.addTile(new Tile("O", 1));
		result.player1.addTile(new Tile("R", 1));
		result.player1.addTile(new Tile("G", 1));
		result.player1.addTile(new Tile("O", 2));
		result.player1.addTile(new Tile("G", 2));
		result.player1.playTurn();
		System.out.println("Field: ");
		result.showField();
		assertNotNull(result.field.get(1));
		result.player1.addTile(new Tile("B", 2));
		result.player1.playTurn();
		System.out.println("Field: ");
		result.showField();
		assertNotNull(result.field.get(2));
	}
	public void test30Player1() { //4a1 , 4a2, 4b1, 4b2, 4c
		TileRummyMain result = new TileRummyMain();
		result.resetStaticVars();
		//can try with 9, 10, 11 of same colour also
		//result.player1.addTile(new Tile("B", 9)); 
		//result.player1.addTile(new Tile("B", 10));
		//result.player1.addTile(new Tile("B", 11));
		result.player1.addTile(new Tile("O", 10)); 
		result.player1.addTile(new Tile("R", 10));
		result.player1.addTile(new Tile("G", 10));
		ArrayList<ArrayList<Tile>> aa1 = new ArrayList<ArrayList<Tile>>();
		assertEquals(aa1, result.field);
		result.player1.playTurn();
		System.out.println("test 30Player1 Field: ");
		result.showField();
		assertNotNull(result.field.get(0));
		
		//over 30  4a2
		result.resetStaticVars();
		result.player1.addTile(new Tile("O", 11)); 
		result.player1.addTile(new Tile("R", 11));
		result.player1.addTile(new Tile("G", 11));
		assertEquals(aa1, result.field);
		result.player1.playTurn();
		System.out.println("test Over30Player1 Field: ");
		result.showField();
		assertNotNull(result.field.get(0));
		
		result.resetStaticVars();
		result.player1.addTile(new Tile("O", 1)); 
		result.player1.addTile(new Tile("R", 1));
		result.player1.addTile(new Tile("G", 1));
		result.player1.addTile(new Tile("O", 2)); 
		result.player1.addTile(new Tile("R", 2));
		result.player1.addTile(new Tile("G", 2));
		result.player1.addTile(new Tile("O", 3)); 
		result.player1.addTile(new Tile("R", 3));
		result.player1.addTile(new Tile("G", 3));
		result.player1.addTile(new Tile("O", 4)); 
		result.player1.addTile(new Tile("R", 4));
		result.player1.addTile(new Tile("G", 4));
		assertEquals(aa1, result.field);
		result.player1.playTurn();
		System.out.println("test 30Player1 MultiMelds Field: ");
		result.showField();
		assertNotNull(result.field.get(0));
		assertNotNull(result.field.get(1));
		assertNotNull(result.field.get(2));
		
		result.resetStaticVars();
		result.player0.addTile(new Tile("O", 1)); 
		result.player2.addTile(new Tile("R", 1));
		result.player3.addTile(new Tile("G", 1));
		result.player1.addTile(new Tile("O", 1)); 
		result.player1.addTile(new Tile("R", 1));
		result.player1.addTile(new Tile("G", 1));
		result.player1.addTile(new Tile("O", 2)); 
		result.player1.addTile(new Tile("R", 2));
		result.player1.addTile(new Tile("G", 2));
		result.player1.addTile(new Tile("B", 8));
		result.player1.addTile(new Tile("G", 8));
		result.player1.addTile(new Tile("O", 8)); 
		result.player1.addTile(new Tile("B", 5)); 
		result.player1.addTile(new Tile("B", 6));
		result.player1.addTile(new Tile("B", 7));
		
		assertEquals(true, result.checkGameStatus()); //check win
		assertEquals(aa1, result.field);
		result.player1.playTurn();
		System.out.println("test Over30Player1 MultiMelds Field: ");
		result.showField();
		assertNotNull(result.field.get(0));
		assertNotNull(result.field.get(1));
		assertNotNull(result.field.get(2));
		assertNotNull(result.field.get(3));
		assertEquals(false, result.checkGameStatus()); //won
	}
	
	public void testPlayer1DrawTile() {
		TileRummyMain result = new TileRummyMain();
		result.resetStaticVars();
		result.buildDeck(TileRummyMain.suites, TileRummyMain.values);
		Collections.shuffle(result.initDeck);
		result.player1.playTurn(); //should draw a Tile
		assertEquals(1, result.player1.getHand().size());
	}
	
	//Works when TileRummyMain dealHands() deals to Player3
	public void testExistsAComparativelySmallHand() {
		TileRummyMain result = new TileRummyMain();
		result.initialize();
		Strategy3 strat3 = new Strategy3();
		assertEquals(false, strat3.existsAComparativelySmallHand());
		result.player3.addTile(new Tile("B", 2));
		result.player3.addTile(new Tile("B", 3));
		assertEquals(false, strat3.existsAComparativelySmallHand());
		result.player3.addTile(new Tile("R", 3));
		assertEquals(true, strat3.existsAComparativelySmallHand());
	}
}
