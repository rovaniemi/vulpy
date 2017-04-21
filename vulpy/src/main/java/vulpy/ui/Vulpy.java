package vulpy.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Main-luokka joka tarjoaa ohjelman käynnistämisen ja pitää huolen UI:n pääikkunasta.
 */

public class Vulpy extends Application {

    Stage window;

    public static void main(String[] args) {
        try {
            URL iconURL  = Vulpy.class.getClassLoader().getResource("ui/logo.png");
            Image image = new ImageIcon(iconURL).getImage();
            com.apple.eawt.Application.getApplication().setDockIconImage(image);
        } catch (Exception e) {
            //This is for linux and windows
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox layout = new HBox();
        layout.setStyle("-fx-background-color: #FAFBFC;");

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #FAFBFC;");

        layout.getChildren().addAll(borderPane);

        Scene scene = new Scene(layout, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/vulpy.css").toExternalForm());

        Projects projects = new Projects();

        Menu menu = new Menu(primaryStage, borderPane, scene);

        borderPane.setPrefSize(800, 500);
        layout.getChildren().addAll(menu.getSidebar());
        window = menu.getWindow();
        window.setTitle("Vulpy");
        window.setScene(menu.getScene());
        window.setResizable(false);
        window.show();
    }

}
