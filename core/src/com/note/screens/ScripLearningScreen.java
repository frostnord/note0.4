package com.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.note.actors.NoteGoriz;
import com.note.game.Assets;


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
    private Array<NoteGoriz> actors;
    private float key;
    private Float time = 0f;
    private TextureAtlas.AtlasRegion pressedKey;
    boolean rightButton = false;
    public int scoreRight = 0;
    public int scoreWrong = 0;


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
/////////////////
//        stage.addActor(new NoteGoriz(game));
        actors = new Array();

        NoteGoriz noteGoriz = new NoteGoriz(game);
        actors.add(noteGoriz);
        stage.addActor(noteGoriz);


        controller();
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
                keyPressed(x);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new LevelScreen(game));
//                dispose();
                keyStatus = KeyStatus.UP;
                rightButton = false;
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
        controller();

        stage.act(delta);
        stage.draw();

        if (keyStatus == KeyStatus.DOWN) {
            drawKey(key);
        }
//        renderGuiFpsCounter();
        score();
    }
    private  void score (){


        float x =650;
        float y = 460;
//        int fps = Gdx.graphics.getFramesPerSecond();
        BitmapFont score = Assets.instance.fonts.levelCompleted;
//        BitmapFont scoreWFont = Assets.instance.fonts.levelCompleted;
//        if (fps >= 45) {
            // 45 or more FPS show up in green
//            fpsFont.setColor(0, 1, 0, 1);
//        } else if (fps >= 30) {
            // 30 or more FPS show up in yellow
//            fpsFont.setColor(1, 1, 0, 1);
//        } else {
            // less than 30 FPS show up in red
//        scoreWFont.setColor(1, 0, 0, 1);

        score.setColor(1, 0, 0, 1);
//        }
        stage.getBatch().begin();
        score.draw(stage.getBatch(), " " + scoreWrong, x, y);
        score.setColor(0, 1, 0, 1);
        score.draw(stage.getBatch(), " " + scoreRight, x + 30, y);
        stage.getBatch().end();
//        scoreFont.setColor(1, 1, 1, 1); // white
    }
    private void keyPressed(float x) {

        key = (x - 3) / 34;
        System.out.println(key);
//        System.out.println( actors.get(0).getNoteNumber());

        if (actors.size != 0 ) {
            if (actors.get(0).getNoteNumber() == (int) key) {
                actors.get(0).setNoteCliked(true);
                rightButton = true;
//            System.out.println(actors.get(0).getName());
                actors.removeIndex(0);
                scoreRight +=1;
            }else {
                actors.get(0).setNoteCliked(true);
                actors.get(0).setNoteCliked(true);
                actors.removeIndex(0);
                scoreWrong +=1;
            }
        }
    }

    public void controller() {
        time += 1;
        if (time >= 210f) {
            NoteGoriz noteGoriz = new NoteGoriz(game);
            actors.add(noteGoriz);
            stage.addActor(noteGoriz);
            time = 0f;
        }
        if (actors.size != 0 ) {
            if (actors.get(0).getPosition().x <= 250) {
                actors.get(0).setNoteCliked(true);
                actors.removeIndex(0);
                scoreWrong +=1;
            }
        }
//
    }
    public void drawKey(float key) {
//        float keyPosition = 8 + (34 * (int) key);
        float keyPosition = keybordImg.getX() + 4 +(34 * (int)key) ;

        if (((int) key == 0) || ((int) key == 3) ) {
            pressedKey = Assets.instance.noteImg.doKeyImg;
        } else if ((int) key == 4) {
            pressedKey = Assets.instance.noteImg.solKeyImg;
        } else if ((int) key == 5) {
            pressedKey = Assets.instance.noteImg.laKeyImg;
        } else if ((int) key == 6)  {
            pressedKey = Assets.instance.noteImg.siKeyImg;
        } else if ((int) key == 1)  {
            pressedKey = Assets.instance.noteImg.reKeyImg;
        } else if ((int) key == 2) {
            pressedKey = Assets.instance.noteImg.miKeyImg;
        }
        if (rightButton) {
            stage.getBatch().setColor(0.0f, 1.0f, 0.0f, 1.0f);
        }else{
            stage.getBatch().setColor(1.0f, 0.0f, 0.0f, 1.0f);

        }

        stage.getBatch().begin();
        stage.getBatch().draw(pressedKey, keyPosition, 1, pressedKey.getRegionWidth(), pressedKey.getRegionHeight());
//        stage.getBatch().setColor(1, 1, 1, 1);
        stage.getBatch().end();
//        System.out.println(keyPosition);

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
