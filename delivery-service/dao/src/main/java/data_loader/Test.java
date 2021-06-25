package data_loader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test {

    public static void main(String[] args){
        try (Writer writer = new FileWriter("dao/src/main/resources/data/test.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(new Abc(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
