package ru.euleykin.game.simpletanks.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import ru.euleykin.game.simpletanks.model.Movable;
import ru.euleykin.game.simpletanks.model.Player;
import ru.euleykin.game.simpletanks.model.Renderable;

public class Tank extends Player implements Movable, Renderable {

    private Vector2 velocity;

    public Tank(float posX, float posY, String tankTexturePath) {
        super(posX, posY, tankTexturePath);
        this.velocity = new Vector2(0.0f, 0.0f);
    }

    public Tank(float posX, float posY, String texturePath, float velocityX, float velocityY) {
        super(posX, posY, texturePath);
        this.velocity = new Vector2(velocityX, velocityY);
    }

    @Override
    public void move() {
        position.add(velocity);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - radius.x, position.y - radius.y);
    }
}
