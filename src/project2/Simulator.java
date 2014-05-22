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
		
		Integer[] testArray = new Integer[] {1, 2, 3, 4};
		
		for (Integer i : testArray)
		{
			System.out.print(i);
		}
		System.out.println();
		
		Collections.shuffle(Arrays.asList(testArray));
		
		for (Integer i : testArray)
		{
			System.out.print(i);
		}
		
		System.out.println();
		
		Integer[] testAr = Board.randomDirections();
		
		for (int i = 0; i < 4; i++)
		{
			System.out.print(testAr[i]);
		}
	}
}
