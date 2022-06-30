package doc.strange.proyect.scene1;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class MainController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private BorderPane boderPane;
    @FXML
    private StackPane parentContainer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Font font = Font.loadFont("file:C:\\Users\\adama\\Desktop\\doc\\src\\doc\\strange\\proyect\\resources\\css\\HoustonComicsPersonalUse-6Yea1.ttf", 18);
        button.setFont(font);
    }

    public void loadSecond(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/doc/strange/proyect/scene2/menu-view.fxml"));
        Scene scene = button.getScene();
        root.translateXProperty().set(scene.getHeight());
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.60), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(boderPane);
            button.setDisable(true);

        });
        timeline.play();
    }
}
