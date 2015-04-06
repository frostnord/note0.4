package com.note.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.note.utils.Constants;

public class VertLines extends Actor {

    private final TextureRegion textureRegion;

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion,0, Constants.APP_HEIGHT / 3.5f,Constants.APP_WIDTH ,Constants.APP_HEIGHT-Constants.APP_HEIGHT /3);

    }

    public VertLines() {
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal(Constants.VERTLINES_IMAGE_PATH)));
    }

}
