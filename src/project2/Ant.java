/**
 * Ant.java
 *
 * Create Ant subclass and default constructor
 * 
 * Project 2 due May 28, 2014
 * 
 * @author Stefano Prezioso
 * @date May 15, 2014
 */
package project2;

public class Ant extends Organism
{
	/**
	* Empty Constructor.
	* Sets symbol to 'O' and breedThreshold to 3.
	*/
	public Ant()
	{
		super();
		this.symbol = 'O';
		this.breedThreshold = 3;
	}
	
	/**
	* Complete Constructor.
	* Places Ant at given row and col values, sets symbol to 'O'
	* and breedThreshold to 3.
	* @param row The row position the new Ant will occupy.
	* @param col The column position the new Ant will occupy.
	*/
	public Ant(int row, int col)
	{
		super(row, col);
		this.symbol = 'O';
		this.breedThreshold = 3;
	}
	
	/**
	* Copy Constructor
	* @param a The Ant object to be copied.
	*/
	public Ant (Ant a)
	{
		super(a);
	}
	
	/**
	* Moves called bug in the given direction.
	* @param direction The direction for the bug to be moved. Must be 1, 2, 3, or 4.
	*/
	public void moveBug(int direction)
	{
		if (direction < 1 || direction > 4)
		{
			System.err.println("Error: Improper moveBug parameter.");
			System.exit(0);
		}
		
		switch (direction) {
		case 1: //Board.field[this.getRowPosition() - 1][this.getColPosition()] = null; //Remove Ant
				Board.field[this.getRowPosition() - 1][this.getColPosition()] = this; //Copy over Ant
				Board.field[this.getRowPosition()][this.getColPosition()] = null; //Remove old Ant
				this.setRowPosition(this.getRowPosition() - 1);
				break;
				
		case 2: //Board.field[this.getRowPosition()][this.getColPosition() + 1] = null; //Remove Ant
				Board.field[this.getRowPosition()][this.getColPosition() + 1] = this; //Copy over Ant
				Board.field[this.getRowPosition()][this.getColPosition()] = null; //Remove old Ant
				this.setColPosition(this.getColPosition() + 1);
				break;
				
		case 3: //Board.field[this.getRowPosition() + 1][this.getColPosition()] = null; //Remove Ant
				Board.field[this.getRowPosition() + 1][this.getColPosition()] = this; //Copy over Ant
				Board.field[this.getRowPosition()][this.getColPosition()] = null; //Remove old Ant
				this.setRowPosition(this.getRowPosition() + 1);
				break;
				
		case 4: //Board.field[this.getRowPosition()][this.getColPosition() - 1] = null; //Remove Ant
				Board.field[this.getRowPosition()][this.getColPosition() - 1] = this; //Copy over Ant
				Board.field[this.getRowPosition()][this.getColPosition()] = null; //Remove old Ant
				this.setColPosition(this.getColPosition() - 1);
				break;
	}
		
	}
}
