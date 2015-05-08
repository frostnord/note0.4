package com.note.actors.menu;


import com.badlogic.gdx.math.Rectangle;
import com.note.utils.Constants;

public class LearningScripButton extends GameButton {


    public interface LearningScripButtonListener {
        public void onStart();
    }

    private LearningScripButtonListener listener;

    public LearningScripButton(Rectangle bounds, LearningScripButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.PRACTICE_SCRIP_RIGHT_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onStart();
    }
}
