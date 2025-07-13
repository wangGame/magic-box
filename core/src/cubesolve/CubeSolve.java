package cubesolve;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ai.Solv;
import game3D.Game3D;
import screen.GameScreen;
import screen.LoadingScreen;
import stage3D.Stage3D;
import viewport3D.CommonViewport;
import viewport3D.Viewport3D;

/**
 * Rubik's cube in libgdx
 */
public class CubeSolve extends Game3D {

	public static String[] CONTROLS_INFO = new String[] {
			"---Column---",
			"Q - Rotate Left",
			"W - Rotate Middle",
			"E - Rotate Right",
			"",
			"--Row--",
			"A - Rotate Top",
			"S - Rotate Middle",
			"D - Rotate Bottom",
			"",
			"--Face--",
			"Z - Rotate Front",
			"X - Rotate Middle",
			"C - Rotate Back",
			"",
			"--Other--",
			"R - Randomize",
			"T - Reset"
	};
	private Viewport3D viewport3D;
	private ModelBatch modelBatch;
	private SpriteBatch hudBatch;

	private boolean solved = true;
    private long lastFpsUpdate;
    private Viewport viewport;

	@Override
	public void create() {
		modelBatch = new ModelBatch();
		viewport3D = new CommonViewport();


		hudBatch = new SpriteBatch();
		viewport = new ExtendViewport(500,500);

		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run() {
				setSence(new GameScreen(CubeSolve.this));
			}
		});
//
//		cube = new Cube(3);
//		Gdx.graphics.setContinuousRendering(true);
//		stage = new Stage(new ExtendViewport(500,500),hudBatch);
//		Image image = new Image(new Texture("cubelet.png"));
//		stage.addActor(image);
//		image.addListener(new ClickListener(){
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				super.clicked(event, x, y);
//				Solv.s(cube);
//			}
//		});
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.2f,
				solved ? 0.2f + (1 + (float) Math.sin((System.currentTimeMillis() % 6282) / 200.0f)) * 0.05f : 0.2f,
				0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		super.render();
	}

	@Override
	public void dispose() {
		modelBatch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width,height);
		viewport.apply();
		Constant.width = viewport.getWorldWidth();
		Constant.height = viewport.getWorldHeight();
		viewport3D.upate(width,height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}


	/**
	 * Check whether the cube is solved.
	 * Should be called every time the cube changes.
	 */
	public void updateSolved() {
//		this.solved = cube.isSolved();
//        if(solved) {
//            Gdx.graphics.setTitle("CubeSolve - You Win");
//        } else {
//            Gdx.graphics.setTitle("CubeSolve");
//        }
	}

	private void createControlsCache() {
//		// The controls only matter for desktop since it's the only platform with a keyboard
//		if(Gdx.app.getType().equals(Application.ApplicationType.Desktop)
//				|| Gdx.app.getType().equals(Application.ApplicationType.WebGL)) {
//			controlsCache.clear();
//			float y = fpsFont.getLineHeight();
//			for (int i = CONTROLS_INFO.length - 1; i >= 0; i--) { // Backwards because Y is upside down
//				String s = CONTROLS_INFO[i];
//
//				controlsCache.addText(s, 4, y);
//				y += fpsFont.getLineHeight();
//			}
//		}
	}

    private void updateFpsCache() {
        if(System.currentTimeMillis() - lastFpsUpdate > 1000l) {
//            fpsCache.setText("FPS: " + Gdx.graphics.getFramesPerSecond(),
//					4, Gdx.graphics.getHeight() - 4);
            lastFpsUpdate = System.currentTimeMillis();
        }
    }

	public ModelBatch getModelBatch() {
		return modelBatch;
	}

	public Viewport3D getViewport3D() {
		return viewport3D;
	}

	public SpriteBatch getHudBatch() {
		return hudBatch;
	}

	public Viewport getViewport() {
		return viewport;
	}
}