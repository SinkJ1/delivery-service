package dao;

import java.util.List;

public interface Repository<T, Y> {

    void create(T entity);

    T read(Y id);

    List<T> readAll();

    void update(T entity);

    void delete(T entity);
}
