package com.tanks.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen implements Screen {

    private TanksGame parent;
    private Stage stage;
    private Skin skin;
    private BitmapFont font48;
    private TextureAtlas.AtlasRegion textureBackground;

    public MenuScreen(TanksGame tanksGame) {
        parent = tanksGame;
        /// create stage and set it as input processor
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        font48 = Assets.getInstance().getAssetManager().get("zorque48.ttf", BitmapFont.class);
        textureBackground = Assets.getInstance().getAtlas().findRegion("background");
    }

    @Override
    public void render(float delta) {

        parent.getBatch().begin();
        parent.getBatch().draw(textureBackground, 0, 0);
        font48.draw(parent.getBatch(), "New Game", Gdx.graphics.getWidth()/2-100, Gdx.graphics.getHeight()/2 + 100);
        font48.draw(parent.getBatch(), "Quit", Gdx.graphics.getWidth()/2-50, Gdx.graphics.getHeight()/2);
        parent.getBatch().end();

        if (Gdx.input.justTouched()) {
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();
            if (getRectangleNewGame().contains(x, y))
            {
                ScreenManager.getInstance().switchScreen(ScreenManager.ScreenType.GAME);
                dispose();
            } else if (getRectangleQuitGame().contains(x, y))
            {
                dispose();
                Gdx.app.exit();
            }
        }
    }

    private Rectangle getRectangleNewGame()
    {
        return new Rectangle(Gdx.graphics.getWidth()/2-100, Gdx.graphics.getHeight()/2 - 100, 200, 50);
    }

    private Rectangle getRectangleQuitGame()
    {
        return new Rectangle(Gdx.graphics.getWidth()/2-5, Gdx.graphics.getHeight()/2, 100, 50);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
