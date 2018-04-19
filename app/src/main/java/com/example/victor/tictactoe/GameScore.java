package com.example.victor.tictactoe;

import android.widget.TextView;

/**
 *  Copyright 2018 (C)
 *  Created on  :    4/6/2018
 *  Author     :    Victor Edet
 *
 *  GameScore increments the score when there is a win
 */

public class GameScore {
    public GameScore(TextView winner) {
        int score = Integer.parseInt(winner.getText().toString());
        winner.setText(String.valueOf(score + 1));
    }
}
