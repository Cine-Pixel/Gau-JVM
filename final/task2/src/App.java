import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    /*
     * მარტივი თამაში რულეტკა JavaFX-ში: თამაშის დაწყებამდე მოთამაშეს აქვს თანხა 100
     * ლარი, რულეტკის დატრიალების შემდეგ გამოდის 5x4 გრაფა, რომელშიდაც
     * შემთხვევითად გამოტანილია ციფრები მოთამაშის იგებს 5 ლარს იმ შემთხვევაში თუ
     * გრაფებში არსებული ციფრების ჯამი 100-ზე მეტია და აგებს 10 ლარს თუ ჯამი 100-ზე
     * ნაკლებია ან ტოლი. თანხის ყოველი ცვლილება აისახება რულეტკის დატრიალების
     * შემდეგ.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GridScene.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("უნივერსიტეტის ბაზა");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}