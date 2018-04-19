package com.example.victor.tictactoe;


import android.widget.Button;
import android.widget.TextView;

/**
 *  Copyright 2018 (C)
 *  Created on  :    4/6/2018
 *  Author     :    Victor Edet
 *
 *  Player class handles the playing of the game
 */

public class Player {
    private PlayerSymbol mPlayerSymbol;
    private TextView mGameStatus;
    private Button mPositionPlayed;
    private String currentPlayerSymbol;

    /**
     *  Initialising class variables
     *
     * @param playerSymbol      receives the symbol object for each player
     * @param gameStatus        receives the TextView object used in displaying the game status
     * @param positionPlayed    receives the last position played
     */
    public Player(PlayerSymbol playerSymbol, TextView gameStatus, Button positionPlayed){
        mPlayerSymbol = playerSymbol;
        mGameStatus = gameStatus;
        mPositionPlayed = positionPlayed;
    }

    public boolean play(){
        // Get symbol from the PlayerSymbol class for the current player
        currentPlayerSymbol = mPlayerSymbol.getPlayerSymbol();

        // Set the current symbol on the position played by the current Player
        mPositionPlayed.setText(currentPlayerSymbol);

        // Change symbol at the PlayerSymbol class for the next player
        if (currentPlayerSymbol.equalsIgnoreCase("O")) {
            mPlayerSymbol.setPlayerSymbol("X");

            // Set game status, informing of whose turn to play
            mGameStatus.setText("X's turn to play");
        }
        if (currentPlayerSymbol.equalsIgnoreCase("X")) {
            mPlayerSymbol.setPlayerSymbol("O");

            // Set game status, informing of whose turn to play
            mGameStatus.setText("O's turn to play");
        }
        // Disable the position which has just been played by the current player
        mPositionPlayed.setClickable(false);
        return true;
    }


}
