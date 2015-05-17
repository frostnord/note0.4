package com.note.utils;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;


public class MyTexturePacker {

    public static void main(String[] args) {
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.paddingX=1;
        settings.paddingY=1;
        settings.debug=false;
        TexturePacker.process(settings,"\\Users\\1\\Desktop\\assets", "\\Projects\\note 0.4\\android\\assets", "sprites");
    }
}