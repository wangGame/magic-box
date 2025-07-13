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

    public Environment getEnvironment() {
        return environment;
    }

}
