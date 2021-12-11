package com.example.ikeak.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard mTicTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);



        Button playAgainButton = findViewById(R.id.playagainButton);
        Button buttonHome = findViewById(R.id.homeButton);
        TextView playersTurn = findViewById(R.id.playersTurn);


        String [] playerNames = getIntent().getStringArrayExtra("USER_NAMES");
        mTicTacToeBoard = findViewById(R.id.ticTacToeBoard);
        mTicTacToeBoard.setUpGame(playAgainButton, buttonHome, playersTurn, playerNames);

        if(playerNames != null) {

            playersTurn.setText((playerNames[0] + "'s Turn"));
        }

        playAgainButton.setVisibility(View.GONE);
        buttonHome.setVisibility(View.GONE);
    }

    public void playAgainButton(View view) {

        mTicTacToeBoard.resetGame();
        //update the display of the tictactoeboard
        //Generally, invalidate() means 'redraw on screen' and results to a call of the view's onDraw() method.
        // So if something changes and it needs to be reflected on screen, you need to call invalidate()
        mTicTacToeBoard.invalidate();
    }

    public void homeButton(View view) {

        Intent intent = new Intent(GameDisplay.this, MainActivity.class);
        startActivity(intent);
    }
}
