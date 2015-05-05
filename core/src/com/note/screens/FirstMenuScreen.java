package com.note.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.note.game.Assets;

public class FirstMenuScreen extends AbstractGameScreen {

    private Table layerBackground;
    private Image imgBackground;
    private Stage stage;
    private TextureAtlas atlas;




    private Table layerControls;
    private Button scripMenuImg;
    private Button bassMenuImg;
    private Button settingsMenuImg;
    private Table layerSettings;

    public FirstMenuScreen(DirectedGame directedGame) {
        super(directedGame);
    }
//        this.game = game;
//        ScripTextureRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.SCRIP_BUTTON_REGION_NAME));
//        SettingsRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.SETTINGS_REGION_NAME));
//        BassTextureRegion = new  TextureRegion(AssetsManager.getTextureAtlas().findRegion(Constants.BASS_BUTTON_REGION_NAME));
//        settingsImage = new Image(SettingsRegion);
//        scripImage = new Image(ScripTextureRegion);
//        bassImage = new Image(BassTextureRegion);


//        settingsImage.addListener(new ClickListener(){
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
////                Gdx.input.vibrate(20);
//                System.out.println("111");
//                return true;
//            };
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
////                game.setScreen(new LevelScreen(game));
////                dispose();
//            };
//        } );
//        scripImage.addListener(new ClickListener() {
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
////                Gdx.input.vibrate(20);
//                System.out.println("111");
//                return true;
//            };
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new ScripMenuScreen(game));
//                dispose();
//            };
//        });
//        bassImage.addListener(new ClickListener() {
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
////                Gdx.input.vibrate(20);
//                System.out.println("222");
//                return true;
//            };
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
////                game.setScreen(new ScripMenuScreen(game));
////                dispose();
//            };
//        });



//        table = new Table();
//
//
//        table.setFillParent(true);
//        table .right().top().pad(20);
//
//        table.add(settingsImage).colspan(2).right().expandX().padRight(10).padTop(30) ;
//        table.row();
//        table.add(scripImage).size(200,200).padTop(60).padLeft(50) ;
//        table.add(bassImage).size(200,200).padTop(60).padRight(50);
//        System.out.println(scripImage.getWidth());
////        table.row();
//
//
//        table.setDebug(true);//////////////////////////////////
//
//
////        table.row();
////        table.add(exit);
//        stage.addActor(table);

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    private Table buildBackgroundLayer() {
        Table table = new Table();
        this.imgBackground = new Image(this.game.gameSkin.getRegion("background"));
        table.add(this.imgBackground);
        return table;
    }
    private Table buildSettingsLayer() {
        Table table = new Table();
        table.right().top().padRight(this.game.gameSkin.getRegion("SetingsButton").getRegionWidth() / 2).padTop(this.game.gameSkin.getRegion("SetingsButton").getRegionWidth() / 2);
        this.settingsMenuImg = new Button(this.game.gameSkin, "SetingsButton");
        table.add(this.settingsMenuImg);
        this.settingsMenuImg.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                FirstMenuScreen.this.onPlayClicked();
            }
        });
        return table;
    }
    private void onPlayClicked() {
        this.game.setScreen(new ScripMenuScreen(this.game));
    }
    private Table buildControlsLayer() {
        final Table table = new Table();
        table.center().bottom().padBottom(this.game.gameSkin.getRegion("ScripButton").getRegionWidth() / 2);
        this.scripMenuImg = new Button(this.game.gameSkin, "ScripButton");
        table.add(this.scripMenuImg);
        this.scripMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                 FirstMenuScreen.this.onPlayClicked();/////////////////////

            }
        });

        this.bassMenuImg = new Button(this.game.gameSkin, "BassButton");
        table.add(this.bassMenuImg).padLeft(this.game.gameSkin.getRegion("BassButton").getRegionHeight() / 1.5f);
        this.bassMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
//                MenuScreen.this.onStoreClicked();
            }
        });
        return table;
    }
    private void rebuildStage() {
        this.buildMenuLayers();
        this.assembleStage();
    }

    private void buildMenuLayers() {
        this.layerBackground = this.buildBackgroundLayer();
        this.layerControls = this.buildControlsLayer();
        this.layerSettings = this.buildSettingsLayer();
    }



    private void assembleStage() {
        this.stage.clear();
        Stack stack = new Stack();
        this.stage.addActor(stack);
        stack.setSize(800.0f, 480.0f);
        stack.add(this.layerBackground);
        stack.add(this.layerSettings);

        stack.add(this.layerControls);




    }
    @Override
     public void show() {

        this.game.manager.load("sprites.atlas", TextureAtlas.class);
        this.game.manager.finishLoading();
        Gdx.input.setCatchBackKey(true);
        this.stage = new Stage(){
            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.BACK) {
//                    MenuScreen.this.exitGame();
                }
                return false;
            }
        };
        Gdx.input.setInputProcessor(stage);
        this.stage.setViewport(new StretchViewport(800.0f, 480.0f));
//        this.atlas = (TextureAtlas)this.game.manager.get("sprites.atlas", TextureAtlas.class);
        this.game.gameSkin = new Skin(Gdx.files.internal("sprites.json"), new TextureAtlas("sprites.atlas"));
        Assets.instance.init(this.game.manager);
        this.rebuildStage();

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
        Assets.instance.init(new AssetManager());
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        Assets.instance.dispose();
    }
}
