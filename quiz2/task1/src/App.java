import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    /*
     * პროგრამა აგენერირებს შემთხვევით სტრიქონს. მომხარებელს შეუძლია შეარჩიოს
     * შემთხვევითი
     * სტრიქონისთვის ანბანი, სტრიქონში სიტყვების რაოდენობა. გამოიტანეთ შემთხვევითი
     * სტრიქონი.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StringGeneratorScene.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("String Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
