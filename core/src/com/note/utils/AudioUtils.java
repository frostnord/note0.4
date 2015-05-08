package com.note.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;


public class AudioUtils {

    private static final String SOUND_ON_PREFERENCE = "sound_on";

    private static AudioUtils ourInstance = new AudioUtils();

    private AudioUtils() {
    }


    public static AudioUtils getInstance() {
        return ourInstance;
    }
    private Preferences getPreferences() {
        return Gdx.app.getPreferences(GameManager.PREFERENCES_NAME);
    }
    public String getSoundRegionName() {
        boolean soundOn = getPreferences().getBoolean(SOUND_ON_PREFERENCE, true);
        return soundOn ? Constants.SOUND_ON_REGION_NAME : Constants.SOUND_OFF_REGION_NAME;
    }
    public void toggleSound() {
        saveBoolean(SOUND_ON_PREFERENCE, !getPreferences().getBoolean(SOUND_ON_PREFERENCE, true));
    }



    private void saveBoolean(String key, boolean value) {
        Preferences preferences = getPreferences();
        preferences.putBoolean(key, value);
        preferences.flush();
    }
    public static void dispose() {
//        music.dispose();
//        jumpSound.dispose();
//        hitSound.dispose();
    }
}
