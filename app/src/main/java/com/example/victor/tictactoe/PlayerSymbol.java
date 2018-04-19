package com.example.victor.tictactoe;


/**
 *  Copyright 2018 (C)
 *  Created on  :    4/6/2018
 *  Author     :    Victor Edet
 *
 *  PlayerSymbol sets and gets the player symbol
 */

public class PlayerSymbol {
    private String mPlayerSymbolImageResourceId;
    private String mAiPlayerSymbol;
    private String mHumanPlayerSymbol;


    /**
     *  Set the symbol for the first player, from the selection made at the player symbol layout
     * @param playerCharacter receives the resource Id for the symbol that the user chooses from the selection window
     */
    public void setPlayerSymbol(String playerCharacter){
        mPlayerSymbolImageResourceId = playerCharacter;
    }

     /**
     *  Get the symbol for the first player
     * @return the resource locator string for the symbol
     */
    public String getPlayerSymbol() {
        return mPlayerSymbolImageResourceId;
    }
   }


