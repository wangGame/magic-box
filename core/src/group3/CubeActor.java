package group3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import action.RotationAction;
import cubesolve.Cube;
import cubesolve.Cubelet;

public class CubeActor extends Actor3D {
    //    public Model model;
    public Color[] color;
    public Color[] endColor;
    public  MeshBuilder builder;

    public CubeActor() {
        endColor = new Color[6];
        color = new Color[6];
        color[0] = Color.WHITE;
        color[1] = Color.RED;
        color[2] = Color.GREEN;
        color[3] = Color.BLUE;
        color[4] = Color.BLACK;
        color[5] = Color.ORANGE;
    }

    public void init() {
        ModelBuilder modelBuilder = new ModelBuilder();
        Texture cubeletTexture = new Texture(Gdx.files.internal("cubelet.png"));
        Material cubeMaterial = new Material(ColorAttribute.createSpecular(Color.WHITE),
                TextureAttribute.createDiffuse(cubeletTexture));
        modelBuilder.begin();
        builder = new MeshBuilder();
        builder.begin(VertexAttributes.Usage.Position | VertexAttributes.Usage.TextureCoordinates | VertexAttributes.Usage.ColorPacked | VertexAttributes.Usage.Normal, GL20.GL_TRIANGLES);

        //上
        builder.setColor(color[0]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y + depth, z + depth,
                x + depth, y + depth, z + depth,
                x + depth, y + depth, z,
                x, y + depth, z,
                0, 1, 0);

        //下
        builder.setColor(color[1]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z,
                x + depth, y, z,
                x + depth, y, z + depth,
                x, y, z + depth,
                0, -1, 0);


        //后
        builder.setColor(color[2]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y + depth, z,
                x + depth, y + depth, z,
                x + depth, y, z,
                x, y, z,
                0, 0, -1);

        //qian
        builder.setColor(color[3]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z + depth,
                x + depth, y, z + depth,
                x + depth, y + depth, z + depth,
                x, y + depth, z + depth,
                0, 0, 1);

        //left
        builder.setColor(color[4]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z + depth,
                x, y + depth, z + depth,
                x, y + depth, z,
                x, y, z,
                -1, 0, 0);



        //you
        builder.setColor(color[5]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x + depth, y, z,
                x + depth, y + depth, z,
                x + depth, y + depth, z + depth,
                x + depth, y, z + depth,
                1, 0, 0);

        Mesh mesh = builder.end();
        modelBuilder.part("cube", mesh, GL20.GL_TRIANGLES, cubeMaterial);
        Model model = modelBuilder.end();
        modelInstance = new ModelInstance(model);
    }

    public float getAgree() {
        Quaternion quaternion = new Quaternion();
        Quaternion rotation = modelInstance.transform.getRotation(quaternion);
        float angle = rotation.getAngle();
        float angleAroundX = rotation.getAngleAround(1, 0, 0);
        float angleAroundY = rotation.getAngleAround(0, 1, 0);
        float angleAroundZ = rotation.getAngleAround(0, 0, 1);
        return angle;
    }





    @Override
    public void draw(ModelBatch batch, Environment environment) {
        batch.render(modelInstance, environment);
    }

    public void setUpColor(Color color) {
        this.color[0] = color;
        builder.setColor(this.color[0]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y + depth, z + depth,
                x + depth, y + depth, z + depth,
                x + depth, y + depth, z,
                x, y + depth, z,
                0, 1, 0);
    }

    public void setDownColor(Color color) {
        this.color[1] = color;
        builder.setColor(this.color[1]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z,
                x + depth, y, z,
                x + depth, y, z + depth,
                x, y, z + depth,
                0, -1, 0);
    }


    public void setLeftColor(Color color) {
        this.color[4] = color;
        builder.setColor(this.color[4]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z + depth,
                x, y + depth, z + depth,
                x, y + depth, z,
                x, y, z,
                -1, 0, 0);
    }

    public void setRightColor(Color color) {
        //you
        builder.setColor(this.color[5]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x + depth, y, z,
                x + depth, y + depth, z,
                x + depth, y + depth, z + depth,
                x + depth, y, z + depth,
                1, 0, 0);
    }

    public void setFrontColor(Color color) {
        this.color[3] = color;
        builder.setColor(this.color[3]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z + depth,
                x + depth, y, z + depth,
                x + depth, y + depth, z + depth,
                x, y + depth, z + depth,
                0, 0, 1);

    }

    public void setBackColor(Color color) {
        this.color[2] = color;
        builder.setColor(this.color[2]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y + depth, z,
                x + depth, y + depth, z,
                x + depth, y, z,
                x, y, z,
                0, 0, -1);
    }

    public Color getColor(int index) {
        return color[index];
    }

    public void rotate90(int index) {
        if (index == 0){
//            endColor[0] = color[4];
//            endColor[4] = color[1];
//            endColor[0] = color[1];
        }
    }

}