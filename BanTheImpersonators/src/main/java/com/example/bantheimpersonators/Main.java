package com.example.bantheimpersonators;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        MenuViewManager manager = new MenuViewManager();
        primaryStage = manager.getMainStage();
        primaryStage.show();
    }

    /**
     * Entry to main method.
     * @param args command-line arguments array.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
