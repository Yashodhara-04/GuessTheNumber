package service;

import java.util.HashMap;

import dao.GameRepository;
import dto.Game;

public class GameService implements IGameService {
	
	GameRepository gameRepository = null;
	
	public GameService()
	{
		gameRepository = new GameRepository();
	}

	@Override
	public void generateRandomNumber(int[] range) {
		// TODO Auto-generated method stub
		gameRepository.generateRandomNumber(range);
	}

	@Override
	public String printAtempts(int attempts) {
		// TODO Auto-generated method stub
		return gameRepository.printAtempts(attempts);
	}

	public void createTheMagicNumber(String mangicWord) {
		// TODO Auto-generated method stub
		gameRepository.createTheMagicNumber(mangicWord);
		
	}

	@Override
	public void gessTheNumber(Game game) {
		// TODO Auto-generated method stub
		gameRepository.gessTheNumber(game);
	}

	@Override
	public HashMap<String, String> showResult() {
		// TODO Auto-generated method stub
		return gameRepository.showResult();
	}

	@Override
	public void gessTheNumberDoublePlayer(Game game) {
		// TODO Auto-generated method stub
		gameRepository.gessTheNumberDoublePlayer(game);
	}

}
