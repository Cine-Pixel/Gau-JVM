package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ProductFormController {

    @FXML
    private Button btnSave;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldPrice;

    @FXML
    private TextField fieldQuantity;

    @FXML
    void btnSaveClicked(ActionEvent event) {
        String url = "jdbc:mariadb://localhost:3306/Store";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement prepStmt;
            prepStmt = conn
                    .prepareStatement("INSERT INTO product(name, image, price, quantity) VALUES(?, ?, ?, ?)");
            prepStmt.setString(1, fieldName.getText());
            prepStmt.setString(2, "/img/laptop.png");
            prepStmt.setString(3, fieldPrice.getText());
            prepStmt.setString(4, fieldQuantity.getText());

            prepStmt.executeUpdate();

            ShowAlert("ოპერაცია წარმატებულია", "ოპერაცია წარმატებულია", "ოპერაცია წარმატებით შესრულდა",
                    AlertType.INFORMATION);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void ShowAlert(String title, String header, String content, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

}
