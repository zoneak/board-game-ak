package game;

import java.util.Random;

/**
 * This class simulates the dice rolls and holds the count of rolls played in a game.
 * @author Adriano Kaito
 *
 */
public class Dice {
	
	private final static int MAX_NUMBER_ROLLS = 1000;  
	private int rollCount = 1;
	
	/**
	 * Generates a random number between 1 and 6.
	 * @return The value of the face 
	 */
	public int getFace() {
		Random rd = new Random();
		int face = 1 + rd.nextInt(6);
		return face;
	}
	
	/**
	 * Simulates rolls of two dices and updates the roll count.
	 * @return The sum of both faces of the dices
	 */
	public int roll() {
		int dice1 = getFace();
		int dice2 = getFace();
		this.rollCount += 1;
		return Integer.sum(dice1, dice2);
	}
	
	/**
	 * Checks if the game is over due to maximum rolls of the dice per game.
	 * @return True if roll count reached the number defined in MAX_NUMBER_ROLLS
	 */
	public boolean hasReachedMaxRolls() {
		return this.rollCount > MAX_NUMBER_ROLLS;
	}
	
	/**
	 * Resets the roll count for a new game.
	 */
	public void resetRollCount() {
		this.rollCount = 1;
	}

}
