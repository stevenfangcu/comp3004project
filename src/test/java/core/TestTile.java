package core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import junit.framework.TestCase;

public class TestTile extends TestCase
{
		@Test
		public void testGetValue()
		{
			Tile testTile = new Tile("", 0);
			
			/* Check extreme values */
			assertEquals(testTile.setValue(-1), false);
			assertEquals(testTile.setValue(10), true);
			assertEquals(testTile.setValue(1000), false);
			assertEquals(testTile.getValue(), 10);
		}
		@Test
		public void testGetColour()
		{
			Tile testTile = new Tile("", 0);
			
			//Check each colour Red, Green, Blue, Black
			assertEquals(testTile.setColour("green"), true);
			assertEquals(testTile.getColour(), "G");
			
			assertEquals(testTile.setColour("blue"), true);
			assertEquals(testTile.getColour(), "B");
			
			assertEquals(testTile.setColour("orange"), true);
			assertEquals(testTile.getColour(), "O");
			
			assertEquals(testTile.setColour("red"), true);
			assertEquals(testTile.getColour(), "R");
			
			assertEquals(testTile.setColour("blue"), true);
			assertEquals(testTile.getColour(), "B");
			
			assertEquals(testTile.setColour("Orange"), true);
			assertEquals(testTile.getColour(), "O");
			
			assertEquals(testTile.setColour("Red"), true);
			assertEquals(testTile.getColour(), "R");
		}
		
		@Test
		public void testTileConstructor() {
			Tile testTile = new Tile("Orange", 13);
			assertEquals(testTile.getValue(), 13);
			assertEquals("O", testTile.getColour());
			
			testTile = new Tile("blue", 1);
			assertEquals(testTile.getValue(), 1);
			assertEquals("B", testTile.getColour());
		}
		/* @Test
		public void testGetFileImage()
		{
			Tile testTile = new Tile();
			assertEquals(1, 2);
		} */
		
		@Test
		public void testSetValue()
		{
			Tile testTile = new Tile("", 0);
			/* Check values 1 to 13 */
			for(int i = 1; i < 14; i++)
			{
				assertEquals(testTile.setValue(i), true);
				assertEquals(testTile.getValue(), i);
			}
		}
		@Test
		public void testSetColour()
		{
			Tile testTile = new Tile("", 0);
			/* check each colour */
			assertEquals(testTile.setColour("green"), true);
			assertEquals(testTile.setColour("blue"), true);
			assertEquals(testTile.setColour("red"), true);
			assertEquals(testTile.setColour("orange"), true);

			assertEquals(testTile.setColour("Blue"), true);
			assertEquals(testTile.setColour("Red"), true);
			assertEquals(testTile.setColour("Orange"), true);
			assertEquals(testTile.setColour("R"), true);
			assertEquals(testTile.setColour("Blfdsafji"), true); //turns to Blue
			assertEquals(testTile.setColour("Not a colour"), false);
		}
		
		@Test
		public void testToString() {
			Tile testTile = new Tile("O", 7);
			assertEquals("O7", testTile.toString());
			testTile.setValue(11);
			assertEquals("O11", testTile.toString());
		}
		@Test
		public void testSetFileImage()
		{
			Tile testTile = new Tile("B", 4);
			assertEquals(testTile.setFileImage("TileB10.jpg"), true);
			assertEquals(testTile.setFileImage("TileR9.jpg"), true);
			assertEquals(testTile.setFileImage("TileB10.jpg"), true);
			assertEquals(testTile.setFileImage("TileO9.jpg"), true);
		}
		
		@Test
		public void testCompareTo() {
			assertEquals(0, new Tile("B", 4).compareTo(new Tile("B", 4)));
			assertEquals(13, new Tile("O", 4).compareTo(new Tile("B", 4)));
			assertEquals(-13, new Tile("B", 4).compareTo(new Tile("O", 4)));
			assertEquals(-2, new Tile("B", 4).compareTo(new Tile("B", 6)));
			assertEquals(2, new Tile("B", 6).compareTo(new Tile("B", 4)));
		}
		
		@Test
		public void testSetPos() 
		{
			Tile r4 = new Tile("R", 4);
			assertEquals(r4.setx(9999), false);
			assertEquals(r4.sety(9999), false);
			assertEquals(r4.setx(100), true);
			assertEquals(r4.sety(100), true);
		}
}
