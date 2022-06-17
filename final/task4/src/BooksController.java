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

public class BooksController implements Initializable {
    @FXML
    private TableView<Book> tableItems;

    @FXML
    private TableColumn<Book, String> colAuthor;

    @FXML
    private TableColumn<Book, String> colDate;

    @FXML
    private TableColumn<Book, String> colId;

    @FXML
    private TableColumn<Book, String> colName;

    @FXML
    private TableColumn<Book, String> colPrice;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button buttonLoad;

    @FXML
    private Button buttonSave;

    @FXML
    private TextField fieldAuthor;

    @FXML
    private TextField fieldDate;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldPrice;

    private String action = "ADD";
    private Book book;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private void ClearForm() {
        fieldName.setText("");
        fieldAuthor.setText("");
        fieldDate.setText("");
        fieldPrice.setText("");
    }

    @FXML
    void buttonDeleteClicked(ActionEvent event) {
        Book item = tableItems.getSelectionModel().getSelectedItem();
        if (item == null) {
            ShowAlert("შეცდომა", "", "გთხოვთ მონიშნოთ ელემენტი სიიდან", AlertType.ERROR);
        }

        String url = "jdbc:mariadb://localhost:3306/library";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM books WHERE id = ?");
            prepStmt.setString(1, item.id);
            prepStmt.executeUpdate();

            ShowAlert("ოპერაცია წარმატებულია", "ოპერაცია წარმატებულია", "წიგნი წაიშალა",
                    AlertType.INFORMATION);

            buttonLoad.fire();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void buttonEditClicked(ActionEvent event) {
        Book item = tableItems.getSelectionModel().getSelectedItem();
        if (item == null) {
            ShowAlert("შეცდომა", "", "გთხოვთ მონიშნოთ წიგნი სიიდან", AlertType.ERROR);
        }

        fieldName.setText(item.name);
        fieldAuthor.setText(item.author);
        fieldDate.setText(item.releaseDate);
        fieldPrice.setText(item.price);
        this.book = item;
        this.action = "UPDATE";
    }

    @FXML
    void buttonLoadClicked(ActionEvent event) {
        String url = "jdbc:mariadb://localhost:3306/library";
        Connection conn;
        tableItems.getItems().clear();

        try {
            conn = DriverManager.getConnection(url, "root", "");
            String query = "SELECT * from books";
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String id = Integer.toString(rs.getInt("id"));
                String name = rs.getString("name");
                String author = rs.getString("author");
                String date = rs.getDate("release_date").toString();
                String price = rs.getBigDecimal("price").toString();

                Book row = new Book();
                row.setId(id);
                row.setName(name);
                row.setAuthor(author);
                row.setReleaseDate(date);
                row.setPrice(price);
                tableItems.getItems().add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void buttonSaveClicked(ActionEvent event) {
        String url = "jdbc:mariadb://localhost:3306/library";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement prepStmt;
            if (this.action == "ADD") {
                prepStmt = conn
                        .prepareStatement("INSERT INTO books(name, author, release_date, price) VALUES(?, ?, ?, ?)");
            } else {
                prepStmt = conn
                        .prepareStatement(
                                "UPDATE books SET name = ?, author = ?, release_date = ?, price = ? WHERE id = ?");
                prepStmt.setString(5, book.id);
            }
            prepStmt.setString(1, fieldName.getText());
            prepStmt.setString(2, fieldAuthor.getText());
            prepStmt.setString(3, fieldDate.getText());
            prepStmt.setString(4, fieldPrice.getText());

            prepStmt.executeUpdate();

            ShowAlert("ოპერაცია წარმატებულია", "ოპერაცია წარმატებულია", "ოპერაცია წარმატებით შესრულდა",
                    AlertType.INFORMATION);

            this.book = null;
            this.action = "ADD";
            this.ClearForm();
            buttonLoad.fire();
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
