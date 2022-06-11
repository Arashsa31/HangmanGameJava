import java.util.Scanner;

/**
 * @author Arash
 *
 */
public class HangmanDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//uses a default constructor
		//HangmanGame game = new HangmanGame();
		//game.input();			
 		
		//uses overloaded constructor	
		Scanner keyboard = new Scanner(System.in);			
		int tries = 10;
		HangmanGame game1 = new HangmanGame("kaiju");
		System.out.println("*****LET'S PLAY HANGMAN!!*****\nAfter " + tries + " incorrect tries, you lose!");
		while (true) {						
			System.out.print("Enter a letter:");
			char tempChar = keyboard.next().toLowerCase().charAt(0);
			game1.makeGuess(tempChar);
			System.out.println(game1.toString());
				if(game1.isFound()) {
					System.out.println("YOU ARE A WINNER!");
					System.exit(0);
				}
				else if (game1.getIncorrectGuessCount() == tries)
						System.out.println("This is your last try before you lose!\n");
				else if (game1.getIncorrectGuessCount() > tries) {
					System.out.println("YOU LOST!");
					System.exit(0);
				}
		} 
		
		
	}
}
