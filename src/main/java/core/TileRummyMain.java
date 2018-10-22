package core;

import java.util.*;

public class TileRummyMain {
	
	public static final String[] suites = {"R", "B", "G", "Y"};
	public static final int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	public static ArrayList<ArrayList<Tile>> field = new ArrayList<ArrayList<Tile>>();
	ArrayList<Tile> initDeck = new ArrayList<Tile>();
	List<String> initDeckDummy = new ArrayList<String>();
	public Player player0 = new Player();
	public AI player1 = new AI();
	public AI player2 = new AI();
	public AI player3 = new AI();
	boolean gameStatus = true;
	public int playerTurn = 0;
	public static int fieldSize = 0;
	
	public void initialize() {
		initDeck = buildDeck(suites,values);
		//initDeckDummy = buildDeck(suites,values);
		//Collections.shuffle(initDeckDummy);
		Collections.shuffle(initDeck);
		dealHands();
	}
	
	//public static List<String> buildDeck(String[] suites, String[] values){
	public static ArrayList<Tile> buildDeck(String[] suites, int[] values){ //when we are done the tile class 
		ArrayList<Tile> dummyDeck = new ArrayList<Tile>();
		//List<String> initDeckDummy2 = new ArrayList<String>();
		for(int x = 0; x < 2; x++) {
			for (int i = 0; i < suites.length; i++){ // for each colour 
				for (int j = 0; j < values.length; j++){ // for each value 
					Tile k = new Tile(suites[i], values[j]); 
					//String k = (values[j]) + (suites[i]);
					//initDeckDummy2.add(k); // adding it into the dummy deck 
					dummyDeck.add(k);
				}
			}
		}
		//initDeckDummy2.add("BJ");
		//initDeckDummy2.add("RJ");
		//return initDeckDummy2;
		//TODO Add Wild Tiles
		return dummyDeck;
	}
	
	public void showDeck() {
		System.out.println();
		for(int i = 0; i < initDeck.size(); i++) {
			System.out.print( initDeck.get(i).toString() + " ");
		}
		System.out.println();
		System.out.println(initDeck.size());
	}
	
	public void dealHands() {
		for(int i = 0; i < 14; i++) {
			player0.drawTile(initDeck);
			player1.drawTile(initDeck);
			player2.drawTile(initDeck);
			//player3.drawTile(initDeck);
		}
	}

	public void showHands() {
		System.out.println("User's 1 Hand: " + player1.getHand() );
		
	}
	public void getHandSize() { 
		
	}
	public void showField() {
		if(field.size() > 0) {
			for(int x = 0; x < field.size(); x++) { // gets the length of the first object in the first position
				System.out.print(field.get(x) + ",");
			}
			System.out.println(); //spacing
		}else {
			System.out.println("field is empty");
		}
	}
/*
	public boolean checkMend(ArrayList<Tile> collection){ // checks for users first hand with sets 
		// move this to player after team meeting
		boolean returnV = true;
		int checkSum = 0;
		ArrayList<String> suitDeck = new ArrayList<String>();
		int checkValue = collection.get(0).getValue();
		if(collection.size() == 0) {
			return false;
		}else {
			for(int i = 0; i < collection.size(); i++) {
				if(!suitDeck.contains(collection.get(i).getColour())) {
					if(collection.get(i).getValue() == checkValue){
						suitDeck.add(collection.get(i).getColour());
						checkSum += collection.get(i).getValue();
					}
				}
			}
		}
		System.out.println(checkSum + " " + suitDeck + " " + checkValue);
		if(checkSum < 30) {
			returnV = false;
		}
		if(returnV) {
			System.out.println(checkSum);
			addMend(collection);
		}
		return returnV;
	}
*/
	
	public static void addMend(ArrayList<Tile> collection) { // basic adding into the field of tiles
		System.out.println(collection.size());
		field.add(collection);
		System.out.println(field.get(fieldSize));
		fieldSize++;
	}
	
	

	public boolean checkGameStatus() {
		if(player0.getHand().size() == 0) {
			gameStatus = false;
			System.out.println("Player has won!");
		}else if(player1.getHand().size() == 0) {
			gameStatus = false;
			System.out.println("User 2 has won!");
		}else if(player2.getHand().size() == 0) {
			gameStatus = false;
			System.out.println("User 3 has won!");
		}else if(player3.getHand().size() == 0) {
			gameStatus = false;
			System.out.println("User 4 has won!");
		}
		return gameStatus;
	}

	public void playGame() { // where most of the game logic is going to go.
		while(gameStatus){
			System.out.print(playerTurn + " ");
			if(playerTurn == 0) {
				System.out.println("Players Turn");
			}else if(playerTurn == 1){
				System.out.println("AI 1's Turn");
			}else if(playerTurn == 2){
				System.out.println("AI 2's Turn");
			}else if(playerTurn == 3){
				System.out.println("AI 3's Turn");
				playerTurn = playerTurn%3;
				break;
			}
			playerTurn++;
		}
	}

	public void drawTile() {
		Tile drawTile = initDeck.remove(0);
		if(playerTurn == 0) {
			player0.addTile(drawTile);
			System.out.println("Players draws a tile");
		}else if(playerTurn == 1){
			System.out.println("AI 1's draws a tile");
			player1.addTile(drawTile);
		}else if(playerTurn == 2){
			System.out.println("AI 2's draws a tile");
			player2.addTile(drawTile);
		}else if(playerTurn == 3){
			System.out.println("AI 3's draws a tile");
			player3.addTile(drawTile);
		}
	}

	public boolean checkPlays(ArrayList<ArrayList<Tile>> temp1) {
		if(player0.checkPlays(temp1)) {
			for(int i = 0; i < temp1.size(); i++) {
				addMend(temp1.get(i));
			}
		}
		return false;
	}
}
