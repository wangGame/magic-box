package sence;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;

public interface Sence3D {

    /** Called when this screen becomes the current screen for a {@link Game}. */
    public void show ();

    /** Called when the screen should render itself.
     * @param delta The time in seconds since the last render. */
    public void render (float delta);

    /** @see ApplicationListener#resize(int, int) */
    public void resize (int width, int height);

    /** @see ApplicationListener#pause() */
    public void pause ();

    /** @see ApplicationListener#resume() */
    public void resume ();

    /** Called when this screen is no longer the current screen for a {@link Game}. */
    public void hide ();

    /** Called when this screen should release all resources. */
    public void dispose ();
}
