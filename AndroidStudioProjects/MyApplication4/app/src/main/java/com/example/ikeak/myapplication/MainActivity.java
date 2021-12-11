package com.example.ikeak.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText player1;
    EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1 = findViewById(R.id.player1Name1);
        player2 = findViewById(R.id.playerName2);


        }

        public void nextScreen(View view) {

            String player1Name = player1.getText().toString();
            String player2Name = player2.getText().toString();

            Intent intent = new Intent(MainActivity.this, GameDisplay.class);
            intent.putExtra("USER_NAMES", new String[] {player1Name, player2Name} );
        }
}
