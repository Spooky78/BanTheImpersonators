package com.example.bantheimpersonators;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

public class Level {
    private static final String tileset1 = "tileset1.png";
    private static final String tileset2 = "tileset2.png";
    private static final String tileset3 = "tileset3.png";
    private static final String tileset6 = "tileset6.png";
    private static ArrayList<Integer> levelMap = new ArrayList<>();
    private ArrayList<String> levelTileMap = new ArrayList<>();
    private static int currentLevel;
    private HBox tilePane = new HBox();

    public Level(int level) throws FileNotFoundException {
        currentLevel = level;
        File levelFile = new File("BanTheImpersonators/src/main/resources/LEVEL00.txt");
        Scanner levelFileReader = new Scanner(levelFile);
        readLineByLine(levelFileReader);
        createLevelMap();
    }

    private static void readLineByLine(Scanner in) {
        while(in.hasNextLine()) {
            String scannerVariable = in.nextLine();
            String[] params = scannerVariable.split(" ");

            switch (params[0]) {
                case "1":
                    levelMap.add(1);
                    System.out.println(1);
                    break;
                case "2":
                    levelMap.add(2);
                    System.out.println(2);
                    break;
                case "3":
                    levelMap.add(3);
                    System.out.println(3);
                    break;
                case "6":
                    levelMap.add(6);
                    System.out.println(6);
                    break;
            }
        }
        in.close();
    }

    private void createLevelMap(){
        for (int i=0; i<levelMap.size(); i++){
            String currentTile = null;
            switch (levelMap.get(i)){
                case 1:
                    currentTile = tileset1;
                    break;
                case 2:
                    currentTile = tileset2;
                    break;
                case 3:
                    currentTile = tileset3;
                    break;
                case 6:
                    currentTile = tileset6;
                    break;
            }
            if (currentTile != null) {
                levelTileMap.add(currentTile);
            }
        }

        for (int i=0; i<levelTileMap.size(); i++){
            ImageView currentTile = new ImageView(levelTileMap.get(i));
            tilePane.getChildren().add(currentTile);
        }
    }

    public HBox getTilePane(){
        return tilePane;
    }
}
