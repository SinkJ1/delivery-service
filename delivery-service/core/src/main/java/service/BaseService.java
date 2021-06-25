package service;

import dao.Repository;

import java.util.List;

public interface BaseService<T, Y> {

    void create(T entity, Repository<T, Y> repository);

    T read(Y id, Repository<T, Y>  repository);

    List<T> readAll(Repository<T, Y>  repository);

    void update(T entity, Repository<T, Y>  repository);

    void delete(T entity, Repository<T, Y>  repository);

}
