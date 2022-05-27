package game;

/**
 * This class represents a square on the board.
 * @author Adriano Kaito
 *
 */
public class Square {

	private String name;
	private SquareType type;
	private double cost;
	private boolean purchased;

	public Square(String name, SquareType type, double cost, boolean purchased) {
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.purchased = purchased;
	}

	public String getName() {
		return name;
	}

	public SquareType getType() {
		return type;
	}

	public double getCost() {
		return cost;
	}

	public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}

}
