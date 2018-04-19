package com.example.victor.tictactoe;

import android.widget.Button;
import java.util.ArrayList;

/**
 *  Copyright 2018 (C)
 *  Created on  :    4/6/2018
 *  Author     :    Victor Edet
 *
 *  CheckWinning class searches through the game board to ascertain if there is a winning or a draw
 */

public class CheckWinning {
    private String winnerSymbol; // String representing the sybol of the winner
    private String boardPosition0;
    private String boardPosition1;
    private String boardPosition2;
    private String boardPosition3;
    private String boardPosition4;
    private String boardPosition5;
    private String boardPosition6;
    private String boardPosition7;
    private String boardPosition8;

    /**
     *      CheckWinning constructor gets the positions on the game board and also gets the different symbols on each spot
     *      @param board is the game board, passed in from any class that needs the functions of CheckWinning
     */
    public CheckWinning(ArrayList<Button> board){
        // Get the symbols displayed on all the game boardPosition
        boardPosition0 = board.get(0).getText().toString().trim();// First position on first row
        boardPosition1 = board.get(1).getText().toString().trim();// Second position on first row
        boardPosition2 = board.get(2).getText().toString().trim();// Third position on first row
        boardPosition3 = board.get(3).getText().toString().trim();// First position on second row
        boardPosition4 = board.get(4).getText().toString().trim();// Second position on second row
        boardPosition5 = board.get(5).getText().toString().trim();// Third position on second row
        boardPosition6 = board.get(6).getText().toString().trim();// First position on third row
        boardPosition7 = board.get(7).getText().toString().trim();// Second position on third row
        boardPosition8 = board.get(8).getText().toString().trim();// Third position on third row
    }

    /**
     *      isGameWon checks if there is a winning in any of the columns, rows or diagonal
     *      @return true if there is a winning and false, otherwise
     */
    public boolean isGameWon() {
        boolean gameWon = false;
        // Check if all boxes at row 1 contains a symbol
        if ((!boardPosition0.isEmpty()) && (!boardPosition1.isEmpty()) && (!boardPosition2.isEmpty())) {
            // Check if there is a winning at row 1
            if ((boardPosition0.equalsIgnoreCase(boardPosition1)) && (boardPosition0.equalsIgnoreCase(boardPosition2))) {
                winnerSymbol = boardPosition0;
                gameWon = true;
                return gameWon;
            }
        }

        // Check if all boxes at row 2 contains a symbol
        // Check if there is a winning at row 2
        if ((!boardPosition3.isEmpty()) && (!boardPosition4.isEmpty()) && (!boardPosition5.isEmpty()))
            if ((boardPosition3.equalsIgnoreCase(boardPosition4)) && (boardPosition3.equalsIgnoreCase(boardPosition5))) {
                winnerSymbol = boardPosition3;
                gameWon = true;
                return gameWon;
            }

        // Check if all boxes at row 3 contains a symbol
        if ((!boardPosition6.isEmpty()) && (!boardPosition7.isEmpty()) && (!boardPosition8.isEmpty())) {
            // Check if there is a winning at row 3
            if ((boardPosition6.equalsIgnoreCase(boardPosition7)) && (boardPosition6.equalsIgnoreCase(boardPosition8))) {
                winnerSymbol = boardPosition6;
                gameWon = true;
                return gameWon;
            }
        }

        // Check if all boxes at column 1 contains a symbol
        if ((!boardPosition0.isEmpty()) && (!boardPosition3.isEmpty()) && (!boardPosition6.isEmpty())) {
            // Check if there is a winning at column 1
            if ((boardPosition0.equalsIgnoreCase(boardPosition3)) && (boardPosition0.equalsIgnoreCase(boardPosition6))) {
                winnerSymbol = boardPosition0;
                gameWon = true;
                return gameWon;
            }
        }

        // Check if all boxes at column 2 contains a symbol
        if ((!boardPosition1.isEmpty()) && (!boardPosition4.isEmpty()) && (!boardPosition7.isEmpty())) {
            // Check if there is a winning at column 2
            if ((boardPosition1.equalsIgnoreCase(boardPosition4)) && (boardPosition1.equalsIgnoreCase(boardPosition7))) {
                winnerSymbol = boardPosition1;
                gameWon = true;
                return gameWon;
            }
        }

        // Check if all boxes at column 3 contains a symbol
        if ((!boardPosition2.isEmpty()) && (!boardPosition5.isEmpty()) && (!boardPosition8.isEmpty())) {
            // Check if there is a winning at column 3
            if ((boardPosition2.equalsIgnoreCase(boardPosition5)) && (boardPosition2.equalsIgnoreCase(boardPosition8))) {
                winnerSymbol = boardPosition2;
                gameWon = true;
                return gameWon;
            }
        }

        // Check if all boxes at left diagonal contains a symbol
        if ((!boardPosition0.isEmpty()) && (!boardPosition4.isEmpty()) && (!boardPosition8.isEmpty())) {
            // Check if there is a winning at left diagonal
            if ((boardPosition0.equalsIgnoreCase(boardPosition4)) && (boardPosition0.equalsIgnoreCase(boardPosition8))) {
                winnerSymbol = boardPosition0;
                gameWon = true;
                return gameWon;
            }
        }

        // Check if all boxes at right diagonal contains a symbol
        if ((!boardPosition2.isEmpty()) && (!boardPosition4.isEmpty()) && (!boardPosition6.isEmpty())) {
            // Check if there is a winning at right diagonal
            if ((boardPosition2.equalsIgnoreCase(boardPosition4)) && (boardPosition2.equalsIgnoreCase(boardPosition6))) {
                winnerSymbol = boardPosition2;
                gameWon = true;
                return gameWon;
            }
        }
        return gameWon; // game is not won
    }

    /**
     *
     *      isGameDraw checks if the game game has ended in a win-win or draw. ie no winner-no loser
     *      @return true if there is a draw and false, otherwise
     */
    public boolean isGameDraw(){
        boolean gameDraw = false;
        // Check first if all moves have been exhausted
        if ((!boardPosition0.isEmpty()) && (!boardPosition1.isEmpty())
                && (!boardPosition2.isEmpty()) && (!boardPosition3.isEmpty())
                && (!boardPosition4.isEmpty()) && (!boardPosition5.isEmpty())
                && (!boardPosition6.isEmpty()) && (!boardPosition7.isEmpty())
                && (!boardPosition8.isEmpty())){
            // Check if there is a draw
            // There can only be a draw if there is no winning set
            if((!((boardPosition0.equalsIgnoreCase(boardPosition1))
                    && (boardPosition0.equalsIgnoreCase(boardPosition2))))
                    && (!((boardPosition3.equalsIgnoreCase(boardPosition4))
                    && (boardPosition3.equalsIgnoreCase(boardPosition5))))
                    && (!((boardPosition6.equalsIgnoreCase(boardPosition7))
                    && (boardPosition6.equalsIgnoreCase(boardPosition8))))
                    && (!((boardPosition0.equalsIgnoreCase(boardPosition3))
                    && (boardPosition0.equalsIgnoreCase(boardPosition6))))
                    && (!((boardPosition1.equalsIgnoreCase(boardPosition4))
                    && (boardPosition1.equalsIgnoreCase(boardPosition7))))
                    && (!((boardPosition2.equalsIgnoreCase(boardPosition5))
                    && (boardPosition2.equalsIgnoreCase(boardPosition8))))
                    && (!((boardPosition0.equalsIgnoreCase(boardPosition4))
                    && (boardPosition0.equalsIgnoreCase(boardPosition8))))
                    && (!((boardPosition2.equalsIgnoreCase(boardPosition4))
                    && (boardPosition2.equalsIgnoreCase(boardPosition6))))){
                gameDraw = true;
                return gameDraw;
            }
        }
        return  gameDraw;// game not draw
    }

    /**
     *      getWinnerSymbol gets the symbol of the winner, so that a winning can be announced appropriately
     *      @return the winner symbol
     */
    public String getWinnerSymbol(){
        return winnerSymbol;
    }

    /**
     *      getStatusForGameDraw returns a string for the status where the game is a draw, so that a draw can be announced appropriately
     *      @return the winner symbol
     */
    public String getStatusForGameDraw(){
        return "The game is a draw\nCongratulations!";
    }
}
