package com.note.actors.menu;

import com.badlogic.gdx.math.Rectangle;
import com.note.utils.Constants;


public class BassKeyButton extends GameButton {

    private BassKeyButtonListener listener;

    public interface BassKeyButtonListener {
        public void onStart();
    }

    public BassKeyButton(Rectangle bounds, BassKeyButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.BASS_BUTTON_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onStart();

    }
}
