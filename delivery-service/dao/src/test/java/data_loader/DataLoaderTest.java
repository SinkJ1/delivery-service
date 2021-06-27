package data_loader;

import com.google.gson.Gson;
import dto.entity.OrderDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DataLoaderTest {


    @Test
    public void writeReadTest() throws IOException {

        FileWorker fileWorker = new FileWorker();

        List<OrderDto> orderDtos = List.of(
                new OrderDto(1L, 1l, List.of(1L), 1l)
        );
        fileWorker.writeToFile(orderDtos, "src/test/resources/data/test.json");

        List<OrderDto> orders = Arrays.asList(new Gson().fromJson(new FileReader("src/test/resources/data/test.json"), OrderDto[].class));
        Assert.assertEquals(orderDtos, orders);
    }

}
