/**
 * Ant.java
 *
 * Create Ant subclass and default constructor
 * 
 * Project 2 due May 26, 2014
 * 
 * @author Stefano Prezioso
 * @date May 15, 2014
 */
package project2;

public class Ant extends Organism
{
	
	public Ant()
	{
		super();
		this.symbol = 'O';
		this.breedThreshold = 3;
	}
	
	public Ant(int row, int col)
	{
		super(row, col);
		this.symbol = 'O';
		this.breedThreshold = 3;
	}
	
//	Integer[] directionOrder = Board.randomDirections();
	
	public void moveBug(int direction)
	{
		if (direction < 1 || direction > 4)
		{
			System.out.println("Error: Improper moveBug parameter.");
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
