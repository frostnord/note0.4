package com.note.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.note.Note;
import com.note.actors.Background;
import com.note.actors.menu.ScripKeyButton;
import com.note.utils.Constants;

/**
 * Created by 1 on 29.03.2015.
 */
public class ScripTreningScreen implements Screen {

    private  ScripKeyButton startButton;
    private OrthographicCamera camera;
    private Note game;
    private Stage stage;
    private Table table;
    private Image treningImage ,practiceImage,learningImage;
    private TextureRegion treningRegion,practiceRegion,learningRegion;

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    public ScripTreningScreen(final Note game) {
        this.game = game;
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        stage = new Stage(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                camera));

        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
        stage.addActor(new Background());
        setUpScripKeyButton();





//        //////////////////////////////
        InputProcessor backProcessor = new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {

                if ((keycode == Input.Keys.ESCAPE) || (keycode == Input.Keys.BACK) )

                    game.setScreen(new ScripMenuScreen(game));
                return true;
            }
        };

        InputMultiplexer multiplexer = new InputMultiplexer(stage,
                backProcessor);
        Gdx.input.setInputProcessor(multiplexer);
        /////////////////////////////////
//        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);
    }
    private void setUpScripKeyButton() { ///////Scrip Key Button
        Rectangle ScripKeyBounds = new Rectangle(camera.viewportWidth * 3 / 16,
                camera.viewportHeight / 4, camera.viewportWidth / 4,
                camera.viewportWidth / 4);
        startButton = new ScripKeyButton(ScripKeyBounds, new ScripKeyButton.ScripKeyListener() {
            @Override
            public void onStart() {

            }
        });
        stage.addActor(startButton);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
//        if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
//            game.setScreen(new ScripMenuScreen(game));
//        }
    }

    @Override
    public void resize(int width, int height) {

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
