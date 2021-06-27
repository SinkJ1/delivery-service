package service.impl;

import dao.BaseRepository;
import service.BaseService;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class BaseServiceImpl<T, Y> implements BaseService<T, Y> {

    public void create(T entity, BaseRepository<T, Y> repository){
        repository.create(entity);
    }

    public T read(Y id, BaseRepository<T, Y> repository){
        return repository.read(id);
    }

    public List<T> readAll(BaseRepository<T, Y> repository) {
        return repository.readAll();
    }

    public void delete(T entity, BaseRepository<T, Y> repository){
        repository.delete(entity);
    }

    public List<T> sort(List<T> entities, Comparator<T> comparator) {
       return entities.stream().sorted(comparator.reversed()).
                collect(Collectors.toList());
    }

    public void update(T entity, BaseRepository<T, Y> repository){
        repository.create(entity);
    }

    public List<T> filter(BaseRepository<T, Y> repository, Predicate<T> ...predicates){
        return repository.filter(predicates);
    }

}
