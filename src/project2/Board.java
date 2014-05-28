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
	static int numberOfAnts;
	static int numberOfDoodlebugs;
	Random randomNumGen = new Random();
	static int rowScan = 0;
	static int colScan = 0;
	
	//Default Constructor
	public Board()
	{
		numberOfAnts = 100;
		numberOfDoodlebugs = 5;
		initializeBoard(numberOfAnts, numberOfDoodlebugs);
	}
	
	//Complete Constructor
	public Board(int ants, int doodlebugs)
	{
		numberOfAnts = ants;
		numberOfDoodlebugs = doodlebugs;
		initializeBoard(numberOfAnts, numberOfDoodlebugs);
		
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
	public static Organism getBug(int row, int col)
	{
		//Catch out of bounds error
//		if (row < 0 || col < 0)
//		{
//			System.out.println("Out of bounds in getBug!");
//			System.exit(0);
//		}
		return field[row][col];
	}
	
	//Return Organism at position given by array
	public static Organism getBug(int[] position)
	{
		//Catch out of bounds error
//		if (position[0] < 0 || position[1] < 0)
//		{
//			System.out.println("Out of bounds in getBug!");
//			System.exit(0);
//		}
		return field[position[0]][position[1]];
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
	
	//Return true if there is an Ant in an adjacent cell to Doodlebug
	public boolean antAdjacent(Doodlebug db)
	{
		System.out.println("antAdjacent");
		System.out.println(db);
		System.out.println();//Debug
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
	
	//Return true if there is an empty cell adjacent to the bug
	public boolean emptyCellAdjacent(Organism bug)
	{
		//Top left corner check
				if (bug.topFlag && bug.leftFlag)
				{
					if (
							(getBug(bug.getRowPosition(), bug.getColPosition() + 1) == null) ||
							(getBug(bug.getRowPosition() + 1, bug.getColPosition()) == null) )
					{
						return true;
					}

					else
					{
						return false;
					}
				}

				//Bottom right corner check
				else if (bug.bottomFlag && bug.rightFlag)
				{
					if (
							(getBug(bug.getRowPosition() - 1, bug.getColPosition()) == null) ||
							(getBug(bug.getRowPosition(), bug.getColPosition() - 1) == null) )
					{
						return true;
					}

					else
					{
						return false;
					}
				}

				//Top right corner check
				else if (bug.topFlag && bug.rightFlag)
				{
					if (
							(getBug(bug.getRowPosition() + 1, bug.getColPosition()) == null) ||
							(getBug(bug.getRowPosition(), bug.getColPosition() - 1) == null) )
					{
						return true;
					}

					else
					{
						return false;
					}
				}

				//Bottom left corner check
				else if (bug.bottomFlag && bug.leftFlag)
				{
					if (
							(getBug(bug.getRowPosition() - 1, bug.getColPosition()) == null) ||
							(getBug(bug.getRowPosition(), bug.getColPosition() + 1) == null) )
					{
						return true;
					}

					else
					{
						return false;
					}
				}
				//Top row check
				else if (bug.topFlag)
				{
					if (
							(getBug(bug.getRowPosition(), bug.getColPosition() + 1) == null) ||
							(getBug(bug.getRowPosition() + 1, bug.getColPosition()) == null) ||
							(getBug(bug.getRowPosition(), bug.getColPosition() - 1) == null) )
					{
						return true;
					}

					else
					{
						return false;
					}
				}

				//Right column check
				else if (bug.rightFlag)
				{
					if (
							(getBug(bug.getRowPosition() - 1, bug.getColPosition()) == null) ||
							(getBug(bug.getRowPosition() + 1, bug.getColPosition()) == null) ||
							(getBug(bug.getRowPosition(), bug.getColPosition() - 1) == null) )
					{
						return true;
					}

					else
					{
						return false;
					}
				}

				//Bottom row check
				else if (bug.bottomFlag)
				{
					if (
							(getBug(bug.getRowPosition() - 1, bug.getColPosition()) == null) ||
							(getBug(bug.getRowPosition(), bug.getColPosition() + 1) == null) ||
							(getBug(bug.getRowPosition(), bug.getColPosition() - 1) == null) )
					{
						return true;
					}

					else
					{
						return false;
					}
				}

				//Left column check
				else if (bug.leftFlag)
				{
					if (
							(getBug(bug.getRowPosition() - 1, bug.getColPosition()) == null) ||
							(getBug(bug.getRowPosition(), bug.getColPosition() + 1) == null) ||
							(getBug(bug.getRowPosition() + 1, bug.getColPosition()) == null) )
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
						(getBug(bug.getRowPosition() - 1, bug.getColPosition()) == null) ||
						(getBug(bug.getRowPosition(), bug.getColPosition() + 1) == null) ||
						(getBug(bug.getRowPosition() + 1, bug.getColPosition()) == null) ||
						(getBug(bug.getRowPosition(), bug.getColPosition() - 1) == null) )
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
		System.out.println("   01234567890123456789 ");
		
		for(int i = 0; i < field.length; i++)
		{
			//Left edge border
			System.out.printf("%2d|", i);
			
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
		System.out.println("\n");
		System.out.println("Number of Ants: " + numberOfAnts);
		System.out.println("Number of Doodlebugs: " + numberOfDoodlebugs);

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
		
		if(field[row][col] instanceof Ant)
		{
			numberOfAnts--;
		}
		
		if(field[row][col] instanceof Doodlebug)
		{
			numberOfDoodlebugs--;
		}
	}
	
	//Returns Integer array of 1 - 4 in a random order
	public static Integer[] randomDirections()
	{
		Integer[] directionArray = new Integer[] {1, 2, 3, 4};
		
		Collections.shuffle(Arrays.asList(directionArray));
		
		return directionArray;
	}
	
	//Use to scan through field and return int array of position row, col
	public static int[] antScanner()
	{
		//System.out.println("DEBUG rowScan colScan: " + rowScan + " " + colScan);
		for (int j = colScan; j < 20; j++)
		{
			//Finish partially completed row
			if (field[rowScan][j] instanceof Ant)
			{
				//System.out.println("We have an ant! " + this.rowScan + " " + j); //Debug
				//Check for last column
				if (colScan >= 19)
				{
					colScan = 0;
					rowScan++;
					return new int[] {rowScan - 1, 19};
				}
				
				else
				{
					colScan = j + 1;
					return new int[] {rowScan, j};
				}
			}
		}
		
		rowScan++;
		colScan = 0;
		
		for (int i = rowScan; i < 20; i++)
		{
			for (int j = colScan; j < 20; j++)
			{
				//if (field[i][j].getClass() ==  new Ant().getClass()) //Perhaps I should use instanceof?
				if (field[i][j] instanceof Ant)
				{
					if (j >= 19)
					{
						colScan = 0;
						rowScan++;
						return new int[] {i, 19};
					}
					
					else
					{
						colScan = j + 1;
						return new int[] {i, j};
					}
					
				}
				
				else if (j >= 19)
				{
					colScan = 0;
					rowScan++;
				}
			}
		}
		
		rowScan = 0;
		colScan = 0;
		return new int[] {-1, -1};
	}
	
	//Use to scan through field and return int array of position row, col
	public static int[] doodlebugScanner()
	{
		for (int j = colScan; j < 20; j++)
		{
			//Finish partially completed row
			if (field[rowScan][j] instanceof Doodlebug)
			//if (field[rowScan][j].getClass() == new Doodlebug().getClass())
			{
				//System.out.println("We have an ant! " + rowScan + " " + j); //Debug
				//Check for last column
				if (colScan >= 19)
				{
					colScan = 0;
					rowScan++;
					return new int[] {rowScan - 1, 19};
				}
				
				else
				{
					colScan = j + 1;
					return new int[] {rowScan, j};
				}
			}
		}
		
		rowScan++;
		colScan = 0;
		
		for (int i = rowScan; i < 20; i++)
		{
			for (int j = colScan; j < 20; j++)
			{
				//if (field[i][j].getClass() ==  new Ant().getClass()) //Perhaps I should use instanceof?
				if (field[i][j] instanceof Doodlebug)
				{
					if (j >= 19)
					{
						colScan = 0;
						rowScan++;
						return new int[] {i, 19};
					}
					
					else
					{
						colScan = j + 1;
						return new int[] {i, j};
					}
					
				}
				
//				else if (j >= 19)
//				{
//					colScan = 0;
//					rowScan++;
//				}
			}
			colScan = 0;
			rowScan++;
		}
		
		rowScan = 0;
		colScan = 0;
		return new int[] {-1, -1};
	}
	
	//Takes a bug and a movement direction, and moves the bug to the new cell.
	public static void moveBug(Organism bug, int direction)
	{
		int rowPos = bug.getRowPosition();
		int colPos = bug.getColPosition();
		
		if (bug.getSymbol() == 'O')
		{
			switch (direction)
			{
			case 1:
				field[rowPos - 1][colPos] = new Ant((Ant) bug);
				getBug(rowPos - 1, colPos).setRowPosition(rowPos - 1);
				field[rowPos][colPos] = null;
				rowPos--;
				break;
			case 2:
				field[rowPos][colPos + 1] = new Ant((Ant) bug);
				getBug(rowPos, colPos + 1).setColPosition(colPos + 1);
				field[rowPos][colPos] = null;
				colPos++;
				break;
			case 3:
				field[rowPos + 1][colPos] = new Ant((Ant) bug);
				getBug(rowPos + 1, colPos).setRowPosition(rowPos + 1);
				field[rowPos][colPos] = null;
				rowPos++;
				break;
			case 4:
				field[rowPos][colPos - 1] = new Ant((Ant) bug);
				getBug(rowPos, colPos - 1).setColPosition(colPos - 1);
				field[rowPos][colPos] = null;
				colPos--;
				break;
			}
		}
		
		else if(bug.getSymbol() == 'X')
		{
			switch (direction)
			{
			case 1:
				field[rowPos - 1][colPos] = new Doodlebug((Doodlebug) bug);
				getBug(rowPos - 1, colPos).setRowPosition(rowPos - 1);
				field[rowPos][colPos] = null;
				rowPos--;
				break;
			case 2:
				field[rowPos][colPos + 1] = new Doodlebug((Doodlebug) bug);
				getBug(rowPos, colPos + 1).setColPosition(colPos + 1);
				field[rowPos][colPos] = null;
				colPos++;
				break;
			case 3:
				field[rowPos + 1][colPos] = new Doodlebug((Doodlebug) bug);
				getBug(rowPos + 1, colPos).setRowPosition(rowPos + 1);
				field[rowPos][colPos] = null;
				rowPos++;
				break;
			case 4:
				field[rowPos][colPos - 1] = new Doodlebug((Doodlebug) bug);
				getBug(rowPos, colPos - 1).setColPosition(colPos - 1);
				field[rowPos][colPos] = null;
				colPos--;
				break;
			}
			
			bug.timeSinceBreed++; //Increment counter for breeding
		}
	}
	
	public void breed(Organism bug)
	{
		//Check breed threshold and open adjacent cell
		if ((bug.timeSinceBreed == bug.breedThreshold) && this.emptyCellAdjacent(bug))
		{
			int row = bug.getRowPosition();
			int col = bug.getColPosition();
			
			Integer[] randomDirections = Board.randomDirections();
			boolean breedComplete = false;
			
			//Check for type of bug, ant or doodlebug
			if (bug instanceof Ant)
			{
				Ant ant = (Ant) Board.getBug(row, col);
				
				for (int i = 0; i < 4 && (breedComplete == false); i++)
				{
					switch (randomDirections[i])
					{
					case 1:
						if (ant.topFlag)
							break;
						
						if (Board.getBug(row - 1, col) == null)
						{
							field[row - 1][col] = new Ant(row - 1, col);
							//Board.moveBug(Board.getBug(row, col), 1);
							breedComplete = true;
						}
						break;
					case 2:
						if (ant.rightFlag)
							break;
						
						if (Board.getBug(row, col + 1) == null)
						{
							field[row][col + 1] = new Ant(row, col + 1);
							breedComplete = true;
						}
						break;
					case 3:
						if (ant.bottomFlag)
							break;
						
						if (Board.getBug(row + 1, col) == null)
						{
							field[row + 1][col] = new Ant(row + 1, col);
							breedComplete = true;
						}
						break;
					case 4:
						if (ant.leftFlag)
							break;
						
						if (Board.getBug(row, col - 1) == null)
						{
							field[row][col - 1] = new Ant(row, col - 1);
							breedComplete = true;
						}
						break;
					}
				}
				bug.timeSinceBreed = 0; //Reset breeding counter
				numberOfAnts++;
			}
			else if (bug instanceof Doodlebug)
			{
				Doodlebug db = (Doodlebug) Board.getBug(row, col);
				
				for (int i = 0; i < 4 && (breedComplete == false); i++)
				{
					switch (randomDirections[i])
					{
					case 1:
						if (db.topFlag)
							break;
						
						if (Board.getBug(row - 1, col) == null)
						{
							field[row - 1][col] = new Doodlebug(row - 1, col);
							breedComplete = true;
						}
						break;
					case 2:
						if (db.rightFlag)
							break;
						
						if (Board.getBug(row, col + 1) == null)
						{
							field[row][col + 1] = new Doodlebug(row, col + 1);
							breedComplete = true;
						}
						break;
					case 3:
						if (db.bottomFlag)
							break;
						
						if (Board.getBug(row + 1, col) == null)
						{
							field[row + 1][col] = new Doodlebug(row + 1, col);
							breedComplete = true;
						}
						break;
					case 4:
						if (db.leftFlag)
							break;
						
						if (Board.getBug(row, col - 1) == null)
						{
							field[row][col - 1] = new Doodlebug(row, col - 1);
							breedComplete = true;
						}
						break;
					}
				}
				bug.timeSinceBreed = 0; //Reset breeding counter
				numberOfDoodlebugs++;
			}
			else //Catch error
			{
				System.out.println("Error in breed!");
				System.exit(0);
			}
		}		
	}
}
