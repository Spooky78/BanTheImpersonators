package com.example.bantheimpersonators;

import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuViewManager {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 800;
    private final BorderPane menuPane;
    private final Scene menuScene;
    private final Stage menuStage;
    /**
     * Creates a main menu window.
     */
    public MenuViewManager() throws FileNotFoundException {
        menuPane = new BorderPane();
        menuScene = new Scene(menuPane, WIDTH, HEIGHT);
        menuStage = new Stage();
        menuStage.setScene(menuScene);
    }

    /**
     * Gets main stage.
     * @return The main stage.
     */
    public Stage getMainStage() {
        return menuStage;
    }
}
