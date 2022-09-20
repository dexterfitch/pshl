package ce.pshl.domain;

import ce.pshl.data.ProductRepository;
import ce.pshl.models.Product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService service;

    @MockBean
    ProductRepository repository;

    @Test
    void shouldCreateProduct() {
        Product expected = new Product(6, "belVita Limited Edition Pumpkin Spice Breakfast Biscuits - 5ct", "Generic Food", new BigDecimal(3.99), "https://www.target.com/p/belvita-limited-edition-pumpkin-spice-breakfast-biscuits-5ct/-/A-49109858", "image", false, 0, "");
        Product actual = new Product(0, "belVita Limited Edition Pumpkin Spice Breakfast Biscuits - 5ct", "Generic Food", new BigDecimal(3.99), "https://www.target.com/p/belvita-limited-edition-pumpkin-spice-breakfast-biscuits-5ct/-/A-49109858", "image", false, 0, "");

        when(repository.create(actual)).thenReturn(expected);
        Result<Product> result = service.create(actual);
        assertEquals(ResultType.SUCCESS, result.getType());
    }

    @Test
    void shouldNotCreateNullProduct() {
        Product product = null;
        Result<Product> result = service.create(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotCreateProductWithNullName() {
        Product product = new Product(6, null, "Generic Food", new BigDecimal(3.99), "https://www.target.com/p/belvita-limited-edition-pumpkin-spice-breakfast-biscuits-5ct/-/A-49109858", "image", false, 0, "");
        Result<Product> result = service.create(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotCreateProductWithNoName() {
        Product product = new Product(6, "", "Generic Food", new BigDecimal(3.99), "https://www.target.com/p/belvita-limited-edition-pumpkin-spice-breakfast-biscuits-5ct/-/A-49109858", "image", false, 0, "");
        Result<Product> result = service.create(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotCreateProductWithNullCategory() {
        Product product = new Product(6, "belVita Limited Edition Pumpkin Spice Breakfast Biscuits - 5ct", null, new BigDecimal(3.99), "https://www.target.com/p/belvita-limited-edition-pumpkin-spice-breakfast-biscuits-5ct/-/A-49109858", "image", false, 0, "");
        Result<Product> result = service.create(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotCreateProductWithNoCategory() {
        Product product = new Product(6, "belVita Limited Edition Pumpkin Spice Breakfast Biscuits - 5ct", "", new BigDecimal(3.99), "https://www.target.com/p/belvita-limited-edition-pumpkin-spice-breakfast-biscuits-5ct/-/A-49109858", "image", false, 0, "");
        Result<Product> result = service.create(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotCreateProductWithNullPrice() {
        Product product = new Product(6, "belVita Limited Edition Pumpkin Spice Breakfast Biscuits - 5ct", "Generic Food", null, "https://www.target.com/p/belvita-limited-edition-pumpkin-spice-breakfast-biscuits-5ct/-/A-49109858", "image", false, 0, "");
        Result<Product> result = service.create(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotCreateProductWithPriceLessThanOrEqualToZero() {
        Product product = new Product(6, "belVita Limited Edition Pumpkin Spice Breakfast Biscuits - 5ct", "Generic Food", new BigDecimal(0), "https://www.target.com/p/belvita-limited-edition-pumpkin-spice-breakfast-biscuits-5ct/-/A-49109858", "image", false, 0, "");
        Result<Product> result = service.create(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldUpdateProduct() {
        Product product = new Product(3, "Deny Designs Caroline Okun Pumpkin Spice Duvet Cover Set", "Miscellany", new BigDecimal(159.20), "https://www.target.com/p/deny-designs-caroline-okun-pumpkin-spice-duvet-cover-set/-/A-77676611", "image", true, 5, "Love it!");

        when(repository.update(product)).thenReturn(true);
        Result<Product> result = service.update(product);
        assertEquals(ResultType.SUCCESS, result.getType());
    }

    @Test
    void shouldNotUpdateNullProduct() {
        Product product = null;
        Result<Product> result = service.update(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateProductWithNullName() {
        Product product = new Product(3, null, "Miscellany", new BigDecimal(159.20), "https://www.target.com/p/deny-designs-caroline-okun-pumpkin-spice-duvet-cover-set/-/A-77676611", "image", true, 5, "Love it!");
        Result<Product> result = service.update(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateProductWithNoName() {
        Product product = new Product(3, "", "Miscellany", new BigDecimal(159.20), "https://www.target.com/p/deny-designs-caroline-okun-pumpkin-spice-duvet-cover-set/-/A-77676611", "image", true, 5, "Love it!");
        Result<Product> result = service.update(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateProductWithNullCategory() {
        Product product = new Product(3, "Deny Designs Caroline Okun Pumpkin Spice Duvet Cover Set", null, new BigDecimal(159.20), "https://www.target.com/p/deny-designs-caroline-okun-pumpkin-spice-duvet-cover-set/-/A-77676611", "image", true, 5, "Love it!");
        Result<Product> result = service.update(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateProductWithNoCategory() {
        Product product = new Product(3, "Deny Designs Caroline Okun Pumpkin Spice Duvet Cover Set", "", new BigDecimal(159.20), "https://www.target.com/p/deny-designs-caroline-okun-pumpkin-spice-duvet-cover-set/-/A-77676611", "image", true, 5, "Love it!");
        Result<Product> result = service.update(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateProductWithNullPrice() {
        Product product = new Product(3, "Deny Designs Caroline Okun Pumpkin Spice Duvet Cover Set", "Miscellany", null, "https://www.target.com/p/deny-designs-caroline-okun-pumpkin-spice-duvet-cover-set/-/A-77676611", "image", true, 5, "Love it!");
        Result<Product> result = service.update(product);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateProductWithPriceLessThanOrEqualToZero() {
        Product product = new Product(3, "Deny Designs Caroline Okun Pumpkin Spice Duvet Cover Set", "Miscellany", new BigDecimal(0), "https://www.target.com/p/deny-designs-caroline-okun-pumpkin-spice-duvet-cover-set/-/A-77676611", "image", true, 5, "Love it!");
        Result<Product> result = service.update(product);
        assertEquals(ResultType.INVALID, result.getType());
    }
}