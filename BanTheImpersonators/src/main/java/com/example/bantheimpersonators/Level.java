package com.example.bantheimpersonators;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {
    private static final String tileset1 = "tileset1.png";
    private static final String tileset2 = "tileset2.png";
    private static final String tileset3 = "tileset3.png";
    private static final String tileset6 = "tileset6.png";
    private static ArrayList<Integer> levelMap = new ArrayList<>();
    private static int currentLevel;

    public Level(int level) throws FileNotFoundException {
        currentLevel = level;
        File levelFile = new File("BanTheImpersonators/src/main/resources/LEVEL00.txt");
        Scanner levelFileReader = new Scanner(levelFile);
        readLineByLine(levelFileReader);
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

}
