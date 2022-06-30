package doc.strange.proyect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth() -80;
        int height = gd.getDisplayMode().getHeight()-80;
        Image image = new Image("doc/strange/proyect/resources/img/ico.png");
        Parent root = FXMLLoader.load(getClass().getResource("/doc/strange/proyect/sceneVideo/media-view.fxml"));
        Scene scene = new Scene(root,width,height);
        stage.getIcons().add(new Image("https://cdn6.aptoide.com/imgs/7/1/9/7193e8b89af7d5650baa68bc75a64538_icon.png"));
        stage.setScene(scene);
        stage.setTitle("Doctor Strange");
        scene.setCursor(new ImageCursor(image));
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setFullScreenExitHint("");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
