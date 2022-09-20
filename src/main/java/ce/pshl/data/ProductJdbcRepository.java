package ce.pshl.data;

import ce.pshl.data.mappers.ProductMapper;
import ce.pshl.models.Product;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductJdbcRepository implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> findAll() {
        final String sql = "SELECT id, `name`, category, price, link, image, tried, rating, review " +
            "FROM products " +
            "ORDER BY `name`;";

        return jdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public Product findById(int id) {
        final String sql = "SELECT id, `name`, category, price, link, image, tried, rating, review " +
            "FROM products " +
            "WHERE id = ?;";

        return jdbcTemplate.query(sql, new ProductMapper(), id)
            .stream().findFirst().orElse(null);
    }

    @Override
    public List<Product> filterByNameLike(String name) {
        final String sql = "SELECT id, `name`, category, price, link, image, tried, rating, review " +
            "FROM products " +
            "WHERE `name` LIKE CONCAT('%', ?, '%') " +
            "ORDER BY `name`;";

        return jdbcTemplate.query(sql, new ProductMapper(), name);
    }

    @Override
    public List<Product> filterByCategory(String category) {
        final String sql = "SELECT id, `name`, category, price, link, image, tried, rating, review " +
            "FROM products " +
            "WHERE category = ? " +
            "ORDER BY `name`;";

        return jdbcTemplate.query(sql, new ProductMapper(), category);
    }

    @Override
    public List<Product> filterByRating(int rating) {
        final String sql = "SELECT id, `name`, category, price, link, image, tried, rating, review " +
            "FROM products " +
            "WHERE rating = ? " +
            "ORDER BY `name`;";

        return jdbcTemplate.query(sql, new ProductMapper(), rating);
    }

    @Override
    public Product create(Product product) {
        final String sql = "INSERT INTO products (`name`, category, price, link, image, tried, rating, review) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setString(2, product.getCategory());
            statement.setBigDecimal(3, product.getPrice());
            statement.setString(4, product.getLink());
            statement.setString(5, product.getImage());
            statement.setBoolean(6, product.getTried());
            statement.setInt(7, product.getRating());
            statement.setString(8, product.getReview());
            return statement;
        }, keyHolder);

        if (rowsAffected == 0) {
            return null;
        }

        product.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());

        return product;
    }

    @Override
    public boolean update(Product product) {
        final String sql = "UPDATE products SET " +
            "`name` = ?, " +
            "category = ?, " +
            "price = ?, " +
            "link = ?, " +
            "image = ?, " +
            "tried = ?, " +
            "rating = ?, " +
            "review = ? " +
            "WHERE id = ?;";

        return jdbcTemplate.update(sql,
            product.getName(),
            product.getCategory(),
            product.getPrice(),
            product.getLink(),
            product.getImage(),
            product.getTried(),
            product.getRating(),
            product.getReview(),
            product.getId()) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        final String sql = "DELETE FROM products WHERE id = ?;";

        return jdbcTemplate.update(sql, id) > 0;
    }
}
