/**
 * Organism.java
 *
 * Create the Organism superclass with default constructor and
 * getSymbol method.
 * 
 * Project 2 due May 26, 2014
 * 
 * @author Stefano Prezioso
 * @date May 15, 2014
 */
package project2;

public class Organism
{
	int timeSinceBreed;
	char symbol;
	
	public Organism()
	{
		this.timeSinceBreed = 0;
	}
	
	public char getSymbol()
	{
		return this.symbol;
	}
	
	
	
}
