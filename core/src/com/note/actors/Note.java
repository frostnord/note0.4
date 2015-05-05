package com.note.actors;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.note.enums.GameState;
import com.note.game.Assets;
import com.note.screens.DirectedGame;
import com.note.screens.ScripTreningScreen;
import com.note.utils.Constants;
import com.note.utils.GameManager;

import java.util.Random;


public class Note extends Actor {

    private TextureRegion textureRegion;
    private final DirectedGame game;
    private float index=0;
    private GameState gameState;
    private String noteState;
    private Vector2 position;

    public Vector2 dimension;
    public Vector2 origin;
    public Vector2 scale;
    public float rotation1;

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

//        if (GameManager.ourInstance.getGameState()== GameState.FIRSTPRESSED) {
        if (noteState.equals("firstPressed")) {
            textureRegion = Assets.instance.note.note_grey;
        }else {
            textureRegion = Assets.instance.note.note;
        }
            batch.draw(textureRegion, position.x, position.y, Constants.APP_WIDTH / 12, Constants.APP_HEIGHT / 10);
    }
    public Note(DirectedGame directedGame) {
        this.gameState = GameManager.ourInstance.getGameState();
        this.game = directedGame;
        randomNote();
        position = new Vector2(Constants.APP_WIDTH / (23) * index - 11,Constants.APP_HEIGHT - (Constants.APP_HEIGHT/5));
//        this.position.y = 400;
        noteState ="not";

        dimension = new Vector2(1, 1);
        origin = new Vector2();
        scale = new Vector2(1, 1);
        rotation1 = 0;
    }
    public void setNoteState(String state){
        noteState = state;
    }

    private float randomNote(){
        Random rand = new Random();
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
        position.y -= 1;
//        System.out.println(actorY);

        if (position.y <= ScripTreningScreen.keybordHeight()) {
            remove();

        }
    }

}


