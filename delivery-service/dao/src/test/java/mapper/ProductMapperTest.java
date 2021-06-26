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
        ProductMapper productMapper = new ProductMapper("", "");
        ProductDto productDto = productMapper.toDto(product);
        ProductDto productDto1 = new ProductDto(1l, "product", "Russia", 2020 , List.of(1l,2l,3l,4l));
        Assert.assertEquals(productDto, productDto1);

    }

    @Test
    public void mapToEntityTest(){
        ProductMapper productMapper = new ProductMapper("","");
        ProductDto productDto = new ProductDto(1l, "product", "Russia", 2020 , List.of(1l,2l,3l,4l));
        Product product = productMapper.toEntity(productDto);
        Product product2 = new Product(1l, "product", "Russia", 2020 , MockData.categories);
        Assert.assertEquals(product, product2);

    }

}
