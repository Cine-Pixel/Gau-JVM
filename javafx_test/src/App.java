import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// public class App extends Application {
//     @Override
//     public void start(Stage primaryStage) throws Exception {
//         Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
//         Scene scene = new Scene(root);

//         primaryStage.setTitle("Hello World!");
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator("2 * ( 5 + 3 )");
        System.out.println(calculator.Execute());
    }
}