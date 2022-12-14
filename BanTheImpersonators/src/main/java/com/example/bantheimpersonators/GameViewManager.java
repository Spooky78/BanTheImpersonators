package com.example.bantheimpersonators;

import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameViewManager {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static final int BACKGROUND_SIZE = 100;
    private static final String BACKGROUND_PATH = "background.png";
    private final FlowPane gamePane;
    private final Stage gameStage;
    private Stage menuStage;

    /**
     * Creates a main menu window.
     */
    public GameViewManager() throws FileNotFoundException {
        gamePane = new FlowPane();
        gamePane.setAlignment(Pos.BOTTOM_LEFT);
        Scene gameScene = new Scene(gamePane, WIDTH, HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);
        createBackground();
        createTileMap();
    }

    /**
     * Creates a new game.
     * @param stage The previous stage (usually menuStage).
     */
    public void createNewGame(Stage stage) {
        this.menuStage = stage;
        this.menuStage.hide();
        createBackground();
        gameStage.show();
    }

    private void createTileMap() throws FileNotFoundException {
        Level testLevel = new Level(0);
        //gamePane.setAlignment(Pos.BASELINE_LEFT);
        gamePane.getChildren().add(testLevel.getTilePane());
    }

    /**
     * Sets the background of the menu.
     */
    private void createBackground() {
        Image backgroundImage = new Image(BACKGROUND_PATH, WIDTH, HEIGHT, false, false);
        BackgroundImage background = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(BACKGROUND_SIZE, BACKGROUND_SIZE, true, true, true, true));
        gamePane.setBackground(new Background(background));
    }

    /**
     * Gets main stage.
     * @return The main stage.
     */
    public Stage getStage() {
        return gameStage;
    }
}
