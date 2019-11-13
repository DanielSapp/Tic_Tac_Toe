package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {
    int currentPlayer = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
    public void onBoardMove(View v) {
        Button clickedButton = (Button) v;
        CharSequence cs = clickedButton.getText();
        if (cs.length() != 0) {
            return;
        }
        if (currentPlayer == 1) {
            clickedButton.setText("X");
        } else {
            clickedButton.setText("O");
        }
        //TODO: CHECK IF WIN CONDITION HAS BEEN REACHED
    }
}
