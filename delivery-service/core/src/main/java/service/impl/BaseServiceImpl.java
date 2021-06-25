package service.impl;

import dao.Repository;
import service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<T, Y> implements BaseService<T, Y> {

    public void create(T entity, Repository<T, Y>  repository){
        repository.create(entity);
    }

    public T read(Y id, Repository<T, Y> repository){
        return repository.read(id);
    }

    public List<T> readAll(Repository<T, Y> repository) {
        return null;
    }

    public void delete(T entity, Repository<T, Y>  repository){
        repository.delete(entity);
    }

    public void update(T entity, Repository<T, Y>  repository){
        repository.create(entity);
    }



}
