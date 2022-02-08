package service;

import model.Category;

public class CategoryService {
    public Category mainCreateCategory(){
        Category category = new Category();
        category.setParent_id(null);
        category.setName("Konut");
        category.setId(1L);
        subCategoryCreate(category);
        return category;
    }

    public Category subCategoryCreate(Category c){
        Category category = new Category();
        category.setParent_id(c.getId());
        category.setName("Daire");
        category.setId(2L);
        return category;
    }
}
