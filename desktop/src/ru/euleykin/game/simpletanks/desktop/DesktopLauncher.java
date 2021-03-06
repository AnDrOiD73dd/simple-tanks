package ru.euleykin.game.simpletanks.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.euleykin.game.simpletanks.GdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GdxGame.WINDOW_WIDTH;
		config.height = GdxGame.WINDOW_HEIGHT;
		new LwjglApplication(new GdxGame(), config);
	}
}
