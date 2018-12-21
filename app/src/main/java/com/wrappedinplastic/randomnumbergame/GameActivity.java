package com.wrappedinplastic.randomnumbergame;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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

    public void guess(View view) {
        String value = txtGuess.getText().toString();
        int guessInt = Integer.parseInt(value);

        AlertDialog.Builder verify = new AlertDialog.Builder(this);

        if (guessInt > 100 || guessInt < 1) {
            verify.setTitle("Input error!");
            verify.setMessage("Please enter a number between 1 and 100");
            verify.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    txtGuess.setText("");
                }
            });
            verify.setCancelable(false);
            verify.show();
        } else {

            if (random == guessInt) {
                //txtResult.setText("Correct!");
                AlertDialog.Builder popUp = new AlertDialog.Builder(this);
                popUp.setTitle("Correct!");
                popUp.setMessage("You guessed the right number!" + "\n" + "It took you " + guessCount + " guesses." + "\n" + "The correct number was " + random + ".");
                popUp.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                popUp.setCancelable(false);
                popUp.show();

            } else if (guessInt < random) {
                txtResult.setText("Too low!");
                guessCount++;
                txtCounter.setText("Guess #" + String.valueOf(guessCount));
            } else if (guessInt > random) {
                txtResult.setText("Too high!");
                guessCount++;
                txtCounter.setText("Guess #" + String.valueOf(guessCount));
            }
        }

    }
}
