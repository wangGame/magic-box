package viewport3D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;

public class CommonViewport extends Viewport3D{

    public CommonViewport(){
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        camera.position.set(5f, 5f, 5f);
        camera.position.set(5f, 5f, 5f);
        camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update(true);
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 1, 1, 1, 0.8f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, 1, 1, 1));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1, -1, -1));
    }


    @Override
    public void upate(float width, float hight) {

    }
}
