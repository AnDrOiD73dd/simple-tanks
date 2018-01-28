package ru.euleykin.game.simpletanks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Tank extends Player implements Movable {

    private Vector2 velocity;

    public Tank(float posX, float posY, String texturePath) {
        position = new Vector2(posX, posY);
        texture = new Texture(texturePath);
        center = new Vector2(texture.getWidth()/2, texture.getHeight()/2);
    }

    public Tank(float posX, float posY, String texturePath, float velocityX, float velocityY) {
        position = new Vector2(posX, posY);
        texture = new Texture(texturePath);
        this.velocity = new Vector2(velocityX, velocityY);
    }

    @Override
    public void move() {
        position.add(velocity);
    }
}
