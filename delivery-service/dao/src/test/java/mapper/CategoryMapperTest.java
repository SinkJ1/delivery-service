package mapper;

import dto.entity.CategoryDto;
import entity.Category;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryMapperTest {

    @Test
    public void mapToDtoTest(){

        CategoryMapper categoryMapper = new CategoryMapper();
        Category category = new Category(1l, "name");
        CategoryDto categoryDto = categoryMapper.toDto(category);
        CategoryDto categoryDto1 = new CategoryDto(1l, "name");
        Assert.assertEquals(categoryDto1,categoryDto);
    }


}
