package ce.pshl.data;

import ce.pshl.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(int id);

    List<Product> filterByNameLike(String name);

    List<Product> filterByCategory(String category);

    List<Product> filterByRating(int rating);

    Product create(Product product);

    boolean update(Product product);

    boolean deleteById(int id);
}
