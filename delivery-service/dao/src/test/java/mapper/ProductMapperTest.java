package mapper;

import dao.MockData;
import dto.entity.ProductDto;
import entity.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductMapperTest {

    @Test
    public void mapToDtoTest(){
        Product product = MockData.products.get(0);
        ProductMapper productMapper = new ProductMapper("");
        ProductDto productDto = productMapper.map().map(product,ProductDto.class);
        ProductDto productDto1 = new ProductDto(1l, "product", "Russia", 2020 , List.of(1l,2l,3l,4l));
        Assert.assertEquals(productDto, productDto1);

    }

}
