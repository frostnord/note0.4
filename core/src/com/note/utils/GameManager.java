package com.note.utils;

import com.note.enums.GameState;


public class GameManager {

    private GameState gameState;

    private static GameManager ourInstance = new GameManager();

    public static final String PREFERENCES_NAME = "preferences";

    public static GameManager getInstance() {
        return ourInstance;
    }

    private GameManager() {
        gameState = GameState.OVER;
    }
    public GameState getGameState() {
        return gameState;
    }
}
