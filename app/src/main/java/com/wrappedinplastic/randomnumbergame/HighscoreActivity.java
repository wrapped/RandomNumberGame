package com.wrappedinplastic.randomnumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HighscoreActivity extends AppCompatActivity {

    Button btnPlayAgain;
    TextView txtCurrentScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        btnPlayAgain = findViewById(R.id.btnPlayAgain);
        txtCurrentScore = findViewById(R.id.txtCurrentScore);

        int score = getIntent().getIntExtra("SCORE", 0);
        txtCurrentScore.setText(String.valueOf(score));


    }

    public void playGame(View view){

        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        startActivity(intent);
        this.finish();
    }
}
