package com.tanks.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Tank {
    private Texture textureBase;
    private Texture textureTurret;
    private Vector2 position;
    private Vector2 weaponPosition;
    private TanksGame game;
    private float turretAngle;
    private int hp;
    private int maxHp;
    private float power;
    private float minPower;
    private float maxPower;
    private Circle hitArea;

    public Tank(TanksGame game, Vector2 position) {
        this.game = game;
        this.position = position;
        this.weaponPosition = new Vector2(position).add(20, 26);
        this.textureBase = new Texture("tank.png");
        this.textureTurret = new Texture("weapon.png");
        this.turretAngle = 0.0f;
        this.maxHp = 100;
        this.hp = this.maxHp;
        this.power = 0.0f;
        this.minPower = 0.25f;
        this.maxPower = 2.2f;
        this.hitArea = new Circle(position.x + 64, position.y + 64, 32);
    }

    public Texture getTextureBase() {
        return textureBase;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Circle getHitArea() {
        return hitArea;
    }

    public void render(SpriteBatch batch) {
        batch.draw(textureTurret, weaponPosition.x, weaponPosition.y, 12, 16, 64, 32, 1, 1, turretAngle, 0, 0, 64, 32, false, false);
        batch.draw(textureBase, position.x, position.y);
    }

    public void rotateTurret(int n, float dt) {
        turretAngle += n * 90.0f * dt;
    }

    public void update(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            rotateTurret(1, dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            rotateTurret(-1, dt);
        }
        if (!checkOnGround()) {
            position.y -= 100.0f * dt;
            weaponPosition.set(position).add(20, 26);
        }
        // По удержанию пробела накапливаем мощность
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            power += dt;
        } else {  // <-- выстрел, когда отпустили пробел
            if (power > minPower) {
                power = MathUtils.clamp(power, minPower, maxPower);
                fire();
                power = 0.0f;
            }
        }

        // Перемещаем hitArea вместе с позицией танка
        hitArea.x = position.x;
        hitArea.y = position.y;
    }

    private void fire() {
        float ammoPosX = weaponPosition.x + 12 + 28 * (float) Math.cos(Math.toRadians(turretAngle));
        float ammoPosY = weaponPosition.y + 16 + 28 * (float) Math.sin(Math.toRadians(turretAngle));

        float power = 400.0f * this.power;
        float ammoVelX = power * (float) Math.cos(Math.toRadians(turretAngle));
        float ammoVelY = power * (float) Math.sin(Math.toRadians(turretAngle));

        game.getBulletEmitter().setup(ammoPosX, ammoPosY, ammoVelX, ammoVelY);
    }

    public boolean checkOnGround() {
        for (int i = 25; i < 75; i += 10) {
            if (game.getMap().isGround(position.x + i, position.y + 25)) {
                return true;
            }
        }
        return false;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        System.out.println("HP = " + this.hp);
    }
}
