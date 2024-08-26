package dao;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import dto.Game;

public class GameRepository {
	
	
	public int randomNumber;
	public HashMap<Integer,String> attemptsMap = new HashMap<>();
	public HashMap<String,String> result = new HashMap<>();
	public int magicNumber = 0;
	
	public GameRepository()
	{
		randomNumber=0;
		attemptsMap.put(1,"first");
		attemptsMap.put(2,"second");
		attemptsMap.put(3,"thirst");
		attemptsMap.put(4,"forth");
		attemptsMap.put(5,"fifth");
		attemptsMap.put(6,"sixth");
		attemptsMap.put(7,"seventh");
		attemptsMap.put(8,"eigth");
		attemptsMap.put(9,"ninteeth");
		attemptsMap.put(10,"tenth");
	}
	
	public void generateRandomNumber(int[] range)
	{
		 Random random = new Random();
		 randomNumber  = random.nextInt((range[1] - range[0]) + 1) + range[0];
	}
	
	public void gessTheNumber(Game game)
	{
		int attempts=1;
		while(attempts<=game.getNumberOfGuess())
		{
			System.out.println("\nEnter your "+ attemptsMap.get(attempts) +" guess: ");
			Scanner sc = new Scanner(System.in);
			int num =  sc.nextInt();
			String res = isNumberEqual(num,game);
			if(res != "true")
			{
				System.out.println(res);
				attempts++;
			}	
			else
			{
				System.out.println("\nCongratulations "+ game.getPlayer1() + ", you have won the game..!!!");
				System.out.println("*************************End Game*************************");
				break;
			}
		}
		if(attempts > game.getNumberOfGuess())
		{
			System.out.println("\nNo Attempts left!!!");
			System.out.println("Sorry " + game.getPlayer1() +", you lost the game.");
			System.out.println("*************************End Game*************************");
		}
	}
	
	public void gessTheNumberDoublePlayer(Game game)
	{
		int attempts=1;
		while(attempts<=game.getNumberOfGuess())
		{
			System.out.println("\nEnter your "+ attemptsMap.get(attempts) +" guess: ");
			Scanner sc = new Scanner(System.in);
			int num =  sc.nextInt();
			String res = isNumberEqual(num,game);
			if(res != "true")
			{
				System.out.println(res);
				attempts++;
			}	
			else
			{
				result.put(game.getPlayer2(),"Won");
				System.out.println("\nCongratulations "+ game.getPlayer2() + ", you have won the game..!!!");
				System.out.println("*************************End Game*************************");
				break;
			}
		}
		if(attempts > game.getNumberOfGuess())
		{
			result.put(game.getPlayer2(),"Lost");
			System.out.println("\nNo Attempts left!!!");
			System.out.println("Sorry " + game.getPlayer2() +", you lost the game.");
			System.out.println("*************************End Game*************************");
		}
	}
		
	public String isNumberEqual(int num, Game game)
	{
		if(num < randomNumber)
		{
			return "Hint: Too Low!";
		}
		else if(num > randomNumber)
		{
			return "Hint: Too High!";
		}
		else
		{
			return "true";
		}
	}
	
	public String printAtempts(int attempts)
	{
		return attemptsMap.get(attempts);
	}
	
	public HashMap<String,String> showResult()
	{
		return result;
	}
	
	public void createTheMagicNumber(String magicWord)
	{
		for(char c : magicWord.toCharArray())
		{
			randomNumber += c;
		}
	}
}
