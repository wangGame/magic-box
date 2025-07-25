package stage3D;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pools;

import group3.Actor3D;
import group3.Group3D;
import listener.GameController;
import viewport3D.CommonViewport;
import viewport3D.Viewport3D;

public class Stage3D extends InputAdapter implements Disposable {
    private Viewport3D viewport3D;
    private ModelBatch batch;
    private Group3D group3D;
    private GameController controller;

    public Stage3D(Viewport3D viewport3D, ModelBatch batch){
        this.viewport3D = viewport3D;
        this.batch = batch;
        this.group3D = new Group3D();
        controller = new GameController((PerspectiveCamera) viewport3D.getCamera());
    }

    public void act(){
        checkTileTouched();
        group3D.act(Gdx.graphics.getDeltaTime());
    }

    public void draw(){
        batch.begin(viewport3D.getCamera());
        group3D.draw(batch, viewport3D.getEnvironment());
        batch.end();
    }

    public void addActor(Actor3D actor3D) {
        group3D.addActor3d(actor3D);
    }

    public Group3D getRoot() {
        return group3D;
    }

    @Override
    public void dispose() {

    }

//    final Vector3 intersection = new Vector3();
    private void checkTileTouched() {
        if (Gdx.input.justTouched()) {
            System.out.println("touch down ："+Gdx.input.getX()+"    "+Gdx.input.getY());
            Ray pickRay = viewport3D.getCamera().getPickRay(Gdx.input.getX(), Gdx.input.getY());

            float distance = -1;
            Actor3D actor3D = null;
            for (Actor3D child : getRoot().getChildren()) {
                float dist2 = child.hit1(pickRay);
                if (dist2 >= 0f && (distance < 0f || dist2 <= distance)) {
                    actor3D = child;
                    distance = dist2;
                }
            }
            if (actor3D!=null) {
                actor3D.rayTest(pickRay);
            }
        }
    }
}
