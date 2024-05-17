package ra.btss18.dao;

import ra.btss18.entity.Category;
import ra.btss18.entity.Product;

import java.util.List;

public interface IGenericProduct {
    List<Product> getProduct();
    public Product getProductById(Integer pro_Id);
    public boolean insertProduct(Product pro);
    public boolean updateProduct(Product pro);
    public boolean deleteProduct(Integer pro_Id);
    public List<Product> getProductByName(String name);
}
