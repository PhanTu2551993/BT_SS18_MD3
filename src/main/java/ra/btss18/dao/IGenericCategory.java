package ra.btss18.dao;

import ra.btss18.entity.Category;

import java.util.List;

public interface IGenericCategory{
    List<Category> getCategory();
    public Category getCategoryById(Integer cat_Id);
    public boolean insertCategory(Category cat);
    public boolean updateCategory(Category cat);
    public boolean deleteCategory(Integer cat_Id);
    public List<Category> getCategoryByName(String name);
}
