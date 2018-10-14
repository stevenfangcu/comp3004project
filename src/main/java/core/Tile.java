package core;

import java.io.File;

public class Tile implements Comparable<Tile>
{
	private int value;
	private String colour;
	private static final String imageDir = "src/main/resources/core/cards/";
	private File tileImage;
	public String getColour() { return colour;}
	public int getValue() { return value;}
	public boolean joker = false;
	
	public Tile(String tileColour, int value) {
		if(value == 99){ // setting it up as a dummy checker for Jokers, need team input
			this.joker = true;
		}else {
			setValue(value);
		}
		setColour(tileColour);
		//TODO Set Image
	}
	
	public boolean setValue(int tempValue) 
	{
		if( 13 < tempValue || tempValue < 1)
			return false;
		this.value = tempValue;
		return true;
	}

	public boolean setColour(String tempColour) 
	{
		tempColour.trim(); 
		tempColour = tempColour.toUpperCase(); //case sensitive is handled
		if(!tempColour.isEmpty()) {
			tempColour = tempColour.substring(0,1);} //change to single letter form
		if(!tempColour.equals("R") & !tempColour.equals("B") & !tempColour.equals("G") & !tempColour.equals("Y"))
			return false;
		this.colour = tempColour;
		return true;
	}
	
	public boolean setFileImage(String fileName) 
	{
		File file = new File(imageDir + fileName);
		tileImage = file;
		
		if(tileImage != null)
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
	
	public String toString() {
		return colour + value;
	}
	
	@Override
	public int compareTo(Tile o) {
		if (this.value == o.value) {
			return this.colour.compareTo(o.colour);
		} else {
			return Integer.compare(this.value, o.value);
		}
	}
}
