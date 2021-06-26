package dao;

import entity.Category;

import java.util.List;

public class CategoryRepositoryImpl extends BaseDao<Category, Long> implements CategoryRepository{

    //final static String path = "dao/src/main/resources/data/category.json";

    public CategoryRepositoryImpl(String path){
        super(path, MockData.categories);
    }


    @Override
    protected Class<Category[]> getTClass() {
        return Category[].class;
    }

    @Override
    protected Category getById(Long id, List<Category> entities) {
        return null;
    }


}
