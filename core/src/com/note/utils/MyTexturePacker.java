package com.note.utils;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;


public class MyTexturePacker {

    public static void main(String[] args) {
        TexturePacker.Settings settings = new TexturePacker.Settings();
        settings.paddingX=0;
        settings.paddingY=0;
        settings.debug=false;
        TexturePacker.process(settings,"\\Users\\1\\Desktop\\assets", "\\Users\\1\\note 0.3\\android\\assets", "sprites");

    }
}