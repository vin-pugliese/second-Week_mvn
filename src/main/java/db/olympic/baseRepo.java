package db.olympic;

import java.util.List;

public interface baseRepo<T> {

    void insert(T x);
    void delete (int id);
    void update (T x);
    void findbykey (int id);
    void findAll();
    List<Athlete> findAll(double height);
}
