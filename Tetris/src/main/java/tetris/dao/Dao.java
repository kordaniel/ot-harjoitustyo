package tetris.dao;

import java.util.List;

public interface Dao<T,K> {    
    T findOne(K key);
    //T findByName(String name);
    List<T> findAll();
    //T saveOrUpdate(T object);
    void saveAll(List<T> scores);
    void delete(K key);
    void deleteAll();
}
