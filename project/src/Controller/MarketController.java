package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import app.MyListener;
import model.Product;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarketController implements Initializable {
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnView;

    @FXML
    private TextField fieldSearch;

    @FXML
    private Label labelCount;

    @FXML
    private Label labelIncome;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private List<Product> products = new ArrayList<>();
    private MyListener myListener;

    private List<Product> getData(String search) {
        String url = "jdbc:mariadb://localhost:3306/Store";
        Connection conn;

        try {
            conn = DriverManager.getConnection(url, "root", "");
            String query;
            if (search == "") {
                query = "SELECT * from product";
            } else {
                query = "SELECT * FROM product WHERE name LIKE '%" + search + "%'";
            }
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            List<Product> products = new ArrayList<>();
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

            labelCount.setText(Integer.toString(products.size()));
            BigDecimal sum = BigDecimal.ZERO;
            for (Product p : products) {
                sum = sum.add(p.getPrice());
            }
            labelIncome.setText("$" + sum.toString());

            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    private void clearGrid() {
        grid.getChildren().clear();
        grid.getChildren().removeAll();
        products.clear();
        while (grid.getRowConstraints().size() > 0) {
            grid.getRowConstraints().remove(0);
        }

        while (grid.getColumnConstraints().size() > 0) {
            grid.getColumnConstraints().remove(0);
        }
    }

    private void loadGrid(String search) {
        clearGrid();
        if (search == "") {
            products.addAll(getData(""));
        } else {
            products.addAll(getData(search));
        }

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < products.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                myListener = new MyListener() {
                    @Override
                    public void onClickListener() {
                        loadGrid("");
                    }
                };

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(products.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); // (child,column,row)
                // set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                // set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadGrid("");
        fieldSearch.textProperty().addListener((obs, oldText, newText) -> {
            loadGrid(newText);
        });
    }

    @FXML
    void btnAddClicked(ActionEvent event) throws IOException {
        clearGrid();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/views/productForm.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();

        grid.setAlignment(Pos.CENTER);

        grid.add(anchorPane, 0, 0); // (child,column,row)
        // set grid width
        grid.setMinWidth(Region.USE_COMPUTED_SIZE);
        grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
        grid.setMaxWidth(Region.USE_PREF_SIZE);

        // set grid height
        grid.setMinHeight(Region.USE_COMPUTED_SIZE);
        grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
        grid.setMaxHeight(Region.USE_PREF_SIZE);

        GridPane.setMargin(anchorPane, new Insets(10));
    }

    @FXML
    void btnViewClicked(ActionEvent event) {
        loadGrid("");
    }

    @FXML
    void fieldSearchAction(ActionEvent event) {

    }
}
