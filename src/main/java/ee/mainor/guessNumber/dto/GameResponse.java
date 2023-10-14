package ee.mainor.guessNumber.dto;

import lombok.Data;

@Data
public class GameResponse {

    private String text;
    private Integer attempts;

    public GameResponse() {
        this.attempts = 0;
    }
    public void incrementAttempts() {
        attempts++;
    }
}
