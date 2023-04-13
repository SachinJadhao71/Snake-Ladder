package com.example.snakeladder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeAndLadder extends Application {
    public static final int tilesize=40, width=10, height=10;
    public static final int buttonLine = tilesize*height + 50, infoLine = buttonLine-30;

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
       playerTwoButton.setTranslateY(buttonLine);
       playerTwoButton.setTranslateX(300);
       startButton.setTranslateY(buttonLine);
       startButton.setTranslateX(180);

       Label playerOneLable = new Label("Your Turn !");
       Label palyerTwoLabel = new Label("Your Turn !");
       Label startButtonLable = new Label("Start");


       playerOneLable.setTranslateY(infoLine);
       playerOneLable.setTranslateX(20);
       palyerTwoLabel.setTranslateY(infoLine);
       palyerTwoLabel.setTranslateX(300);
       startButtonLable.setTranslateY(infoLine);
       startButtonLable.setTranslateX(180);




       root.getChildren().addAll(board,playerOneButton,playerTwoButton,startButton,playerOneLable,palyerTwoLabel,startButtonLable);
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