package com.note.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.note.game.Assets;
import com.note.utils.Constants;

public class Keybord extends Actor {

    private final TextureRegion textureRegion;
    private static float textuerKeybordHeight ;

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
//        textureRegion = Assets.instance.
        batch.draw(textureRegion,0,0,Constants.APP_WIDTH , textuerKeybordHeight);

    }

    public Keybord() {
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal(Constants.KEYBORD_IMAGE_PATH)));
        textuerKeybordHeight = Constants.APP_HEIGHT/3.5f;
    }
    public static float getTextuerKeybordHeight(){
        return textuerKeybordHeight;
    }
}
