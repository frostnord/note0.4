package com.note.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.note.enums.GameState;
import com.note.game.Assets;
import com.note.utils.GameManager;

/**
 * Created by 1 on 25.03.2015.
 */
public class ScripMenuScreen extends AbstractGameScreen  {


    private Table layerBackground;
    private Image imgBackground;
//    private TextureAtlas atlas;
    private Stage stage;
    private Table layerControls;
    private Button treningMenuImg;
    private Button practiceMenuImg;
    private Button lerningMenuImg;
    private Image keybordImg;
    private float keybordHeight;
    private Image lineImg;
    private Table layerKeyboard;
    private Table layerLines;


    public ScripMenuScreen(DirectedGame directedGame) {
        super(directedGame);
    }

    private void rebuildStage() {
        this.buildMenuLayers();
        this.assembleStage();
    }
    private void assembleStage() {
        this.stage.clear();
        Stack stack = new Stack();
        this.stage.addActor(stack);
        stack.setSize(800.0f, 480.0f);
        stack.add(this.layerBackground);
        stack.add(this.layerKeyboard);
        stack.add(this.layerLines);
        stack.add(this.layerControls);

    }
    private Table buildKeyboardLayer() {
        final Table table = new Table();
        table.center().bottom();
        this.keybordImg = new Image(this.game.gameSkin, "keybord");
        table.add(this.keybordImg);
        keybordHeight = keybordImg.getTop();
        return table;
    }
    private Table buildLinesLayer() {
        Table table = new Table();
        table.bottom().left().padBottom(keybordHeight);
        this.lineImg = new Image(this.game.gameSkin, "lines");
        table.add(this.lineImg);

        return table;
    }
    private void buildMenuLayers() {
        this.layerBackground = this.buildBackgroundLayer();

        this.layerKeyboard=this.buildKeyboardLayer();
        this.layerLines = this.buildLinesLayer();
        this.layerControls = this.buildControlsLayer();
//        this.layerSettings = this.buildSettingsLayer();
    }
    private Table buildBackgroundLayer() {
        Table table = new Table();
        this.imgBackground = new Image(this.game.gameSkin,"backgroundMenu");
        table.add(this.imgBackground);
        return table;
    }
    private Table buildControlsLayer() {
        final Table table = new Table();
        table.center().bottom().padBottom(this.game.gameSkin.getRegion("ScripButton").getRegionWidth() / 1.8f);
        this.treningMenuImg = new Button(this.game.gameSkin, "TreningScrip_left");
        table.add(this.treningMenuImg);
        this.treningMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                FirstMenuScreen.this.onPlayClicked();/////////////////////
                ScripMenuScreen.this.onTreningClicked();

            }
        });

        this.practiceMenuImg = new Button(this.game.gameSkin, "LearningScrip_mid");
        table.add(this.practiceMenuImg).padLeft(this.game.gameSkin.getRegion("LearningScrip_mid").getRegionHeight() /2.2f);
        this.practiceMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                onLearningClicked();
            }
        });

        this.lerningMenuImg = new Button(this.game.gameSkin, "PracticeScrip_right");
        table.add(this.lerningMenuImg).padLeft(this.game.gameSkin.getRegion("LearningScrip_mid").getRegionHeight()/2.2f );
        this.lerningMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                MenuScreen.this.onStoreClicked();
            }
        });
        return table;
    }

    private void onLearningClicked() {
        this.game.setScreen(new ScripLearningScreen(this.game));
    }

    private void onTreningClicked() {
        this.game.setScreen(new ScripTreningScreen(this.game));
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
        this.stage.dispose();
    }

    @Override
    public void dispose() {
        Assets.instance.dispose();
    }

//    @Override
//    public InputProcessor getInputProcessor() {
//        return null;
//    }
    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
        this.stage = new Stage(){
            @Override
            public boolean keyUp(int keycode) {
                if ((keycode == Input.Keys.BACK)|| (keycode == Keys.ESCAPE)){
                    ScripMenuScreen.this.Back();
                }
                return false;
            }
        };
        Gdx.input.setInputProcessor(stage);
        this.stage.setViewport(new StretchViewport(800.0f, 480.0f));
        GameManager.ourInstance.setGameState(GameState.MOVE);
//        this.atlas = (TextureAtlas)this.game.manager.get("sprites.atlas", TextureAtlas.class);
        this.rebuildStage();
    }

    private void Back() {
        this.game.setScreen(new FirstMenuScreen(this.game));
    }

}
