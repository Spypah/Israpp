package com.example.israpp;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String DICTIONARY = "DICTIONARY";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_WORD = "WORD";
    public static final String COLUMN_READING = "READING";
    public static final String COLUMN_MEANING = "MEANING";
    public static final String COLUMN_CATEGORY = "CATEGORY";
    public static final String COLUMN_SHOWED = "SHOWED";



    public DataBaseHelper(@Nullable Context context) {
        super(context, "dictionary.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + DICTIONARY +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " " +  COLUMN_WORD + " TEXT NOT NULL," +
                " " + COLUMN_READING + " TEXT NOT NULL," +
                " " + COLUMN_MEANING + " TEXT NOT NULL," +
                " " + COLUMN_CATEGORY + " TEXT NOT NULL," +
                " " + COLUMN_SHOWED + " INTEGER NOT NULL)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }



    public boolean addW(WordModel wordModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_WORD, wordModel.getWord());
        cv.put(COLUMN_READING, wordModel.getReading());
        cv.put(COLUMN_MEANING, wordModel.getMeaning());
        cv.put(COLUMN_CATEGORY, wordModel.getCategory());
        cv.put(COLUMN_SHOWED, wordModel.getShowed());

        long insert = db.insert(DICTIONARY, null, cv);

        if(insert == -1 ){
            return false;
        }else{
            return true;
        }

    }
}
