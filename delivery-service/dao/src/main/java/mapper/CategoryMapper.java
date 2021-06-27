package mapper;

import dto.entity.CategoryDto;
import entity.Category;

public class CategoryMapper extends BaseMapper<Category, CategoryDto> {


    public CategoryMapper() {
        super(Category.class, CategoryDto.class);
    }

    @Override
    void mapSpecificFieldsEntity(Category source, CategoryDto destination) {

    }

    @Override
    void mapSpecificFieldsDto(CategoryDto source, Category destination) {

    }
}
