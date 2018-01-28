package ru.euleykin.game.simpletanks;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.euleykin.game.simpletanks.model.Bullet;

public class GdxGame extends ApplicationAdapter {

    public static final int WINDOW_WIDTH = 1024;
    public static final int WINDOW_HEIGHT = 768;

	private SpriteBatch batch;
	private Grass grass;
	private TankGray3Turret2 playerTank;
	private Bullet5 bullet;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        grass = new Grass();
        initPlayerTank();
        bullet = new Bullet5(
//                playerTank.getTurretSprite().getX() + playerTank.getTurretSprite().getWidth(),
                playerTank.getTurretSprite().getX(),
                playerTank.getTurretSprite().getY(),
                100, 100);
    }

	private void initPlayerTank() {
//	    float centerX = WINDOW_WIDTH / 2;
//	    playerTank = new TankGray3Turret2(centerX, (float) grass.getTexture().getHeight() + 35);
        playerTank = new TankGray3Turret2(50, (float) grass.getTexture().getHeight() + 35, 100.f, 100.0f);
    }

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		Gdx.gl.glClearColor((float)89/255, (float)182/255, (float)255/255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        drawGrass();
        bullet.render(batch);
        playerTank.render(batch);
		batch.end();
	}

    private void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (playerTank.getTurretSprite().getRotation() < 90) {
                playerTank.getTurretSprite().rotate(1);
                bullet.getSprite().rotate(1);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (playerTank.getTurretSprite().getRotation() > -20) {
                playerTank.getTurretSprite().rotate(-1);
                bullet.getSprite().rotate(-1);
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {

        }
	}

	private void drawGrass() {
	    int count = WINDOW_WIDTH/grass.getTexture().getWidth();
	    if (WINDOW_WIDTH/grass.getTexture().getWidth() > 0)
	        count++;
        for (int i = 0; i < count; i++) {
            batch.draw(grass.getTexture(), i * grass.getTexture().getWidth(), 0);
        }
    }
	
	@Override
	public void dispose () {
        grass.getTexture().dispose();
		playerTank.getTexture().dispose();
		playerTank.getTurret().getTexture().dispose();
		bullet.getTexture().dispose();
        batch.dispose();
	}
}
