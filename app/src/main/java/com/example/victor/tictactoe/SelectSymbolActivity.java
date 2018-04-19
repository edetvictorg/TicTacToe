package com.example.victor.tictactoe;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 *  Copyright 2018 (C)
 *  Created on  :    4/6/2018
 *  Author     :    Victor Edet
 *
 *  SelectSymbolActivity allows the user to select the symbol he wants to use for the game
 */

public class SelectSymbolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_symbol);

        //  find 'o' Image view and set OnClickListener on it
        final ImageView oSymbol = (ImageView) findViewById(R.id.o_symbol);
        oSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             *  Open activity that allows user to select game level
             */
            public void onClick(View view) {
                // Initialise Intent for the Game board
                Intent gameBoardIntent = new Intent(SelectSymbolActivity.this, GameBoardActivity.class);
                // Pass the game symbol selected to the GameBoard activity
                gameBoardIntent.putExtra("playerSymbol", R.drawable.o_symbol);
                startActivity(gameBoardIntent);
            }
        });

        //  find 'x' Image view and set OnClickListener on it
        final ImageView xSymbol = (ImageView) findViewById(R.id.x_symbol);
        xSymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             *  Open activity that allows user to select game level
             */
            public void onClick(View view) {
                // Initialise Intent for the Game board
                Intent gameBoardIntent = new Intent(SelectSymbolActivity.this, GameBoardActivity.class);
                // Pass the game symbol selected to the GameBoard activity
                gameBoardIntent.putExtra("playerSymbol", R.drawable.x_symbol);
                startActivity(gameBoardIntent);
            }
        });
    }
}
