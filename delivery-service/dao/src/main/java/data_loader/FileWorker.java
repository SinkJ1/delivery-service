package data_loader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

public class FileWorker<T> {

    public FileReader readFromFile(String path) throws FileNotFoundException {

        return new FileReader(path);
    }

    public void writeToFile(List<T> list,String path){
        try (Writer writer = new FileWriter(path)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
