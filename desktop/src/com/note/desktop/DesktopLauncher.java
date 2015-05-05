package com.note.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.note.Note;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 800;
//        config.width = 320;
        config.height = 480;
//        config.height = 240;
//        config.vSyncEnabled = true;
		new LwjglApplication(new Note(), config);
	}
}
