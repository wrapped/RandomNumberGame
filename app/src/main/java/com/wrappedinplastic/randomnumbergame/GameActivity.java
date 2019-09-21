package com.wrappedinplastic.randomnumbergame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView txtMakeGuess, txtResult, txtCounter;
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
        txtCounter = findViewById(R.id.txtCounter);

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
                txtResult.setText("");
                AlertDialog.Builder popUp = new AlertDialog.Builder(this);
                popUp.setTitle("Correct!");
                popUp.setMessage("You guessed the right number!" + "\n" + "You guessed " + guessCount + " times." + "\n" + "The correct number was " + random + ".");
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
                txtGuess.setText("");
                txtResult.setText(value + " is too low!");
                guessCount++;
                txtCounter.setText("Guess #" + String.valueOf(guessCount));
            } else if (guessInt > random) {
                txtGuess.setText("");
                txtResult.setText(value + " is too high!");
                guessCount++;
                txtCounter.setText("Guess #" + String.valueOf(guessCount));
            }
        }

    }
}
