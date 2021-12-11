package com.example.ikeak.myapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeBoard extends View {

    private final int boardColor;
    private final int Xcolor;
    private final int Ocolor;
    private final int winningLineColor;

    //Winning Line indicates that we have a winner
    private boolean winningLine = false;

    private final Paint paint = new Paint();
    //We need to know the size of the cells to know where to draw in the lines
    private int cellSize = getWidth() / 3;

    //Allows you to bring the Gamelogic class
    private final GameLogic game;

    public TicTacToeBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        game = new GameLogic();

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.TicTacToeBoard, 0, 0);


        try {

            boardColor = a.getInteger(R.styleable.TicTacToeBoard_boardColor, 0);
            Xcolor = a.getInteger(R.styleable.TicTacToeBoard_XColor, 0);
            Ocolor = a.getInteger(R.styleable.TicTacToeBoard_OColor, 0);
            winningLineColor = a.getInteger(R.styleable.TicTacToeBoard_winningLineColor, 0);
        } finally {

            a.recycle();
        }

    }

    //Set up the dimensions of the board makes it a perfect square
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //Extract the smallest value
        int dimension = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cellSize = dimension / 3;
        setMeasuredDimension(dimension, dimension);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        drawGameBoard(canvas);
        drawMarkers(canvas);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        //check if the gameboard was clicked
        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN) {

            //When user clicks on the tictactoeboard it will calculate the row and column
            //but it doesn't do more than that - need to update the gameboard in the gamelogic class
            //You want when you click an area on the tictactoe board to show up in the gamelogic class

            //This calculation will be a 1, 2 or 3
            int row = (int) Math.ceil(y / cellSize);
            int col = (int) Math.ceil(x / cellSize);

            //if you havent won yet keep adding pieces
            if(!winningLine) {

                if(game.updateGameBoard(row, col)) {

                    //update the gameboard graphically
                    invalidate();

                    //We need to know that the player didnt win by adding that
                    //marker
                    if(game.winnerCheck()) {

                        winningLine = true;
                    }

                    //Player twos turn
                    if(game.getPlayer()%2 == 0) {

                        //Change to player one
                        game.setPlayer(game.getPlayer() - 1);
                    } else {

                        //Player ones turn
                        game.setPlayer(game.getPlayer() + 1);
                    }
                }



            }
            //invalidate redraw the gameboard and run the Ondraw method again.
            invalidate();

            return true;
        }

        return false;
    }


    private void drawGameBoard(Canvas canvas) {

        paint.setColor(boardColor);
        paint.setStrokeWidth(16);

        for (int c = 1; c < 3; c++) {

            canvas.drawLine(cellSize * c, 0, cellSize * c, canvas.getWidth(),
                    paint);
        }

        for (int r = 1; r < 3; r++) {

            canvas.drawLine(0, cellSize * r, canvas.getWidth(), cellSize * r, paint);
        }
    }

    private void drawMarkers(Canvas canvas) {

        //find out if to draw and X or and O
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {

                if (game.getGameBoard()[r][c] != 0) {

                    //#1 defines X
                    if (game.getGameBoard()[r][c] == 1) {

                        drawX(canvas, r, c);
                    }

                    else{

                        drawO(canvas, r, c);

                    }
                }

            }
        }
    }

        private void drawX(Canvas canvas,int row, int col){

            //paint.setColor(Xcolor);

            canvas.drawLine((col + 1) * cellSize - cellSize * 0.2f,
                    row * cellSize + cellSize * 0.2f,
                    col * cellSize + cellSize * 0.2f,
                    (row + 1) * cellSize - cellSize * 0.2f,
                    paint);


            canvas.drawLine(col * cellSize + cellSize * 0.2f,
                    row * cellSize + cellSize * 0.2f,
                    (col + 1) * cellSize - cellSize * 0.2f,
                    (row + 1) * cellSize - cellSize * 0.2f,
                    paint);

        }

        private void drawO(Canvas canvas,int row, int col){

           //paint.setColor(Ocolor);

            canvas.drawOval(col * cellSize + cellSize * 0.2f,
                    row * cellSize + cellSize * 0.2f,
                    col * cellSize + cellSize - cellSize * 0.2f,
                    row * cellSize + cellSize - cellSize * 0.2f
                    , paint);

        }

    //We are trying to end the game and draw winning line
        public void setUpGame(Button playAgain, Button home, TextView playerDisplay, String[] names) {

            game.setPlayAgainBTN(playAgain);
            game.setHomeBTN(home);
            game.setPlayerTurn(playerDisplay);
            game.setPlayerNames(names);

        }

        public void resetGame() {

            game.resetGame();
        }
    }

