package Tasks;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.concurrent.Task;
import model.Product;

public class LoadTask extends Task<List<Product>> {
    @Override
    protected List<Product> call() throws Exception {

        String url = "jdbc:mariadb://localhost:3306/Store";
        Connection conn;
        List<Product> products = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(url, "root", "");
            String query = "SELECT * FROM product";
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                BigDecimal price = rs.getBigDecimal("price");
                Integer quantity = rs.getInt("quantity");

                Product product = new Product();
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                product.setImgSrc(image);
                product.setQuantity(quantity);
                products.add(product);
            }

            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}