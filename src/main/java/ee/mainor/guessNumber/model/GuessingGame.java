package ee.mainor.guessNumber.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class GuessingGame {

    @Id
    private Long id;
    private Integer correctAnswer;
    private String name;
}
