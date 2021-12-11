package com.example.ikeak.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {


    private int [][] gameBoard;
    //We need to set the getters and the setters to alternate between the
    //x's and O's
    private int player = 1;

    private String [] playerNames = {"Player1", "Player2"};
    private Button playAgainBTN;
    private Button homeBTN;
    private TextView playerTurn;


    GameLogic() {

        gameBoard = new int[3][3];

        for(int r = 0; r < 3; r++) {
            for(int c =0; c < 3; c++){

                gameBoard[r][c] = 0;
            }
        }
    }

    public boolean winnerCheck() {

        //find out if we have a winner
        //Return true if there was a winner
        //return false if there wasn't

        Boolean isWinner = false;

        for(int r = 0; r < 3; r++) {

            if(gameBoard[r][0] == gameBoard[r][1] &&
                    gameBoard[r][0] == gameBoard[r][2]&& gameBoard[r][0] != 0) {

                isWinner = true;
            }

        }

        for (int c = 0; c < 3; c++) {

            if(gameBoard[0][c] == gameBoard[1][c] && gameBoard[0][c] ==
                    gameBoard[2][c]&& gameBoard[c][0] != 0) {

                isWinner = true;
            }
        }

        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] ==
                gameBoard[2][2] && gameBoard[0][0] != 0) {

            isWinner = true;
        }

        if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[2][0] ==
                gameBoard[0][2] && gameBoard[2][2] != 0) {

            isWinner = true;
        }


        int boardFilled = 0;

        for(int r=0; r<3; r++) {

            for(int c=0; c<3; c++) {

                if(gameBoard[r][c] != 0) {

                    boardFilled += 1;
                }
            }
        }

        if(isWinner) {

            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText((playerNames[player - 1] + " Won!!"));
            return true;

        }

        else if(boardFilled == 9) {

            playAgainBTN.setVisibility(View.VISIBLE);
            homeBTN.setVisibility(View.VISIBLE);
            playerTurn.setText("Tied Game");
            return true;

        }

        else {

            return false;
        }
    }


    public void resetGame() {

        gameBoard = new int [3][3];

        for(int r = 0; r < 3; r++) {

            for(int c=0; c<3; c++) {

                gameBoard[r][c] = 0;
            }
        }

    }


    public void setPlayAgainBTN(Button playAgainBTN) {
        this.playAgainBTN = playAgainBTN;

    }

    public void setHomeBTN(Button homeBTN) {

        this.homeBTN = homeBTN;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;

    }

    public void setPlayerNames(String[] names) {
        this.playerNames = names;

    }


    //we are creating a getter for our Gamelogic to get it over to the tic tac toe class

    public boolean updateGameBoard(int row, int col) {

        //See if the row and column clicked in the ontouchevent method is actually
        //available in the gameboard
        //
        if(gameBoard[row - 1][col -1] == 0) {

            //assign the player value 1 or 2 or draw X / draw O in the tictactoeboard
            //class
            gameBoard[row - 1][col - 1] = player;

            if(player == 1) {

                playerTurn.setText((playerNames[1] + "'s Turn"));
            } else {

                playerTurn.setText((playerNames[0] + "'s Turn"));
            }

            return true;
        }

        else{

            return false;
        }
    }


    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setPlayer(int player) {
        this.player = player;

    }

    public int getPlayer() {
        return player;
    }
}
