package ee.mainor.guessNumber.service;

import ee.mainor.guessNumber.dto.GameRequest;
import ee.mainor.guessNumber.dto.GameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class gameService {

    private Map<Integer, Integer> games = new HashMap<>();
    private Random random = new Random();
    int min = 1;
    int max = 100;

    public Integer createGame(GameRequest gameRequest) {
        Integer id = random.nextInt(max - min + 1) + min; //random id between 1 and 100
        games.put(id, gameRequest.getCorrectAnswer());
        return id;
    }

    public GameResponse guessableNumber(Integer gameId, Integer userGuess) {

        GameResponse gameResponse = new GameResponse();

        Integer correctAnswer = games.get(gameId);

        if (userGuess.equals(correctAnswer)) {
            gameResponse.setText("Correct ");
        } else if (userGuess < correctAnswer) {
            gameResponse.setText("Nr is bigger");
        } else {
            gameResponse.setText("Nr is smaller");
        }
        return gameResponse;
    }

}

