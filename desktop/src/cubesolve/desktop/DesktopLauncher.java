package cubesolve.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import cubesolve.CubeSolve;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		config.samples = 16; // 4x MSAA
//		config.foregroundFPS = 10000; // Unlimit fps. Setting to 0 makes it drop to 30 w/ continuous rendering off :(
//		config.backgroundFPS = 1; // Limit FPS when not in foreground
//		config.vSyncEnabled = false; // Sync w/ vertical refresh
//		config.useGL30 = true;
		config.width = 700;
		config.height = 700;
		config.resizable = true;

		new LwjglApplication(new CubeSolve(), config);
	}
}
