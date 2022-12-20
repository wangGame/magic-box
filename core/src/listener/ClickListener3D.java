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
        switch(keycode) {
            case Input.Keys.R:
                manager.backRotation90N(0);
                break;
            case Input.Keys.T:
                manager.backRotation90N(1);
                break;
            case Input.Keys.Y:
                manager.backRotation90N(2);
                break;
            case Input.Keys.F:
                manager.leftRotation90N(0);
                break;
            case Input.Keys.G:
                manager.leftRotation90N(1);
                break;
            case Input.Keys.H:
                manager.leftRotation90N(2);
                break;
            case Input.Keys.V:
                manager.bottomRotation90N(0);
                break;
            case Input.Keys.B:
                manager.bottomRotation90N(1);
                break;
            case Input.Keys.N:
                manager.bottomRotation90N(2);
                break;

            case Input.Keys.Q:
                manager.backRotation90(0);
                break;
            case Input.Keys.W:
                manager.backRotation90(1);
                break;
            case Input.Keys.E:
                manager.backRotation90(2);
                break;
            case Input.Keys.A:
                manager.leftRotation90(0);
                break;
            case Input.Keys.S:
//                manager.leftMiddleRotation90();
                manager.leftRotation90(1);
                break;
            case Input.Keys.D:
//                manager.rightRotation90();
                manager.leftRotation90(2);
                break;
            case Input.Keys.Z:
                manager.bottomRotation90(0);
                break;
            case Input.Keys.X:
                manager.bottomRotation90(1);
                break;
            case Input.Keys.C:
                manager.bottomRotation90(2);
                break;
        }

        return super.keyDown(keycode);
    }
}
