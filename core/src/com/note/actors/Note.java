package com.note.actors;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.note.stages.GameStage;
import com.note.utils.AssetsManager;
import com.note.utils.Constants;

import java.util.Random;


public class Note extends Actor {

    private final TextureRegion textureRegion;
    private float index=0;
    private float actorHeight;




    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
//        float ppx = Constants.APP_WIDTH /24 ;
//        System.out.println(ppx);

        batch.draw(textureRegion, (Constants.APP_WIDTH /(23)) * index-11,actorHeight , Constants.APP_WIDTH / 12,Constants.APP_HEIGHT /10);
        }

//
    public Note() {
        actorHeight = Constants.APP_HEIGHT - Constants.APP_HEIGHT/5;
        randomNote();
        textureRegion = AssetsManager.getTextureAtlas().findRegion(Constants.NOTE_REGION_NAME);
//        this.index= index;
    }
    private float randomNote(){
        Random rand = new Random();
//        int index = 0;
//        index = rand.nextInt(arr.length);
        index = rand.nextInt(23);
        System.out.println(index);

        if (( index==1)||(index==8)||(index==22)||(index==15)) {
            System.out.println("fa");
        }
        if (( index==2)||(index==9)||(index==23)||(index==16)) {
            System.out.println("sol");
        }
        if (( index==3)||(index==10)||(index==17)) {
            System.out.println("la");
        }
        if (( index==4)||(index==11)||(index==18)) {
            System.out.println("si");
        }
        if (( index==5)||(index==12)||(index==19)) {
            System.out.println("do");
        }
        if (( index==6)||(index==13)||(index==20)) {
            System.out.println("re");
        }
        if (( index==7)||(index==14)||(index==21)) {
            System.out.println("mi");
        }
        //        switch (i){
//            case (1 || 8 || 22 || 15);
        return index;
    }

    public void act(float delta) {
        super.act(delta);
        actorHeight -= 1;
        System.out.println(actorHeight);

        if (actorHeight <=  Keybord.getTextuerKeybordHeight()) {
            remove();

        }
    }

}


