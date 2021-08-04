package com.alper.sqlitekaydetvesirala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SiralaActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Oyuncular> gamer;
    ListView liste;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sirala);

        //recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        liste = findViewById(R.id.listemiz);

        DatabaseHelper db =new DatabaseHelper(this);

        OyuncularDao oyuncularDao = new OyuncularDao();
        gamer = new ArrayList<>();
         gamer= oyuncularDao.tumKisiler(db);


        ArrayList<Integer> listScore = new ArrayList<>();
        ArrayList<String> listName = new ArrayList<>();

        for (int j = 0; j <gamer.size(); j++){
            listName.add(j,gamer.get(j).getName());
        }

         for (int i =0; i<gamer.size(); i++){
             listScore.add(i,gamer.get(i).getScore());
        }


        ArrayAdapter<Integer> madapter= new ArrayAdapter<Integer>(this,R.layout.satir_row,R.id.listMetin,listScore);
        liste.setAdapter(madapter);


         //myadapter myadapter = new myadapter(gamer);
         //recyclerView.setAdapter(myadapter);


    }
}