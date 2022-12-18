package group3;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.Array;

public class Group3D extends Actor3D{

    private Array<Actor3D> actor3Ds = new Array<Actor3D>();

    public void addActor3d(Actor3D actor3D){
        actor3Ds.add(actor3D);
    }

    @Override
    public void act(float delta) {
        for (Actor3D actor3D : actor3Ds) {
            actor3D.act(delta);
        }
    }

    @Override
    public void draw(ModelBatch batch, Environment environment) {
        for (Actor3D actor3D : actor3Ds) {
            actor3D.draw(batch,environment);
        }
    }
}
