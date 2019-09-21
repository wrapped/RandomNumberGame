package com.wrappedinplastic.randomnumbergame;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
    }

    public void playGame(View view){

        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        startActivity(intent);
    }

}
