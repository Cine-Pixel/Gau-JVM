package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.App;
import app.MyListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Product;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;

    @FXML
    private Button btnDelete;

    private Product product;
    private MyListener myListener;

    public void setData(Product product, MyListener myListener) {
        this.product = product;
        this.myListener = myListener;
        nameLabel.setText(product.getName());
        priceLable.setText(App.CURRENCY + product.getPrice());
        Image image = new Image(getClass().getResourceAsStream(product.getImgSrc()));
        img.setImage(image);
    }

    @FXML
    void btnDeleteClicked(ActionEvent event) {
        String url = "jdbc:mariadb://localhost:3306/Store";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM product WHERE id = ?");
            prepStmt.setString(1, Integer.toString(this.product.getId()));
            prepStmt.executeUpdate();
            myListener.onClickListener();

            // ShowAlert("ოპერაცია წარმატებულია", "ოპერაცია წარმატებულია", "წიგნი წაიშალა",
            // AlertType.INFORMATION);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
