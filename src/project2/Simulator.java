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
import java.util.Collections;

public class Simulator {
	
	public void turnSequence()
	{
		//Determine Doodlebug moves
		
		//Move Doodlebugs
		
		//Determine Ant moves
		
		//Move Ants
		
		//Determine Breeding
		
		//Breed
	}
	public static void main(String[] args)
	{
		//Create testBoard
		Board testBoard = new Board();
		
		//Print out testBoard
		testBoard.printBoard();
		
		//for (int j = 0; j < 20; j++)
		//	Board.field[1][j] = null;
		
		//Print out testBoard
//		testBoard.printBoard();
//		
//		System.out.println(testBoard.rowScan + " " + testBoard.colScan);
//
//		
//		for (int i = 0; i < 101; i++)
//		{
//			int[] coord = testBoard.antScanner();
//			int row = coord[0];
//			int col = coord[1];
//		System.out.println("Ant Scanner: (" + row + ", " + col + ")");
//		System.out.println(testBoard.rowScan + " " + testBoard.colScan);
//		}
//		
//		for (int i = 0; i < 5; i++)
//		{
//			int[] coord = testBoard.doodlebugScanner();
//			int row = coord[0];
//			int col = coord[1];
//		System.out.println("DB Scanner: (" + row + ", " + col + ")");
//		System.out.println(testBoard.rowScan + " " + testBoard.colScan);
//		}
		
		//System.out.println(Board.field[0].length);
//		Integer[] testArray = new Integer[] {1, 2, 3, 4};
//		
//		for (Integer i : testArray)
//		{
//			System.out.print(i);
//		}
//		System.out.println();
//		
//		Collections.shuffle(Arrays.asList(testArray));
//		
//		for (Integer i : testArray)
//		{
//			System.out.print(i);
//		}
//		
//		System.out.println();
//		
//		Integer[] testAr = Board.randomDirections();
//		
//		for (int i = 0; i < 4; i++)
//		{
//			System.out.print(testAr[i]);
//		}
		
		int[] coords = new int[2];
		coords = testBoard.doodlebugScanner();
		boolean topFlag = false;
		boolean leftFlag = false;
		boolean rightFlag = false;
		boolean bottomFlag = false;
		
		if (coords[0] == 0)
		{
			topFlag = true;
		}
		else if(coords[0] == 19)
		{
			bottomFlag = true;
		}
		
		if (coords[1] == 0)
		{
			leftFlag = true;
		}
		else if (coords[1] == 19)
		{
			rightFlag = true;
		}
		
		boolean antIsPresent = testBoard.antAdjacent((Doodlebug)testBoard.getBug(coords[0], coords[1]));
		System.out.println(antIsPresent);
		
		if (antIsPresent)
		{
			Integer[] randomDirections = Board.randomDirections();
			boolean moveComplete = false;
			for (int i = 0; i < 4 && (moveComplete == false); i++)
			{
				switch (randomDirections[i])
				{
				case 1:
					if (topFlag)
						break;
					
					if (testBoard.getBug(coords[0] - 1, coords[1]) instanceof Ant)
					{
						Board.field[coords[0] - 1][coords[1]] = null;
						testBoard.moveBug(testBoard.getBug(coords[0], coords[1]), 1);
						moveComplete = true;
					}
					break;
				case 2:
					if (rightFlag)
						break;
					
					if (testBoard.getBug(coords[0], coords[1] + 1) instanceof Ant)
					{
						Board.field[coords[0]][coords[1] + 1] = null;
						testBoard.moveBug(testBoard.getBug(coords[0], coords[1]), 2);
						moveComplete = true;
					}
					break;
				case 3:
					if (bottomFlag)
						break;
					
					if (testBoard.getBug(coords[0] + 1, coords[1]) instanceof Ant)
					{
						Board.field[coords[0] + 1][coords[1]] = null;
						testBoard.moveBug(testBoard.getBug(coords[0], coords[1]), 3);
						moveComplete = true;
					}
					break;
				case 4:
					if (leftFlag)
						break;
					
					if (testBoard.getBug(coords[0], coords[1] - 1) instanceof Ant)
					{
						Board.field[coords[0]][coords[1] - 1] = null;
						testBoard.moveBug(testBoard.getBug(coords[0], coords[1]), 4);
						moveComplete = true;
					}
					break;
				}
			}
		}
		
		testBoard.printBoard();
		
		
		
	}
}
