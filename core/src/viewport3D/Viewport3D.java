package viewport3D;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract class Viewport3D {
    protected PerspectiveCamera camera;
    protected Environment environment;
    public void upate(float width,float hight){

    }

    public Camera getCamera(){
        return camera;
    }


    private final Vector3 tmp = new Vector3();
    private int screenX = 0, screenY = 0, screenWidth = 10, screenHeight = 10;

    public Vector2 unproject (Vector2 screenCoords) {
        tmp.set(screenCoords.x, screenCoords.y, 1);
        camera.unproject(tmp, screenX, screenY, screenWidth, screenHeight);
        screenCoords.set(tmp.x, tmp.y);
        return screenCoords;
    }


    public Environment getEnvironment() {
        return environment;
    }

}
