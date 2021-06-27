package dao;

import dto.entity.CategoryDto;
import entity.Category;
import mapper.CategoryMapper;

import java.util.List;

public class CategoryRepositoryImpl extends BaseDao<Category, CategoryDto, Long> implements CategoryRepository {

    public CategoryRepositoryImpl(String path) {
        super(path, new CategoryMapper());
    }

    @Override
    protected Class<CategoryDto[]> getDClass() {
        return CategoryDto[].class;
    }

    @Override
    protected Category getById(Long id, List<Category> entities) {
        return entities.stream().filter(c -> c.getId().equals(id)).findFirst().get();
    }

    @Override
    public void update(Category entity) {
        List<Category> categories = readAll();
        List<CategoryDto> dtoList;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId().equals(entity.getId())) {
                categories.set(i, entity);
                break;
            }
        }
        dtoList = mapListEntitiesToDtos(categories);
        write(dtoList);
    }


}
