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

import java.util.Random;
//import java.util.Scanner;

public class Board {
	
	Organism[][] field = new Organism[20][20];
	int numberOfAnts;
	int numberOfDoodlebugs;
	Random randomNumGen = new Random();
	
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
	
	//Fill with EmptyBugs first, then Ants, then Doodlebugs
	public void initializeBoard(int numAnt, int numDoodlebugs)
	{
		//Fill field with EmptyBug
		for(int i = 0; i < this.field.length; i++)
		{
			for(int j = 0; j < this.field[i].length; j++)
			{
				field[i][j] = new EmptyBug();
			}
		}
		
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
	
	//Check if cell is occupied, return true if occupied with EmptyBug, otherwise false
	public boolean isOccupied(int row, int col)
	{
		//System.out.println("isOccupied conditional says: " + (this.field[row][col].symbol != ' ')); //Debugging
		
		//Check for EmptyBug symbol in given field index
		if (this.field[row][col].symbol != ' ')
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
	
	//Place bug in empty cell
	public void placeBug(Organism bug, int numBug)
	{
		//Declare and initialize random row and column values
		int row = randomNumGen.nextInt(19);
		int col = randomNumGen.nextInt(19);
		
		//int counter = 0; //debug
		
		//Cycle through field until an empty cell is found
		while (this.isOccupied(row, col))
		{
			row = randomNumGen.nextInt(19);
			col = randomNumGen.nextInt(19);
			//counter++; //Debug
		}

		//System.out.println("Made if out of placeBug while loop: " + counter); //debug

		//Place a new Ant in open cell
		if(bug instanceof Ant)
		{
			//System.out.println("placeBug placed an Ant"); //Debug
			this.field[row][col] = new Ant();
		}
		
		//Place a new Doodlebug in open cell
		else if(bug instanceof Doodlebug)
		{
			//System.out.println("placeBug placed a DoodleBug");  //Debug
			this.field[row][col]= new Doodlebug();
		}
		
		//Error catching
		else
		{
			System.out.println("Error in placeBug method! Did not place a bug in an open cell.");
		}
	}

	//Print out the current board with different bug symbols
	public void printBoard()
	{
		//System.out.println(this.field.length); //debug
		for(int i = 0; i < this.field.length; i++)
		{
			for(int j = 0; j < this.field[i].length; j++)
			{
				System.out.print(field[i][j].symbol);
			}
			System.out.println();
		}
	}
}
