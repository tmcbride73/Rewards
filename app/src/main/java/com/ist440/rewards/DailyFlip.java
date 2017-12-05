package com.ist440.rewards;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class DailyFlip extends AppCompatActivity {

    int coinSide; //0 = Heads, 1 = Tails
    Random r = new Random(); // Random value

    private ImageView iv_coin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_flip);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button flip_coin = (Button) findViewById(R.id.flip_coin);

        //COIN

        iv_coin = (ImageView) findViewById(R.id.iv_coin);

        flip_coin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Coin Flipped", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                coinSide = r.nextInt(2);

                if(coinSide == 0)
                {
                    iv_coin.setImageResource(R.drawable.heads);
                }
                else
                {
                    iv_coin.setImageResource(R.drawable.tails);
                }

                RotateAnimation rotate = new RotateAnimation(0, 360,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(1000);
                iv_coin.startAnimation(rotate);
            }
        });

        // CLOSE COIN
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
