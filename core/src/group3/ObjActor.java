package group3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class ObjActor extends Actor3D {
    public ObjActor(String path){
        ModelLoader loader = new ObjLoader();
        Model model = loader.loadModel(Gdx.files.internal(path));

        modelInstance = new ModelInstance(model);
        Material cubeMaterial = new Material(ColorAttribute.createSpecular(Color.WHITE),
                ColorAttribute.createSpecular(Color.BLACK));
        model.materials.add(cubeMaterial);

//        ModelBuilder builder = new ModelBuilder();
//        builder.part("part1", GL20.GL_TRIANGLES, VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal, new Material());
//        builder.setUVRange(0, 0, width, height);
//        builder.rect(x, y + depth, z,
//                x + depth, y + depth, z,
//                x + depth, y, z,
//                x, y, z,
//                0, 0, -1);

    }

    @Override
    public void draw(ModelBatch batch, Environment environment) {
        batch.render(modelInstance, environment);
    }
}
