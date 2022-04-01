package db.olympic;

import db.olympic.Bean.Athlete;

import java.util.List;

public interface baseRepo<T> {

    void insert(T x);
    void delete (int id);
    void update (T x);
    void findbykey (int id);
    void findAll();
    List<Athlete> findAll(double height);
}
