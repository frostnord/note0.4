package com.note.actors.menu;


import com.badlogic.gdx.math.Rectangle;
import com.note.utils.Constants;

public class PracticeBassButton extends GameButton {

    private PracticeBassButtonListener listener;

    public interface PracticeBassButtonListener {
        public void onStart();
    }

    public PracticeBassButton(Rectangle bounds, PracticeBassButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.PRACTICE_BASS_MIDDLE_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onStart();

    }
}
