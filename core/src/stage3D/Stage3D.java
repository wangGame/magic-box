package stage3D;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pools;

import group3.Actor3D;
import group3.Group3D;
import viewport3D.CommonViewport;
import viewport3D.Viewport3D;

public class Stage3D extends InputAdapter implements Disposable {
    private Viewport3D viewport3D;
    private ModelBatch batch;
    private Group3D group3D;
    public Stage3D(Viewport3D viewport3D, ModelBatch batch){
        this.viewport3D = viewport3D;
        this.batch = batch;
        this.group3D = new Group3D();
    }

    public PerspectiveCamera getCamera(){
        return (PerspectiveCamera) viewport3D.getCamera();
    }


    private final boolean[] pointerTouched = new boolean[20];
    private final int[] pointerScreenX = new int[20];
    private final int[] pointerScreenY = new int[20];
    private final Actor[] pointerOverActors = new Actor[20];
    private final Vector2 tempCoords = new Vector2();

    public void act(){
        group3D.act(Gdx.graphics.getDeltaTime());
    }


    public Vector2 screenToStageCoordinates (Vector2 screenCoords) {
        viewport3D.unproject(screenCoords);
        return screenCoords;
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
}
