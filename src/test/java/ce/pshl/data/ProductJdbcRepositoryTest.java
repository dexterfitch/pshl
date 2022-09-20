package ce.pshl.data;

import ce.pshl.models.Product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductJdbcRepositoryTest {

    @Autowired
    ProductJdbcRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup() {
        knownGoodState.set();
    }

    @Test
    void shouldFindAll() {
        List<Product> products = repository.findAll();
        assertNotNull(products);
        assertTrue(products.size() == 5 || products.size() == 6);
    }

    @Test
    void shouldFindById() {
        Product ornament = repository.findById(5);
        assertEquals(5, ornament.getId());
        assertEquals("Holiday Ornament 4.0\" Pumpkin Spice Latte Fresh - Tree Ornaments", ornament.getName());
    }

    @Test
    void shouldFilterByNameLikeBaby() {
        List<Product> babyClothes = repository.filterByNameLike("baby");
        assertEquals(1, babyClothes.size());
    }

    @Test
    void shouldFilterByNameLikePumpkin() {
        List<Product> pumpkinStuff = repository.filterByNameLike("pumpkin");
        assertEquals(5, pumpkinStuff.size());
    }

    @Test
    void shouldFilterByCategoryMiscellany() {
        List<Product> miscStuff = repository.filterByCategory("miscellany");
        assertEquals(3, miscStuff.size());
    }

    @Test
    void shouldFilterByCategorySweet() {
        List<Product> sweetStuff = repository.filterByCategory("sweet");
        assertEquals(1, sweetStuff.size());
    }

    @Test
    void shouldFilterByNoRating() {
        List<Product> unratedStuff = repository.filterByRating(0);
        assertEquals(4, unratedStuff.size());
    }

    @Test
    void shouldFilterByRatingFour() {
        List<Product> ratedFourStuff = repository.filterByRating(4);
        assertEquals(1, ratedFourStuff.size());
    }

    @Test
    void shouldCreate() {
        Product expected = new Product(6, "belVita Limited Edition Pumpkin Spice Breakfast Biscuits - 5ct", "Generic Food", new BigDecimal(3.99), "https://www.target.com/p/belvita-limited-edition-pumpkin-spice-breakfast-biscuits-5ct/-/A-49109858", "image", false, 0, "");
        Product actual = repository.create(expected);
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
    }

    @Test
    void shouldUpdate() {
        Product duvet = new Product(3, "Deny Designs Caroline Okun Pumpkin Spice Duvet Cover Set", "Miscellany", new BigDecimal(159.20), "https://www.target.com/p/deny-designs-caroline-okun-pumpkin-spice-duvet-cover-set/-/A-77676611", "image", true, 5, "Love it!");
        assertTrue(repository.update(duvet));
        assertEquals(duvet.getRating(), repository.findById(3).getRating());
    }

    @Test
    void shouldDeleteById() {
        assertTrue(repository.deleteById(5));
        assertFalse(repository.deleteById(5));
    }
}