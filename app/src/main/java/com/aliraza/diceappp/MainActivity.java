package com.aliraza.diceappp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView diceImage1 = findViewById(R.id.imgDice1);
        final ImageView diceImage2 = findViewById(R.id.imgDice2);
        final int [] diceImage = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
        Button btnRoll = findViewById(R.id.btnRollTheDice);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("DiceApp","my dice App");
                Random rnd = new Random();
                int myRandomNumer = rnd.nextInt(6);
                diceImage1.setImageResource(diceImage[myRandomNumer]);
                myRandomNumer = rnd.nextInt(6);
                diceImage2.setImageResource(diceImage[myRandomNumer]);
                YoYo.with(Techniques.RollIn)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice1));
                YoYo.with(Techniques.RollIn)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice2));
                mp.start();


            }
        });
    }
}