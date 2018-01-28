package ru.euleykin.game.simpletanks.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import ru.euleykin.game.simpletanks.model.Renderable;

public class Packet implements Renderable {

    private Vector2 position;
    private Vector2 velocity;
    private Texture texture;
    private Sprite sprite;

    public Packet(float posX, float posY, float velocityX, float velocityY, String texturePath) {
        this.position = new Vector2(posX, posY);
        this.velocity = new Vector2(velocityX, velocityY);
        this.texture = new Texture(texturePath);
        sprite = new Sprite(texture);
        sprite.setPosition(posX, posY);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Texture getTexture() {
        return texture;
    }

    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
