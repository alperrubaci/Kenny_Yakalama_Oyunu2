package com.alper.sqlitekaydetvesirala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView txt1,txt2;
    Button button,sirala;
    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    txt1 = findViewById(R.id.editText);
    //txt2 = findViewById(R.id.editText1);
    button = findViewById(R.id.button);
    sirala = findViewById(R.id.buttonSirala);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this,GameActivity.class);
            intent.putExtra("name",txt1.getText().toString());
            startActivity(intent);
            /*
          OyuncularDao oyuncularDao = new OyuncularDao();
          oyuncularDao.kisiEkle(db,txt1.getText().toString(),(txt2.getText().toString()));
          */
        }
    });

    /*
    sirala.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),GameActivity.class));
        }
    });*/




    }
}