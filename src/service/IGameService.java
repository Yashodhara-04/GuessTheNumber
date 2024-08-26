package service;

import java.util.HashMap;

import dto.Game;

public interface IGameService {
	public void generateRandomNumber(int[] range);
	
	public String printAtempts(int attempts);
	
	public void createTheMagicNumber(String mangicWord);
	
	public void gessTheNumber(Game game);
	
	public HashMap<String,String> showResult();
	
	public void gessTheNumberDoublePlayer(Game game);
}
