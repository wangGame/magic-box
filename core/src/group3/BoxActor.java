package group3;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import javax.swing.Box;

public class BoxActor extends Actor3D{
    public BoxActor(){
        ModelBuilder modelBuilder = new ModelBuilder();
        Model box = modelBuilder.createBox(1, 1, 1,
                new Material(ColorAttribute.createDiffuse(Color.GREEN)),
                VertexAttributes.Usage.Position
                        | VertexAttributes.Usage.Normal);
        modelInstance = new ModelInstance(box);
    }

    @Override
    public void draw(ModelBatch batch, Environment environment) {
        batch.render(modelInstance,environment);
    }
}
