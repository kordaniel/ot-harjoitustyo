package tetris.dao;

import java.util.List;
import tetris.domain.Score;

public interface ScoreDao {
    
    List<Score> getAll();
    void saveAll(List<Score> scores);
}
