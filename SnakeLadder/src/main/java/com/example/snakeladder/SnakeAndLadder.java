package com.example.snakeladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeAndLadder extends Application {
    public static final int tilesize=40, width=10, height=10;
    public static final int buttonLine = tilesize*height + 50, infoLine = buttonLine-30;
    private static Dice dice = new Dice();
    private Player playerOne,playerTwo;

    private boolean gameStarted = false, playerOneTurn = false, playerTwoTurn = false;

   private Pane createContent(){
       Pane root = new Pane();
       root.setPrefSize(width*tilesize, height*tilesize + 100);

       for (int i = 0; i < height; i++) {
           for (int j = 0; j < width; j++) {
               Tile tile = new Tile(tilesize);
               tile.setTranslateX(j*tilesize);
               tile.setTranslateY(i*tilesize);
               root.getChildren().add(tile);
           }
       }

       Image img = new Image("C:\\Users\\jadha\\IdeaProjects\\SnakeLadder\\src\\main\\board snake ladder.jpg");
       ImageView board = new ImageView();
       board.setImage(img);
       board.setFitHeight(height*tilesize);
       board.setFitWidth(width*tilesize);

       Button playerOneButton = new Button("Player One");
       Button playerTwoButton = new Button("Player Two");
       Button startButton = new Button("Start");

       playerOneButton.setTranslateY(buttonLine);
       playerOneButton.setTranslateX(20);
       playerOneButton.setDisable(true);
       playerTwoButton.setTranslateY(buttonLine);
       playerTwoButton.setTranslateX(300);
       playerTwoButton.setDisable(true);
       startButton.setTranslateY(buttonLine);
       startButton.setTranslateX(180);

       Label playerOneLable = new Label("");
       Label palyerTwoLabel = new Label("");
       Label diceLabel = new Label("Start");


       playerOneLable.setTranslateY(infoLine);
       playerOneLable.setTranslateX(20);
       palyerTwoLabel.setTranslateY(infoLine);
       palyerTwoLabel.setTranslateX(300);
       diceLabel.setTranslateY(infoLine);
       diceLabel.setTranslateX(180);

       playerOne = new Player(tilesize, Color.BLACK , "Amit");
       playerTwo = new Player(tilesize-5, Color.WHITE, "Sachin");


       playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
               if(gameStarted) {
                   if (playerOneTurn) {
                       int diceValue = dice.getRolledDicevalue();

                       diceLabel.setText("Dice Value : " + diceValue);
                       playerOne.movePlayer(diceValue);
//                       winning condition
                       if(playerOne.isWinner()){
                           diceLabel.setText("The Winner Is : " + playerOne.getName());
                           playerOneTurn = false;
                           playerOneButton.setDisable(true);
                           playerOneLable.setText("");

                           playerTwoTurn = true;
                           playerTwoButton.setDisable(true);
                           palyerTwoLabel.setText("");

                           startButton.setDisable(false);
                           startButton.setText("Restart Game");

                           gameStarted = false;
                       }
                       else{
                           playerOneTurn = false;
                           playerOneButton.setDisable(true);
                           playerOneLable.setText("");

                           playerTwoTurn = true;
                           playerTwoButton.setDisable(false);
                           palyerTwoLabel.setText("Your Turn " + playerTwo.getName());
                       }




                   }
               }
           }
       });

       playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
               if(gameStarted) {
                   if (playerTwoTurn) {
                       int diceValue = dice.getRolledDicevalue();

                       diceLabel.setText("Dice Value : " + diceValue);
                       playerTwo.movePlayer(diceValue);

//                       winning condition
                       if(playerTwo.isWinner()){
                           diceLabel.setText("The Winner Is : " + playerTwo.getName());
                           playerOneTurn = false;
                           playerOneButton.setDisable(true);
                           playerOneLable.setText("");

                           playerTwoTurn = true;
                           playerTwoButton.setDisable(true);
                           palyerTwoLabel.setText("");

                           startButton.setDisable(false);
                           startButton.setText("Restart Game");
                       }
                       else{
                           playerOneTurn = true;
                           playerOneButton.setDisable(false);
                           playerOneLable.setText("Your Turn " + playerOne.getName());

                           playerTwoTurn = false;
                           playerTwoButton.setDisable(true);
                           palyerTwoLabel.setText("");
                       }



                   }
               }
           }
       });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted =true;
                diceLabel.setText("Game Started");

                startButton.setDisable(true);

                playerOneTurn = true;

                playerOneLable.setText("Your Turn " + playerOne.getName());

                playerOneButton.setDisable(false);
                playerOne.startingPosition();

                playerTwoTurn = false;
                palyerTwoLabel.setText("");

                playerTwoButton.setDisable(true);
                playerTwo.startingPosition();
            }
        });


       root.getChildren().addAll(board,playerOneButton,playerTwoButton,startButton,
               playerOneLable,palyerTwoLabel,diceLabel, playerOne.getCoins(), playerTwo.getCoins()
       );
       return root;
   }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}