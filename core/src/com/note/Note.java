package com.note;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.note.screens.FirstMenuScreen;
import com.note.screens.GameScreen;
import com.note.utils.AssetsManager;
import com.note.utils.AudioUtils;

public class Note extends Game {

    private Skin skin;


    @Override
    public void create() {

        skin = new Skin();
        AssetsManager.loadAssets();
        skin.addRegions(AssetsManager.getTextureAtlas());



        setScreen(new FirstMenuScreen(this));
    }
//    protected void loadTextureRegion() {
//        ButtonStyle style = new ButtonStyle();
//        style.up = skin.getDrawable(getRegionName());
//        setStyle(style);
//    }

//    protected abstract String getRegionName();



//        System.out.println(Gdx.files.getLocalStoragePath());
    @Override
    public void dispose() {
        super.dispose();
        AudioUtils.dispose();
        AssetsManager.dispose();
    }

}
