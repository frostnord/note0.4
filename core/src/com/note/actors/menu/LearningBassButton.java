package com.note.actors.menu;


import com.badlogic.gdx.math.Rectangle;
import com.note.utils.Constants;

public class LearningBassButton extends GameButton {


    public interface LearningBassButtonListener {
        public void onStart();
    }

    private LearningBassButtonListener listener;

    public LearningBassButton(Rectangle bounds, LearningBassButtonListener listener) {
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
