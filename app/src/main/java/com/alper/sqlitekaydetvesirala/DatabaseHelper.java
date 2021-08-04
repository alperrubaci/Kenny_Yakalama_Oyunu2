package com.alper.sqlitekaydetvesirala;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String veritabaniAdi = "rehber.db";

    public DatabaseHelper(Context context) {
        super(context, veritabaniAdi,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE oyuncular (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,score INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS oyuncular");

        onCreate(db);
    }
}
