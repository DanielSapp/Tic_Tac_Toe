package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    char currentPlayer = 'X';
    char[] gameState = new char[] {'e','e','e','e','e','e','e','e','e'};
    TextView textDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textDisplay = findViewById(R.id.GameTextDisplay);
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
        setGameState(clickedButton);
        if (isHorizontalWin() || isVerticalWin() || isDiagonalWin()) {
            displayWinMessage();
            resetBoard();
        }


    }
    private void setGameState(Button clickedButton) {
        switch (clickedButton.getId()) {
            case R.id.ULButton:
                gameState[0] = currentPlayer;
                break;
            case R.id.UMButton:
                gameState[1] = currentPlayer;
                break;
            case R.id.URButton:
                gameState[2] = currentPlayer;
                break;
            case R.id.MLButton:
                gameState[3] = currentPlayer;
                break;
            case R.id.MMButton:
                gameState[4] = currentPlayer;
                break;
            case R.id.MRButton:
                gameState[5] = currentPlayer;
                break;
            case R.id.BLButton:
                gameState[6] = currentPlayer;
                break;
            case R.id.BMButton:
                gameState[7] = currentPlayer;
                break;
            case R.id.BRButton:
                gameState[8] = currentPlayer;
        }
    }
    private boolean isHorizontalWin() {
        for (int i = 0; i < gameState.length-2; i++) {
            if (gameState[i] == currentPlayer && (gameState[i+1] == gameState[i] && gameState[i+2] == gameState[i])) {
                return true;
            }
        }
        return false;
    }
    private void setTextDisplay(String s) {
        textDisplay.setText(s);
    }
    private void displayWinMessage() {
        setTextDisplay("Congratulations player " + (currentPlayer == 'X' ? "1" : "2") + ", you won!");
    }
    private void resetBoard() {
        //TODO
    }
    private boolean isVerticalWin() {
        for (int i = 0; i < 3; i++) {
            if (gameState[i] == currentPlayer && (gameState[i+3] == gameState[i] && gameState[i+6] == gameState[i])) {
                return true;
            }
        }
        return false;
    }
    private boolean isDiagonalWin() {
        //TODO
        return false;
    }
}
