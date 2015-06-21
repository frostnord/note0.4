package com.note.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.note.actors.NoteVert;
import com.note.game.Assets;

public class FirstMenuScreen extends AbstractGameScreen {

    private static final String TAG = FirstMenuScreen.class.getName();

    private Table layerBackground;
    private Image imgBackground;
    private Stage stage;
    private TextureAtlas atlas;
    private Table layerKeyboard;




    private Table layerControls;
    private Button scripMenuImg;
    private Button bassMenuImg;
    private Button settingsMenuImg;
    private Table layerSettings;
    private Image keybordImg;
    private float keybordHeight;
    private Image lineImg;
    private Table layerLines;
    private NoteVert oneMenuNoteVert;
    private Table layerNote;

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
        if (oneMenuNoteVert.getPosition().y==keybordHeight+15) {
            oneMenuNoteVert.remove();
            oneMenuNoteVert =null;
        }
        if (oneMenuNoteVert ==null){
            layerNote.addActor(oneMenuNoteVert = new NoteVert(game));
        }
    }

    private Table buildBackgroundLayer() {
        Table table = new Table();
        this.imgBackground = new Image(this.game.gameSkin.getRegion("backgroundMenu"));
        table.add(this.imgBackground).size(stage.getViewport().getWorldWidth(),stage.getViewport().getWorldHeight());
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
        table.center().bottom().padBottom(104);
        this.scripMenuImg = new Button(this.game.gameSkin, "ScripButton");
//        table.add(this.scripMenuImg).size(stage.getViewport().getWorldWidth() / 4,stage.getViewport().getWorldHeight() / 3 );
        table.add(this.scripMenuImg);
        System.out.println(stage.getViewport().getWorldWidth() / 4);
        this.scripMenuImg.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                 FirstMenuScreen.this.onPlayClicked();/////////////////////

            }
        });

        this.bassMenuImg = new Button(this.game.gameSkin, "BassButton");
//        table.add(this.bassMenuImg).padLeft(this.game.gameSkin.getRegion("BassButton").getRegionHeight() / 1.5f).size(stage.getViewport().getWorldWidth() / 4,stage.getViewport().getWorldHeight() / 3);
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
    private Table buildKeyboardLayer() {
        final Table table = new Table();
        table.center().bottom();
        this.keybordImg = new Image(this.game.gameSkin, "keybord");
        table.add(this.keybordImg);
        keybordHeight = keybordImg.getTop();
        return table;
    }

    private void buildMenuLayers() {
        this.layerBackground = this.buildBackgroundLayer();
        this.layerKeyboard=this.buildKeyboardLayer();
        this.layerLines = this.buildLinesLayer();
        this.layerNote = this.noteCreate();
        this.layerControls = this.buildControlsLayer();
        this.layerSettings = this.buildSettingsLayer();

    }
    private Table buildLinesLayer() {
        Table table = new Table();
        table.bottom().left().padBottom(keybordHeight);
        this.lineImg = new Image(this.game.gameSkin, "lines");
        table.add(this.lineImg);

        return table;
    }


    private void assembleStage() {
        this.stage.clear();
        Stack stack = new Stack();
        this.stage.addActor(stack);
        stack.setSize(800.0f, 480.0f);
        stack.add(this.layerBackground);
        stack.add(this.layerSettings);
        stack.add(this.layerKeyboard);
//        stack.add(this.layerLines);
//        stack.add(this.layerNote);
        stack.add(this.layerControls);

    }
    private Table noteCreate(){
        Table table = new Table();

        table.addActor(oneMenuNoteVert = new NoteVert(game));

        return table;
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
                    Gdx.app.exit();
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
        this.stage.dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
        Assets.instance.dispose();
    }
}
