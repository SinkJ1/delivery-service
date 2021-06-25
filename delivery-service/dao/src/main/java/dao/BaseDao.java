package dao;

import data_loader.FileWorker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public abstract class BaseDao<T, Y> implements Repository<T, Y> {

    FileWorker<T> fileWorker = new FileWorker<T>();

    private String path;
    protected List<T> entities;

    public BaseDao(String path, List<T> entities) {
        this.path = path;
        this.entities = new ArrayList<>(entities);
    }

    protected abstract Class<T[]> getTClass();
    protected abstract T getById(Y id, List<T> entities);

    private void write(List<T> list) throws IOException {
        fileWorker.writeToFile(list, path);
    }

    @Override
    public void create(T entity) {
        /*try {
            List<T> entities = new ArrayList<>(readData(path));
            entities.add(entity);
            writeData(entities, path);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        entities.add(entity);
    }

    @Override
    public T read(Y id) {

      /*  try {

            List<T> entities = readData(path);
           /* return entities.stream().
                    filter(e -> e.getId().equals(id)).findFirst();*/


        /*} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            //throw new IOException(e);
            e.printStackTrace();
        }*/


        return getById(id, entities);
    }

    @Override
    public List<T> readAll() {
        //return Arrays.asList(new Gson().fromJson(fileWorker.readFromFile(path), getTClass()));
      return entities;
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {
        entities.remove(entity);
    }
}
