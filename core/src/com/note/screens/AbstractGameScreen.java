package com.note.screens;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.note.game.Assets;

/**
 * Created by 1 on 13.04.2015.
 */
public abstract class AbstractGameScreen implements Screen {

    protected DirectedGame game;

    public AbstractGameScreen(DirectedGame directedGame) {
        this.game = directedGame;
    }
    @Override
    public void dispose() {
        Assets.instance.dispose();
    }

//    public abstract InputProcessor getInputProcessor();

    @Override
    public abstract void hide();

    @Override
    public abstract void pause();

    @Override
    public abstract void render(float var1);

    @Override
    public abstract void resize(int var1, int var2);

    @Override
    public void resume() {
    }

    @Override
    public abstract void show();
}
