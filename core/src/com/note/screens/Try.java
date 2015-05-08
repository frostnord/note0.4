package com.note.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.note.game.Assets;

/**
 * Created by 1 on 22.04.2015.
 */
public class Try extends AbstractGameScreen {

    public static final String TAG = LoadingScreen.class.getName();
    private TextureAtlas atlas;
    private BitmapFont defaultBig;
    private int displayPercent = 0;
    private BitmapFont fontPercent;
    private boolean fullyLoaded;
    private boolean isFiveLoaded;
    private boolean isFourLoaded;
    private boolean isOneLoaded;
    private boolean isScreenSet;
    private boolean isThreeLoaded;
    private boolean isTwoLoaded;
    private Table layerBackground;
    private Table layerLoadingBar;
    private float loadBarIncrement = 0.0f;
    private Image loading;
    private Image loadingBar;
    private float percent = 0.0f;
    private boolean skipOneRender;
    private boolean skipUpdate;
    private Stage stage;
    private float totalLoadBarHeight = 10.0f;
    private float totalLoadBarWidth = 164.0f;

    public Try(DirectedGame directedGame) {
        super(directedGame);
    }

    private Table buildBackgroundLayer() {
        Table table = new Table();
        this.loading = new Image(this.atlas.findRegion("loading"));
        table.add(this.loading);
        return table;
    }

    private Table buildLoadingBarLayer() {
        Table table = new Table();
        table.top().left().padTop(400.0f).padLeft(315.0f);
        this.loadingBar = new Image(this.atlas.findRegion("loading_bar"));
        table.add(this.loadingBar);
        return table;
    }

    private void updateLoadingBar(float f, boolean bl) {
        if (bl) {
            this.loadingBar.setWidth(f * this.totalLoadBarWidth);
            this.loadingBar.setHeight(this.totalLoadBarHeight);
            this.percent = 100.0f * (this.loadingBar.getWidth() / this.totalLoadBarWidth);
            if (this.percent > 83.0f) {
                this.percent = 83.0f;
            }
            return;
        }
        this.totalLoadBarWidth = f + this.totalLoadBarWidth;
        this.loadingBar.setWidth(this.totalLoadBarWidth);
        this.loadingBar.setHeight(this.totalLoadBarHeight);
        this.percent = f + this.percent;
    }

//    @Override
//    public InputProcessor getInputProcessor() {
//        return null;
//    }

    @Override
    public void hide() {
        this.game.manager.unload("images/runandgun-loading.atlas");
    }

    @Override
    public void pause() {
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void render(float f) {
        Gdx.gl.glClear(16384);
        this.loadBarIncrement = this.game.manager.getProgress();
        if (this.game.manager.update() && !this.skipUpdate) {
            if (this.fullyLoaded) {
                this.game.setScreen(new MenuScreen(this.game));
                this.isScreenSet = true;
            }
            if (!this.isScreenSet) {
                if (!this.isOneLoaded) {
//                    SaveManager.instance.initializeDefaults1();
                    this.isOneLoaded = true;
                    this.updateLoadingBar(5.0f, false);
                    this.stage.act();
                    this.stage.draw();
                    this.displayPercent = (int)this.percent;
                    this.stage.getBatch().begin();
                    this.fontPercent = this.defaultBig;
                    this.fontPercent.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                    this.fontPercent.drawMultiLine(this.stage.getBatch(), (CharSequence)("" + this.displayPercent + "%"), 30.0f + (800.0f - this.fontPercent.getBounds((CharSequence)java.lang.Float.toString((float)((float)this.displayPercent))).width) / 2.0f, 191.0f, 0.0f, BitmapFont.HAlignment.CENTER);
                    this.stage.getBatch().end();
                    return;
                }
                if (!this.isTwoLoaded) {
//                    SaveManager.instance.initializeDefaults2();
                    this.isTwoLoaded = true;
                    this.updateLoadingBar(4.0f, false);
                    this.stage.act();
                    this.stage.draw();
                    this.displayPercent = (int)this.percent;
                    this.stage.getBatch().begin();
                    this.fontPercent = this.defaultBig;
                    this.fontPercent.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                    this.fontPercent.drawMultiLine(this.stage.getBatch(), (CharSequence)("" + this.displayPercent + "%"), 30.0f + (800.0f - this.fontPercent.getBounds((CharSequence)java.lang.Float.toString((float)((float)this.displayPercent))).width) / 2.0f, 191.0f, 0.0f, BitmapFont.HAlignment.CENTER);
                    this.stage.getBatch().end();
                    return;
                }
                if (!this.isThreeLoaded) {
//                    SaveManager.instance.initializeDefaults3();
                    this.isThreeLoaded = true;
                    this.updateLoadingBar(3.0f, false);
                    this.stage.act();
                    this.stage.draw();
                    this.displayPercent = (int)this.percent;
                    this.stage.getBatch().begin();
                    this.fontPercent = this.defaultBig;
                    this.fontPercent.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                    this.fontPercent.drawMultiLine(this.stage.getBatch(), (CharSequence)("" + this.displayPercent + "%"), 30.0f + (800.0f - this.fontPercent.getBounds((CharSequence)java.lang.Float.toString((float)((float)this.displayPercent))).width) / 2.0f, 191.0f, 0.0f, BitmapFont.HAlignment.CENTER);
                    this.stage.getBatch().end();
                    return;
                }
                if (!this.isFourLoaded) {
//                    SaveManager.instance.initializeDefaults4();
                    this.isFourLoaded = true;
                    this.updateLoadingBar(2.0f, false);
                    this.stage.act();
                    this.stage.draw();
                    this.displayPercent = (int)this.percent;
                    this.stage.getBatch().begin();
                    this.fontPercent = this.defaultBig;
                    this.fontPercent.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                    this.fontPercent.drawMultiLine(this.stage.getBatch(), (CharSequence)("" + this.displayPercent + "%"), 30.0f + (800.0f - this.fontPercent.getBounds((CharSequence)java.lang.Float.toString((float)((float)this.displayPercent))).width) / 2.0f, 191.0f, 0.0f, BitmapFont.HAlignment.CENTER);
                    this.stage.getBatch().end();
                    return;
                }
                if (!this.isFiveLoaded) {
//                    SaveManager.instance.initializeDefaults5();
                    this.isFiveLoaded = true;
                    this.updateLoadingBar(3.0f, false);
                    this.stage.act();
                    this.stage.draw();
                    this.displayPercent = (int)this.percent;
                    this.stage.getBatch().begin();
                    this.fontPercent = this.defaultBig;
                    this.fontPercent.setColor(1.0f, 1.0f, 1.0f, 1.0f);
                    this.fontPercent.drawMultiLine(this.stage.getBatch(), (CharSequence)("" + this.displayPercent + "%"), 30.0f + (800.0f - this.fontPercent.getBounds((CharSequence)java.lang.Float.toString((float)((float)this.displayPercent))).width) / 2.0f, 191.0f, 0.0f, BitmapFont.HAlignment.CENTER);
                    this.stage.getBatch().end();
                    return;
                }
                this.game.gameSkin = new Skin(Gdx.files.internal("images/runandgun-ui.json"), new TextureAtlas("images/runandgun-ui.atlas"));
                Assets.instance.init(this.game.manager);
//                this.game.visibleAds = (Boolean)SaveManager.instance.loadDataValue("visibleAds", Boolean.TYPE);
                this.fullyLoaded = true;
                this.skipOneRender = true;
            }
        }
        if (!this.isFiveLoaded) {
            this.updateLoadingBar(this.loadBarIncrement, true);
        }
        this.stage.act();
        this.stage.draw();
        this.displayPercent = (int)this.percent;
        this.stage.getBatch().begin();
        this.fontPercent = this.defaultBig;
        this.fontPercent.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        this.fontPercent.drawMultiLine(this.stage.getBatch(), (CharSequence)("" + this.displayPercent + "%"), 30.0f + (800.0f - this.fontPercent.getBounds((CharSequence)java.lang.Float.toString((float)((float)this.displayPercent))).width) / 2.0f, 191.0f, 0.0f, BitmapFont.HAlignment.CENTER);
        this.stage.getBatch().end();
        if (this.skipOneRender) {
            this.skipOneRender = false;
            this.skipUpdate = true;
            return;
        }
        if (!this.fullyLoaded) return;
        this.skipUpdate = false;
    }

    @Override
    public void resize(int n, int n2) {
        this.stage.getViewport().update(n, n2, true);
    }

    @Override
    public void show() {
//        FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/wolfsbane2ii.ttf"));
//        FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
//        freeTypeFontParameter.size = 30;
//        this.defaultBig = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
        this.defaultBig.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.defaultBig.setScale(1.0f, 1.0f);
        this.game.manager.load("images/runandgun-loading.atlas", TextureAtlas.class);
        this.game.manager.finishLoading();
        this.stage = new Stage();
        this.stage.setViewport(new StretchViewport(800.0f, 480.0f));
        this.atlas = (TextureAtlas)this.game.manager.get("images/runandgun-loading.atlas", TextureAtlas.class);
        this.layerBackground = this.buildBackgroundLayer();
        this.layerLoadingBar = this.buildLoadingBarLayer();
        this.stage.clear();
        Stack stack = new Stack();
        this.stage.addActor(stack);
        stack.setSize(800.0f, 480.0f);
        stack.add(this.layerBackground);
        stack.add(this.layerLoadingBar);
        this.stage.act();
        this.stage.draw();
        Assets.instance.load(this.game.manager);
    }
}
