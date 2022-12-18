package stage3D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g3d.ModelBatch;

import group3.Actor3D;
import group3.Group3D;
import viewport3D.CommonViewport;
import viewport3D.Viewport3D;

public class Stage3D extends Actor3D{
    private Viewport3D viewport3D;
    private ModelBatch batch;
    private Group3D group3D;
    public Stage3D(Viewport3D viewport3D, ModelBatch batch){
        this.viewport3D = viewport3D;
        this.batch = batch;
        this.group3D = new Group3D();
    }

    public void act(){
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
}
