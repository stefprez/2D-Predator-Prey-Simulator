/**
 * Organism.java
 *
 * Create the Organism superclass with default constructor and
 * getSymbol method.
 * 
 * Project 2 due May 28, 2014
 * 
 * @author Stefano Prezioso
 * @date May 15, 2014
 */
package project2;

public class Organism
{
	int breedThreshold; //At what point the Organism breeds
	int timeSinceBreed;
	char symbol; //O for Ants, X for Doodlebugs
	int rowPosition;
	int colPosition;
	
	//Flags for against edges to prevent out of bounds exceptions.
	boolean topFlag;
	boolean rightFlag;
	boolean bottomFlag;
	boolean leftFlag;
	
	/**
	* Empty Constructor
	*/
	public Organism()
	{
		this.setRowPosition(-1);
		this.setColPosition(-1);
		this.timeSinceBreed = 0;
		this.topFlag = true;
		this.bottomFlag = true;
		this.leftFlag = true;
		this.rightFlag = true;
		
	}
	
	/**
	* Complete Constructor
	* @param row The row position of the new Organism 
	* @param col The column position of the new Organism
	*/
	public Organism(int row, int col)
	{
		this.setRowPosition(row);
		this.setColPosition(col);
		this.timeSinceBreed = 0;
	}
	
	/**
	* Copy Constructor
	* @param o Organism to be copied
	*/
	public Organism(Organism o)
	{
		this.breedThreshold = o.breedThreshold;
		this.timeSinceBreed = o.timeSinceBreed;
		this.symbol = o.symbol;
		this.setRowPosition(o.getRowPosition());
		this.setColPosition(o.getColPosition());
	}
	
	/**
	* @return symbol as char
	*/
	public char getSymbol()
	{
		return this.symbol;
	}
	
	/**
	* @return row position as int
	*/
	public int getRowPosition()
	{
		return this.rowPosition;
	}
	
	/**
	* @return column position as int
	*/
	public int getColPosition()
	{
		return this.colPosition;
	}
	
	/**
	* Sets flags if along edge or in corner of board.
	* @param row New row position
	*/
	public void setRowPosition(int row)
	{
		this.topFlag = false;
		this.bottomFlag = false;
		
		this.rowPosition = row;
		
		if (row <= 0)
		{
			this.topFlag = true;
		}
		
		else if(row >= 19)
		{
			this.bottomFlag = true;
		}
	}
	
	/**
	* Sets flags if along edge or in corner of board.
	* @param col New column position
	*/
	public void setColPosition(int col)
	{
		this.leftFlag = false;
		this.rightFlag = false;
		
		this.colPosition = col;
		
		if (col <= 0)
		{
			this.leftFlag = true;
		}
		
		else if(col >= 19)
		{
			this.rightFlag = true;
		}
	}
}
