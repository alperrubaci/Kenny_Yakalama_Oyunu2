package com.alper.sqlitekaydetvesirala;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class OyuncularDao {
    public void kisiEkle(DatabaseHelper vt,String name,int score){

        SQLiteDatabase dbx=vt.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put("name",name );
        values.put("score",score );


        dbx.insertOrThrow("oyuncular", null, values);
        dbx.close();
    }

    public ArrayList<Oyuncular> tumKisiler(DatabaseHelper vt){

        ArrayList<Oyuncular> oyuncularArrayList=new ArrayList<>();
        SQLiteDatabase dbx=vt.getWritableDatabase();
        Cursor cursor=dbx.rawQuery("SELECT * FROM oyuncular ORDER BY score DESC", null);

        while(cursor.moveToNext()){
            Oyuncular kisi = new Oyuncular(cursor.getInt(cursor.getColumnIndex("id")),cursor.getString(cursor.getColumnIndex("name")),cursor.getInt(cursor.getColumnIndex("score")));
            oyuncularArrayList.add(kisi);
        }
        return oyuncularArrayList;

    }

}
