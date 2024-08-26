package controller;

import java.util.Scanner;

import dto.Game;
import service.IGameService;
import service.GameService;


public class GuessTheNumberController {
	IGameService gameService = new GameService();;
	int[] range = new int[2];

	public void startTheGame()
	{
		while(true)
		{
			System.out.print("\n---------------------------------------------------------------------------------------------");
			System.out.println("\n        Welcome to the Game - Guess the Number");
			showMenu();
		}
	}
	
	public void showMenu()
	{
		String gameChoice = getUserInputString("Do you want to play with your Friend ? [Y/N]: ");
		switch(gameChoice)
		{
			case "N": singlePlayerStartUp();
					  break;
			case "Y": doublePLayerStartUp();
					  break;
			default: System.out.println("Invalid Choice!!");
					 break;
		}

	}
	
	public void doublePLayerStartUp()
	{
		String player1 = getUserInputString("\nEnter the player1 name : ");
		String player2 = getUserInputString("\nEnter the player2 name : ");
		String magicWord = getUserInputString("\n"+player1+ " please enter the magic word to be guessed : ");
		Game game = new Game(getNumberOfGuess(),player1,player2,magicWord);
		gameService.createTheMagicNumber(game.getmagicWord());
		gameService.gessTheNumberDoublePlayer(game); 
		System.out.println("Result: "+gameService.showResult());
	}
	
	public void singlePlayerStartUp()
	{
		String name = getUserInputString("\nEnter the player name: ");
		Game game = new Game(getNumberOfGuess(),name);		
		range = getRange();		
		generateRandomNumber(range);
		gameService.gessTheNumber(game);
	}
	
	public int[] getRange()
	{
		System.out.println("\nEnter the Range where you want to Play");
		System.out.println("1. less than 10 \n2. less than 100 \n3. 100 to 500 \n4. 1 to 1000\r\n");
		int ch = getUserInput("Enter your choice: ");
		switch(ch)
		{
			case 1: return new int[]{0,10}; 
			case 2: return new int[] {0,100};
			case 3: return new int[] {100,500};
			case 4: return new int[] {1,100};
			default : System.out.println("Taking default range[0-99]");
					return new int[] {0,99};
		}
	}
	
	public int getUserInput(String str)
	{
		System.out.print(str);
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		return num;
	}
	
	public String getUserInputString(String str)
	{
		System.out.print(str);
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		return input;
	}
	
	public int getNumberOfGuess()
	{
		int numberOfGuess = getUserInput("\nEnter the number of chances to guess the number [Max you can have is 10 chances]: ");
		while(numberOfGuess > 10)
		{
			numberOfGuess = getUserInput("\nMax you can have is 10 chances:");			
		}
		return numberOfGuess;
	}
	public void generateRandomNumber(int[] range)
	{
		gameService.generateRandomNumber(range);
	}
}
