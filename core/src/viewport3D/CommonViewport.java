package viewport3D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;

public class CommonViewport extends Viewport3D{

    public CommonViewport(){
        camera = new PerspectiveCamera(67, 0.01f,0.01f);
//        camera.position.set(5f, 5f, 5f);
        camera.position.set(10f, 10, 10f);
        camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update(true);
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 1, 1, 1, 0.8f));
//        environment.add(new DirectionalLight().set(1f, 1f, 1f, -6, -4, -7));
        environment.set(new ColorAttribute(ColorAttribute.Fog,0,0,0,1));


    }


    @Override
    public void upate(float width, float hight) {

    }
}
