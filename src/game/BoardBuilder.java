package game;

import java.util.ArrayList;
import java.util.List;

/**
 * This class generates a representation of the board (A list of Squares).
 * @author Adriano Kaito
 *
 */
public class BoardBuilder {

	/**
	 * Generates the "board" itself by creating a list of squares, each one containing:
	 * 	Name, Type, Cost, Purchased
	 * @return the list of squares (representing the board)
	 */
	public List<Square> generateBoard() {
		
		String[] squareNames = {
			"Go", "Mediterranean Avenue", "Community Chest", "Baltic Avenue", "Income Tax", 
			"Reading Railroad", "Oriental Avenue", "Chance", "Vermont Avenue", "Connecticut Avenue", 
			"Jail Visit", "St. Charles Place", "Electric Company", "States Avenue", "Virginia Avenue", 
			"Pennsylvania Railroad", "St. James Place", "Community Chest", "Tennessee Avenue", "New York Avenue", 
			"Free Parking", "Kentucky Avenue", "Chance", "Indiana Avenue", "Illinois Avenue", 
			"B. & O. Railroad", "Atlantic Avenue", "Ventnor Avenue", "Water Works", "Marvin Gardens", 
			"Police Bribe", "Pacific Avenue", "North Carolina Avenue", "Community Chest", "Pennsylvania Avenue", 
			"Short Line", "Chance", "Park Place", "Luxury Tax", "Boardwalk" 
		};
		
		SquareType[] squareTypes = {
			SquareType.PENALTY, SquareType.PROPERTY, SquareType.PENALTY, SquareType.PROPERTY, SquareType.PENALTY,  
			SquareType.PROPERTY, SquareType.PROPERTY, SquareType.PENALTY, SquareType.PROPERTY, SquareType.PROPERTY, 
			SquareType.PENALTY, SquareType.PROPERTY, SquareType.PROPERTY, SquareType.PROPERTY, SquareType.PROPERTY, 
			SquareType.PROPERTY, SquareType.PROPERTY, SquareType.PENALTY, SquareType.PROPERTY, SquareType.PROPERTY, 			
			SquareType.PENALTY, SquareType.PROPERTY, SquareType.PENALTY, SquareType.PROPERTY, SquareType.PROPERTY, 		
			SquareType.PROPERTY, SquareType.PROPERTY, SquareType.PROPERTY, SquareType.PROPERTY, SquareType.PROPERTY, 
			SquareType.PENALTY, SquareType.PROPERTY, SquareType.PROPERTY, SquareType.PENALTY, SquareType.PROPERTY, 
			SquareType.PROPERTY, SquareType.PENALTY, SquareType.PROPERTY, SquareType.PENALTY, SquareType.PROPERTY 
		};
		
		double[] squareCosts = {
			0, 60, 0, 60, 200, 
			200, 100, 0, 100, 120, 
			50, 140, 150, 140, 160, 
			200, 180, 0, 180, 200, 
			0, 220, 0, 220, 240, 
			200, 260, 260, 150, 280, 
			50, 300, 300, 0, 320, 
			200, 0, 350, 75, 400 
		};
		
		List<Square> board = new ArrayList<Square>();
		for (int i = 0; i < squareNames.length; i++) {
			board.add(new Square(squareNames[i], squareTypes[i], squareCosts[i], false));
		}
		
		return board;
	}
	
}
