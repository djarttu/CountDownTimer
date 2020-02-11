package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Timer;

public class TimerActivity extends AppCompatActivity {
    int i;
    ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_timer);
        Intent intent = getIntent();
        String aika = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        final TextView text = findViewById(R.id.timeField);
        text.setText(aika);
        try{
            i = Integer.parseInt(aika.trim());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        new CountDownTimer(i * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                i = i - 1;
                text.setText(String.valueOf(i));
                if(i>0)
                    toneGen1.startTone(ToneGenerator.TONE_CDMA_HIGH_L,50);
                if(i==0)
                    toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,150);


            }

            @Override
            public void onFinish() {

                TimerActivity.this.finish();
            }

        }.start();

    }
}
