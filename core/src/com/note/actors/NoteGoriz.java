package com.note.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.note.enums.GameState;
import com.note.game.Assets;
import com.note.screens.DirectedGame;
import com.note.utils.Constants;
import com.note.utils.GameManager;

import java.util.Random;

/**
 * Created by 1 on 13.06.2015.
 */
public class NoteGoriz extends Actor {
    private TextureRegion textureRegion;
    private TextureRegion lineImg;
    private final DirectedGame game;
    private float index=0;
    private GameState gameState;
    private boolean isSecond;


    private Vector2 position;
    private String note ;
    public Vector2 dimension;
    public Vector2 origin;
    public Vector2 scale;
    public float rotation1;
    private BitmapFont font;
    private boolean move ;
    private int noteNumber;
    private float ran;

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
        if ((index== 5)||(index == 4)){
            batch.draw(lineImg,position.x - 10 , 208,70,2);
//            batch.draw(lineImg,192 ,position.y - lineImg.getRegionHeight()/4+8,lineImg.getRegionWidth(),lineImg.getRegionHeight());


        }
        if ((index == 3)||(index == 2)) {
            batch.draw(lineImg,position.x - 10 , 208,70,2);
            batch.draw(lineImg,position.x - 10 , 179,70,2);
        }
        if ((index== 1)||(index == 0)){
            batch.draw(lineImg,position.x - 10 , 208,70,2);
            batch.draw(lineImg,position.x - 10 , 179,70,2);
            batch.draw(lineImg,position.x - 10 , 151,70,2);
        }
        if( (index== 17)||(index==18)){
            batch.draw(lineImg,position.x - 10 , 375,70,2);
        }

        if ((index == 19)||(index==20)){
            batch.draw(lineImg,position.x - 10 , 375,70,2);
            batch.draw(lineImg,position.x - 10 , 403,70,2);
        }
        if ((index == 21)||(index==22)){
            batch.draw(lineImg,position.x - 10 , 375,70,2);
            batch.draw(lineImg,position.x - 10 , 403,70,2);
            batch.draw(lineImg,position.x - 10 , 431,70,2);
        }
        if (isSecond) {
            textureRegion = Assets.instance.note.note_grey;
            ran = 1;
        }
        batch.draw(textureRegion, position.x, position.y, 50, 34);

        this.font = Assets.instance.fonts.levelCompleted;
        font.setColor(0, 0, 0, 1);
        if (ran!=0) {
            font.drawMultiLine(batch, note, position.x + 25, position.y + 37, 0, BitmapFont.HAlignment.CENTER);
        }
//        font.drawMultiLine(batch, Float.toString( index), position.x+50, position.y, 0, BitmapFont.HAlignment.CENTER);
//        if (GameManager.ourInstance.getGameState()== GameState.WAITKEYPRESS) {
    }
    public NoteGoriz(DirectedGame directedGame) {
        this.game = directedGame;
        randomNote();
        this.move= true;
        lineViev();
//        index = 22;
//        note ="mi";
        position = new Vector2(770 , (index * 14) + 118);/////////////////////
//        position = new Vector2(Constants.APP_WIDTH / (23) * index - 8,Constants.APP_HEIGHT - (Constants.APP_HEIGHT/5));
        this.isSecond=false;
        dimension = new Vector2(1, 1);
        origin = new Vector2();
        scale = new Vector2(1, 1);
        rotation1 = 0;
    }
    private float lineViev() {
        Random random = new Random();
        ran = random.nextInt(5);
        return ran;
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
    public int getNoteNumber(){
        return noteNumber;
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

        if (( index==0)||(index==7)||(index==21)||(index==14)) {
            note = "mi";
            System.out.println("mi");
            noteNumber = 2;
        }
        if (( index==1)||(index==8)||(index==22)||(index==15)) {
            note = "fa";
            System.out.println("fa");
            noteNumber = 3;
        }
        if (( index==2)||(index==9)||(index==16)) {
            note="sol";
            System.out.println("sol");
            noteNumber = 4;
        }
        if (( index==3)||(index==10)||(index==17)) {
            note ="la";
            System.out.println("la");
            noteNumber = 5;
        }
        if (( index==4)||(index==11)||(index==18)) {
            note="si";
            System.out.println("si");
            noteNumber = 6;
        }
        if (( index==5)||(index==12)||(index==19)) {
            note="do";
            System.out.println("do");
            noteNumber = 0;
        }
        if (( index==6)||(index==13)||(index==20)) {
            note="re";
            System.out.println("re");
            noteNumber = 1;
        }
        return index;
    }

    public void act(float delta) {
        super.act(delta);
        if  (GameManager.ourInstance.getGameState()==GameState.MOVE) {
            position.x -= 0.9;
        }
        if (position.x <= 25){
            remove();
        }
    }
}
