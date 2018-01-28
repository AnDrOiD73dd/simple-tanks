package ru.euleykin.game.simpletanks;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.euleykin.game.simpletanks.model.TankWithTurret;

public class TankGray3Turret2 extends TankWithTurret {

    public TankGray3Turret2(float posX, float posY) {
        super("tank_grey_3_without_turret.png", posX, posY, "tanks_turret2.png", posX + 42,posY + 54);
        super.turretSprite.setPosition(turret.getPosition().x - 50, turret.getPosition().y - 35);
        super.turretSprite.setOrigin(0,0);
//        updateTurretPosition();
    }

    public TankGray3Turret2(float posX, float posY, float velocityX, float velocityY) {
        super("tank_grey_3_without_turret.png", posX, posY,  velocityX, velocityY, "tanks_turret2.png", posX + 42,posY + 54);
        super.turretSprite.setPosition(turret.getPosition().x - 50, turret.getPosition().y - 35);
        super.turretSprite.setOrigin(0,0);
//        updateTurretPosition();
    }

    @Override
    public void render(SpriteBatch batch) {
//        updateTurretPosition();
//        batch.draw(turret.getTexture(), turret.getPosition().x - radius.x, turret.getPosition().y - radius.y);
        super.render(batch);
    }

    private void updateTurretPosition() {
        turret.getPosition().x = position.x + radius.x;
        turret.getPosition().y = position.y + 54;
    }
}
