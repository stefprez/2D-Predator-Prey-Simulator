/**
 * Doodlebug.java
 *
 * Create the Doodlebug subclass and default constructor
 * 
 * Project 2 due May 26, 2014
 * 
 * @author Stefano Prezioso
 * @date May 15, 2014
 */
package project2;

public class Doodlebug extends Organism
{
	
	public Doodlebug()
	{
		super();
		this.symbol = 'X';
		this.breedThreshold = 8;
	}
	
	public Doodlebug(int row, int col)
	{
		super(row, col);
		this.symbol = 'X';
		this.breedThreshold = 8;
	}
	
//	public boolean antChecker()
//	{
//		//Check four positions for Ant
//		if (	Board.getBug(this.getRowPosition() + 1, this.getColPosition()) instanceof Ant ||
//				Board.getBug(this.getRowPosition() - 1, this.getColPosition()) instanceof Ant ||
//				Board.getBug(this.getRowPosition(), this.getColPosition() + 1) instanceof Ant ||
//				Board.getBug(this.getRowPosition(), this.getColPosition() - 1) instanceof Ant
//			)			
//		{
//			return true;
//		}
//		
//		else
//			return false;
//	}
	
	public void move()
	{
		//Check for Ant
		
		//If Ant, eat.
		
		//If no ant, check for open space
		//Move to open space
		//If no open space, do not move
	}
}
