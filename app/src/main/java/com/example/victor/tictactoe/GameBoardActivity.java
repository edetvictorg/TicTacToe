package com.example.victor.tictactoe;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

/**
 *  Copyright 2018 (C)
 *  Created on  :    4/6/2018
 *  Author     :    Victor Edet
 *
 *  GameBoarding activity is more or less the direct motherboard of the game.
 *  It is from here that almost every other gets called to perform their specific functions
 */

public class GameBoardActivity extends AppCompatActivity {
    private PlayerSymbol playerSymbol = new PlayerSymbol();// Initialising a player symbol object to track each player's symb
    private int bundleFromSelectedSymbol;// Used to receive selected symbol from SelectSymbolActivity
    private ArrayList<Button> board;// Game board array
    TextView xScore;// Placeholder for X's score
    TextView oScore;// Placeholder for O's score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        xScore = (TextView)findViewById(R.id.x_score);// Find the score TextView for X player
        oScore = (TextView)findViewById(R.id.o_score);// Find the score TextView for O player

        //Get the passed symbol from the SelectSymbolActivity class, for the player
        Bundle bundle = this.getIntent().getExtras();
        bundleFromSelectedSymbol = bundle.getInt("playerSymbol");

        if (bundleFromSelectedSymbol == R.drawable.x_symbol) {
            // Pass the player symbol to the specialised PlayerSymbol class
            playerSymbol.setPlayerSymbol("X");
        }

        if (bundleFromSelectedSymbol == R.drawable.o_symbol) {
            // Pass the player symbol to the specialised PlayerSymbol class
            playerSymbol.setPlayerSymbol("O");
        }
    }

    /**
     *  Gets executed each time a players plays his move. The position click activity is
     *  received and a search is made to find out which position was actually played.
     *  The play method is called from the player calls which upon execution, a CheckWinning object is called to check
     *  for either a win or a draw.
     *
     *  @param clickedView receives the position played by the player
     */
    public void play(View clickedView) {
        // Find the game status Text view
        TextView statusTextView = (TextView) findViewById(R.id.status);

        // Find the particular position on the game board, which the player just played
        Button slot = (Button) findViewById(clickedView.getId());

        Button x1y1 = (Button) findViewById(R.id.x1y1);
        Button x2y1 = (Button) findViewById(R.id.x2y1);
        Button x3y1 = (Button) findViewById(R.id.x3y1);
        Button x1y2 = (Button) findViewById(R.id.x1y2);
        Button x2y2 = (Button) findViewById(R.id.x2y2);
        Button x3y2 = (Button) findViewById(R.id.x3y2);
        Button x1y3 = (Button) findViewById(R.id.x1y3);
        Button x2y3 = (Button) findViewById(R.id.x2y3);
        Button x3y3 = (Button) findViewById(R.id.x3y3);

        // Add all the buttons used for game board for easy transport
        board = new ArrayList<>();
        board.add(x1y1);
        board.add(x2y1);
        board.add(x3y1);
        board.add(x1y2);
        board.add(x2y2);
        board.add(x3y2);
        board.add(x1y3);
        board.add(x2y3);
        board.add(x3y3);

        // Instantiating and calling method play from Player class
        new Player(playerSymbol, statusTextView, slot).play();

        // Check if game is a win
        CheckWinning checkIfThereIsAWinning = new CheckWinning(board);
        ResetGameBoard resetGameBoard = new ResetGameBoard(board, bundleFromSelectedSymbol);
        if (checkIfThereIsAWinning.isGameWon()) {
            String winnerSymbol = checkIfThereIsAWinning.getWinnerSymbol();
            String message = winnerSymbol + " has won the game\nCongratulations!";
            statusTextView.setText(message);

            if(winnerSymbol.equalsIgnoreCase("X")){
                new GameScore(xScore);
            }

            if(winnerSymbol.equalsIgnoreCase("O")){
                new GameScore(oScore);
            }
            // Clear game board
            resetGameBoard.clearAllSymbols();
            resetGameBoard.enableBoard();
        }
        // Check if game is a draw
        if (checkIfThereIsAWinning.isGameDraw()) {
            statusTextView.setText(checkIfThereIsAWinning.getStatusForGameDraw());
            // Clear game board
            resetGameBoard.clearAllSymbols();
            resetGameBoard.enableBoard();
        }
    }

    /**
     *  resetGame refreshes the both the game board and the score board
     * @param view is the reset button itself
     */
    public void resetGame(View view){
        // Call method reset, from ResetGame Board
        new ResetGameBoard(board, bundleFromSelectedSymbol).reset(xScore, oScore);
    }
}
