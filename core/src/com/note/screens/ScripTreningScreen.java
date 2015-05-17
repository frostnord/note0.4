package com.note.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    private Table layerLines;
    private Image imgBackground;
    private TextureAtlas atlas;
    private Stage stage;
    private Table layerKeyboard;
    private Button keybordImg;
    private Note firstActor  ,secondActor;
    private GameState gameState;
    private static float keybordHeight;
    private Float time =0f;
    private Float currIndex, nextIndex;
    private Image lineImg;



    public ScripTreningScreen(DirectedGame directedGame) {
        super(directedGame);
    }
    private void rebuildStage() {
        this.buildMenuLayers();
        this.assembleStage();
    }
    private void buildMenuLayers() {
        this.layerBackground = this.buildBackgroundLayer();
        this.layerKeyboard = this.buildKeyboardLayer();
//        this.layerSettings = this.buildSettingsLayer();
        this.layerLines = this.buildLinesLayer();
    }

    private Table buildLinesLayer() {
        Table table = new Table();
        table.bottom().left().padBottom(keybordHeight);
        this.lineImg = new Image(this.game.gameSkin,"lines");
//        this.lineImg.setWidth(10.0f);
//        this.lineImg.setHeight(80.0f);
        System.out.println(lineImg.getHeight());
        table.add(this.lineImg);

        return table;
    }

    private Table buildBackgroundLayer() {
        Table table = new Table();
        this.imgBackground = new Image(this.game.gameSkin,"background");
        table.add(this.imgBackground);
        return table;
    }

    private Table buildKeyboardLayer() {
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
                keyPressed(x);
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

        stack.add(this.layerLines);
        stack.add(this.layerKeyboard);

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
        this.stage.act();
        this.stage.draw();
    }
    private void Back() {
        this.game.setScreen(new ScripMenuScreen(this.game));
    }
    private void renderGuiFpsCounter () {
        SpriteBatch batch = new SpriteBatch();
//        float x = stage.getViewport().getScreenWidth()+ 55;
        float x = 400;
        float y = 240;
//        float y = stage.getViewport().getScreenHeight() + 15;
        int fps = Gdx.graphics.getFramesPerSecond();
        BitmapFont fpsFont = Assets.instance.fonts.heroInfo;
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
        batch.begin();
        fpsFont.draw(batch, "FPS: " + fps, x, y);
        batch.end();
        fpsFont.setColor(1, 1, 1, 1); // white
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        controller(delta);

//        this.lineImg.setWidth(10.0f);
//        this.lineImg.setHeight(80.0f);

        stage.act(delta);
        stage.draw();
        renderGuiFpsCounter();


    }
    public void controller(float delta) {
        if (firstActor == null) {

            firstActor = new Note(game);
            currIndex = firstActor.getIndex();
            System.out.println(firstActor.getIndex() + "index");

            stage.addActor(firstActor);

        }
        time += 1;
        if (time >= 180f) {
            if (secondActor == null)
                secondActor = new Note(game);
            stage.addActor(secondActor);
            currIndex = nextIndex;
            time = 0f;

        }
        if (firstActor.getPosition().y <= keybordImg.getTop()) {

            secondActor.move(false);

            if (firstActor.getNoteCliked(true)) {

//                firstActor = null;
                currIndex = nextIndex;
                firstActor.remove();
                firstActor = secondActor;
                secondActor = null;
                firstActor.move(true);

            } else {
                firstActor.move(false);
            }
        }
//        if (!(secondActor == (null))){
//            if (firstActor.getPosition().y <= keybordImg.getTop()) {
//                secondActor.move(false);
//            }
//        }
    }

    private void keyPressed(float x ) {
        float key = (x-7) /34;
        System.out.println(key);
        if ((int)firstActor.getIndex() ==(int)key){
            System.out.println("OK");

            firstActor.setNoteCliked(true);

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
