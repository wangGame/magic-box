package listener;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import group3.CubeManager;

public class ClickListener3D extends InputAdapter {

    private CubeManager manager;
    public ClickListener3D(CubeManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean keyDown(int keycode) {
        boolean consumed = false;
        switch(keycode) {
            case Input.Keys.Q:
                manager.backRotation90();
                consumed = true;
                break;
            case Input.Keys.W:
                manager.backMiddleRotation90();
                consumed = true;
                break;
            case Input.Keys.E:
                manager.frontRotation90();
                consumed = true;
                break;
            case Input.Keys.A:
                manager.leftRotation90();
                consumed = true;
                break;
            case Input.Keys.S:
                manager.leftMiddleRotation90();
                consumed = true;
                break;
            case Input.Keys.D:
                manager.rightRotation90();
                consumed = true;
                break;
            case Input.Keys.Z:
                manager.bottomRotation90();
                consumed = true;
                break;
            case Input.Keys.X:
                manager.bottomMiddleRotation90();
                consumed = true;
                break;
            case Input.Keys.C:
                manager.upRotation90();
                consumed = true;
                break;
            case Input.Keys.R:
                manager.showF();
                consumed = true;
                break;
            case Input.Keys.T:
                consumed = true;
                break;
            case Input.Keys.B:

        }

        return consumed || super.keyDown(keycode);
    }
}
