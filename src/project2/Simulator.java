/**
 * Simulator.java
 *
 * Contains main method to test the other classes of
 * Project 2.
 * 
 * Project 2 due May 26, 2014
 * 
 * @author Stefano Prezioso
 * @date May 15, 2014
 */
package project2;

import java.util.Arrays;
import java.util.Scanner;
//import java.util.Arrays;
//import java.util.Collections;

public class Simulator {
	
	//Waits for enter to continue program
	public static void enterToContinue()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Press enter to continue: ");
		keyboard.nextLine();
	}
	
	//Takes coordinates of Doodlebug and eats
	//a random, adjacent Ant
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
					//db.timeSinceEat = 0;
					//db.timeSinceBreed++;
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
					//db.timeSinceEat = 0;
					//db.timeSinceBreed++;
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
					//db.timeSinceEat = 0;
					//db.timeSinceBreed++;
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
					//db.timeSinceEat = 0;
					//db.timeSinceBreed++;
				}
				break;
			}
		}
		
	}
	
	//Moves Doodlebug at given coordinates to random empty adjacent cell
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
		//db.timeSinceBreed++;
	}
	
	//Moves ant to random empty adjacent cell
	public static void moveAnt(int[] coordinates)
	{
		int row = coordinates[0];
		int col = coordinates[1];
		//System.out.println("moveAnt");
		//System.out.println("Testing position " + row + ", " + col)
;		//System.out.println(row + " " + col);
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
		//ant.timeSinceBreed++;
	}
	
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
	
	public static void turnSequence(Board testBoard)
	{
		int[][] dbPositions = new int[Board.numberOfDoodlebugs][2];
		dbPositions = doodlebugPositions();
		int[] position = new int[2];
		
		//For all the doodlebugs...
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
			
			//System.out.println("Testing DB at " + position[0] + ", " + position[1]);
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
			
			//testBoard.printBoard();
			
		}
		//System.exit(0); //STOP
		
//*****   ANTS ******
		int[][] antPositions = new int[Board.numberOfAnts][2];
		antPositions = antPositions();
		
		//Loop through all the ants
		for (int i = 0; i < Board.numberOfAnts; i++)
		{
			//Get Ant position
			//position = Board.antScanner();
			position = antPositions[i];
			
			if (position[0] < 0 || position[1] < 0)
				break;
			
			//System.out.println("Ant at " + position[0] + ", " + position[1]);

			//Move Ant
			Ant ant = (Ant)Board.getBug(position);
			ant.timeSinceBreed++;
			moveAnt(position);
			
			//testBoard.printBoard();
			
		}
		//System.exit(0); //STOP DEBUG
		//Breed
		Board.rowScan = 0;
		Board.colScan = 0;
		
		//For all the doodlebugs...
		dbPositions = doodlebugPositions();
		int tempNumberOfDoodlebugs = Board.numberOfDoodlebugs;
		for (int i = 0; i < tempNumberOfDoodlebugs; i++)
		{
			//Get Doodlebug Coordinates
			//position = Board.doodlebugScanner();		
			position = dbPositions[i];
			int row = position[0];
			int col = position[1];
			
			if (row < 0 || col < 0)
			{
				break;
			}
			//System.out.println("DB at " + position[0] + ", " + position[1]);
			testBoard.breed(Board.getBug(position));
			
			//testBoard.printBoard();
			
		}
		
		antPositions = antPositions();
		int tempNumberOfAnts = Board.numberOfAnts;
		for (int i = 0; i < tempNumberOfAnts; i++)
		{
			//Get Ant Coordinates
			//position = Board.antScanner();		
			position = antPositions[i];
			int row = position[0];
			int col = position[1];
			
			if (row < 0 || col < 0)
				break;
			
			//System.out.println("Ant at " + position[0] + ", " + position[1]);
			testBoard.breed(Board.getBug(row, col));
			
			//testBoard.printBoard();
			
		}
	}

	public static void main(String[] args)
	{
		//Create testBoard
		Board testBoard = new Board();
		
		//Print out testBoard
		testBoard.printBoard();
		
		printPositions();
		
		while (true)
		{
			turnSequence(testBoard);
		
			testBoard.printBoard();
			
			//printPositions();
			
			enterToContinue();
		}
		
		
	}
}
