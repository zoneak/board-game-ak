package game;

import java.util.Arrays;
import java.util.List;

/**
 * This class is responsible for the Game actions and calculating the final results.
 * @author Adriano Kaito
 *
 */
public class Game {
	
	private final static int NUMBER_OF_GAMES = 1000; 
	private final static String INDIANA_AVENUE = "Indiana Avenue";
	private final static String INCOME_TAX = "Income Tax";
	
	private int[] turns = new int[NUMBER_OF_GAMES];
	private int[] properties = new int[NUMBER_OF_GAMES];
	private int indianaAvePurchased = 0;
	
	/**
	 * Starts the games.
	 */
	public void start() {
		System.out.println(NUMBER_OF_GAMES + " Games in progress...");
		
		Player player = new Player();
		Dice dice = new Dice();
		BoardBuilder boardBuilder = new BoardBuilder();
		List<Square> board = boardBuilder.generateBoard();
		
		executeActions(player, dice, board);
		
		System.out.println(NUMBER_OF_GAMES + " Games are over. Calculating results...");
		calculateResults(turns, properties, indianaAvePurchased);
	}

	/**
	 * Executes the game actions throughout each one.
	 * @param player The Player object
	 * @param dice The Dice object
	 * @param board The generated board
	 */
	private void executeActions(Player player, Dice dice, List<Square> board) {
		for (int i = 0; i < NUMBER_OF_GAMES; i++) {			
			int turnsPlayed = 0;
			int propertiesPurchased = 0;
			
			while (!dice.hasReachedMaxRolls()) {
				turnsPlayed++;
				
				int roll = dice.roll();
				
				int previousPosition = player.getPosition();
				player.setPosition(player.newPosition(previousPosition + roll, board.size()));
				player.checkRoundTheBoard(previousPosition);
				
				Square square = board.get(player.getPosition());
				String squareName = square.getName();
				double squareCost = square.getCost();
				
				if (square.getType().equals(SquareType.PROPERTY)) {
					if (!square.isPurchased()) {
						if (player.hasMoneyToPay(squareCost)) {							
							player.subtractMoney(squareCost);
							square.setPurchased(true);
							propertiesPurchased++;
							
							if (squareName.equals(INDIANA_AVENUE)) {
								indianaAvePurchased++;
							}
						} else break;
					} 
				} else {
					/* is PENALTY */
					double penalty = squareCost;
					if (squareName.equals(INCOME_TAX)) {
						double moneyPercent = player.getMoney() * 0.1;
						if (moneyPercent > squareCost) {
							penalty = moneyPercent;
						}
					} 
					
					if (player.hasMoneyToPay(penalty)) {
						player.subtractMoney(penalty);
					} else break;
				}
			}
			
			turns[i] = turnsPlayed;
			properties[i] = propertiesPurchased;
			
			resetGame(player, dice, board);
		}
	}

	/**
	 * Resets player's money and position on the board, dice roll count and purchased properties.
	 * @param player The Player object
	 * @param dice The Dice object
	 * @param board The board containing the list of squares
	 */
	private void resetGame(Player player, Dice dice, List<Square> board) {
		player.resetMoney();
		player.resetPosition();
		dice.resetRollCount();
		board.forEach(s -> s.setPurchased(false));
	}
	
	/**
	 * Calculates and displays the final results after game over:
	 * 	Average number of rolls (turns) in a game,
	 * 	Average number of properties purchased in a game,
	 * 	Percentage of games when Indiana Avenue was purchased
	 * @param turns Array containing the number of turns played in each game 
	 * @param properties Array containing the number of properties purchased in each game
	 * @param indianaAvePurchased Sum of how many times Indiana Ave. was purchased
	 */
	private static void calculateResults(int[] turns, int[] properties, int indianaAvePurchased) {
		double avgTurns = Arrays.stream(turns).average().orElse(Double.NaN);
		double avgProperties = Arrays.stream(properties).average().orElse(Double.NaN);
		float percentage = (indianaAvePurchased * 100f) / NUMBER_OF_GAMES;
		
		System.out.println("Average number of rolls (turns) in a game: " + (float)avgTurns);
		System.out.println("Average number of properties purchased in a game: " + (float)avgProperties);
		System.out.println("Percentage of games when Indiana Avenue was purchased: " + percentage + "%");
	}
	
}
