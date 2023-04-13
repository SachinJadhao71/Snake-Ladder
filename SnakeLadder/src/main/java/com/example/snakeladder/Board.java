package com.example.snakeladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>> positionCoordinate;

    public Board(){
        positionCoordinate = new ArrayList<>();
        populatePositionCoordinate();
    }

    private void populatePositionCoordinate(){
        positionCoordinate.add(new Pair<>(0,0));

        for (int i = 0; i < SnakeAndLadder.height; i++) {
            for (int j = 0; j < SnakeAndLadder.width; j++) {
                int xCord= 0;
                if(i%2==0){
                    xCord = j*SnakeAndLadder.tilesize + SnakeAndLadder.tilesize/2;
                }
                else{
                    xCord = SnakeAndLadder.tilesize * SnakeAndLadder.height - (j*SnakeAndLadder.tilesize) - SnakeAndLadder.tilesize/2;

                }
                int yCord = SnakeAndLadder.tilesize * SnakeAndLadder.height - (i*SnakeAndLadder.tilesize) - SnakeAndLadder.tilesize/2;
                positionCoordinate.add(new Pair<>(xCord,yCord));
            }
        }
    }
    int getXCordinate(int position){
        if(position >=1 && position <= 100){
           return positionCoordinate.get(position).getKey();
        }
        else{
            return -1;
        }
    }

    int getYCordinate(int position){
        if(position >=1 && position <= 100){
            return positionCoordinate.get(position).getValue();
        }
        else{
            return -1;
        }
    }

//    public static void main(String[] args) {
//        Board board = new Board();
//
//        for (int i = 0; i < board.positionCoordinate.size(); i++) {
//            System.out.println(i + " $ x :" +  board.positionCoordinate.get(i).getKey()
//            + " y : " + board.positionCoordinate.get(i).getValue()
//            );
//        }
//    }
}
