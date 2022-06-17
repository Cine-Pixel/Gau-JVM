import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;

public class GridController {
    @FXML
    private GridPane board;

    @FXML
    private Button buttonRoll;

    @FXML
    private Label labelMoney;

    private int money = 100;
    private int[][] boardNumbers = new int[5][4];

    private void refillNumbers() {
        Random random = new Random();
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 4; c++) {
                int number = random.nextInt(0, 12);
                boardNumbers[r][c] = number;
            }
        }
    }

    private void checkScore() {
        int sum = 0;
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 4; c++) {
                sum += boardNumbers[r][c];
            }
        }
        if (sum > 100) {
            this.money += 5;
        } else {
            this.money -= 10;
        }
        labelMoney.setText("თანხა: " + Integer.toString(this.money));

        if (this.money < 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("თქვენ წააგეთ");
            alert.setHeaderText("");
            alert.setContentText("თქვენ აღარ გაქვთ თანხა");
            alert.show();
        }
    }

    @FXML
    void buttonRollClicked(ActionEvent event) {
        board.getChildren().clear();
        board.setPadding(new Insets(10));
        board.setHgap(1);
        board.setVgap(1);

        refillNumbers();

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 4; c++) {
                Button button = new Button(String.valueOf(boardNumbers[r][c]));
                button.setMinHeight(50);
                button.setMinWidth(100);
                board.add(button, c, r);
            }
        }

        checkScore();
    }

}
