package management.service;

import java.util.List;

public interface GeneralService <T>{
    List<T> findAll();
    List<T> findByName(String key);
    int findIndexById(int id);
    void save(T t);
    T findById(int id);
    void update(int id, T t);
    void remove(int id);
}
