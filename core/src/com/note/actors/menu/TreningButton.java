package com.note.actors.menu;


import com.badlogic.gdx.math.Rectangle;
import com.note.utils.Constants;

public class TreningButton extends GameButton {


    public interface TreningButtonListener {
        public void onStart();
    }

    private TreningButtonListener listener;

    public TreningButton(Rectangle bounds, TreningButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.TRENING_SCRIP_LEFT_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onStart();
    }
}
