package com.note.actors.menu;


import com.badlogic.gdx.math.Rectangle;
import com.note.utils.Constants;

public class TreningBassButton extends GameButton {


    public interface TreningBassButtonListener {
        public void onStart();
    }

    private TreningBassButtonListener listener;

    public TreningBassButton(Rectangle bounds, TreningBassButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.TRENING_BASS_LEFT_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onStart();
    }
}
