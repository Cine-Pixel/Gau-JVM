import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    /*
     * ააგეთ JavaFX-ისა და JDBC-ის საშუალებით წიგნის მონაცემების (წიგნის დასახელება,
     * ავტორი, წიგნის გამოშვების თარიღი, ფასი) მონაცემთა ბაზაში ჩაწერის და ბაზიდან
     * მონაცემების გამოტანის შესაბამისი პროგრამული მოდული.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("BooksScene.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Books");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}