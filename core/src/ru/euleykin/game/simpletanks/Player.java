package ru.euleykin.game.simpletanks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Player {

    protected Vector2 position;
    protected Texture texture;
    protected Vector2 center;
    protected Vector2 radius;

    public Player(float posX, float posY, String texturePath) {
        texture = new Texture(texturePath);
        position = new Vector2(posX, posY);
        center = new Vector2(posX/2, posY/2);
        radius = new Vector2(texture.getWidth()/2, texture.getHeight()/2);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }

    public Vector2 getCenter() {
        return center;
    }

    public Vector2 getRadius() {
        return radius;
    }
}
