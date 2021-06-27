package data_loader;

import com.google.gson.Gson;
import dto.entity.OrderDto;
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

        List<Long> ll = new ArrayList<>();
        ll.add(1L);

        List<OrderDto> orderDtos = List.of(
                new OrderDto(1L, 1l, ll, 1l)
        );
        fileWorker.writeToFile(orderDtos, "src/test/resources/data/test.json");


        List<OrderDto> categories1 = Arrays.asList(new Gson().fromJson(new FileReader("src/test/resources/data/order.json"), OrderDto[].class));
        Assert.assertEquals(orderDtos, categories1);
    }

}
