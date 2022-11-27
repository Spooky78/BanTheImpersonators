package com.example.bantheimpersonators;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
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
