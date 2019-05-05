package tetris.dao;

import java.util.List;

public interface Dao<T, K> {    
    T findOne(K key);
    List<T> findAll();
    void saveAll(List<T> scores);
    void deleteAll();
}
