package com.note.actors;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    private TextureRegion lineImg;
    private final DirectedGame game;
    private float index=0;
    private GameState gameState;
    private boolean isSecond;
    private float speed = 0.7f;


    private Vector2 position;
    private String note ;
    public Vector2 dimension;
    public Vector2 origin;
    public Vector2 scale;
    public float rotation1;
    private BitmapFont font;
    private boolean move ;

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        lineImg= Assets.instance.decoration.lineImg;
        if (note.equals("do")){
            textureRegion = Assets.instance.note.noteRedDo;
        }else if (note.equals("re")){
            textureRegion = Assets.instance.note.noteOrangeRe;
        }else if (note.equals("mi")){
            textureRegion = Assets.instance.note.noteYellowMi;
        }else if (note.equals("fa")){
            textureRegion = Assets.instance.note.noteGreenFa;
        }else if (note.equals("sol")){
            textureRegion = Assets.instance.note.noteBlueSol;
        }else if (note.equals("la")){
            textureRegion = Assets.instance.note.noteSiniiLa;
        }else if (note.equals("si")){
            textureRegion = Assets.instance.note.notePurpleSi;
        }

//        switch ((int)index){
//            case 4   :
//                batch.draw(lineImg,position.x-5,position.y-40,lineImg.getRegionWidth(),lineImg.getRegionHeight());
//                return;
//        }
        if (index== 5){
            batch.draw(lineImg,192 ,position.y - lineImg.getRegionHeight()/4+8,lineImg.getRegionWidth(),lineImg.getRegionHeight());
        }
        if (index == 4) {
            batch.draw(lineImg,192 ,position.y - lineImg.getRegionHeight()/4+8,lineImg.getRegionWidth(),lineImg.getRegionHeight());
        }
        if ((index == 3)||(index == 2)) {
            batch.draw(lineImg, 125, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight());
            batch.draw(lineImg, 192, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight());
        }
        if ((index== 1)||(index == 0)){
            batch.draw(lineImg, 192, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight());
            batch.draw(lineImg, 125, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight());
            batch.draw(lineImg, 55, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight());
        }
        if (index== 17){
            batch.draw(lineImg,602 ,position.y - lineImg.getRegionHeight()/4+8,lineImg.getRegionWidth(),lineImg.getRegionHeight());
        }
        if (index==18){
            batch.draw(lineImg,670 ,position.y - lineImg.getRegionHeight()/4+8,lineImg.getRegionWidth(),lineImg.getRegionHeight());
        }
        if ((index == 19)||(index==20)){
            batch.draw(lineImg, 600, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight());
            batch.draw(lineImg, 668, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight());
        }
        if ((index == 21)||(index==22)){
            batch.draw(lineImg, 600, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight());
            batch.draw(lineImg, 670, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight());
            batch.draw(lineImg, 739, position.y - lineImg.getRegionHeight() / 4 + 8, lineImg.getRegionWidth(), lineImg.getRegionHeight());
        }
        if (isSecond) {
            textureRegion = Assets.instance.note.note_grey;
        }
        batch.draw(textureRegion, position.x, position.y, Constants.APP_WIDTH / 12, Constants.APP_HEIGHT / 10);

        this.font = Assets.instance.fonts.levelComplete;
        font.setColor(0, 0, 0, 1);
        font.drawMultiLine(batch, note, position.x, position.y, 0, BitmapFont.HAlignment.CENTER);
        font.drawMultiLine(batch, Float.toString( index), position.x+50, position.y, 0, BitmapFont.HAlignment.CENTER);
//        if (GameManager.ourInstance.getGameState()== GameState.FIRSTPRESSED) {
    }
    public Note(DirectedGame directedGame) {
        this.gameState = GameManager.ourInstance.getGameState();
        this.game = directedGame;
        randomNote();
        this.move= true;
//        index = 22;
//        note ="mi";
        position = new Vector2(Constants.APP_WIDTH / (23) * index - 8,Constants.APP_HEIGHT - (Constants.APP_HEIGHT/5));
        this.isSecond=false;
        dimension = new Vector2(1, 1);
        origin = new Vector2();
        scale = new Vector2(1, 1);
        rotation1 = 0;
    }
    private void drawNote(Batch batch){
//        batch.setColor();

    }
    public void setNoteCliked(boolean isSecond){
        this.isSecond = isSecond;
    }
    public boolean getNoteCliked(boolean isSecond){
        return this.isSecond ;
    }
    public float getIndex(){
        return this.index;
    }
    public String getNote(){
        return note;
    }
    public void move(boolean move){
        this.move = move;
    }
    public Vector2 getPosition() {
        return position;
    }
    private float randomNote(){
        Random rand = new Random();
        index = rand.nextInt(22);
//        System.out.println(index);

        if (( index==0)||(index==7)||(index==21)||(index==14)) {
            note = "mi";
            System.out.println("mi");
        }
        if (( index==1)||(index==8)||(index==22)||(index==15)) {
            note = "fa";
            System.out.println("fa");
        }
        if (( index==2)||(index==9)||(index==16)) {
            note="sol";
            System.out.println("sol");
        }
        if (( index==3)||(index==10)||(index==17)) {
            note ="la";
            System.out.println("la");
        }
        if (( index==4)||(index==11)||(index==18)) {
            note="si";
            System.out.println("si");
        }
        if (( index==5)||(index==12)||(index==19)) {
            note="do";
            System.out.println("do");
        }
        if (( index==6)||(index==13)||(index==20)) {
            note="re";
            System.out.println("re");
        }
        //        switch (i){
//            case (1 || 8 || 22 || 15);
        return index;
    }

    public void act(float delta) {
        super.act(delta);
        if  (move) {
            position.y -= 0.7;
//        System.out.println(actorY);
        }

//            if (position.y <= ScripTreningScreen.keybordHeight()) {
//                if (isSecond){
//                remove();
//            }else {
//                    move=false;
//                }
//        }
    }

}


