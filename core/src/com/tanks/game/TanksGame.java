package com.tanks.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TanksGame extends Game {
    public BitmapFont getFont48() {
        return font48;
    }

    private BitmapFont font48;

    public BitmapFont getFont12() {
        return font12;
    }

    private BitmapFont font12;

    public SpriteBatch getBatch() {
        return batch;
    }

    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        ScreenManager.getInstance().init(this, batch);
        ScreenManager.getInstance().switchScreen(ScreenManager.ScreenType.MENU);
        font12 = Assets.getInstance().getAssetManager().get("zorque12.ttf", BitmapFont.class);
        font48 = Assets.getInstance().getAssetManager().get("zorque48.ttf", BitmapFont.class);
    }


    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        getScreen().render(dt);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
