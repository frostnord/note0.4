package com.note.screens;

import android.widget.ImageButton;
import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.note.Note;
import com.note.actors.Background;
import com.note.utils.AssetsManager;
import com.note.utils.Constants;

/**
 * Created by 1 on 25.03.2015.
 */
public class ScripMenuScreen implements Screen  {


    private OrthographicCamera camera;

    private Stage stage;
    private Note game;
    //    private TextButton play, exit;
    private ImageButton scrip ,bass;
    private Skin skin;
    private Table table;
    private Image treningImage ,practiceImage,learningImage;
    private TextureRegion treningRegion,practiceRegion,learningRegion;

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    public ScripMenuScreen(final Note game) {
        this.game = game;
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
        stage = new Stage(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));
        stage.addActor(new Background());

        treningRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.TRENING_SCRIP_LEFT_REGION_NAME));
        practiceRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.LEARNING_SCRIP_MID_REGION_NAME));
        learningRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.PRACTICE_SCRIP_RIGHT_REGION_NAME));
        treningImage = new Image(treningRegion);
        practiceImage = new Image(practiceRegion);
        learningImage = new Image(learningRegion);

        treningImage.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.input.vibrate(20);
                System.out.println("111");
                return true;
            };
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new ScripTreningScreen(game));
                dispose();
            };
        } );
        practiceImage.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.input.vibrate(20);
                System.out.println("111");
                return true;
            };
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new ScripPracticeScreen(game));
                dispose();
            };
        });
        learningImage.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.input.vibrate(20);
                System.out.println("222");
                return true;
            };
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new ScripLearningScreen());
                dispose();
            };
        });

        table = new Table();
        table.setFillParent(true);
//        table .right().top().pad(20);
        table.row().width(camera.viewportWidth / 5).height(camera.viewportWidth / 5);
        table.add(treningImage).padRight(60);
        table.add(practiceImage) ;
        table.add(learningImage).padLeft(60);
        stage.addActor(table);
        table.debug();

        InputProcessor backProcessor = new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {

                if ((keycode == Input.Keys.ESCAPE) || (keycode == Input.Keys.BACK) )

                    game.setScreen(new FirstMenuScreen(game));
                return true;
            }
        };

        InputMultiplexer multiplexer = new InputMultiplexer(stage,
                backProcessor);
        Gdx.input.setInputProcessor(multiplexer);



//        Gdx.input.setInputProcessor(stage);
        Gdx.input.setCatchBackKey(true);
    }




    @Override
    public void show() {



    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        if (Gdx.input.isKeyPressed(Keys.BACK)){
//            game.setScreen(new FirstMenuScreen(game));
//        }

        stage.act(delta);
        stage.draw();


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
