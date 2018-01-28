package ru.euleykin.game.simpletanks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Player {

    protected Vector2 position;
    protected Texture texture;
    protected Vector2 center;

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector2 getCenter() {
        return center;
    }
}
