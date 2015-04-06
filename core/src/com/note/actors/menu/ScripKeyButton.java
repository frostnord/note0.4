package com.note.actors.menu;


import com.badlogic.gdx.math.Rectangle;
import com.note.utils.Constants;

public class ScripKeyButton extends GameButton {

    public interface ScripKeyListener {
        public void onStart();
    }

    private ScripKeyListener listener;

    public ScripKeyButton(Rectangle bounds, ScripKeyListener listener) {
        super(bounds);
        this.listener = listener;
    }
//    @Override
//    public void act(float delta) {
//        super.act(delta);
//        if (GameManager.getInstance().getGameState() != GameState.OVER) {
//            remove();
//        }
//    }

    @Override
    protected String getRegionName() {
        return Constants.SCRIP_BUTTON_REGION_NAME;
    }

    @Override
    public void touched() {
        listener.onStart();

    }
}
