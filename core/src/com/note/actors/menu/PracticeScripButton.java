package com.note.actors.menu;


import com.badlogic.gdx.math.Rectangle;
import com.note.utils.Constants;

public class PracticeScripButton extends GameButton {

    private PracticeScripButtonListener listener;

    public interface PracticeScripButtonListener {
        public void onStart();
    }

    public PracticeScripButton(Rectangle bounds, PracticeScripButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.LEARNING_SCRIP_MID_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onStart();

    }
}
