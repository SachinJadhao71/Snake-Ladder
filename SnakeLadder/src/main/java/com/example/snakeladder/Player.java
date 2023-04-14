package com.example.snakeladder;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
   private Circle coins;
    private int currentPosition;
    private String name;

    private static Board gameBoard = new Board();

    Player(int tilesize , Color coinColor, String palyerName){
        coins = new Circle(tilesize/2);
        coins.setFill(coinColor);
        currentPosition = 0;
        movePlayer(1);
        name = palyerName;
    }
    public void movePlayer(int diceValue){
        if(currentPosition + diceValue <= 100){
            currentPosition+=diceValue;

            TranslateTransition secondMove = null, firstMove = translateAnimation(diceValue);



            int newPosition = gameBoard.getNewPosition(currentPosition);

            if(newPosition != currentPosition && newPosition != -1){
                currentPosition = newPosition;
                secondMove = translateAnimation(6);
            }
            if(secondMove == null){
                firstMove.play();
            }
            else{
                SequentialTransition sequentialTransition = new SequentialTransition(firstMove,
                        new PauseTransition(Duration.millis(1000)), secondMove );

                sequentialTransition.play();
            }
        }


//        int x= gameBoard.getXCordinate(currentPosition);
//        int y = gameBoard.getYCordinate(currentPosition);
//        coins.setTranslateX(x);
//        coins.setTranslateY(y);


    }
    private TranslateTransition translateAnimation(int diceValue){
        TranslateTransition animate = new TranslateTransition(Duration.millis(200*diceValue),coins);
        animate.setToX(gameBoard.getXCordinate(currentPosition));
        animate.setToY(gameBoard.getYCordinate(currentPosition));
        animate.setAutoReverse(false);
        return animate;
    }

    public void startingPosition(){
        currentPosition=0;
        movePlayer(1);
    }

    boolean isWinner(){
        if(currentPosition==100){
            return true;
        }
        return false;
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
