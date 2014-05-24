/**
 * Board.java
 *
 * Create Board class with default and complete
 * constructors. Generates a 20x20 board with
 * 100 Ants and 5 Doodlebugs by default.
 * Contains methods to initialize the board,
 * check if a cell is occupied, place a bug in
 * a cell, and print out the board.
 * 
 * 
 * Project 2 due May 26, 2014
 * 
 * @author Stefano Prezioso
 * @date May 15, 2014
 */
package project2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
//import java.util.Scanner;

public class Board {
	
	static Organism[][] field = new Organism[20][20];
	int numberOfAnts;
	int numberOfDoodlebugs;
	Random randomNumGen = new Random();
	int rowScan = 0;
	int colScan = 0;
	
	//Default Constructor
	public Board()
	{
		this.numberOfAnts = 100;
		this.numberOfDoodlebugs = 5;
		initializeBoard(this.numberOfAnts, this.numberOfDoodlebugs);
	}
	
	//Complete Constructor
	public Board(int ants, int doodlebugs)
	{
		this.numberOfAnts = ants;
		this.numberOfDoodlebugs = doodlebugs;
		initializeBoard(this.numberOfAnts, this.numberOfDoodlebugs);
		
	}
	
	//Fill with Ants first, then Doodlebugs
	public void initializeBoard(int numAnt, int numDoodlebugs)
	{		
		//Place Ants in field
		for (int i = 0; i < numAnt; i++)
		{
			placeBug(new Ant(), numAnt);
			//System.out.println("Ant Placement: " + i); //Debugging
		}
		
		//Place Doodlebugs in field
		for (int i = 0; i < numDoodlebugs; i++)
		{
			placeBug(new Doodlebug(), numDoodlebugs);
			//System.out.println("Doodlebug Placement: " + i); //Debugging
		}
		
	}
	
	//Check if cell is occupied, return true if occupied with Bug, otherwise false
	public boolean isOccupied(int row, int col)
	{
		//System.out.println("isOccupied conditional says: " + (this.field[row][col].symbol != ' ')); //Debugging
		
		//Check for null value in given field index
		if (Board.field[row][col] != null)
		{
			//System.out.println("isOccupied returned true"); //Debug
			return true;
		}
		
		else
		{
			//System.out.println("isOccupied returned false"); //Debug
			return false;
		}
	}
	
	//Place bug in empty cell. Only for initializing new board!
	public void placeBug(Organism bug, int numBug)
	{
		//Declare and initialize random row and column values
		int row = randomNumGen.nextInt(20);
		int col = randomNumGen.nextInt(20);
		
		//int counter = 0; //debug
		
		//Cycle through field until an empty cell is found
		while (this.isOccupied(row, col))
		{
			row = randomNumGen.nextInt(20);
			col = randomNumGen.nextInt(20);
			//counter++; //Debug
		}

		//System.out.println("Made if out of placeBug while loop: " + counter); //debug

		//Place a new Ant in open cell
		if(bug instanceof Ant)
		{
			//System.out.println("placeBug placed an Ant"); //Debug
			field[row][col] = new Ant(row, col);
			
		}
		
		//Place a new Doodlebug in open cell
		else if(bug instanceof Doodlebug)
		{
			//System.out.println("placeBug placed a DoodleBug");  //Debug
			field[row][col]= new Doodlebug(row, col);
		}
		
		//Error catching
		else
		{
			System.out.println("Error in placeBug method! Did not place a bug in an open cell.");
		}
	}
	
	//Return Organism at given row and column
	public Organism getBug(int row, int col)
	{
		return field[row][col];
	}
	
	// Return int of null location (empty cell). 1 = Up, 2 = Right, 3 = Down, 4 = Left. 0 = No empty cells.
	// 3 = Up/Right, 5 = Up/Down, 6 = Right/Down, 7 = Up/Right/Down,
	// 9 = 8 + 1, 10 = 8 + 2, 11 = 8 + 2 + 1, 12 = 8 + 4
	// 13 = 8 + 4 + 1, 14 = 8 + 4 + 2, 15 = 8 + 4 + 2 + 1.
	public int emptyCellChecker(Organism bug)
	{
		int flag = 0;
		
		//Check four positions for null
		if (getBug(bug.getRowPosition() - 1, bug.getColPosition()) == null)
			flag += 1;
		
		if (getBug(bug.getRowPosition(), bug.getColPosition() + 1) == null)
			flag += 2;
		
		if (getBug(bug.getRowPosition() + 1, bug.getColPosition()) == null)
			flag += 4;
		
		if (getBug(bug.getRowPosition(), bug.getColPosition() - 1) == null)
			flag += 8;
		
		return flag;
	}
	
//	// Return int of Ant location. 1 = Up, 2 = Right, 4 = Down, 8 = Left. 0 = No Ant.
//	// 3 = Up/Right, 5 = Up/Down, 6 = Right/Down, 7 = Up/Right/Down,
//	// 9 = 8 + 1, 10 = 8 + 2, 11 = 8 + 2 + 1, 12 = 8 + 4
//	// 13 = 8 + 4 + 1, 14 = 8 + 4 + 2, 15 = 8 + 4 + 2 + 1.
//	public int antChecker(Doodlebug db)
//	{
//		int flag = 0;
//		
//		//Check four positions for Ant
//		if (getBug(db.getRowPosition() - 1, db.getColPosition()) instanceof Ant)
//			flag += 1;
//		
//		if (getBug(db.getRowPosition(), db.getColPosition() + 1) instanceof Ant)
//			flag += 2;
//		
//		if (getBug(db.getRowPosition() + 1, db.getColPosition()) instanceof Ant)
//			flag += 4;
//		
//		if (getBug(db.getRowPosition(), db.getColPosition() - 1) instanceof Ant)
//			flag += 8;
//		
//		return flag;
//	}
	
	//Return true if there is an Ant in an adjacent cell to Doodlebug
	public boolean antAdjacent(Doodlebug db)
	{
		//Top left corner check
		if (db.topFlag && db.leftFlag)
		{
			if (
					(getBug(db.getRowPosition(), db.getColPosition() + 1) instanceof Ant) ||
					(getBug(db.getRowPosition() + 1, db.getColPosition()) instanceof Ant) )
			{
				return true;
			}

			else
			{
				return false;
			}
		}

		//Bottom right corner check
		else if (db.bottomFlag && db.rightFlag)
		{
			if (
					(getBug(db.getRowPosition() - 1, db.getColPosition()) instanceof Ant) ||
					(getBug(db.getRowPosition(), db.getColPosition() - 1) instanceof Ant) )
			{
				return true;
			}

			else
			{
				return false;
			}
		}

		//Top right corner check
		else if (db.topFlag && db.rightFlag)
		{
			if (
					(getBug(db.getRowPosition() + 1, db.getColPosition()) instanceof Ant) ||
					(getBug(db.getRowPosition(), db.getColPosition() - 1) instanceof Ant) )
			{
				return true;
			}

			else
			{
				return false;
			}
		}

		//Bottom left corner check
		else if (db.bottomFlag && db.leftFlag)
		{
			if (
					(getBug(db.getRowPosition() - 1, db.getColPosition()) instanceof Ant) ||
					(getBug(db.getRowPosition(), db.getColPosition() + 1) instanceof Ant) )
			{
				return true;
			}

			else
			{
				return false;
			}
		}
		//Top row check
		else if (db.topFlag)
		{
			if (
					(getBug(db.getRowPosition(), db.getColPosition() + 1) instanceof Ant) ||
					(getBug(db.getRowPosition() + 1, db.getColPosition()) instanceof Ant) ||
					(getBug(db.getRowPosition(), db.getColPosition() - 1) instanceof Ant) )
			{
				return true;
			}

			else
			{
				return false;
			}
		}

		//Right column check
		else if (db.rightFlag)
		{
			if (
					(getBug(db.getRowPosition() - 1, db.getColPosition()) instanceof Ant) ||
					(getBug(db.getRowPosition() + 1, db.getColPosition()) instanceof Ant) ||
					(getBug(db.getRowPosition(), db.getColPosition() - 1) instanceof Ant) )
			{
				return true;
			}

			else
			{
				return false;
			}
		}

		//Bottom row check
		else if (db.bottomFlag)
		{
			if (
					(getBug(db.getRowPosition() - 1, db.getColPosition()) instanceof Ant) ||
					(getBug(db.getRowPosition(), db.getColPosition() + 1) instanceof Ant) ||
					(getBug(db.getRowPosition(), db.getColPosition() - 1) instanceof Ant) )
			{
				return true;
			}

			else
			{
				return false;
			}
		}

		//Left column check
		else if (db.leftFlag)
		{
			if (
					(getBug(db.getRowPosition() - 1, db.getColPosition()) instanceof Ant) ||
					(getBug(db.getRowPosition(), db.getColPosition() + 1) instanceof Ant) ||
					(getBug(db.getRowPosition() + 1, db.getColPosition()) instanceof Ant) )
			{
				return true;
			}

			else
			{
				return false;
			}
		}

		//Check four positions for Ant
		else if (
				(getBug(db.getRowPosition() - 1, db.getColPosition()) instanceof Ant) ||
				(getBug(db.getRowPosition(), db.getColPosition() + 1) instanceof Ant) ||
				(getBug(db.getRowPosition() + 1, db.getColPosition()) instanceof Ant) ||
				(getBug(db.getRowPosition(), db.getColPosition() - 1) instanceof Ant) )
		{
			return true;
		}

		else
		{
			return false;
		}
	}
	
	//Print out the current board with different bug symbols
	public void printBoard()
	{
		//System.out.println(this.field.length); //debug
		
		//Top row border
		System.out.println("----------------------");
		
		for(int i = 0; i < field.length; i++)
		{
			//Left edge border
			System.out.print("|");
			
			for(int j = 0; j < field[i].length; j++)
			{
				//Print whitespace if empty cell
				if (field[i][j] == null)
				{
					System.out.print("-");
				}
				
				//Print symbol for occupying bug
				else
				{
				System.out.print(field[i][j].symbol);
				}
			}
			//Right edge border
			System.out.print("|");
			
			//Prevent printing last empty line
			if (i < field.length - 1)
				System.out.println();
		}
		//Bottom row border
		System.out.println("\n----------------------");
	}
	
	//Takes position of bug and removes it, filling with null.
	public void removeBug(int row, int col)
	{
		if (field[row][col] == null)
		{
			System.out.println("Error: removeBug tried to remove a bug, but there was none.");
			System.exit(0);
		}
		
		field[row][col] = null;
	}
	
	//Returns Integer array of 1 - 4 in a random order
	public static Integer[] randomDirections()
	{
		Integer[] directionArray = new Integer[] {1, 2, 3, 4};
		
		Collections.shuffle(Arrays.asList(directionArray));
		
		return directionArray;
	}
	
	//Use to scan through field and have each Ant perform actions
	public int[] antScanner()
	{
		for (int j = colScan; j < 20; j++)
		{
			//Finish partially completed row
			if (field[this.rowScan][j] instanceof Ant)
			{
				//System.out.println("We have an ant! " + this.rowScan + " " + j); //Debug
				//Check for last column
				if (this.colScan == field[0].length - 1)
				{
					this.colScan = 0;
					this.rowScan++;
					return new int[] {rowScan - 1, field[0].length - 1};
				}
				
				else
				{
					this.colScan = j + 1;
					return new int[] {rowScan, j};
				}
			}
		}
		
		this.rowScan++;
		this.colScan = 0;
		
		for (int i = this.rowScan; i < field.length; i++)
		{
			for (int j = this.colScan; j < field[0].length; j++)
			{
				//if (field[i][j].getClass() ==  new Ant().getClass()) //Perhaps I should use instanceof?
				if (field[i][j] instanceof Ant)
				{
					if (j == field[0].length - 1)
					{
						this.colScan = 0;
						this.rowScan++;
						return new int[] {i, j};
					}
					
					else
					{
						this.colScan = j + 1;
						return new int[] {i, j};
					}
					
				}
				
				else if (j == field[0].length - 1)
				{
					this.colScan = 0;
					this.rowScan++;
				}
			}
		}
		
		this.rowScan = 0;
		this.colScan = 0;
		return new int[] {-1, -1};
	}
	
	//Use to scan through field and have each Doodlebug perform actions
	public int[] doodlebugScanner()
	{
		for (int j = colScan; j < 20; j++)
		{
			//Finish partially completed row
			if (field[this.rowScan][j] instanceof Doodlebug)
			{
				//System.out.println("We have an ant! " + this.rowScan + " " + j); //Debug
				//Check for last column
				if (this.colScan == field[0].length - 1)
				{
					this.colScan = 0;
					this.rowScan++;
					return new int[] {rowScan - 1, field[0].length - 1};
				}
				
				else
				{
					this.colScan = j + 1;
					return new int[] {rowScan, j};
				}
			}
		}
		
		this.rowScan++;
		this.colScan = 0;
		
		for (int i = this.rowScan; i < field.length; i++)
		{
			for (int j = this.colScan; j < field[0].length; j++)
			{
				//if (field[i][j].getClass() ==  new Ant().getClass()) //Perhaps I should use instanceof?
				if (field[i][j] instanceof Doodlebug)
				{
					if (j == field[0].length - 1)
					{
						this.colScan = 0;
						this.rowScan++;
						return new int[] {i, j};
					}
					
					else
					{
						this.colScan = j + 1;
						return new int[] {i, j};
					}
					
				}
				
				else if (j == field[0].length - 1)
				{
					this.colScan = 0;
					this.rowScan++;
				}
			}
		}
		
		this.rowScan = 0;
		this.colScan = 0;
		return new int[] {-1, -1};
	}
	
	//Takes a bug and a movement direction, and moves the bug to the new cell.
	public void moveBug(Organism bug, int direction)
	{
		int rowPos = bug.getRowPosition();
		int colPos = bug.getColPosition();
		
		switch (direction)
		{
		case 1:
			field[rowPos - 1][colPos] = new Organism(bug);
			getBug(rowPos - 1, colPos).setRowPosition(rowPos - 1);
			field[rowPos][colPos] = null;
			rowPos--;
			break;
		case 2:
			field[rowPos][colPos + 1] = new Organism(bug);
			getBug(rowPos, colPos + 1).setColPosition(colPos + 1);
			field[rowPos][colPos] = null;
			colPos++;
			break;
		case 3:
			field[rowPos + 1][colPos] = new Organism(bug);
			getBug(rowPos + 1, colPos).setRowPosition(rowPos + 1);
			field[rowPos][colPos] = null;
			rowPos++;
			break;
		case 4:
			field[rowPos][colPos - 1] = new Organism(bug);
			getBug(rowPos, colPos - 1).setColPosition(colPos - 1);
			field[rowPos][colPos] = null;
			colPos--;
			break;
		}
		
//		if (bug instanceof Ant)
//		{
//			field[rowPos][colPos] = (Ant) field[rowPos][colPos];
//			//Ant newBug = new Ant ((Ant) bug);
//		}
//		
//		if(bug instanceof Doodlebug)
//		{
//			field[rowPos][colPos] = (Doodlebug) field[rowPos][colPos];
//			//Doodlebug newBug = new Doodlebug ((Doodlebug) bug);
//		}
	}
	
}
