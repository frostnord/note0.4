package com.note.stages;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.note.actors.Background;
import com.note.actors.Keybord;
import com.note.actors.VertLines;
import com.note.actors.menu.*;
import com.note.utils.Constants;

public class GameStage extends Stage {

    private OrthographicCamera camera;

    private SoundButton soundButton;
    private ScripKeyButton startButton;
    private BassKeyButton bassKeyButton;
    private SettingsButton settingsButton;

    public float index=0;

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;


    public GameStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT,
                new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));

        setUpWorld();
        setupCamera();
        setUpSound();
        setupGorizKeybord();
        setUpSettingsButton();
        setUp1Menu();
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);



    }
    private void setUp1Menu(){
        setUpScripKeyButton();
        setUpBassKeyButton();
    }
    private void setUpSettingsButton() {
        Rectangle aboutButtonBounds = new Rectangle(getCamera().viewportWidth * 23 / 25,
                getCamera().viewportHeight * 13 / 20, getCamera().viewportHeight / 10,
                getCamera().viewportHeight / 10);
        settingsButton = new SettingsButton(aboutButtonBounds, new SettingsButton.SetingsButtonListener() {
            @Override
            public void onStart() {
                clear();
                setUpWorld();
            }
        });
        addActor(settingsButton);
    }

    private void setUpBassKeyButton(){
        Rectangle leaderboardButtonBounds = new Rectangle(getCamera().viewportWidth * 9 / 16,
                getCamera().viewportHeight / 4, getCamera().viewportWidth / 4,
                getCamera().viewportWidth / 4);
        bassKeyButton = new BassKeyButton(leaderboardButtonBounds,
                new BassKeyButton.BassKeyButtonListener() {
                    @Override
                    public void onStart() {
                        clear();
                        setUpWorld();
                        setUpBassPracticeMiddle();
                        setUpBassTreningLeft();
                        setUpBassLerningRight();

                    }
                });
        addActor(bassKeyButton);

    }

    private void setUpWorld() {
        setUpBackground();
    }

    private void setMenu() {
        setUpSound();
    }
    private void setupGorizKeybord(){
        addActor(new Keybord());
    }
    private void setUpBackground() {
        addActor(new Background());
    }
    private void setupVertLines(){
        addActor(new VertLines());
    }
    private void setUpScripKeyButton() { ///////Scrip Key Button
        Rectangle ScripKeyBounds = new Rectangle(getCamera().viewportWidth * 3 / 16,
                getCamera().viewportHeight / 4, getCamera().viewportWidth / 4,
                getCamera().viewportWidth / 4);
        startButton = new ScripKeyButton(ScripKeyBounds, new ScripKeyButton.ScripKeyListener() {
            @Override
            public void onStart() {
                clear();
                setUpWorld();
                setupGorizKeybord();
                setUpScripTreningLeft();
                setUpScripPracticeMiddle();
                setUpScripLerningRight();
            }
        });
        addActor(startButton);
    }
    private void setUpSound() {
        Rectangle soundButtonBounds = new Rectangle(getCamera().viewportWidth / 64,
                getCamera().viewportHeight * 13 / 20, getCamera().viewportHeight / 10,
                getCamera().viewportHeight / 10);
        soundButton = new SoundButton(soundButtonBounds);
        addActor(soundButton);
    }
    private void setupCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();

    }
    public void setupGorizNote(){

//        addActor(new Note());
    }


    private void setUpScripPracticeMiddle() {
        float width = getCamera().viewportHeight / 4;
        System.out.println(width);
        float x = getCamera().viewportWidth * 2 / 4 - width / 2;
        Rectangle rightTutorialBounds = new Rectangle(x, getCamera().viewportHeight * 9 / 20, width,
                width);
        addActor(new PracticeScripButton(rightTutorialBounds, new PracticeScripButton.PracticeScripButtonListener() {
            @Override
            public void onStart() {
                clear();
                setUpWorld();
                setUpScripTreningLeft();
            }
        }));
    }
    private void setUpBassPracticeMiddle() { ///////BASS PRACTICE MIDDLE
        float width = getCamera().viewportHeight / 4;
        System.out.println(width);
        float x = getCamera().viewportWidth * 2 / 4 - width / 2;
        Rectangle rightTutorialBounds = new Rectangle(x, getCamera().viewportHeight * 9 / 20, width,
                width);
        addActor(new PracticeBassButton(rightTutorialBounds, new PracticeBassButton.PracticeBassButtonListener() {
            @Override
            public void onStart() {
//                clear();
                setUpWorld();
                setUpBassPracticeMiddle();
            }
        }));
    }
    private void setUpScripTreningLeft() {
        float width = getCamera().viewportHeight / 4;
        float x = getCamera().viewportWidth / 4 - width / 2;
        Rectangle leftTutorialBounds = new Rectangle(x, getCamera().viewportHeight * 9 / 20, width,
                width);
        addActor(new TreningButton(leftTutorialBounds, new TreningButton.TreningButtonListener() {
            @Override
            public void onStart() {
                clear();
                setUpBackground();
                setupGorizKeybord();
//                setUpWorld();
                setupVertLines();
                setupGorizNote();
                setUpScripTreningLeft();

            }
        }));
    }
    private void setUpBassTreningLeft() {
        float width = getCamera().viewportHeight / 4;
        float x = getCamera().viewportWidth / 4 - width / 2;
        Rectangle leftTutorialBounds = new Rectangle(x, getCamera().viewportHeight * 9 / 20, width,
                width);
        addActor(new TreningBassButton(leftTutorialBounds, new TreningBassButton.TreningBassButtonListener() {
            @Override
            public void onStart() {
                clear();
                setUpWorld();
            }
        }));
    }

    private void setUpScripLerningRight() {
        float width = getCamera().viewportHeight / 4;
        System.out.println(width);
        float x = getCamera().viewportWidth * 3/ 4 - width / 2;
        Rectangle rightTutorialBounds = new Rectangle(x, getCamera().viewportHeight * 9 / 20, width,
                width);
        addActor(new LearningScripButton(rightTutorialBounds, new LearningScripButton.LearningScripButtonListener() {
            @Override
            public void onStart() {
                ////
            }
        }));
    }
    private void setUpBassLerningRight() {
        float width = getCamera().viewportHeight / 4;
        System.out.println(width);
        float x = getCamera().viewportWidth * 3/ 4 - width / 2;
        Rectangle rightTutorialBounds = new Rectangle(x, getCamera().viewportHeight * 9 / 20, width,
                width);
        addActor(new LearningBassButton(rightTutorialBounds, new LearningBassButton.LearningBassButtonListener() {
            @Override
            public void onStart() {
                ////
            }
        }));
    }
    public void act(float delta){
        super.act(delta);

    }

//    private class ScripKeyListener implements ScripKey.ScripKeyListener {
//        @Override
//        public void onStart() {
//            clear();
//            setUpWorld();
//            setUpScripTreningLeft();
//            setUpScripPracticeMiddle();
//            setUpScripLerningRight();
//        }
//    }
//    private class TreningButtonListener implements TreningButton.TreningButtonListener {
//
//        @Override
//        public void onStart() {
//            clear();
//            setUpWorld();
////            setUpStageBase();
////            setUpCharacters();
////            setUpPause();
////            setUpTutorial();
////            onGameResumed();
//        }
//
//    }
//    private class BassKeyListener implements BassKey.BassKeyListener {
//
//        @Override
//        public void onStart() {
//            clear();
//            setUpWorld();
////            setUpStageBase();
////            setUpCharacters();
////            setUpPause();
////            setUpTutorial();
////            onGameResumed();
//        }
//
//    }
}

