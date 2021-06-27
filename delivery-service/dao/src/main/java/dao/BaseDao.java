package dao;

import com.google.gson.Gson;
import data_loader.FileWorker;
import mapper.BaseMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public abstract class BaseDao<T, D, Y> implements BaseRepository<T, Y> {

    private FileWorker<D> fileWorker;

    private String path;
    private BaseMapper<T, D> mapper;


    public BaseDao(String path, BaseMapper<T, D> mapper) {
        this.path = path;
        this.mapper = mapper;
        this.fileWorker = new FileWorker<>();
    }

    protected abstract Class<D[]> getDClass();

    protected abstract T getById(Y id, List<T> entities);

    protected void write(List<D> list) {
        fileWorker.writeToFile(list, path);
    }

    @Override
    public void create(T entity) {
        try (FileReader fileReader = fileWorker.readFromFile(path)) {
            List<D> entities = new ArrayList<>(Arrays.asList(new Gson().fromJson(fileReader, getDClass())));
            entities.add(mapper.toDto(entity));
            write(entities);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T read(Y id) {

        List<T> entities = new ArrayList<>();
        List<D> dtoEntities;
        try (FileReader fileReader = fileWorker.readFromFile(path)) {
            dtoEntities = new ArrayList<>(Arrays.asList(new Gson().fromJson(fileReader, getDClass())));
            entities = mapListDtosToEntities(dtoEntities);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return getById(id, entities);
    }

    @Override
    public List<T> readAll() {
        List<T> entities = new ArrayList<>();
        List<D> dtoEntities;
        try {
            dtoEntities = new ArrayList<>(Arrays.asList(new Gson().fromJson(fileWorker.readFromFile(path), getDClass())));
            entities = mapListDtosToEntities(dtoEntities);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public void update(T entity) {

    }

    public List<D> mapListEntitiesToDtos(List<T> entities) {
        List<D> dtoEntities = new ArrayList<>();
        entities.stream().forEach(e -> dtoEntities.add(mapper.toDto(e)));
        return dtoEntities;
    }

    public List<T> mapListDtosToEntities(List<D> dtos) {
        List<T> entities = new ArrayList<>();
        dtos.stream().forEach(d -> entities.add(mapper.toEntity(d)));
        return entities;
    }

    @Override
    public void delete(T entity) {
        List<T> entities = readAll();
        entities.remove(entity);
        write(mapListEntitiesToDtos(entities));
    }

    public List<T> filter(Predicate<T>... predicates) {
        Stream<T> result = readAll().stream();
        for (Predicate<T> predicate : predicates) {
            result = result.filter(predicate);
        }
        return result.collect(Collectors.toList());
    }

}
