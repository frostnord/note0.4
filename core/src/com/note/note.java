package com.note;

import com.note.screens.DirectedGame;
import com.note.screens.FirstMenuScreen;

public class Note extends DirectedGame {




    @Override
    public void create() {

        this.setScreen(new FirstMenuScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();

    }

}
