package ce.pshl.domain;

import ce.pshl.data.ProductRepository;
import ce.pshl.models.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    };

    public Product findById(int id) {
        return repository.findById(id);
    };

    public List<Product> filterByNameLike(String name) {
        return repository.filterByNameLike(name);
    };

    public List<Product> filterByCategory(String category) {
        return repository.filterByCategory(category);
    };

    public List<Product> filterByRating(int rating) {
        return repository.filterByRating(rating);
    };

    public Result<Product> create(Product product) {
        Result<Product> result = validate(product);

        if (!result.isSuccess()) {
            return result;
        }

        if (product.getId() != 0) {
            result.addMessage("id cannot be preset for create operation", ResultType.INVALID);
            return result;
        }

        product = repository.create(product);

        result.setPayload(product);

        return result;
    };

    public Result<Product> update(Product product) {
        Result<Product> result = validate(product);

        if (!result.isSuccess()) {
            return result;
        }

        if (product.getId() <= 0) {
            result.addMessage("id must be set for 'update' operation", ResultType.INVALID);

            return result;
        }

        if (!repository.update(product)) {
            String msg = String.format("id: %s, not found", product.getId());

            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;};

    public boolean deleteById(int id) {
        return repository.deleteById(id);
    };

    private Result<Product> validate(Product product) {
        Result<Product> result = new Result<>();

        if (product == null) {
            result.addMessage("product cannot be null", ResultType.INVALID);
            return result;
        }

        if (product.getName() == null || product.getName().isBlank()) {
            result.addMessage("name is required", ResultType.INVALID);
        }

        if (product.getCategory() == null || product.getCategory().isBlank()) {
            result.addMessage("category is required", ResultType.INVALID);
        }

        if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            result.addMessage("price > 0 is required", ResultType.INVALID);
        }

        return result;
    }
}
