package game3D;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

import sence.Sence3D;

public class Game3D implements ApplicationListener {
    private Sence3D sence;
    @Override
    public void create() {

    }

    public void setSence(Sence3D sence) {
        if (this.sence != null) {
            this.sence.hide();
        }
        this.sence = sence;
        this.sence.show();
    }

    @Override
    public void resize(int width, int height) {
        sence.resize(width,height);
    }

    @Override
    public void render() {
        sence.render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void pause() {
        sence.pause();
    }

    @Override
    public void resume() {
        sence.resume();
    }

    @Override
    public void dispose() {
        sence.dispose();
    }
}
