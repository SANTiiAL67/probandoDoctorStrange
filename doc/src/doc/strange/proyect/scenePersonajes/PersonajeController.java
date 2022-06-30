package doc.strange.proyect.scenePersonajes;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class PersonajeController implements Initializable {

    @FXML
    private Label stats;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Font font = Font.loadFont("file:C:\\Users\\adama\\Desktop\\doc\\src\\doc\\strange\\proyect\\resources\\css\\HoustonComicsPersonalUse-6Yea1.ttf", 48);
        stats.setFont(font);

    }

}
