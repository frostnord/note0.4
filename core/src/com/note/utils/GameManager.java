package com.note.utils;

import com.note.enums.GameState;


public class GameManager {

    private GameState gameState;

    public static GameManager ourInstance = new GameManager();

    public static final String PREFERENCES_NAME = "preferences";

    public static GameManager getInstance() {
        return ourInstance;
    }

    private GameManager() {
        gameState = GameState.MOVE;
    }
    public GameState getGameState() {
        return gameState;
    }
    public void setGameState (GameState a){
        gameState = a;
    }
}
