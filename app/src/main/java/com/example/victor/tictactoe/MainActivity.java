package com.example.victor.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 *  Copyright 2018 (C)
 *  Created on  :    4/5/2018
 *  Author     :    Victor Edet
 *
 *  Main Activity is the entry point of the game, from where interaction with the widgets,
 *  gives you access to other activity of the game
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the play game button
        Button playGameButton = (Button) findViewById(R.id.play_game_button);

        // Attaching listening object to the play game button to listen for click activity
        playGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selectSymbolIntent = new Intent(MainActivity.this, SelectSymbolActivity.class);
                startActivity(selectSymbolIntent);
            }
        });

        // Find the play game button
        Button howToPlay = (Button) findViewById(R.id.how_to_play);

        // Attaching listening object to the play game button to listen for click activity
        howToPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent howToPlayIntent = new Intent(MainActivity.this, HowToPlayActivity.class);
                startActivity(howToPlayIntent);
            }
        });
    }
}
