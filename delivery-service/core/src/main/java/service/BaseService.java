package service;

import dao.BaseRepository;

import java.util.Comparator;
import java.util.List;

public interface BaseService<T, Y> {

    void create(T entity, BaseRepository<T, Y> repository);

    T read(Y id, BaseRepository<T, Y> repository);

    List<T> readAll(BaseRepository<T, Y> repository);

    void update(T entity, BaseRepository<T, Y> repository);

    void delete(T entity, BaseRepository<T, Y> repository);

    List<T> sort(List<T> entities, Comparator<T> comparator);
}
