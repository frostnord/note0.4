package com.note.actors.menu;

import com.badlogic.gdx.math.Rectangle;
import com.note.utils.Constants;


public class SettingsButton extends GameButton {

    private SetingsButtonListener listener ;

    public interface SetingsButtonListener {
        public void onStart();
    }

    public SettingsButton(Rectangle bounds, SetingsButtonListener listener) {
        super(bounds);
        this.listener = listener;
    }

    @Override
    protected String getRegionName() {
        return Constants.SETTINGS_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onStart();

    }
}
