/**
 * Simulator.java
 *
 * Contains main method to test the other classes of
 * Project 2, as well as methods to establish the
 * sequence of events for the simulation.
 * 
 * Project 2 due May 28, 2014
 * 
 * @author Stefano Prezioso
 * @date May 15, 2014
 */
package project2;

import java.util.Arrays;
import java.util.Scanner;

public class Simulator {
	
	/**
	 * Waits for user to press enter to continue the program.
	 */
	public static void enterToContinue()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Press enter to continue: ");
		keyboard.nextLine();
	}
	
	/**
	 * Takes array of coordinates of a Doodlebug and eats a random, adjacent Ant
	 * if one is present
	 * 
	 * @param coordinates Array with two elements in order row then column
	 */
	public static void eatAnt(int[] coordinates)
	{
		//Get Doodlebug from coordinates
		Doodlebug db = (Doodlebug) Board.getBug(coordinates[0], coordinates[1]);
		
		Integer[] randomDirections = Board.randomDirections(); //Random direction list
		
		boolean moveComplete = false;
		
		//Check four random directions for Ant, and eat first found
		for (int i = 0; i < 4 && (moveComplete == false); i++)
		{
			switch (randomDirections[i])
			{
			case 1:
				if (db.topFlag)
					break;

				if (Board.getBug(coordinates[0] - 1, coordinates[1]) instanceof Ant)
				{
					Board.field[coordinates[0] - 1][coordinates[1]] = null;
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 1);
					moveComplete = true;
					Board.numberOfAnts--;
				}
				break;
			case 2:
				if (db.rightFlag)
					break;

				if (Board.getBug(coordinates[0], coordinates[1] + 1) instanceof Ant)
				{
					Board.field[coordinates[0]][coordinates[1] + 1] = null;
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 2);
					moveComplete = true;
					Board.numberOfAnts--;
				}
				break;
			case 3:
				if (db.bottomFlag)
					break;

				if (Board.getBug(coordinates[0] + 1, coordinates[1]) instanceof Ant)
				{
					Board.field[coordinates[0] + 1][coordinates[1]] = null;
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 3);
					moveComplete = true;
					Board.numberOfAnts--;
				}
				break;
			case 4:
				if (db.leftFlag)
					break;

				if (Board.getBug(coordinates[0], coordinates[1] - 1) instanceof Ant)
				{
					Board.field[coordinates[0]][coordinates[1] - 1] = null;
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 4);
					moveComplete = true;
					Board.numberOfAnts--;
				}
				break;
			}
		}
		
	}
	
	/**
	 * Moves Doodlebug at given coordinates to random empty adjacent cell.
	 * 
	 * @param coordinates Array with two elements in order row then column
	 */
	public static void moveDoodlebug(int[] coordinates)
	{
		int row = coordinates[0];
		int col = coordinates[1];
		Doodlebug db = (Doodlebug) Board.getBug(row, col);
		
		Integer[] randomDirections = Board.randomDirections();
		boolean moveComplete = false;
		for (int i = 0; i < 4 && (moveComplete == false); i++)
		{
			switch (randomDirections[i])
			{
			case 1:
				if (db.topFlag)
					break;
				
				if (Board.getBug(coordinates[0] - 1, coordinates[1]) == null)
				{
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 1);
					moveComplete = true;
				}
				break;
			case 2:
				if (db.rightFlag)
					break;
				
				if (Board.getBug(coordinates[0], coordinates[1] + 1) == null)
				{
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 2);
					moveComplete = true;
				}
				break;
			case 3:
				if (db.bottomFlag)
					break;
				
				if (Board.getBug(coordinates[0] + 1, coordinates[1]) == null)
				{
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 3);
					moveComplete = true;
				}
				break;
			case 4:
				if (db.leftFlag)
					break;
				
				if (Board.getBug(coordinates[0], coordinates[1] - 1) == null)
				{
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 4);
					moveComplete = true;
				}
				break;
			}
		}
	}
	
	/**
	 * Moves ant at given coordinates to random empty adjacent cell.
	 * 
	 * @param coordinates Array with two elements in order row then column
	 */
	public static void moveAnt(int[] coordinates)
	{
		int row = coordinates[0];
		int col = coordinates[1];

		Ant ant = (Ant) Board.getBug(row, col);
		
		Integer[] randomDirections = Board.randomDirections();
		boolean moveComplete = false;
		
		for (int i = 0; i < 4 && (moveComplete == false); i++)
		{
			switch (randomDirections[i])
			{
			case 1:
				if (ant.topFlag)
					break;
				
				if (Board.getBug(coordinates[0] - 1, coordinates[1]) == null)
				{
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 1);
					moveComplete = true;
				}
				break;
			case 2:
				if (ant.rightFlag)
					break;
				
				if (Board.getBug(coordinates[0], coordinates[1] + 1) == null)
				{
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 2);
					moveComplete = true;
				}
				break;
			case 3:
				if (ant.bottomFlag)
					break;
				
				if (Board.getBug(coordinates[0] + 1, coordinates[1]) == null)
				{
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 3);
					moveComplete = true;
				}
				break;
			case 4:
				if (ant.leftFlag)
					break;
				
				if (Board.getBug(coordinates[0], coordinates[1] - 1) == null)
				{
					Board.moveBug(Board.getBug(coordinates[0], coordinates[1]), 4);
					moveComplete = true;
				}
				break;
			}
		}
	}
	
	/**
	 * Returns an array of position arrays of all the ants
	 * on the field.
	 * 
	 * @return Array with two columns with positions in row then column order.
	 * Each row is a new ant position.
	 */
	public static int[][] antPositions()
	{
		int[][] positions = new int[Board.numberOfAnts][2];
		
		for (int i = 0; i < Board.numberOfAnts; i++)
		{
			positions[i] = Board.antScanner();
		}
		Board.rowScan = 0;
		Board.colScan = 0;
		return positions;
	}
	
	/**
	 * Returns an array of position arrays of all the doodlebugs
	 * on the field.
	 * 
	 * @return Array with two columns with positions in row then column order.
	 * Each row is a new doodlebug position.
	 */
	public static int[][] doodlebugPositions()
	{
		int[][] positions = new int[Board.numberOfDoodlebugs][2];
		
		for (int i = 0; i < Board.numberOfDoodlebugs; i++)
		{
			positions[i] = Board.doodlebugScanner();
		}
		Board.rowScan = 0;
		Board.colScan = 0;
		return positions;
	}
	
	/**
	 * Used for debugging purposes. Prints out all the positions of
	 * all of the Doodlebugs and Ants, in that order.
	 */
	public static void printPositions()
	{
		System.out.println("Doodlebugs");
		int [][] dbPositions = new int[Board.numberOfDoodlebugs][2];
		dbPositions = doodlebugPositions();
		for (int i = 0; i < Board.numberOfDoodlebugs; i++)
		{
			System.out.println(Arrays.toString(dbPositions[i]));
		}
		
		System.out.println("Ants");
		int[][] positions = new int[Board.numberOfAnts][2];
		positions = antPositions();
		for (int i = 0; i < Board.numberOfAnts; i++)
		{
			System.out.println(Arrays.toString(positions[i]));
		}
	}
	
	/**
	 * Establishes the proper sequence of events for the simulation
	 * given the particular rules.
	 * 
	 * 1. Check Doodlebugs for an adjacent Ant, and if so, eat it.
	 * 2. If no adjacent Ant, the Doodlebugs move to an empty, open cell
	 * if one is present.
	 * 3. The Ants move to an empty, open cell, if one is present.
	 * 4. Doodlebugs breed, if eligibile.
	 * 5. Ants breed, if eligible.
	 * 6. Doodlebugs starve to death if they haven't eaten recently enough.
	 * 
	 * @param testBoard
	 */
	public static void turnSequence(Board testBoard)
	{
		int[][] dbPositions = new int[Board.numberOfDoodlebugs][2];
		dbPositions = doodlebugPositions();
		int[] position = new int[2];
		
		/* ********* DOODLEBUGS EAT/MOVE *********** */
		for (int i = 0; i < Board.numberOfDoodlebugs; i++)
		{
			//Get Doodlebug Coordinates
			position = dbPositions[i];
			//position = testBoard.doodlebugScanner();			
			
			//Error checking
			if (position[0] < 0 || position[1] < 0)
			{
				System.out.println("-1 from doodlebugScanner"); //debug
				System.exit(0);
			}
			else if (position[0] > 19 || position[1] > 19)
			{
				System.out.println("20 from doodlebugScanner"); //debug
				System.exit(0);
			}
			
			//Eat Ant if necessary
			if (testBoard.antAdjacent((Doodlebug)Board.getBug(position)))
			{
				Doodlebug db = (Doodlebug)Board.getBug(position);
				db.timeSinceEat = 0;
				db.timeSinceBreed++;
				eatAnt(position);
				
			}
			else
			{
				//Else move doodlebug
				Doodlebug db = (Doodlebug)Board.getBug(position);
				db.timeSinceEat++;
				db.timeSinceBreed++;
				moveDoodlebug(position);
			}	
		}
		
		/* ********* ANTS MOVE *********** */
		int[][] antPositions = new int[Board.numberOfAnts][2];
		antPositions = antPositions();
		
		//Loop through all the ants
		for (int i = 0; i < Board.numberOfAnts; i++)
		{
			//Get Ant position
			position = antPositions[i];
			
			if (position[0] < 0 || position[1] < 0)
			{
				break;
			}
			
			//Move Ant
			Ant ant = (Ant)Board.getBug(position);
			ant.timeSinceBreed++;
			moveAnt(position);
		}
		
		/* ********* DOODLEBUGS BREED *********** */
		Board.rowScan = 0;
		Board.colScan = 0;
		
		//For all the doodlebugs...
		dbPositions = doodlebugPositions();
		int tempNumberOfDoodlebugs = Board.numberOfDoodlebugs;
		for (int i = 0; i < tempNumberOfDoodlebugs; i++)
		{
			//Get Doodlebug Coordinates	
			position = dbPositions[i];
			int row = position[0];
			int col = position[1];
			
			if (row < 0 || col < 0)
			{
				break;
			}
			
			testBoard.breed(Board.getBug(position));
		}
		
		/* ********* ANTS BREED *********** */
		antPositions = antPositions();
		int tempNumberOfAnts = Board.numberOfAnts;
		
		for (int i = 0; i < tempNumberOfAnts; i++)
		{
			//Get Ant Coordinates	
			position = antPositions[i];
			int row = position[0];
			int col = position[1];
			
			if (row < 0 || col < 0)
			{
				break;
			}
			
			testBoard.breed(Board.getBug(row, col));
		}
		
		/* ********* DOODLEBUGS STARVE *********** */
		
		dbPositions = doodlebugPositions();
		tempNumberOfDoodlebugs = Board.numberOfDoodlebugs;
		
		for (int i = 0; i < tempNumberOfDoodlebugs; i++)
		{
			testBoard.starve((Doodlebug)Board.getBug(dbPositions[i][0], dbPositions[i][1]));
		}
		
	}
	
	/**
	 * Creates a testBoard, prints it, and then begins 
	 * looping through the turns to create the predator
	 * prey simulation model.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Create testBoard
		Board testBoard = new Board();
		
		//Print out testBoard
		testBoard.printBoard();
		
		//printPositions(); //Used for debugging
		
		while (Board.numberOfAnts != 0 || Board.numberOfDoodlebugs != 0)
		{
			//Perform the sequence of events for a turn
			turnSequence(testBoard);
			
			//Print out the board
			testBoard.printBoard();
			
			//printPositions(); //Used for debugging
			
			//Prompt the user to continue
			enterToContinue();
		}
		
		
	}
}
