package marketDB;

public interface Ops<T> {

    void insert(T x);

    void update(T x);

    void delete(T x);

    void findByKey(T x);


}
