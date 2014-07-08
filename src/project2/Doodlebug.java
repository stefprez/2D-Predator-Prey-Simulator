/**
 * Doodlebug.java
 *
 * Create the Doodlebug subclass and default constructor
 * 
 * Project 2 due May 28, 2014
 * 
 * @author Stefano Prezioso
 * @date May 15, 2014
 */
package project2;

public class Doodlebug extends Organism
{
	final static int STARVE_THRESHOLD = 3;
	int timeSinceEat;
	
	/**
	* Empty Constructor
	*/
	public Doodlebug()
	{
		super();
		this.symbol = 'X';
		this.breedThreshold = 8;
		this.timeSinceEat = 0;
	}
	
	/**
	* Complete Constructor.
	* @param row Row position of new Doodlebug
	* @param col Column position of new Doodlebug
	*/
	public Doodlebug(int row, int col)
	{
		super(row, col);
		this.symbol = 'X';
		this.breedThreshold = 8;
		this.timeSinceEat = 0;
	}
	
	/**
	* Copy Constructor
	* @param d Doodlebug to be copied
	*/
	public Doodlebug(Doodlebug d)
	{
		super(d);
		this.symbol = d.symbol;
		this.breedThreshold = d.breedThreshold;
		this.timeSinceEat = d.timeSinceEat;
	}
	
	/**
	* Takes int 1, 2, 3, or 4, and moves bug up, right, down, or left respectively.
	* @param direction The direction in which to move the bug.
	*/
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
	
	/**
	* Returns the position, four flag values, time since last ate,
	* and time since last bred as a String.
	* @return String of information and values about Doodlebug
	*/
	public String toString()
	{
		return "Doodlebug at " +  this.getRowPosition() + ", " + this.getColPosition() + "\n" +
				"topFlag " + this.topFlag + "\n" +
				"rightFlag " + this.rightFlag + "\n" +
				"bottomFlag " + this.bottomFlag + "\n" +
				"leftFlag " + this.leftFlag + "\n" +
				"timeSinceEat: " + this.timeSinceEat + "\n" +
				"timeSinceBreed: " + this.timeSinceBreed;
	}
}
