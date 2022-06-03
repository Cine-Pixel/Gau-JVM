import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class StringGeneratorSceneController {

    @FXML
    private Button buttonGenerate;

    @FXML
    private TextField fieldCharacters;

    @FXML
    private TextField fieldNumOfWords;

    @FXML
    private TextArea textResult;

    @FXML
    void buttonGenerateClicked(ActionEvent event) {
        char[] alphabet = fieldCharacters.getText().toCharArray();
        int num_of_words = Integer.parseInt(fieldNumOfWords.getText());
        Random random = new Random();

        StringBuilder generated_string = new StringBuilder();

        for (int i = 0; i < num_of_words; i++) {
            int word_length = random.nextInt(1, 20);
            for (int j = 0; j < word_length; j++) {
                generated_string.append(alphabet[random.nextInt(0, alphabet.length)]);
            }
            generated_string.append(" ");
        }

        textResult.setText(generated_string.toString());
    }

}
