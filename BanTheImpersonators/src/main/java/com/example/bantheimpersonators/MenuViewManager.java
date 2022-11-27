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
    private static final int HEIGHT = 800;
    private static final String BACKGROUND_PATH = "background.png";
    private final String fontPath;
    {
        try {
            fontPath = String.valueOf(new File(ClassLoader.getSystemResource(
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
        menuPane.setPadding(new Insets(30));
        menuPane.setSpacing(50);
        createBackground();
        createTitle();
    }

    private void createTitle(){
        Text title = new Text("BAN THE IMPERSONATORS!");
        title.setFill(Color.WHITE);
        try {
            title.setFont(Font.loadFont(new FileInputStream(fontPath), 90));
        } catch (FileNotFoundException e) {
            title.setFont(Font.font("Verdana", 90));
        }
        menuPane.getChildren().add(title);
    }

    private void createBackground(){
        Image backgroundImage = new Image(BACKGROUND_PATH, WIDTH, HEIGHT, false, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(100, 100,
            true, true, true, true));
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
