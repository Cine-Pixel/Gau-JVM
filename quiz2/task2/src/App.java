import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    /*
     * javaFx აპლიკაცია, რომელიც შეძლებს შეტანილი სტრიქონის ანალიზს და სწორი
     * მათემატიკური მოქმედებების შესრულებას, აპლიკაციას შეუძლია მხოლოდ მიმატება,
     * გამოკლება, გამრავლება, გაყოფის ოპერაციების წარმოება მხოლოდ ორ რიცხვზე.
     * მომხარებელს შეაქვს გამოსახულება, ღილაკზე დაჭერის შემდეგ ვიღებთ შესაბამის
     * პასუხს.
     * მაგალითად:
     * შეტანა: 2+32 აპლიკაცია დაწერს პასუხს 34,
     * შეტანა: 2343-32
     * აპლიკაცია დაწერს პასუხს 2311, პასუხებს პროგრამა ჩაწერს ფაილში ჩაწერის თარიღის
     * მითითებით.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CalculatorScene.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}