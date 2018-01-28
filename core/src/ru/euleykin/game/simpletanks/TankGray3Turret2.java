package ru.euleykin.game.simpletanks;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TankGray3Turret2 extends TankWithTurret {

    public TankGray3Turret2(float posX, float posY) {
        super(posX, posY, "tank_grey_3_without_turret.png", "tanks_turret2.png");
        turret.getPosition().x = position.x + radius.x;
        turret.getPosition().y = position.y + 54;
    }

    public TankGray3Turret2(float posX, float posY, float velocityX, float velocityY) {
        super(posX, posY, "tank_grey_3_without_turret.png", velocityX, velocityY, "tanks_turret2.png");
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(turret.getTexture(), turret.getPosition().x - radius.x, turret.getPosition().y - radius.y);
        super.render(batch);
    }
}
