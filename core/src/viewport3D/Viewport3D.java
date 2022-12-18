package viewport3D;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;

public abstract class Viewport3D {
    protected PerspectiveCamera camera;
    protected Environment environment;
    public abstract void upate(float width,float hight);
    public Camera getCamera(){
        return camera;
    }

    public Environment getEnvironment() {
        return environment;
    }

}
