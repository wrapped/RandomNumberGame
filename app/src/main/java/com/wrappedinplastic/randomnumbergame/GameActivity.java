package com.wrappedinplastic.randomnumbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView txtMakeGuess, txtTesting, txtResult, txtCounter;
    EditText txtGuess;
    int guessCount = 0;
    int min = 0;
    int max = 100;
    int random = new Random().nextInt((max - min) + 1) + min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        txtMakeGuess = findViewById(R.id.txtMakeGuess);
        txtGuess = findViewById(R.id.txtGuess);
        txtResult = findViewById(R.id.txtResult);
        txtTesting = findViewById(R.id.txtTesting);
        txtCounter = findViewById(R.id.txtCounter);

        txtTesting.setText(String.valueOf(random));



    }

    public void guess(View view){
        String value = txtGuess.getText().toString();
        int guessInt = Integer.parseInt(value);
        if (random == guessInt){
            txtResult.setText("Correct");
        } else if (guessInt < random) {
            txtResult.setText("Too low!");
            guessCount++;
            txtCounter.setText(String.valueOf(guessCount));
        } else if (guessInt > random) {
            txtResult.setText("Too high!");
            guessCount++;
            txtCounter.setText(String.valueOf(guessCount));
        }

    }
}
