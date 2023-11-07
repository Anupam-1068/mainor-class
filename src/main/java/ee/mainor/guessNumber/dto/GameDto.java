package ee.mainor.guessNumber.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GameDto {

    public Long id;
    public String name;

}
