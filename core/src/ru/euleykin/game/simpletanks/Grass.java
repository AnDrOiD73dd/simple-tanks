package ru.euleykin.game.simpletanks;

import com.badlogic.gdx.graphics.Texture;

public class Grass {

    private Texture texture;

    public Grass() {
        this.texture = new Texture("grass_texture.png");
    }

    public Texture getTexture() {
        return texture;
    }
}
