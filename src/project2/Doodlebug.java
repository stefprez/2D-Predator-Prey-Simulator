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
	final static int STARVE_THRESHOLD = 3;
	
	//Empty Constructor
	public Doodlebug()
	{
		super();
		this.symbol = 'X';
		this.breedThreshold = 8;
	}
	
	//Complete Constructor
	public Doodlebug(int row, int col)
	{
		super(row, col);
		this.symbol = 'X';
		this.breedThreshold = 8;
	}
	
	public Doodlebug(Doodlebug d)
	{
		super(d);
	}
	
	//Takes int 1, 2, 3, or 4, and moves bug up, right, down, or left respectively
	public void moveBug(int direction)
	{
		if (direction < 1 || direction > 4)
		{
			System.out.println("Error: Improper moveBug parameter.");
			System.exit(0);
		}
		
		switch (direction) {
			case 1: Board.field[this.getRowPosition() - 1][this.getColPosition()] = null; //Remove Ant
					Board.field[this.getRowPosition() - 1][this.getColPosition()] = this; //Copy over DB
					Board.field[this.getRowPosition()][this.getColPosition()] = null; //Remove old DB
					this.setRowPosition(this.getRowPosition() - 1);
					break;
					
			case 2: Board.field[this.getRowPosition()][this.getColPosition() + 1] = null; //Remove Ant
					Board.field[this.getRowPosition()][this.getColPosition() + 1] = this; //Copy over DB
					Board.field[this.getRowPosition()][this.getColPosition()] = null; //Remove old DB
					this.setColPosition(this.getColPosition() + 1);
					break;
					
			case 3: Board.field[this.getRowPosition() + 1][this.getColPosition()] = null; //Remove Ant
					Board.field[this.getRowPosition() + 1][this.getColPosition()] = this; //Copy over DB
					Board.field[this.getRowPosition()][this.getColPosition()] = null; //Remove old DB
					this.setRowPosition(this.getRowPosition() + 1);
					break;
					
			case 4: Board.field[this.getRowPosition()][this.getColPosition() - 1] = null; //Remove Ant
					Board.field[this.getRowPosition()][this.getColPosition() - 1] = this; //Copy over DB
					Board.field[this.getRowPosition()][this.getColPosition()] = null; //Remove old DB
					this.setColPosition(this.getColPosition() - 1);
					break;
		}
	}
	
	public void move()
	{
		//Check for Ant
		
		//If Ant, eat.
		
		//If no ant, check for open space
		//Move to open space
		//If no open space, do not move
	}
}
