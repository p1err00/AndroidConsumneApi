package com.example.applicoursandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Game.db";
    public static final String TABLE_NAME = "Game";
    public static final String COLUMN_ID = "GameID";
    public static final String COLUMN_NAME = "GameName";

    public MyDBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID +
                "INTEGER PRIMARYKEY" +COLUMN_NAME + "TEXT )";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String loadHandler(){
        String result = "";
        String query = " SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    public void addHandler(Game game){

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, game.getId());
        values.put(COLUMN_NAME, game.getGameName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Game findGame(String gameName){

        String query = "SELECT * FROM " +TABLE_NAME + "WHERE" + COLUMN_NAME + " = " + "'" + gameName + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Game game = new Game();
        if(cursor.moveToNext()){
            cursor.moveToFirst();
            game.setId(Integer.parseInt(cursor.getString(0)));
            game.setGameName(cursor.getString(1));
            cursor.close();
        } else {
            game = null;
        }
        db.close();
        return game;
    }

    public boolean deleteHandler(int ID){
        boolean result = false;
        String query = "SELECT * FROM " + TABLE_NAME +" WHERE "+ COLUMN_ID + " = '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Game game = new Game();

        if(cursor.moveToFirst()){
            game.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_NAME, COLUMN_ID + "=?",
                    new String[] {
                            String.valueOf(game.getId())
            });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public int updateHandler(int ID, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, ID);
        args.put(COLUMN_NAME, name);
        int gt;
        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + ID, null);
    }


}
