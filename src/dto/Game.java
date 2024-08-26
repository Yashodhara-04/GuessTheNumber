package dto;

public class Game {
	
	private int numberOfGuess;
	private String player1;
	private String player2;
	private String magicWord;
	
	public Game()
	{

	}

	public Game(int numberOfGuess, String player1)
	{
		this.numberOfGuess = numberOfGuess;
		this.player1 = player1;
	}
	
	public Game(int numberOfGuess, String player1, String player2, String magicWord)
	{
		this.numberOfGuess = numberOfGuess;
		this.player1 = player1;
		this.player2 = player2;
		this.magicWord = magicWord;
	}
	
	public int getNumberOfGuess()
	{
		return this.numberOfGuess;
	}
	
	public String getPlayer1()
	{
		return this.player1;
	}
	
	public String getPlayer2()
	{
		return this.player2;
	}
	
	public String getmagicWord()
	{
		return this.magicWord;
	}
}
