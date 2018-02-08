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
    private BitmapFont font;
    private TextureAtlas.AtlasRegion textureBackground;

    public MenuScreen(TanksGame tanksGame) {
        parent = tanksGame;
        /// create stage and set it as input processor
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        font = Assets.getInstance().getAssetManager().get("zorque48.ttf", BitmapFont.class);
        textureBackground = Assets.getInstance().getAtlas().findRegion("background");

//        parent.assMan.queueAddSkin();
//        parent.assMan.manager.finishLoading();
//        skin = Assets.getInstance().getMenuSkin();
//        skin = new Skin(Gdx.files.internal("menuSkin.json"));
//
//        Gdx.input.setInputProcessor(stage);
//        // Create a table that fills the screen. Everything else will go inside this table.
//        Table table = new Table();
//        table.setFillParent(true);
//        table.setDebug(true);
//        stage.addActor(table);
//
//
//        //create buttons
//        TextButton newGame = new TextButton("New Game", skin);
//        TextButton exit = new TextButton("Exit", skin);
//
//        //add buttons to table
//        table.add(newGame).fillX().uniformX();
//        table.row().pad(10, 0, 10, 0);
//        table.add(exit).fillX().uniformX();
    }

    @Override
    public void render(float delta) {
        parent.getBatch().begin();
        parent.getBatch().draw(textureBackground, 0, 0);
        parent.getFont48().draw(parent.getBatch(), "New Game", Gdx.graphics.getWidth()/2-100, Gdx.graphics.getHeight()/2 + 100);
        parent.getFont48().draw(parent.getBatch(), "Quit", Gdx.graphics.getWidth()/2-50, Gdx.graphics.getHeight()/2);
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
