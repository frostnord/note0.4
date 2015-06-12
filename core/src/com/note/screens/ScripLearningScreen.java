package com.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by 1 on 29.03.2015.
 */
public class ScripLearningScreen extends AbstractGameScreen {


    private Stage stage;
    private Table layerBackground;
    private Image imgBackground;
    private Button keybordImg;
    private Table layerKeyboard;
    private float keybordHeight;
    private KeyStatus keyStatus;
    private Image lineImg;
    private Table layerLines;
    private Image znakImg;
    private Table layerZnak;

    public ScripLearningScreen(DirectedGame directedGame) {
        super(directedGame);
    }

    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
        this.stage = new Stage() {
            @Override
            public boolean keyUp(int keycode) {
                if ((keycode == Input.Keys.BACK) || (keycode == Input.Keys.ESCAPE)) {
                    ScripLearningScreen.this.Back();
                }
                return false;
            }
        };
        Gdx.input.setInputProcessor(stage);
        this.stage.setViewport(new StretchViewport(800.0f, 480.0f));
        this.rebuildStage();
        this.stage.act();
        this.stage.draw();
    }
    private void Back() {
        this.game.setScreen(new ScripMenuScreen(this.game));
    }
    private void rebuildStage() {
        this.buildMenuLayers();
        this.assembleStage();
    }
    private void buildMenuLayers() {
        this.layerBackground = this.buildBackgroundLayer();
        this.layerKeyboard = this.buildKeyboardLayer();
        this.layerZnak = this.buildZnakLayer();
        this.layerLines = this.buildLinesLayer();
    }

    private Table buildZnakLayer() {
        Table table = new Table();
        table.left().top().padLeft(50).padTop(90);
        znakImg = new Image(this.game.gameSkin, "ScripGorZnak");
        table.add(znakImg);
        return table;
    }

    private Table buildLinesLayer() {
        Table table = new Table();
        table.bottom().left().padBottom(keybordHeight - 5);
        this.lineImg = new Image(this.game.gameSkin, "linesGoriz");
        table.add(this.lineImg);

        return table;
    }
    private Table buildKeyboardLayer() {
        final Table table = new Table();
        table.center().bottom();
        this.keybordImg = new Button(this.game.gameSkin, "keybord2");
        table.add(this.keybordImg);
        keybordHeight = keybordImg.getTop();
        this.keybordImg.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.input.vibrate(20);
                keyStatus = KeyStatus.DOWN;
//                keyPressed(x);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new LevelScreen(game));
//                dispose();
                keyStatus = KeyStatus.UP;
            }
        });
        return table;
    }
    public enum KeyStatus {
        DOWN,
        UP
    }
    private Table buildBackgroundLayer() {
        Table table = new Table();
        this.imgBackground = new Image(this.game.gameSkin, "backgroundGame");
        table.add(this.imgBackground);
        return table;
    }
    private void assembleStage() {
        this.stage.clear();
        Stack stack = new Stack();
        this.stage.addActor(stack);

        stack.setSize(800.0f, 480.0f);
        stack.add(this.layerBackground);

        stack.add(this.layerLines);
        stack.add(layerZnak);
        stack.add(this.layerKeyboard);

    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        controller(delta);


        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int n, int n2) {
        this.stage.getViewport().update(n, n2, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
