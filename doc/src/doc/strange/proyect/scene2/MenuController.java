package doc.strange.proyect.scene2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuController implements Initializable {

    @FXML
    private Button button , btn2,btn3;;
    @FXML
    private BorderPane container;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Font font = Font.loadFont("file:C:\\Users\\adama\\Desktop\\doc\\src\\doc\\strange\\proyect\\resources\\css\\HoustonComicsPersonalUse-6Yea1.ttf", 24);
        button.setFont(font);
        btn2.setFont(font);
        btn3.setFont(font);

    }
    @FXML
    private void loadThird(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/doc/strange/proyect/scenePersonajes/personaje-view.fxml"));
        Scene scene = button.getScene();
        root.translateXProperty().set(scene.getWidth());

        StackPane parentContainer = (StackPane) button.getScene().getRoot();
        parentContainer.getChildren().add(root);
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.60), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(t -> {
            parentContainer.getChildren().remove(container);
            button.setDisable(true);
        });
        timeline.play();
    }




}
