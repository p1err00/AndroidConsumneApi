package com.example.applicoursandroid;

public class Game {

    private int gameID;
    private String gameName;

    //Constructor
    public Game(){

    }
    public Game(int id, String gameName){
        this.gameID = id;
        this.gameName = gameName;
    }

    //Properties
    public void setId(int id){
        this.gameID = id;
    }
    public int getId(){
        return this.gameID;
    }

    public void setGameName(String gameName){
        this.gameName = gameName;
    }
    public String getGameName(){
        return this.gameName;
    }

}
