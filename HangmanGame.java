import java.util.Scanner;

/**
 * @author Arash
 *
 *Consider a class that could be used to play a game of hangman. 
 *The class has the following attributes:
 *The secret word.
 *The disguised word, in which each unknown letter in the secret word is replaced 
 *with a question mark (?). For example, if the secret word is abracadabra and 
 *the letters a, b, and e have been guessed, the disguised word would be ab?a?a?ab?a.
 *
 *The number of guesses made.
 *The number of incorrect guesses.
 *
 *It will have the following methods:
 *makeGuess(c) guesses that character c is in the word.
 *getDisguisedWord returns a string containing correctly guessed letters in their correct
 *positions and unknown letters replaced with ?.
 *getSecretWord returns the secret word.
 *getGuessCount returns the number of guesses made.
 *isFound returns true if the hidden word has been discovered.
 *a. Write a method heading for each method.
 *b. Write preconditions and postconditions for each method.
 *c. Write some Java statements that test the class.
 *d. Implement the class.
 *e. List any additional methods and attributes needed in the 
 *implementation that were not listed in the original design. 
 *List any other changes made to the original design.
 *f. Write a program that implements the game of hangman using the class you wrote for Part d.
 */
public class HangmanGame 
{
	//instant variable
	private String secretWord, disguisedWord, guessedLetters;
	private int guessMade, incorrectGuess;	
	
	//default constructor
	public HangmanGame() {
		this.setSecretWord("");
		this.setDisguisedWord();
		this.setGuessCount(0);
		this.setIncorrectGuessCount(0);
		guessedLetters = "";		
	}
	
	//overload constructor
	public HangmanGame(String secretWord) {
		this.setSecretWord(secretWord);
		this.setDisguisedWord();
		this.setGuessCount(0);
		this.setIncorrectGuessCount(0);
		guessedLetters = "";	
	}
	
	//helper method to play the game
	public void input() {
		Scanner keyboard = new Scanner(System.in);		
			System.out.println("*****LET'S PLAY HANGMAN!!*****");
			System.out.print("Enter a word for the user to guess:");
			secretWord = keyboard.next().toLowerCase();
			this.setDisguisedWord();
			System.out.println("Lets begin the game.\n");
			
			while (true) {				
				System.out.print("Enter a letter:");
				char tempChar = keyboard.next().toLowerCase().charAt(0);
				makeGuess(tempChar);
				System.out.println(toString());
					if(isFound()) {
						System.out.println("YOU ARE A WINNER!");
						System.exit(0);
				}
			}			
	}
	/**
	 * @param c
	 */
	public void makeGuess(char c)
	{		
		guessedLetters+= c;
        String word = "";
        for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == c){
                	word += c;
                } 
                else word += disguisedWord.charAt(i);                
        }
        if (! word.equals(disguisedWord)) {
        	disguisedWord = word;        	
        } 
        else {
        	disguisedWord = word;    
        	setIncorrectGuessCount(1);
        } 
        setGuessCount(1);
	}
	/**
	 * @return the disguised word
	 */
	public String getDisguisedWord() {
		return disguisedWord;		
	}
	/**
	 * @return the secret word
	 */
	public String getSecretWord() {
		return secretWord;
	}
	/**
	 * @return the number of guesses made
	 */
	public int getGuessCount()	{
		return guessMade;
	}
	/**
	 * @return the number of incorrect guess made
	 */
	public int getIncorrectGuessCount() {
		return incorrectGuess;
	}
	/**
	 * @return true if the hidden word has been discovered
	 */
	public boolean isFound()
	{
		if (getDisguisedWord().equals(getSecretWord()))
			return true;
		else return false;
	}
	/**
	 * @param secWord
	 */
	public void setSecretWord(String secWord) {
		secretWord = secWord;
	}
	/**
	 * Changes disguisedWord length
	 */
	public void setDisguisedWord() {
		disguisedWord = "";
		for (int i=0; i<this.getSecretWord().length(); i++) {
			disguisedWord += "?";
		}
	}
	/**
	 * @param count
	 */
	public void setGuessCount(int count) {
		guessMade += count;
	}
	/**
	 * @param count
	 */
	public void setIncorrectGuessCount(int count) {
		incorrectGuess += count;
	}
	/**
	 * @return String for disguised word, guess count, incorrect guess count
	 */
	public String toString() {
		return 	"The disguised word is " + getDisguisedWord() + 
				".\nThe number of guesses made is " + getGuessCount() +
				".\nThe number of incorrect guesses made is " + getIncorrectGuessCount() + 
				".\n";
	}

}