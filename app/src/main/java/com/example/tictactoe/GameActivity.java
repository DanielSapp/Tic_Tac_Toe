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
    boolean gameWon = false;
    Button restartButton;
    Button[] gameButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textDisplay = findViewById(R.id.GameTextDisplay);
        restartButton = findViewById(R.id.GameRestartButton);
        gameButtons = new Button[9];
        gameButtons[0] = findViewById(R.id.ULButton);
        gameButtons[1] = findViewById(R.id.UMButton);
        gameButtons[2] = findViewById(R.id.URButton);
        gameButtons[3] = findViewById(R.id.MLButton);
        gameButtons[4] = findViewById(R.id.MMButton);
        gameButtons[5] = findViewById(R.id.MRButton);
        gameButtons[6] = findViewById(R.id.BLButton);
        gameButtons[7] = findViewById(R.id.BMButton);
        gameButtons[8] = findViewById(R.id.BRButton);
    }
    public void onBoardMove(View v) {
        Button clickedButton = (Button) v;
        CharSequence cs = clickedButton.getText();
        if (cs.length() != 0) {
            return;
        }
        if (currentPlayer == 'X') {
            clickedButton.setText("X");
        } else {
            clickedButton.setText("O");
        }
        setGameState(clickedButton);
        if (isHorizontalWin() || isVerticalWin() || isDiagonalWin()) {
            displayWinMessage();
            gameWon = true;
            spawnResetButton();
        } else if (boardIsFull()) {
            displayDrawMessage();
            gameWon = true;
            spawnResetButton();
        } else {
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
                setTextDisplay("Player two, it is your turn!");
            } else {
                currentPlayer = 'X';
                setTextDisplay("Player one, it is your turn!");
            }
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
        for (int i = 0; i < gameState.length-2; i+= 3) {
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
    public void restartGame(View v) {
        if (!gameWon) {return;}
        gameWon = false;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 'e';
        }
        for (Button b : gameButtons) {
            b.setText("");
        }
        restartButton.setVisibility(View.INVISIBLE);
        setTextDisplay("Player one, it is your turn!");
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
        if (gameState[0] == currentPlayer && (gameState[0] == gameState[4] && gameState[0] == gameState[8])) {return true;}
        if (gameState[2] == currentPlayer && (gameState[2] == gameState[4] && gameState[2] == gameState[6])) {return true;}
        return false;
    }
    private void spawnResetButton() {
        restartButton.setVisibility(View.VISIBLE);
    }
    private boolean boardIsFull() {
        for (char c : gameState) {
            if (c == 'e') {
                return false;
            }
        }
        return true;
    }
    private void displayDrawMessage() {
        setTextDisplay("Game over, nobody wins!");
    }
}
