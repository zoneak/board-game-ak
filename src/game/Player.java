package game;

/**
 * This class represents the Player of the game and actions related.
 * @author Adriano Kaito
 *
 */
public class Player {

	private double money = 1500.0;	/* Start with $1500 */
	private int position = 0;

	public double getMoney() {
		return money;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	/**
	 * Adds amount to the total money.
	 * @param amount The amount to be added
	 */
	public void addMoney(double amount) {
		this.money += amount;
	}
	
	/**
	 * Subtracts amount from the total money.
	 * @param amount The amount to be subtracted
	 */
	public void subtractMoney(double amount) {
		this.money -= amount;
	}
	
	/**
	 * Finds Player's new position on the board after rolling the dices.
	 * @param position Previous position + sum of the dices
	 * @param boardSize Board size
	 * @return The new position on the board
	 */
	public int newPosition(int position, int boardSize) {
		return position % boardSize;
	}
	
	/**
	 * Resets the position of the Player to the initial square.
	 */
	public void resetPosition() {
		setPosition(0);
	}
	
	/**
	 * Resets the amount of money to initial value.
	 */
	public void resetMoney() {
		this.money = 1500.0;
	}
	
	/**
	 * Checks if Player has enough money to purchase a property or pay penalty.
	 * @param cost Cost of the Property / Penalty
	 * @return True if money is sufficient or else false
	 */
	public boolean hasMoneyToPay(double cost) {
		if (money >= cost) {
			return true;			
		} else return false;
	}
	
	/**
	 * Checks if Player has rounded the board. If so, earns $200.
	 * @param previousPosition The position before rolling the dices
	 */
	public void checkRoundTheBoard(int previousPosition) {
		if (this.getPosition() < previousPosition) {
			this.addMoney(200);
		}
	}
	
}
