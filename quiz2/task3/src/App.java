import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    /*
     * ააგეთ მონაცემთა ბაზა რომელშიდაც დაამატეთ ერთი ცხრილი, ცხრილში განსაზღვრეთ
     * უმაღლესი
     * საგანმანათლებლო დაწესებულების (უნივერსიტეტისთვის) საჭირო ველები თქვენი
     * შეხედულების შესაბამისად (მინიმუმ 4 ველი), ააგეთ ცხრილში მონაცემების ჩაწერის,
     * წაშლის და გამოტანის
     * შესაბამისი javaFx აპლიკაცია.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("უნივერსიტეტის ბაზა");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}