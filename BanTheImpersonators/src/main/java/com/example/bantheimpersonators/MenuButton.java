package com.example.bantheimpersonators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuButton extends Button {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 83;
    private static final int FONT_SIZE = 30;
    private static final String BACKGROUND_PATH = "button.png";
    private static final String FONT_PATH;
    static {
        try {
            FONT_PATH = String.valueOf(new File(ClassLoader.getSystemResource(
                "Hacked.ttf").toURI()));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a main menu button.
     * @param text the text that the button will display.
     */
    public MenuButton(String text) {
        setText(text);
        setPrefWidth(WIDTH);
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), FONT_SIZE));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", FONT_SIZE));
        }
        setButtonStyle();
        initializeButtonListener();
    }

    /**
     * Initializes button listeners. Listens for mouse events for button to be
     * pressed and released.
     */
    private void initializeButtonListener() {
        setOnMouseEntered(mouseEvent -> setEffect(new DropShadow()));
        setOnMouseExited(mouseEvent -> setEffect(null));
    }

    /**
     * Sets button released style.
     */
    private void setButtonStyle() {
        Image backgroundImage = new Image(BACKGROUND_PATH, WIDTH, HEIGHT, false, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(100, 100,
            true, true, true, true));
        setBackground(new Background(background));

        setTextFill(Color.WHITE);
        setPadding(new Insets(20));
    }
}
