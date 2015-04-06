package com.note.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;


public class AssetsManager {

    private static TextureAtlas textureAtlas;
//    private static AssetManager manager;
//    private static Texture cavemanTexture;
//    private static AssetManager asm = new AssetManager();
    private static String assetsPackPath = "sprites.txt";
//    public static TextureAtlas atlas;

    private AssetsManager() {

    }
    public static void loadAssets() {
//        asm.load(assetsPackPath, TextureAtlas.class);
//        asm.update();
//            asm.finishLoading();
//
//        textureAtlas = asm.get(assetsPackPath);
//        textureAtlas = new TextureAtlas("data/sprites.txt");
//        FileHandle handle = Gdx.files.internal("sprites.txt");
//        textureAtlas = new TextureAtlas(handle);
//        cavemanTexture = new Texture(Gdx.files.internal("sprites.png"));
        textureAtlas = new TextureAtlas(Constants.SPRITES_ATLAS_PATH);





    }


    public static TextureAtlas getTextureAtlas() {
        return textureAtlas;
    }
    public static void dispose() {
        textureAtlas.dispose();

    }
}