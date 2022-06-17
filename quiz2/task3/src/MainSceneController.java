import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainSceneController implements Initializable {

    @FXML
    private Button buttonSave;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button buttonLoad;

    @FXML
    private TextField fieldAddress;

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldName;

    @FXML
    private TableView<UniItem> tableItems;

    @FXML
    private TableColumn<UniItem, String> colEmail;

    @FXML
    private TableColumn<UniItem, String> colId;

    @FXML
    private TableColumn<UniItem, String> colName;

    @FXML
    private TableColumn<UniItem, String> colAddress;

    private String action = "ADD";
    private UniItem item;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private void ShowAlert(String title, String header, String content, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

    private void ClerForm() {
        fieldName.setText("");
        fieldAddress.setText("");
        fieldEmail.setText("");
    }

    @FXML
    void buttonSaveClicked(ActionEvent event) {
        String url = "jdbc:mariadb://localhost:3306/university";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement prepStmt;
            if (this.action == "ADD") {
                prepStmt = conn
                        .prepareStatement("INSERT INTO uni(name, address, email) VALUES(?, ?, ?)");
            } else {
                prepStmt = conn
                        .prepareStatement("UPDATE uni SET name = ?, address = ?, email = ? WHERE id = ?");
                prepStmt.setString(4, item.id);
            }
            prepStmt.setString(1, fieldName.getText());
            prepStmt.setString(2, fieldAddress.getText());
            prepStmt.setString(3, fieldEmail.getText());

            prepStmt.executeUpdate();

            ShowAlert("ოპერაცია წარმატებულია", "ოპერაცია წარმატებულია", "ოპერაცია წარმატებით შესრულდა",
                    AlertType.INFORMATION);

            this.item = null;
            this.action = "ADD";
            this.ClerForm();
            buttonLoad.fire();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void buttonDeleteClicked(ActionEvent event) {
        UniItem item = tableItems.getSelectionModel().getSelectedItem();
        if (item == null) {
            ShowAlert("შეცდომა", "", "გთხოვთ მონიშნოთ ელემენტი სიიდან", AlertType.ERROR);
        }

        String url = "jdbc:mariadb://localhost:3306/university";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM uni WHERE id = ?");
            prepStmt.setString(1, item.id);
            prepStmt.executeUpdate();

            ShowAlert("ოპერაცია წარმატებულია", "ოპერაცია წარმატებულია", "მონაცემი წაიშალა",
                    AlertType.INFORMATION);

            buttonLoad.fire();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void buttonEditClicked(ActionEvent event) {
        UniItem item = tableItems.getSelectionModel().getSelectedItem();
        if (item == null) {
            ShowAlert("შეცდომა", "", "გთხოვთ მონიშნოთ ელემენტი სიიდან", AlertType.ERROR);
        }

        fieldName.setText(item.name);
        fieldAddress.setText(item.address);
        fieldEmail.setText(item.email);
        this.item = item;
        this.action = "UPDATE";
    }

    @FXML
    void buttonLoadClicked(ActionEvent event) {
        String url = "jdbc:mariadb://localhost:3306/university";
        Connection conn;
        tableItems.getItems().clear();

        try {
            conn = DriverManager.getConnection(url, "root", "");
            String query = "SELECT * from uni";
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String id = Integer.toString(rs.getInt("id"));
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");

                UniItem row = new UniItem();
                row.setId(id);
                row.setName(name);
                row.setAddress(address);
                row.setEmail(email);
                tableItems.getItems().add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
