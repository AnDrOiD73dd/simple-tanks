package ru.euleykin.game.simpletanks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class TankWithTurret extends Tank {

    protected Turret turret;

    public TankWithTurret(float posX, float posY, String tankTexturePath, String turretPath) {
        super(posX, posY, tankTexturePath);
        turret = new Turret(new Vector2(0,0),new Vector2(0,0), new Texture(turretPath));
    }

    public TankWithTurret(float posX, float posY, String texturePath, float velocityX, float velocityY, String turretPath) {
        super(posX, posY, texturePath, velocityX, velocityY);
        turret = new Turret(new Vector2(0,0),new Vector2(0,0), new Texture(turretPath));
    }

    public Turret getTurret() {
        return turret;
    }
}
