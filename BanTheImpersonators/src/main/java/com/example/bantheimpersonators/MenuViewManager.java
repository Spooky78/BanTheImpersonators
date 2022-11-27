package com.example.bantheimpersonators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MenuViewManager {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static final int SPACING = 50;
    private static final int PADDING = 30;
    private static final int TITLE_FONT_SIZE = 90;
    private static final int BACKGROUND_SIZE = 100;
    private static final String BACKGROUND_PATH = "background.png";
    private static final String FONT_PATH;
    static {
        try {
            FONT_PATH = String.valueOf(new File(ClassLoader.getSystemResource(
                "Hacked.ttf").toURI()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private final VBox menuPane;
    private final Stage menuStage;
    /**
     * Creates a main menu window.
     */
    public MenuViewManager() {
        menuPane = new VBox();
        Scene menuScene = new Scene(menuPane, WIDTH, HEIGHT);
        menuStage = new Stage();
        menuStage.setScene(menuScene);
        menuPane.setAlignment(Pos.TOP_CENTER);
        menuPane.setPadding(new Insets(PADDING));
        menuPane.setSpacing(SPACING);
        createBackground();
        createTitle();
        createStartButton();
        createHelpButton();
        createExitButton();
    }

    /**
     * Creates the title of the game.
     */
    private void createTitle() {
        Text title = new Text("BAN THE IMPERSONATORS!");
        title.setFill(Color.WHITE);
        try {
            title.setFont(Font.loadFont(new FileInputStream(FONT_PATH), TITLE_FONT_SIZE));
        } catch (FileNotFoundException e) {
            title.setFont(Font.font("Verdana", TITLE_FONT_SIZE));
        }
        menuPane.getChildren().add(title);
    }

    /**
     * Creates the start button.
     */
    private void createStartButton() {
        MenuButton startButton = new MenuButton("START");
        menuPane.getChildren().add(startButton);
    }

    /**
     * Creates the help button.
     */
    private void createHelpButton() {
        MenuButton helpButton = new MenuButton("Help");
        menuPane.getChildren().add(helpButton);
        //helpButton.setOnAction(actionEvent -> );
    }

    /**
     * Creates the exit button, that exits the application.
     */
    private void createExitButton() {
        MenuButton exitButton = new MenuButton("Exit");
        menuPane.getChildren().add(exitButton);
        exitButton.setOnAction(actionEvent -> menuStage.close());
    }

    /**
     * Sets the background of the menu.
     */
    private void createBackground() {
        Image backgroundImage = new Image(BACKGROUND_PATH, WIDTH, HEIGHT, false, false);
        BackgroundImage background = new BackgroundImage(backgroundImage,
            BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(BACKGROUND_SIZE, BACKGROUND_SIZE, true, true, true, true));
        menuPane.setBackground(new Background(background));
    }

    /**
     * Gets main stage.
     * @return The main stage.
     */
    public Stage getMainStage() {
        return menuStage;
    }
}
