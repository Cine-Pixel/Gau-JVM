import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CalculatorSceneController {

    @FXML
    private Button buttonCalculate;

    @FXML
    private TextField fieldExpression;

    @FXML
    private Label labelAnswer;

    private void ShowAlert(String title, String header, String content, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

    @FXML
    void buttonCalculateClicked(ActionEvent event) {
        String expression = fieldExpression.getText();
        Calculator calculator = new Calculator(expression);
        try {
            Double result = calculator.Execute();
            labelAnswer.setText("პასუხი: " + result);
            fieldExpression.clear();
            FileOutputStream stream = new FileOutputStream("./calculator_results.txt", true);
            String a = Double.toString(result);
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
            String strin_result = timeStamp + " - " + a + "\n";
            stream.write(strin_result.getBytes());
            stream.close();
        } catch (NumberFormatException e) {
            ShowAlert(
                    "შეცდომა", "შეცდომა გამოსახულების ფორმატში",
                    "ყველა სიმბოლო (+, -, *, /, (, )) გამოყოფილი უნდა იყოს ცარიელი სივრცით. მაგ: 23 + 13 * ( 203 - 4 )",
                    AlertType.ERROR);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
