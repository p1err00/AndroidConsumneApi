package com.example.applicoursandroid;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class GameDataSource {

    private SQLiteDatabase database;
    private MyDBHandler dbHelper;
    private String[] allColumns = { MyDBHandler.COLUMN_ID,
            MyDBHandler.COLUMN_NAME };

    public GameDataSource(Context context){
        dbHelper = new MyDBHandler(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public Game createGame(String name){
        ContentValues values = new ContentValues();
        values.put(MyDBHandler.COLUMN_NAME, name);
        long insertId = database.insert(MyDBHandler.TABLE_NAME, null, values);
        Cursor cursor = database.query(MyDBHandler.TABLE_NAME, allColumns, MyDBHandler.COLUMN_ID + " = " + insertId, null,
        null, null, null);
        cursor.moveToFirst();
        Game newGame =cursorToGame(cursor);
        cursor.close();
        return newGame;
    }

    public void deleteGame(Game game){
        long id = game.getId();
        System.out.println("Game delete with id" + id);
        database.delete(MyDBHandler.TABLE_NAME, MyDBHandler.COLUMN_ID + " = " + id, null);
    }

    public List<Game> getAllGames(){
        List<Game> games = new ArrayList<Game>();

        Cursor cursor = database.query(MyDBHandler.TABLE_NAME, allColumns, null, null, null, null, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            Game game = cursorToGame(cursor);
            games.add(game);
            cursor.moveToNext();
        }
        cursor.close();
        return games;
    }

    private Game cursorToGame(Cursor cursor){
        Game game = new Game();
        game.setId((int) cursor.getLong(0));
        game.setGameName(cursor.getString(1));
        return game;

    }
}
