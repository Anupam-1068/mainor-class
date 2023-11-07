package ee.mainor.guessNumber.web;

import ee.mainor.guessNumber.dto.GameRequest;
import ee.mainor.guessNumber.dto.GameResponse;
import ee.mainor.guessNumber.service.gameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("game")
public class gameController {

    private final gameService gameService;

    @PostMapping
    public Integer createGame(@RequestBody GameRequest gameRequest) {
        return gameService.createGame(gameRequest);
    }

    @GetMapping("{gameId}/guess/{number}")
    public GameResponse guess(@PathVariable Integer gameId,@PathVariable Integer number){

        return gameService.guessableNumber(gameId,number);
    }

}
