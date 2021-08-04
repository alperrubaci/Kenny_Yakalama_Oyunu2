package com.alper.sqlitekaydetvesirala;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    DatabaseHelper dt= new DatabaseHelper(this);

    TextView scoreText;
    TextView timeText;
    int score ;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //İnitialize

        timeText = findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);
        imageView = findViewById(R.id.imageView);
        imageView2 =findViewById(R.id.imageView2);
        imageView3 =findViewById(R.id.imageView3);
        imageView4 =findViewById(R.id.imageView4);
        imageView5 =findViewById(R.id.imageView5);
        imageView6 =findViewById(R.id.imageView6);
        imageView7 =findViewById(R.id.imageView7);
        imageView8 =findViewById(R.id.imageView8);
        imageView9 =findViewById(R.id.imageView9);

        imageArray = new ImageView[]{
                imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9
        };

        hideImages();
        //increaseScore(scoreText);

        score = 0;
        Intent intent = getIntent();
        String data = intent.getStringExtra("name");

        new CountDownTimer(10000, 1000) {//10 saniye surer.Her saniyede ne yapayım

            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time : "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeText.setText("Time off");
                handler.removeCallbacks(runnable);
                for (ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(GameActivity.this);
                alert.setTitle("Restart?");
                alert.setMessage("Are you sure to resart game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //restart
                        Intent intent =getIntent();
                        finish();//guncel aktivite bitecek.Ayni aktivite bastan baslicak..

                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(GameActivity.this,"Game Over",Toast.LENGTH_LONG).show();

                        Intent intent = getIntent();
                        String data = intent.getStringExtra("name");
                        //String score = (scoreText.getText().toString());

                        OyuncularDao oyuncularDao = new OyuncularDao();
                        oyuncularDao.kisiEkle(dt,data,(score));

                        startActivity(new Intent(getApplicationContext(),SiralaActivity.class));
                        /*
                        Intent intent = new Intent(GameActivity.this,SiralaActivity.class);
                        String score = (String) scoreText.getText();
                        intent.putExtra("score",score);
                        startActivity(intent);
                        */

                    }
                });
                alert.show();
            }

        }.start();
    }

    public void increaseScore(View view) {
        score++;
        scoreText.setText("Score : "+ score);

    }

    public void hideImages(){

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }//hepsini saklar.
                Random random = new Random();
                int i =random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);
            }
        };

        handler.post(runnable);
    }
}