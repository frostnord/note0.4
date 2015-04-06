package com.note.screens;


import android.widget.ImageButton;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.note.Note;
import com.note.actors.Background;
import com.note.utils.AssetsManager;
import com.note.utils.Constants;

public class FirstMenuScreen implements Screen {

    private OrthographicCamera camera;

    private Stage stage;
    private Note game;
//    private TextButton play, exit;
//    private ImageButton scrip ,bass;
//    private Skin skin;
    private Table table;
    private Image scripImage ,bassImage,settingsImage;
    private TextureRegion ScripTextureRegion, SettingsRegion;
    private TextureRegion BassTextureRegion;

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;


    public FirstMenuScreen(final Note game ) {


        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
        this.game = game;
        ScripTextureRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.SCRIP_BUTTON_REGION_NAME));
        SettingsRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.SETTINGS_REGION_NAME));
        BassTextureRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.BASS_BUTTON_REGION_NAME));
        settingsImage = new Image(SettingsRegion);
        scripImage = new Image(ScripTextureRegion);
        bassImage = new Image(BassTextureRegion);
//        scripImage.setSize(camera.viewportWidth / 4, camera.viewportHeight / 4) ;

//        scripImage.setScaling(Scaling.fill);
        settingsImage.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.input.vibrate(20);
                System.out.println("111");
                return true;
            };
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new LevelScreen(game));
//                dispose();
            };
        } );
        scripImage.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.input.vibrate(20);
                System.out.println("111");
                return true;
            };
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new ScripMenuScreen(game));
                dispose();
            };
        });
        bassImage.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.input.vibrate(20);
                System.out.println("222");
                return true;
            };
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new ScripMenuScreen(game));
//                dispose();
            };
        });


        stage = new Stage(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                camera));
        stage.addActor(new Background());
        table = new Table();
//        table.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


        table.setFillParent(true);
        table .right().top().pad(20);

        table.add(settingsImage).colspan(2).right().expandX().padRight(10).padTop(30) ;
        table.row();
        table.add(scripImage).size(200,200).padTop(60).padLeft(50) ;
        table.add(bassImage).size(200,200).padTop(60).padRight(50);
        System.out.println(scripImage.getWidth());
//        table.row();
        System.out.println(camera.viewportWidth/4);

        table.setDebug(true);


//        table.row();
//        table.add(exit);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
//        Gdx.input.setCatchBackKey(true);
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
        stage.dispose();
    }
}
