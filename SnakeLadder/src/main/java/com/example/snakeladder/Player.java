package com.example.snakeladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player {
   private Circle coins;
    private int currentPosition;
    private String name;

    private static Board gameBoard = new Board();

    Player(int tilesize , Color coinColor, String palyerName){
        coins = new Circle(tilesize/2);
        coins.setFill(coinColor);
        currentPosition = 1;
        name = palyerName;
    }
    public void movePlayer(int diceValue){
        if(currentPosition + diceValue <= 100)
        currentPosition+=diceValue;

        int x= gameBoard.getXCordinate(currentPosition);
        int y = gameBoard.getYCordinate(currentPosition);


        coins.setTranslateX(x);
        coins.setTranslateY(y);
    }

    public Circle getCoins() {
        return coins;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }
}
