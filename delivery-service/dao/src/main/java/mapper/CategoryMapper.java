package mapper;

import dto.entity.CategoryDto;
import entity.Category;

public class CategoryMapper extends BaseMapper<Category, CategoryDto> {


    CategoryMapper(Class<Category> entityClass, Class<CategoryDto> dtoClass) {
        super(entityClass, dtoClass);
    }

    @Override
    void mapSpecificFieldsEntity(Category source, CategoryDto destination) {

    }

    @Override
    void mapSpecificFieldsDto(CategoryDto source, Category destination) {

    }
}
