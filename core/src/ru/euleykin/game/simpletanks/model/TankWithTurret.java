package ru.euleykin.game.simpletanks.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import ru.euleykin.game.simpletanks.model.Tank;
import ru.euleykin.game.simpletanks.model.Turret;

public abstract class TankWithTurret extends Tank {

    protected Turret turret;
    protected Sprite turretSprite;

    public TankWithTurret(String tankTexturePath,
                          float posX, float posY,
                          String turretPath,
                          float turretX, float turretY) {
        super(posX, posY, tankTexturePath);
        turret = new Turret(new Vector2(turretX,turretY), new Vector2(100,100), new Texture(turretPath));
        turretSprite = new Sprite(turret.getTexture());
    }

    public TankWithTurret(String texturePath,
                          float posX, float posY,
                          float velocityX, float velocityY,
                          String turretPath,
                          float turretX, float turretY) {
        super(posX, posY, texturePath, velocityX, velocityY);
        turret = new Turret(new Vector2(turretX,turretY), new Vector2(100,100), new Texture(turretPath));
        turretSprite = new Sprite(turret.getTexture());
    }

    public Turret getTurret() {
        return turret;
    }

    public Sprite getTurretSprite() {
        return turretSprite;
    }

    @Override
    public void render(SpriteBatch batch) {
        turretSprite.draw(batch);
        super.render(batch);
    }
}
