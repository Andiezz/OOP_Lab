package com.example.javafx_;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(Painter.class.getResource("Painter.fxml"));
//        fxmlLoader.setRoot(new AnchorPane());
//        Parent root = fxmlLoader.load();

//        Parent root = FXMLLoader.load(getClass().getClassLoader()
//                .getResource("Painter.fxml"));
                //.getResource("/com/example/javafx_/Painter.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(Painter.class.getResource("Painter.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        //Scene scene = new Scene(root);
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
