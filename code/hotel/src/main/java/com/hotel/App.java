package com.hotel;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        try {
            Image im = new Image(
                    "file:C:/Users/Samuel/Desktop/1\u00BADAW/Programaci\u00F3n/ProyectoHotel/ProyectoHotelv4/Proyecto Hotel v2/hotelBueno/hotel/src/main/resources/com/hotel/favicon_posible.png");

            double initialSceneWidth = 920;
            final double initialSceneHeight = 685;
            stage.setTitle("Samuel's Hotel");
            scene = new Scene(loadFXML("primary"), initialSceneWidth, initialSceneHeight);
            String css = this.getClass().getResource("style.css").toExternalForm();
            scene.getStylesheets().add(css);

            stage.getIcons().add(im);

            String css2 = getClass().getResource("datepicker.css").toExternalForm();
            scene.getStylesheets().add(css2);
            String css3 = this.getClass().getResource("alert.css").toExternalForm();
            scene.getStylesheets().add(css3);
            stage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}