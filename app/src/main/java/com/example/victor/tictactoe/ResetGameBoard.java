package com.example.victor.tictactoe;

import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

/**
 *  Copyright 2018 (C)
 *  Created on  :    4/6/2018
 *  Author     :    Victor Edet
 *
 *  ResetGameBoard class resets the control on the game board and the score board
 */

public class ResetGameBoard {
    private int playerSymbol;
    private Button boardPosition0;
    private Button boardPosition1;
    private Button boardPosition2;
    private Button boardPosition3;
    private Button boardPosition4;
    private Button boardPosition5;
    private Button boardPosition6;
    private Button boardPosition7;
    private Button boardPosition8;

    /**
     *  ResetGameBoard constructor initialises the board and the player symbol
     * @param board the game board
     * @param bundleFromSelectedSymbol is the player symbol
     */
    public ResetGameBoard(ArrayList<Button> board, int bundleFromSelectedSymbol){
        boardPosition0 = board.get(0);
        boardPosition1 = board.get(1);
        boardPosition2 = board.get(2);
        boardPosition3 = board.get(3);
        boardPosition4 = board.get(4);
        boardPosition5 = board.get(5);
        boardPosition6 = board.get(6);
        boardPosition7 = board.get(7);
        boardPosition8 = board.get(8);
        playerSymbol = bundleFromSelectedSymbol;
    }

    /**
     *  reset clears all symbols on the game board, sets the score board, sets the new symbol, and enables the positions on the board
     *  @param xScoreBoard is the x score placeholder
     *  @param oScoreBoard is the o score placeholder
     */
    public void reset(TextView xScoreBoard, TextView oScoreBoard){
        clearAllSymbols();
        setScore(xScoreBoard, oScoreBoard);
        setSymbol();
        enableBoard();
    }

    /**
     * clears all symbols of the move that was formerly made
     */
    public void clearAllSymbols(){
        boardPosition0.setText(null);
        boardPosition1.setText(null);
        boardPosition2.setText(null);
        boardPosition3.setText(null);
        boardPosition4.setText(null);
        boardPosition5.setText(null);
        boardPosition6.setText(null);
        boardPosition7.setText(null);
        boardPosition8.setText(null);
    }

    /**
     * sets the symbol for the next player
     */
    private void setSymbol(){
        if(playerSymbol == R.drawable.x_symbol){
            // Pass the player symbol to the specialised PlayerSymbol class
            new PlayerSymbol().setPlayerSymbol("O");
        }

        if(playerSymbol == R.drawable.o_symbol){
            // Pass the player symbol to the specialised PlayerSymbol class
            new PlayerSymbol().setPlayerSymbol("X");
        }
    }

    /**
     *  resets the score at the score board
     *  @param xScoreBoard is the x score
     *  @param oScoreBoard is the o score
     */
    private void setScore(TextView xScoreBoard, TextView oScoreBoard){
        xScoreBoard.setText(String.valueOf(0));
        oScoreBoard.setText(String.valueOf(0));
    }

    /**
     * enables all the positions on the board
     */
    public void enableBoard(){
        boardPosition0.setClickable(true);
        boardPosition1.setClickable(true);
        boardPosition2.setClickable(true);
        boardPosition3.setClickable(true);
        boardPosition4.setClickable(true);
        boardPosition5.setClickable(true);
        boardPosition6.setClickable(true);
        boardPosition7.setClickable(true);
        boardPosition8.setClickable(true);
    }
}
