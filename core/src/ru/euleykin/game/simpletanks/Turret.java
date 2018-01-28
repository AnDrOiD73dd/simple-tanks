package ru.euleykin.game.simpletanks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Turret {

    private Vector2 position;
    private Vector2 velocity;
    private Texture texture;

    public Turret(Vector2 position, Vector2 velocity, Texture texture) {
        this.position = position;
        this.velocity = velocity;
        this.texture = texture;
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
}
