/**
 * Organism.java
 *
 * Create the Organism superclass with default constructor and
 * getSymbol method.
 * 
 * Project 2 due May 26, 2014
 * 
 * @author Stefano Prezioso
 * @date May 15, 2014
 */
package project2;

public class Organism
{
	int breedThreshold;
	int timeSinceBreed;
	char symbol;
	int rowPosition;
	int colPosition;
	
	public Organism()
	{
		this.rowPosition = -1;
		this.colPosition = -1;
		this.timeSinceBreed = 0;
		
	}
	
	public Organism(int row, int col)
	{
		this.rowPosition = row;
		this.colPosition = col;
		this.timeSinceBreed = 0;
	}
	
	public char getSymbol()
	{
		return this.symbol;
	}
	
	public int getRowPosition()
	{
		return this.rowPosition;
	}
	
	public int getColPosition()
	{
		return this.colPosition;
	}
	
	
}
