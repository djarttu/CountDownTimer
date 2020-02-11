package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "com.example.countdowntimer.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.startTimerButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, TimerActivity.class);
        String aika = getGivenTimeField();
        intent.putExtra(EXTRA_MESSAGE, aika);
        startActivity(intent);

    }
    private String getGivenTimeField(){
        EditText editor =findViewById(R.id.givenTimeField);
        String text = editor.getText().toString();
        editor.setText(null);
        return text;
    }

}
