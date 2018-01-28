package ru.euleykin.game.simpletanks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class MovablePlayer extends Player implements Movable {

    public MovablePlayer(float x, float y, String texturePath) {
        position = new Vector2(x, y);
        texture = new Texture(texturePath);
    }

    @Override
    public void move(Vector2 offset) {
        position.add(offset);
    }
}
