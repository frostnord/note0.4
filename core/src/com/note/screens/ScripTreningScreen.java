package com.note.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.note.actors.Note;
import com.note.enums.GameState;
import com.note.game.Assets;
import com.note.utils.GameManager;

/**
 * Created by 1 on 29.03.2015.
 */
public class ScripTreningScreen extends AbstractGameScreen {

    private Table layerBackground;
    private Image imgBackground;
    private TextureAtlas atlas;
    private Stage stage;
    private Table layerKeyboard;
    private Button keybordImg;
    private Note firstActor  ,secondActor;
    private GameState gameState;
    private static float keybordHeight;


    public ScripTreningScreen(DirectedGame directedGame) {
        super(directedGame);
    }
    private void rebuildStage() {
        this.buildMenuLayers();
        this.assembleStage();
    }
    private void buildMenuLayers() {
        this.layerBackground = this.buildBackgroundLayer();
        this.layerKeyboard = this.buildControlslineLayer();
//        this.layerSettings = this.buildSettingsLayer();
    }
    private Table buildBackgroundLayer() {
        Table table = new Table();
        this.imgBackground = new Image(this.game.gameSkin,"background");
        table.add(this.imgBackground);
        return table;
    }

    private Table buildControlslineLayer() {
        final Table table = new Table();
        table.center().bottom();
        this.keybordImg = new Button(this.game.gameSkin, "keybord");
        table.add(this.keybordImg);
        keybordHeight = keybordImg.getTop();
        this.keybordImg.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.input.vibrate(20);
//                System.out.println(x+","+y);
                GameManager.getInstance().setGameState(GameState.FIRSTPRESSED);

                secondActor = firstActor;
                secondActor.setNoteState("firstPressed");
                if (!(null == secondActor)) {
//                    secondActor.remove();
                }
                firstActor = null;


                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new LevelScreen(game));
//                dispose();
            }
        });
        return table;
    }

    
    private void assembleStage() {
        this.stage.clear();
        Stack stack = new Stack();
        this.stage.addActor(stack);

        stack.setSize(800.0f, 480.0f);
        stack.add(this.layerBackground);
        stack.add(this.layerKeyboard);

        firstActor = new Note(game);
        stage.addActor(firstActor);
    }

    @Override
    public void show() {
        Gdx.input.setCatchBackKey(true);
        this.stage = new Stage(){
            @Override
            public boolean keyUp(int keycode) {
                if ((keycode == Input.Keys.BACK)|| (keycode == Input.Keys.ESCAPE)){
                    ScripTreningScreen.this.Back();
                }
                return false;
            }
        };
        firstActor=null;
        Gdx.input.setInputProcessor(stage);
        this.stage.setViewport(new StretchViewport(800.0f, 480.0f));
        this.rebuildStage();
    }
    private void Back() {
        this.game.setScreen(new ScripMenuScreen(this.game));
    }
    private void renderGuiFpsCounter () {

        float x = stage.getViewport().getScreenWidth()+ 55;
        float y = stage.getViewport().getScreenHeight() + 15;
        int fps = Gdx.graphics.getFramesPerSecond();
        BitmapFont fpsFont = Assets.instance.fonts.defaultSmall;
        if (fps >= 45) {
            // 45 or more FPS show up in green
            fpsFont.setColor(0, 1, 0, 1);
        } else if (fps >= 30) {
            // 30 or more FPS show up in yellow
            fpsFont.setColor(1, 1, 0, 1);
        } else {
            // less than 30 FPS show up in red
            fpsFont.setColor(1, 0, 0, 1);
        }
        fpsFont.draw(this.stage.getBatch(), "FPS: " + fps, x, y);
        fpsFont.setColor(1, 1, 1, 1); // white
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        renderGuiFpsCounter();
//        if (firstActor.getY()<=keybordHeight) {
//
//        }

        if (firstActor==null) {
            firstActor = new Note(game);
            stage.addActor(firstActor);
        }
    }
    @Override
    public void resize(int n, int n2) {
        this.stage.getViewport().update(n, n2, true);
    }

    @Override
    public void pause() {

    }

    public static float keybordHeight(){
        return keybordHeight;
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
