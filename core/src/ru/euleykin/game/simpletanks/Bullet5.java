package ru.euleykin.game.simpletanks;

import ru.euleykin.game.simpletanks.model.Bullet;

public class Bullet5 extends Bullet {

    public Bullet5(float posX, float posY, float velocityX, float velocityY) {
        super(posX, posY, velocityX, velocityY, "tank_bullet5.png");
        super.getSprite().setPosition(posX, posY);
        super.getSprite().setOrigin(0,0);
    }
}
