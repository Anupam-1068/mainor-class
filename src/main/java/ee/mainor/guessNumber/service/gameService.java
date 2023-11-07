package ee.mainor.guessNumber.service;

import ee.mainor.guessNumber.GameRepository.GuessingGameRepository;
import ee.mainor.guessNumber.dto.GameDto;
import ee.mainor.guessNumber.dto.GameRequest;
import ee.mainor.guessNumber.dto.GameResponse;
import ee.mainor.guessNumber.model.GuessingGame;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class gameService {

    private final GuessingGameRepository guessingGameRepository;

    private Map<Integer, Integer> games = new HashMap<>();

    @Transactional
    public Long createGame(GameRequest gameRequest) {
        GuessingGame guessingGame = new GuessingGame();
        guessingGame.setName("testName");
        guessingGame.setCorrectAnswer(gameRequest.getCorrectAnswer());

        return guessingGameRepository.save(guessingGame).getId();
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

    public List<GameDto> getAll() {
        return guessingGameRepository.findAll()
                .stream()
                .map(game -> new GameDto().setId(game.getId())
                        .setName(game.getName())).toList();
    }

}

