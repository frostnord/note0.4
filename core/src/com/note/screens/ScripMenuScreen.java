package com.note.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

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


    public ScripMenuScreen(DirectedGame directedGame) {
        super(directedGame);
    }


//        treningRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.TRENING_SCRIP_LEFT_REGION_NAME));
//        practiceRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.LEARNING_SCRIP_MID_REGION_NAME));
//        learningRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.PRACTICE_SCRIP_RIGHT_REGION_NAME));
//

//        treningImage.addListener(new ClickListener(){
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
////                Gdx.input.vibrate(20);
//                System.out.println("111");
//                return true;
//            };
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new ScripTreningScreen(game));
//                dispose();
//            };
//        } );
//        practiceImage.addListener(new ClickListener() {
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
////                Gdx.input.vibrate(20);
//                System.out.println("111");
//                return true;
//            };
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new ScripPracticeScreen(game));
//                dispose();
//            };
//        });
//        learningImage.addListener(new ClickListener() {
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
////                Gdx.input.vibrate(20);
//                System.out.println("222");
//                return true;
//            };
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new ScripLearningScreen());
//                dispose();
//            };
//        });

//        table = new Table();
//        table.setFillParent(true);
////        table .right().top().pad(20);
//        table.row().width(camera.viewportWidth / 5).height(camera.viewportWidth / 5);
//        table.add(treningImage).padRight(60);
//        table.add(practiceImage) ;
//        table.add(learningImage).padLeft(60);
//        stage.addActor(table);
//        table.debug();

//        InputProcessor backProcessor = new InputAdapter() {
//            @Override
//            public boolean keyDown(int keycode) {
//
//                if ((keycode == Input.Keys.ESCAPE) || (keycode == Input.Keys.BACK) )
//
//                    game.setScreen(new FirstMenuScreen(game));
//                return true;
//            }
//        };
//
//        InputMultiplexer multiplexer = new InputMultiplexer(stage,
//                backProcessor);
//        Gdx.input.setInputProcessor(multiplexer);

//        Gdx.input.setInputProcessor(new InputMultiplexer(new InputAdapter() {
//            public boolean keyDown (int keycode) {
//                if ((keycode == Input.Keys.ESCAPE) || (keycode == Input.Keys.BACK) )
//                    game.setScreen(new FirstMenuScreen(game));
//                return false;
//            }
//        }, stage));
////
////        Gdx.input.setInputProcessor(stage);
//        Gdx.input.setCatchBackKey(true);
//    }


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
        stack.add(this.layerControls);




    }
    private void buildMenuLayers() {
        this.layerBackground = this.buildBackgroundLayer();
        this.layerControls = this.buildControlsLayer();
//        this.layerSettings = this.buildSettingsLayer();
    }
    private Table buildBackgroundLayer() {
        Table table = new Table();
        this.imgBackground = new Image(this.game.gameSkin,"background");
        table.add(this.imgBackground);
        return table;
    }
    private Table buildControlsLayer() {
        final Table table = new Table();
        table.center().bottom().padBottom(this.game.gameSkin.getRegion("ScripButton").getRegionWidth() / 2);
        this.treningMenuImg = new Button(this.game.gameSkin, "TreningScrip_left");
        table.add(this.treningMenuImg);
        this.treningMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                FirstMenuScreen.this.onPlayClicked();/////////////////////
                ScripMenuScreen.this.onTrening();

            }
        });

        this.practiceMenuImg = new Button(this.game.gameSkin, "LearningScrip_mid");
        table.add(this.practiceMenuImg).padLeft(this.game.gameSkin.getRegion("LearningScrip_mid").getRegionHeight() / 1.5f);
        this.practiceMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                MenuScreen.this.onStoreClicked();
            }
        });

        this.lerningMenuImg = new Button(this.game.gameSkin, "PracticeScrip_right");
        table.add(this.lerningMenuImg).padLeft(this.game.gameSkin.getRegion("LearningScrip_mid").getRegionHeight() / 1.5f);
        this.lerningMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                MenuScreen.this.onStoreClicked();
            }
        });
        return table;
    }

    private void onTrening() {
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

    }

    @Override
    public void dispose() {

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
//        this.atlas = (TextureAtlas)this.game.manager.get("sprites.atlas", TextureAtlas.class);
        this.rebuildStage();
    }

    private void Back() {
        this.game.setScreen(new FirstMenuScreen(this.game));
    }

}
