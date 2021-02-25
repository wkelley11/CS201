import java.util.Scanner;

public class HangmanDriver2 {
	static int numIncorrect = 0;
	static int numParts = 0;
	char letterGuess;
	String wordGuess;

	
	public static void getChoice() {
		System.out.println("Type (L) to guess a letter, or (W) to get the whole word: ");

	}
	public static void getChoiceL() {
		System.out.println("Guess a letter: ");

	}
	public static void getChoiceW() {
		System.out.println("Guess the word: ");
		
		}
	public static void playGame() {
		Hangman game = new Hangman();
		game.setDefaultWords();
		String word = game.selectGameWord().toUpperCase();
		Scanner scan = new Scanner(System.in);
		char[] newCurrentWord = {'-','-','-','-','-','-','-'};
		char [] newCurrentWord2 = {'-','-','-','-','-','-','-'};
		String incorrectGuesses = "";
		game.setDispArr(newCurrentWord);
		game.setIncorrectGuesses(incorrectGuesses);
		boolean correct;
		numParts = 0;
		System.out.println("Generating secret word...");
		System.out.println("Here is your word: " + game.getCurrentWord());
		
		while(word.equals(game.getCurrentWord()) == false & numParts < 10)
		{

			getChoice();
			String response = scan.nextLine().toUpperCase();
			correct = false;
			if(response.equals("L"))
			{
				getChoiceL();
			}
			
			else
			{
				getChoiceW();
			}
			
			String guess = scan.nextLine().toUpperCase();
			
			if(guess.length() == 1) //letter is guessed
			{
				char letterGuess = guess.charAt(0);
				
				for(int i = 0; i < word.length(); i++)
				{
					if(letterGuess == (word.charAt(i)))
					{
						newCurrentWord[i] = letterGuess;
						correct = true;
					}	
					game.setDispArr(newCurrentWord);
				}

				if(correct == false)
				{
					System.out.println("Incorrect!");
					numParts ++;
					incorrectGuesses += letterGuess;
					game.setIncorrectGuesses(incorrectGuesses);
				}
				else
				{
					System.out.println("Correct!");
				}
				System.out.println(game.getCurrentWord());
				Hangman.showMan(numParts);
				System.out.println("Incorrect Guesses: " + game.getIncorrectGuesses());
				newCurrentWord2 = newCurrentWord;
				}	
			
			else //word is guessed
			{
				if(guess.equals(word))//user correctly guesses the word
				{
					System.out.println("You Win!");
					System.out.println("The word was: " + word);
					game.setDispArr(guess.toCharArray());
				}
				else//user incorrectly guesses the word
				{
					System.out.println("You Lose!");
					System.out.println("The word was: " + word);
				}
			
			game.setDispArr(word.toCharArray());//break while loop
			}
		}
	}
		public static boolean playAgain() {
			Scanner scan = new Scanner(System.in);
			boolean enthusiasm = true;
			System.out.println("Play again? Yes(Y) or No(N)");
			if(scan.nextLine().toUpperCase().equals("Y"))
			{
				enthusiasm = true;
			}
			else
			{
				enthusiasm = false;
				System.out.println("Goodbye!");
			}
			return enthusiasm;
					
				
					
		}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true)
			{
			playGame();
			if(playAgain() == false)
				{
				break;
				}
			}
		

	}

}
