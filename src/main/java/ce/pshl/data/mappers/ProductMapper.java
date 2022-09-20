package ce.pshl.data.mappers;

import ce.pshl.models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("category"),
            rs.getBigDecimal("price"),
            rs.getString("link"),
            rs.getString("image"),
            rs.getBoolean("tried"),
            rs.getInt("rating"),
            rs.getString("review")
        );
    }
}
