package com.note.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements AssetErrorListener, Disposable {
    public static final String TAG = Assets.class.getName();
    public static final Assets instance = new Assets();
    private AssetManager assetManager;
    public AssetNote note;
    public AssetFonts fonts;
    public AssetDecoration decoration;
    public AssetNoteImg noteImg;


    private Assets() {
    }

    @Override
    public void dispose() {
        this.assetManager.dispose();
        this.fonts.defaultSmall.dispose();
        this.fonts.defaultNormal.dispose();
//        this.fonts.defaultBig.dispose();
        this.fonts.levelComplete.dispose();
        this.fonts.levelCompleted.dispose();
//        this.fonts.selectCharacter.dispose();
//        this.fonts.selectLevel.dispose();
        this.fonts.heroInfo.dispose();
//        this.fonts.heroStore.dispose();
    }

    @Override
    public void error(AssetDescriptor assetDescriptor, Throwable throwable) {
    }

    public void error(String string, Class class_, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '" + string + "'", (Throwable)((Exception)throwable));
    }

    public class AssetNoteImg {

        public final AtlasRegion doKeyImg;
        public final AtlasRegion reKeyImg;
        public final AtlasRegion solKeyImg;
        public final AtlasRegion laKeyImg;
        public final AtlasRegion siKeyImg;
        public final AtlasRegion miKeyImg;


        public AssetNoteImg(TextureAtlas atlas) {
            doKeyImg = atlas.findRegion("doKeyImg");
            miKeyImg = atlas.findRegion("miKeyImg");
            reKeyImg = atlas.findRegion("reKeyImg");
            solKeyImg = atlas.findRegion("solKeyImg");
            laKeyImg = atlas.findRegion("laKeyImg");
            siKeyImg = atlas.findRegion("siKeyImg");
        }

    }

    public class AssetNote {
        public final AtlasRegion noteRedDo;
        public final AtlasRegion noteOrangeRe;
        public final AtlasRegion noteYellowMi;
        public final AtlasRegion noteBlueSol;
        public final AtlasRegion noteGreenFa;
        public final AtlasRegion noteSiniiLa;
        public final AtlasRegion notePurpleSi;
        public final AtlasRegion note_grey;

        public AssetNote (TextureAtlas atlas) {
            noteRedDo = atlas.findRegion("noteRedDo");
            noteOrangeRe = atlas.findRegion("noteOrangeRe");
            noteYellowMi = atlas.findRegion("noteYellowMi");
            noteGreenFa = atlas.findRegion("noteGreenFa");
            noteBlueSol = atlas.findRegion("noteBlueSol");
            noteSiniiLa = atlas.findRegion("noteSiniiLa");
            notePurpleSi = atlas.findRegion("notePurpleSi");
            note_grey = atlas.findRegion("note_grey");
        }
    }
    public class AssetDecoration {
        public final TextureAtlas.AtlasRegion lineImg;

        public AssetDecoration(TextureAtlas atlas) {
            this.lineImg = atlas.findRegion("lineImg");
        }
    }


    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.setErrorListener(this);
//        assetManager.load("sprites.atlas", TextureAtlas.class);
//        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get("sprites.atlas");
        for (Texture t : atlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }


        Gdx.app.debug(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);
        for (String string : assetManager.getAssetNames()) {
            Gdx.app.debug(TAG, "asset: " + string);
        }
        note = new AssetNote(atlas);
        this.fonts = new AssetFonts();
        decoration= new AssetDecoration(atlas);
        this.noteImg = new AssetNoteImg(atlas);

    }

    public void load(AssetManager assetManager) {
        this.assetManager = assetManager;
        assetManager.load("sounds/jump.wav", Sound.class);
        assetManager.load("sounds/pickup_coin.wav", Sound.class);
        assetManager.load("sounds/gun_shot.wav", Sound.class);
        assetManager.load("sounds/hero_hurt.wav", Sound.class);
        assetManager.load("sounds/unearth1.wav", Sound.class);
        assetManager.load("sounds/unearth2.wav", Sound.class);
        assetManager.load("sounds/unearth3.wav", Sound.class);
        assetManager.load("sounds/unearth4.wav", Sound.class);
        assetManager.load("sounds/item_purchased.mp3", Sound.class);
        assetManager.load("sounds/stopwatch.mp3", Sound.class);
        assetManager.load("music/main_game1.wav", Music.class);
        assetManager.load("music/menu_loop.wav", Music.class);
        assetManager.load("music/level_complete.mp3", Music.class);
        assetManager.load("music/game_over.mp3", Music.class);
        assetManager.load("images/runandgun.atlas", TextureAtlas.class);
    }

    public class AssetBullet {
        public final Animation animBullet;

        public AssetBullet(TextureAtlas textureAtlas) {
            this.animBullet = new Animation(0.2f, textureAtlas.findRegions("details/anim_gun_bullet"), Animation.PlayMode.NORMAL);
        }
    }

    public class AssetFonts {
//        public final BitmapFont defaultBig;
        public final BitmapFont defaultNormal;
        public final BitmapFont defaultSmall;
        public final BitmapFont heroInfo;
//        public final BitmapFont heroStore;
        public final BitmapFont levelComplete;
        public final BitmapFont levelCompleted;
//        public final BitmapFont selectCharacter;
//        public final BitmapFont selectLevel;

        public AssetFonts() {
            FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("PartnerCondensedMono.ttf"));
            FreeTypeFontGenerator.FreeTypeFontParameter freeTypeFontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            freeTypeFontParameter.size = 15;
            this.defaultSmall = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
            this.defaultSmall.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            this.defaultSmall.setScale(1.0f, -1.0f);
            freeTypeFontParameter.size = 20;
            this.heroInfo = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
            this.heroInfo.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            this.heroInfo.setScale(1.0f, 1.0f);
            freeTypeFontParameter.size = 25;
            this.defaultNormal = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
            this.defaultNormal.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            this.defaultNormal.setScale(1.0f, -1.0f);
//            this.heroStore = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
//            this.heroStore.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//            this.heroStore.setScale(1.0f, 1.0f);
//            freeTypeFontParameter.size = 30;
//            this.defaultBig = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
//            this.defaultBig.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//            this.defaultBig.setScale(1.0f, -1.0f);
            this.levelComplete = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
            this.levelComplete.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            this.levelComplete.setScale(1.0f, 1.0f);
            freeTypeFontParameter.size = 35;
            this.levelCompleted = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
            this.levelCompleted.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            this.levelCompleted.setScale(1.0f, 1.0f);
            freeTypeFontParameter.size = 40;
//            this.selectLevel = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
//            this.selectLevel.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//            this.selectLevel.setScale(1.0f, 1.0f);
//            freeTypeFontParameter.size = 65;
//            this.selectCharacter = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
//            this.selectCharacter.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//            this.selectCharacter.setScale(1.0f, 1.0f);
            freeTypeFontGenerator.dispose();
        }
    }

    public class AssetHero {
        public final Animation animDead;
        public final Animation animDesertStormDead;
        public final Animation animDesertStormDying;
        public final Animation animDesertStormIdle;
        public final Animation animDesertStormJump;
        public final Animation animDesertStormJumpShoot;
        public final Animation animDesertStormRun;
        public final Animation animDesertStormShoot;
        public final Animation animDying;
        public final Animation animIdle;
        public final Animation animJump;
        public final Animation animJumpShoot;
        public final Animation animRun;
        public final Animation animShoot;
        public final Animation animSpecialForcesDead;
        public final Animation animSpecialForcesDying;
        public final Animation animSpecialForcesIdle;
        public final Animation animSpecialForcesJump;
        public final Animation animSpecialForcesJumpShoot;
        public final Animation animSpecialForcesRun;
        public final Animation animSpecialForcesShoot;
        public final Animation animStealthDead;
        public final Animation animStealthDying;
        public final Animation animStealthIdle;
        public final Animation animStealthJump;
        public final Animation animStealthJumpShoot;
        public final Animation animStealthRun;
        public final Animation animStealthShoot;
        public final Animation animSwatDead;
        public final Animation animSwatDying;
        public final Animation animSwatIdle;
        public final Animation animSwatJump;
        public final Animation animSwatJumpShoot;
        public final Animation animSwatRun;
        public final Animation animSwatShoot;

        public AssetHero(TextureAtlas textureAtlas) {
            this.animIdle = new Animation(0.1f, textureAtlas.findRegions("main_hero/anim_hero_idle"), Animation.PlayMode.LOOP_PINGPONG);
            this.animRun = new Animation(0.04f, textureAtlas.findRegions("main_hero/anim_hero_running"), Animation.PlayMode.LOOP);
            this.animJump = new Animation(1.0f, textureAtlas.findRegions("main_hero/anim_hero_jumping"), Animation.PlayMode.NORMAL);
            this.animJumpShoot = new Animation(0.04f, textureAtlas.findRegions("main_hero/anim_hero_jump_shoot"), Animation.PlayMode.NORMAL);
            this.animShoot = new Animation(0.04f, textureAtlas.findRegions("main_hero/anim_hero_shooting"), Animation.PlayMode.NORMAL);
            this.animDying = new Animation(0.25f, textureAtlas.findRegions("main_hero/anim_hero_dying"), Animation.PlayMode.NORMAL);
            this.animDead = new Animation(1.0f, textureAtlas.findRegions("main_hero/anim_hero_dead"), Animation.PlayMode.NORMAL);
            this.animSpecialForcesIdle = new Animation(0.1f, textureAtlas.findRegions("special_forces_hero/anim_hero_idle"), Animation.PlayMode.LOOP_PINGPONG);
            this.animSpecialForcesRun = new Animation(0.04f, textureAtlas.findRegions("special_forces_hero/anim_hero_running"), Animation.PlayMode.LOOP);
            this.animSpecialForcesJump = new Animation(1.0f, textureAtlas.findRegions("special_forces_hero/anim_hero_jumping"), Animation.PlayMode.NORMAL);
            this.animSpecialForcesJumpShoot = new Animation(0.04f, textureAtlas.findRegions("special_forces_hero/anim_hero_jump_shoot"), Animation.PlayMode.NORMAL);
            this.animSpecialForcesShoot = new Animation(0.04f, textureAtlas.findRegions("special_forces_hero/anim_hero_shooting"), Animation.PlayMode.NORMAL);
            this.animSpecialForcesDying = new Animation(0.25f, textureAtlas.findRegions("special_forces_hero/anim_hero_dying"), Animation.PlayMode.NORMAL);
            this.animSpecialForcesDead = new Animation(1.0f, textureAtlas.findRegions("special_forces_hero/anim_hero_dead"), Animation.PlayMode.NORMAL);
            this.animDesertStormIdle = new Animation(0.1f, textureAtlas.findRegions("desert_storm_hero/anim_hero_idle"), Animation.PlayMode.LOOP_PINGPONG);
            this.animDesertStormRun = new Animation(0.04f, textureAtlas.findRegions("desert_storm_hero/anim_hero_running"), Animation.PlayMode.LOOP);
            this.animDesertStormJump = new Animation(1.0f, textureAtlas.findRegions("desert_storm_hero/anim_hero_jumping"), Animation.PlayMode.NORMAL);
            this.animDesertStormJumpShoot = new Animation(0.04f, textureAtlas.findRegions("desert_storm_hero/anim_hero_jump_shoot"), Animation.PlayMode.NORMAL);
            this.animDesertStormShoot = new Animation(0.04f, textureAtlas.findRegions("desert_storm_hero/anim_hero_shooting"), Animation.PlayMode.NORMAL);
            this.animDesertStormDying = new Animation(0.25f, textureAtlas.findRegions("desert_storm_hero/anim_hero_dying"), Animation.PlayMode.NORMAL);
            this.animDesertStormDead = new Animation(1.0f, textureAtlas.findRegions("desert_storm_hero/anim_hero_dead"), Animation.PlayMode.NORMAL);
            this.animSwatIdle = new Animation(0.1f, textureAtlas.findRegions("swat_hero/anim_hero_idle"), Animation.PlayMode.LOOP_PINGPONG);
            this.animSwatRun = new Animation(0.04f, textureAtlas.findRegions("swat_hero/anim_hero_running"), Animation.PlayMode.LOOP);
            this.animSwatJump = new Animation(1.0f, textureAtlas.findRegions("swat_hero/anim_hero_jumping"), Animation.PlayMode.NORMAL);
            this.animSwatJumpShoot = new Animation(0.04f, textureAtlas.findRegions("swat_hero/anim_hero_jump_shoot"), Animation.PlayMode.NORMAL);
            this.animSwatShoot = new Animation(0.04f, textureAtlas.findRegions("swat_hero/anim_hero_shooting"), Animation.PlayMode.NORMAL);
            this.animSwatDying = new Animation(0.25f, textureAtlas.findRegions("swat_hero/anim_hero_dying"), Animation.PlayMode.NORMAL);
            this.animSwatDead = new Animation(1.0f, textureAtlas.findRegions("swat_hero/anim_hero_dead"), Animation.PlayMode.NORMAL);
            this.animStealthIdle = new Animation(0.1f, textureAtlas.findRegions("stealth_hero/anim_hero_idle"), Animation.PlayMode.LOOP_PINGPONG);
            this.animStealthRun = new Animation(0.04f, textureAtlas.findRegions("stealth_hero/anim_hero_running"), Animation.PlayMode.LOOP);
            this.animStealthJump = new Animation(1.0f, textureAtlas.findRegions("stealth_hero/anim_hero_jumping"), Animation.PlayMode.NORMAL);
            this.animStealthJumpShoot = new Animation(0.04f, textureAtlas.findRegions("stealth_hero/anim_hero_jump_shoot"), Animation.PlayMode.NORMAL);
            this.animStealthShoot = new Animation(0.04f, textureAtlas.findRegions("stealth_hero/anim_hero_shooting"), Animation.PlayMode.NORMAL);
            this.animStealthDying = new Animation(0.25f, textureAtlas.findRegions("stealth_hero/anim_hero_dying"), Animation.PlayMode.NORMAL);
            this.animStealthDead = new Animation(1.0f, textureAtlas.findRegions("stealth_hero/anim_hero_dead"), Animation.PlayMode.NORMAL);
        }
    }

    public class AssetLevelDecoration {
        public final Animation animGoldCoin;
        public final TextureAtlas.AtlasRegion blankStone;
        public final TextureAtlas.AtlasRegion coinsContainer;
        public final TextureAtlas.AtlasRegion crossStone;
        public final TextureAtlas.AtlasRegion fenceLeft;
        public final TextureAtlas.AtlasRegion fenceMiddle;
        public final TextureAtlas.AtlasRegion fenceRight;
        public final TextureAtlas.AtlasRegion fullStone;
        public final TextureAtlas.AtlasRegion goal;
        public final TextureAtlas.AtlasRegion healthBar;
        public final TextureAtlas.AtlasRegion heart;
        public final TextureAtlas.AtlasRegion heartContainer;
        public final TextureAtlas.AtlasRegion nightBackground;
        public final TextureAtlas.AtlasRegion signForward;
        public final TextureAtlas.AtlasRegion signQuestion;
        public final TextureAtlas.AtlasRegion signSkull;
        public final TextureAtlas.AtlasRegion signWrong;
        public final TextureAtlas.AtlasRegion spike;
        public final TextureAtlas.AtlasRegion tallPlant;
        public final TextureAtlas.AtlasRegion tree1;
        public final TextureAtlas.AtlasRegion tree2;
        public final TextureAtlas.AtlasRegion zombieContainer;

        public AssetLevelDecoration(TextureAtlas textureAtlas) {
            this.heartContainer = textureAtlas.findRegion("details/heart_container");
            this.heart = textureAtlas.findRegion("details/heart");
            this.coinsContainer = textureAtlas.findRegion("details/coins_container");
            this.zombieContainer = textureAtlas.findRegion("details/zombie_container");
            this.goal = textureAtlas.findRegion("platform_tiles/night_level/goal");
            this.spike = textureAtlas.findRegion("platform_tiles/night_level/spike");
            this.nightBackground = textureAtlas.findRegion("backgrounds/night_background");
            this.healthBar = textureAtlas.findRegion("details/health_bar");
            this.tree1 = textureAtlas.findRegion("details/hole_tree");
            this.tree2 = textureAtlas.findRegion("details/leaning_tree");
            this.tallPlant = textureAtlas.findRegion("details/tall_plant");
            this.blankStone = textureAtlas.findRegion("details/blank_stone");
            this.crossStone = textureAtlas.findRegion("details/cross_stone");
            this.fullStone = textureAtlas.findRegion("details/full_stone");
            this.signForward = textureAtlas.findRegion("details/sign_forward");
            this.signQuestion = textureAtlas.findRegion("details/sign_question");
            this.signSkull = textureAtlas.findRegion("details/sign_skull");
            this.signWrong = textureAtlas.findRegion("details/sign_wrong");
            this.fenceLeft = textureAtlas.findRegion("details/fence_left");
            this.fenceMiddle = textureAtlas.findRegion("details/fence_middle");
            this.fenceRight = textureAtlas.findRegion("details/fence_right");
            this.animGoldCoin = new Animation(0.125f, textureAtlas.findRegions("details/anim_coin"), Animation.PlayMode.LOOP);
        }
    }

    public class AssetMusic {
        public final Music actionMenu;
        public final Music gameOver;
        public final Music levelComplete;
        public final Music mainGame1;

        public AssetMusic(AssetManager assetManager) {
            this.mainGame1 = (Music)assetManager.get("music/main_game1.wav", Music.class);
            this.actionMenu = (Music)assetManager.get("music/menu_loop.wav", Music.class);
            this.levelComplete = (Music)assetManager.get("music/level_complete.mp3", Music.class);
            this.gameOver = (Music)assetManager.get("music/game_over.mp3", Music.class);
        }
    }

    public class AssetNightRock {
        public final TextureAtlas.AtlasRegion green_bottom_left;
        public final TextureAtlas.AtlasRegion green_bottom_middle;
        public final TextureAtlas.AtlasRegion green_bottom_right;
        public final TextureAtlas.AtlasRegion green_float_left;
        public final TextureAtlas.AtlasRegion green_float_middle;
        public final TextureAtlas.AtlasRegion green_float_right;
        public final TextureAtlas.AtlasRegion green_middle_left;
        public final TextureAtlas.AtlasRegion green_middle_middle;
        public final TextureAtlas.AtlasRegion green_middle_right;
        public final TextureAtlas.AtlasRegion green_top_left;
        public final TextureAtlas.AtlasRegion green_top_middle;
        public final TextureAtlas.AtlasRegion green_top_right;

        public AssetNightRock(TextureAtlas textureAtlas) {
            this.green_bottom_left = textureAtlas.findRegion("platform_tiles/night_level/green_bottom_left");
            this.green_bottom_middle = textureAtlas.findRegion("platform_tiles/night_level/green_bottom_middle");
            this.green_bottom_right = textureAtlas.findRegion("platform_tiles/night_level/green_bottom_right");
            this.green_top_left = textureAtlas.findRegion("platform_tiles/night_level/green_top_left");
            this.green_top_middle = textureAtlas.findRegion("platform_tiles/night_level/green_top_middle");
            this.green_top_right = textureAtlas.findRegion("platform_tiles/night_level/green_top_right");
            this.green_middle_left = textureAtlas.findRegion("platform_tiles/night_level/green_middle_left");
            this.green_middle_middle = textureAtlas.findRegion("platform_tiles/night_level/green_middle_middle");
            this.green_middle_right = textureAtlas.findRegion("platform_tiles/night_level/green_middle_right");
            this.green_float_left = textureAtlas.findRegion("platform_tiles/night_level/green_float_left");
            this.green_float_middle = textureAtlas.findRegion("platform_tiles/night_level/green_float_middle");
            this.green_float_right = textureAtlas.findRegion("platform_tiles/night_level/green_float_right");
        }
    }

    public class AssetPowerUp {
        public final TextureAtlas.AtlasRegion bomb;
        public final TextureAtlas.AtlasRegion heart;
        public final TextureAtlas.AtlasRegion shield;
        public final TextureAtlas.AtlasRegion watch;

        public AssetPowerUp(TextureAtlas textureAtlas) {
            this.shield = textureAtlas.findRegion("details/powerup_shield");
            this.heart = textureAtlas.findRegion("details/powerup_heart");
            this.bomb = textureAtlas.findRegion("details/powerup_bomb");
            this.watch = textureAtlas.findRegion("details/powerup_watch");
        }
    }

    public class AssetSounds {
        public final Sound gunShot;
        public final Sound heroHurt;
        public final Sound itemPurchased;
        public final Sound jump;
        public final Sound pickupCoinAndPowerUp;
        public final Sound stopWatch;
        public final Sound unearthZombie1;
        public final Sound unearthZombie2;
        public final Sound unearthZombie3;
        public final Sound unearthZombie4;

        public AssetSounds(AssetManager assetManager) {
            this.jump = (Sound)assetManager.get("sounds/jump.wav", Sound.class);
            this.pickupCoinAndPowerUp = (Sound)assetManager.get("sounds/pickup_coin.wav", Sound.class);
            this.gunShot = (Sound)assetManager.get("sounds/gun_shot.wav", Sound.class);
            this.heroHurt = (Sound)assetManager.get("sounds/hero_hurt.wav", Sound.class);
            this.unearthZombie1 = (Sound)assetManager.get("sounds/unearth1.wav", Sound.class);
            this.unearthZombie2 = (Sound)assetManager.get("sounds/unearth2.wav", Sound.class);
            this.unearthZombie3 = (Sound)assetManager.get("sounds/unearth3.wav", Sound.class);
            this.unearthZombie4 = (Sound)assetManager.get("sounds/unearth4.wav", Sound.class);
            this.itemPurchased = (Sound)assetManager.get("sounds/item_purchased.mp3", Sound.class);
            this.stopWatch = (Sound)assetManager.get("sounds/stopwatch.mp3", Sound.class);
        }
    }

    public class AssetZombie {
        public final Animation animBoyDying;
        public final Animation animBoyRising;
        public final Animation animBoyWalking;
        public final Animation animCopDying;
        public final Animation animCopRising;
        public final Animation animCopWalking;
        public final Animation animGirlDying;
        public final Animation animGirlRising;
        public final Animation animGirlWalking;
        public final Animation animMummyDying;
        public final Animation animMummyRising;
        public final Animation animMummyWalking;
        public final Animation animMusclesDying;
        public final Animation animMusclesRising;
        public final Animation animMusclesWalking;
        public final Animation animPotsAndPansDying;
        public final Animation animPotsAndPansRising;
        public final Animation animPotsAndPansWalking;
        public final Animation animWeirdoDying;
        public final Animation animWeirdoRising;
        public final Animation animWeirdoWalking;

        public AssetZombie(TextureAtlas textureAtlas) {
            this.animBoyRising = new Animation(0.1f, textureAtlas.findRegions("zombie_boy/anim_zombie_rising"), Animation.PlayMode.NORMAL);
            this.animBoyWalking = new Animation(0.16666667f, textureAtlas.findRegions("zombie_boy/anim_zombie_walking"), Animation.PlayMode.LOOP);
            this.animBoyDying = new Animation(0.16666667f, textureAtlas.findRegions("zombie_boy/anim_zombie_dead"), Animation.PlayMode.NORMAL);
            this.animGirlRising = new Animation(0.1f, textureAtlas.findRegions("zombie_girl/anim_zombie_rising"), Animation.PlayMode.NORMAL);
            this.animGirlWalking = new Animation(0.16666667f, textureAtlas.findRegions("zombie_girl/anim_zombie_walking"), Animation.PlayMode.LOOP);
            this.animGirlDying = new Animation(0.16666667f, textureAtlas.findRegions("zombie_girl/anim_zombie_dead"), Animation.PlayMode.NORMAL);
            this.animCopRising = new Animation(0.1f, textureAtlas.findRegions("zombie_cop/anim_zombie_rising"), Animation.PlayMode.NORMAL);
            this.animCopWalking = new Animation(0.16666667f, textureAtlas.findRegions("zombie_cop/anim_zombie_walking"), Animation.PlayMode.LOOP);
            this.animCopDying = new Animation(0.16666667f, textureAtlas.findRegions("zombie_cop/anim_zombie_dead"), Animation.PlayMode.NORMAL);
            this.animMummyRising = new Animation(0.1f, textureAtlas.findRegions("zombie_mummy/anim_zombie_rising"), Animation.PlayMode.NORMAL);
            this.animMummyWalking = new Animation(0.16666667f, textureAtlas.findRegions("zombie_mummy/anim_zombie_walking"), Animation.PlayMode.LOOP);
            this.animMummyDying = new Animation(0.16666667f, textureAtlas.findRegions("zombie_mummy/anim_zombie_dead"), Animation.PlayMode.NORMAL);
            this.animMusclesRising = new Animation(0.1f, textureAtlas.findRegions("zombie_muscles/anim_zombie_rising"), Animation.PlayMode.NORMAL);
            this.animMusclesWalking = new Animation(0.16666667f, textureAtlas.findRegions("zombie_muscles/anim_zombie_walking"), Animation.PlayMode.LOOP);
            this.animMusclesDying = new Animation(0.16666667f, textureAtlas.findRegions("zombie_muscles/anim_zombie_dead"), Animation.PlayMode.NORMAL);
            this.animPotsAndPansRising = new Animation(0.1f, textureAtlas.findRegions("zombie_pots_and_pans/anim_zombie_rising"), Animation.PlayMode.NORMAL);
            this.animPotsAndPansWalking = new Animation(0.16666667f, textureAtlas.findRegions("zombie_pots_and_pans/anim_zombie_walking"), Animation.PlayMode.LOOP);
            this.animPotsAndPansDying = new Animation(0.16666667f, textureAtlas.findRegions("zombie_pots_and_pans/anim_zombie_dead"), Animation.PlayMode.NORMAL);
            this.animWeirdoRising = new Animation(0.1f, textureAtlas.findRegions("zombie_weirdo/anim_zombie_rising"), Animation.PlayMode.NORMAL);
            this.animWeirdoWalking = new Animation(0.16666667f, textureAtlas.findRegions("zombie_weirdo/anim_zombie_walking"), Animation.PlayMode.LOOP);
            this.animWeirdoDying = new Animation(0.16666667f, textureAtlas.findRegions("zombie_weirdo/anim_zombie_dead"), Animation.PlayMode.NORMAL);
        }
    }
}
