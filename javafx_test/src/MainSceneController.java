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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainSceneController implements Initializable {

    @FXML
    private Button buttonAdd;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    void buttonAddClicked(ActionEvent event) {
        String url = "jdbc:mariadb://localhost:3306/university";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO uni(name, address, email) VALUES(?, ?, ?)");
            prepStmt.setString(1, fieldName.getText());
            prepStmt.setString(2, fieldAddress.getText());
            prepStmt.setString(3, fieldEmail.getText());
            prepStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

                System.out.println(id);
                System.out.println(name);
                System.out.println(address);
                System.out.println(email);

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
