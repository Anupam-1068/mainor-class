package ee.mainor.guessNumber.GameRepository;

import ee.mainor.guessNumber.model.GuessingGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuessingGameRepository extends CrudRepository<GuessingGame,Long> {


    @Override
    public List<GuessingGame> findAll();
}
