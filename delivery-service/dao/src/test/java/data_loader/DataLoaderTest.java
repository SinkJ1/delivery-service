package data_loader;

import com.google.gson.Gson;
import entity.Category;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataLoaderTest {


    @Test
    public void writeReadTest() throws IOException {

        FileWorker fileWorker = new FileWorker();
        Category category = new Category(1L, "shop");
        List<Category> categories = new ArrayList<>();
        categories.add(category);
        fileWorker.writeToFile(categories, "src/test/resources/data/category.json");


        List<Category> categories1 = Arrays.asList(new Gson().fromJson(new FileReader("src/test/resources/data/category.json"), Category[].class));
        Assert.assertEquals(categories, categories1);
    }

}
