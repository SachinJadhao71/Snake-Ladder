package com.example.snakeladder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeAndLadder extends Application {
    public static final int tilesize=40, width=10, height=10;

   private Pane createContent(){
       Pane root = new Pane();
       root.setPrefSize(width*tilesize, height*tilesize + 50);

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

       root.getChildren().add(board);
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