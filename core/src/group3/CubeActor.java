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
import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Array;

public class CubeActor extends Actor3D {
    //    public Model model;
    private Color[] color;
    private Color[] endColor;
    private MeshBuilder builder;
    private ModelBuilder modelBuilder;
    private Material cubeMaterial;
    private Model model;

    public CubeActor() {
        height = width = depth = 1;
        modelBuilder = new ModelBuilder();
        builder = new MeshBuilder();
        Texture cubeletTexture = new Texture(Gdx.files.internal("cubelet.png"));
        cubeMaterial = new Material(ColorAttribute.createSpecular(Color.WHITE),
                TextureAttribute.createDiffuse(cubeletTexture));
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
        modelBuilder.begin();
        builder.begin(VertexAttributes.Usage.Position |
                VertexAttributes.Usage.TextureCoordinates | VertexAttributes.Usage.ColorPacked | VertexAttributes.Usage.Normal, GL20.GL_TRIANGLES);

        //上
        builder.setColor(color[0]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y + depth, z + depth,
                x + depth, y + depth, z + depth,
                x + depth, y + depth, z,
                x, y + depth, z,
                0, 1, 0);
        BoundingBox boundingBoxUp = new BoundingBox();
        boundingBoxUp.set(new Vector3(0,2,0),new Vector3(2,2,2));
        boundingBoxs[0] = boundingBoxUp;
        //下
        builder.setColor(color[1]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z,
                x + depth, y, z,
                x + depth, y, z + depth,
                x, y, z + depth,
                0, -1, 0);
        BoundingBox boundingBoxDown = new BoundingBox();
        boundingBoxDown.set(new Vector3(0,0,0),new Vector3(2,0,2));
        boundingBoxs[1] = boundingBoxDown;

        //后
        builder.setColor(color[2]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y + depth, z,
                x + depth, y + depth, z,
                x + depth, y, z,
                x, y, z,
                0, 0, -1);
        BoundingBox boundingBoxBack = new BoundingBox();
        boundingBoxBack.set(new Vector3(0,0,0),new Vector3(2,2,0));
        boundingBoxs[2] = boundingBoxBack;

        //qian
        builder.setColor(color[3]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z + depth,
                x + depth, y, z + depth,
                x + depth, y + depth, z + depth,
                x, y + depth, z + depth,
                0, 0, 1);
        BoundingBox boundingBoxFront = new BoundingBox();
        boundingBoxFront.set(new Vector3(0,0,0),new Vector3(2,2,2));
        boundingBoxs[3] = boundingBoxFront;

        //left
        builder.setColor(color[4]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z + depth,
                x, y + depth, z + depth,
                x, y + depth, z,
                x, y, z,
                -1, 0, 0);
        BoundingBox boundingBoxLeft = new BoundingBox();
        boundingBoxLeft.set(new Vector3(0,0,0),new Vector3(0,2,2));
        boundingBoxs[4] = boundingBoxLeft;


        //you
        builder.setColor(color[5]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x + depth, y, z,
                x + depth, y + depth, z,
                x + depth, y + depth, z + depth,
                x + depth, y, z + depth,
                1, 0, 0);
        BoundingBox boundingBoxRight = new BoundingBox();
        boundingBoxRight.set(new Vector3(2,0,0),new Vector3(2,2,2));
        boundingBoxs[5] = boundingBoxRight;

        Mesh mesh = builder.end();
        modelBuilder.part("cube", mesh, GL20.GL_TRIANGLES, cubeMaterial);
        model = modelBuilder.end();
        modelInstance = new ModelInstance(model);
        model.calculateBoundingBox(this.boundingBox);
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

    public void setUpColor() {
        builder.setColor(this.color[0]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y + depth, z + depth,
                x + depth, y + depth, z + depth,
                x + depth, y + depth, z,
                x, y + depth, z,
                0, 1, 0);
    }

    public void setDownColor() {
        builder.setColor(this.color[1]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z,
                x + depth, y, z,
                x + depth, y, z + depth,
                x, y, z + depth,
                0, -1, 0);
    }


    public void setLeftColor() {
        builder.setColor(this.color[4]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z + depth,
                x, y + depth, z + depth,
                x, y + depth, z,
                x, y, z,
                -1, 0, 0);
    }

    public void setRightColor() {
        builder.setColor(this.color[5]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x + depth, y, z,
                x + depth, y + depth, z,
                x + depth, y + depth, z + depth,
                x + depth, y, z + depth,
                1, 0, 0);
    }

    public void setFrontColor() {
        builder.setColor(this.color[3]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z + depth,
                x + depth, y, z + depth,
                x + depth, y + depth, z + depth,
                x, y + depth, z + depth,
                0, 0, 1);
    }

    public void setBackColor() {
        builder.setColor(this.color[2]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y + depth, z,
                x + depth, y + depth, z,
                x + depth, y, z,
                x, y, z,
                0, 0, -1);
    }

    public void translate(float x,float y,float z){
        modelInstance.transform.translate(x,y,z);
        model.calculateBoundingBox(boundingBox);
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

    public void setColor(){
        init();

//        for (Material m : modelInstance.materials)
//            m.set(ColorAttribute.createDiffuse(c));
//        setUpColor();
//        setDownColor();
//        setLeftColor();
//        setRightColor();
//        setFrontColor();
//        setBackColor();






















    }

    public void rotationBackRotation(CubeActor baseActor) {
        Color oldColor0 = baseActor.getColorByIndex(0);
        Color oldColor1 = baseActor.getColorByIndex(1);
        Color oldColor2 = baseActor.getColorByIndex(2);
        Color oldColor3 = baseActor.getColorByIndex(3);
        Color oldColor4 = baseActor.getColorByIndex(4);
        Color oldColor5 = baseActor.getColorByIndex(5);
        color[0] = new Color(oldColor5);
        color[1] = new Color(oldColor4);
        color[4] = new Color(oldColor0);
        color[5] = new Color(oldColor1);


        color[2] = new Color(oldColor2);
        color[3] = new Color(oldColor3);
        setColor();
    }

    private Color getColorByIndex(int i) {
        return new Color(endColor[i]);
    }

    public void leftRotation(CubeActor baseActor) {
        Color oldColor0 = baseActor.getColorByIndex(0);
        Color oldColor1 = baseActor.getColorByIndex(1);
        Color oldColor2 = baseActor.getColorByIndex(2);
        Color oldColor3 = baseActor.getColorByIndex(3);
        Color oldColor4 = baseActor.getColorByIndex(4);
        Color oldColor5 = baseActor.getColorByIndex(5);
        color[0] = new Color(oldColor2);
        color[3] = new Color(oldColor0);
        color[1] = new Color(oldColor3);
        color[2] = new Color(oldColor1);

        color[4] = new Color(oldColor4);
        color[5] = new Color(oldColor5);
        setColor();
    }

    public void bottomRotation(CubeActor baseActor) {
        Color oldColor0 = baseActor.getColorByIndex(0);
        Color oldColor1 = baseActor.getColorByIndex(1);
        Color oldColor2 = baseActor.getColorByIndex(2);
        Color oldColor3 = baseActor.getColorByIndex(3);
        Color oldColor4 = baseActor.getColorByIndex(4);
        Color oldColor5 = baseActor.getColorByIndex(5);
        color[4] = new Color(oldColor2);
        color[3] = new Color(oldColor4);
        color[5] = new Color(oldColor3);
        color[2] = new Color(oldColor5);
        color[0] = new Color(oldColor0);
        color[1] = new Color(oldColor1);
        setColor();
    }

    public void updateEndColor() {
        endColor[0] = new Color(color[0]);
        endColor[1] = new Color(color[1]);
        endColor[2] = new Color(color[2]);
        endColor[3] = new Color(color[3]);
        endColor[4] = new Color(color[4]);
        endColor[5] = new Color(color[5]);
//        endColor[0] = Color.WHITE;
//        endColor[1] = Color.RED;
//        endColor[2] = Color.GREEN;
//        endColor[3] = Color.BLUE;
//        endColor[4] = Color.BLACK;
//        endColor[5] = Color.ORANGE;
    }

    public void rotationBackRotationN(CubeActor baseActor) {
        Color oldColor0 = baseActor.getColorByIndex(0);
        Color oldColor1 = baseActor.getColorByIndex(1);
        Color oldColor2 = baseActor.getColorByIndex(2);
        Color oldColor3 = baseActor.getColorByIndex(3);
        Color oldColor4 = baseActor.getColorByIndex(4);
        Color oldColor5 = baseActor.getColorByIndex(5);
        color[0] = new Color(oldColor4);
        color[1] = new Color(oldColor5);
        color[4] = new Color(oldColor1);
        color[5] = new Color(oldColor0);
        //5->0->4->1->

        color[2] = new Color(oldColor2);
        color[3] = new Color(oldColor3);
        setColor();
    }

    public void bottomRotationN(CubeActor baseActor) {
        Color oldColor0 = baseActor.getColorByIndex(0);
        Color oldColor1 = baseActor.getColorByIndex(1);
        Color oldColor2 = baseActor.getColorByIndex(2);
        Color oldColor3 = baseActor.getColorByIndex(3);
        Color oldColor4 = baseActor.getColorByIndex(4);
        Color oldColor5 = baseActor.getColorByIndex(5);
        color[4] = new Color(oldColor3);
        color[3] = new Color(oldColor5);
        color[5] = new Color(oldColor2);
        color[2] = new Color(oldColor4);
//        2->4->3->5->2
        color[0] = new Color(oldColor0);
        color[1] = new Color(oldColor1);
        setColor();
    }

    public void leftRotationN(CubeActor baseActor) {
        Color oldColor0 = baseActor.getColorByIndex(0);
        Color oldColor1 = baseActor.getColorByIndex(1);
        Color oldColor2 = baseActor.getColorByIndex(2);
        Color oldColor3 = baseActor.getColorByIndex(3);
        Color oldColor4 = baseActor.getColorByIndex(4);
        Color oldColor5 = baseActor.getColorByIndex(5);
        color[0] = new Color(oldColor3);
        color[3] = new Color(oldColor1);
        color[1] = new Color(oldColor2);
        color[2] = new Color(oldColor0);
//        2->0->3->1->2
        color[4] = new Color(oldColor4);
        color[5] = new Color(oldColor5);
        setColor();
    }

    public void rayTest(Ray ray){
        float distance = -1;
        int index = 0;
        for (int i = 0; i < boundingBoxs.length; i++) {
            BoundingBox box = boundingBoxs[i];
            float dist2 = disten(box,ray);
            if (dist2 >= 0f && (distance < 0f || dist2 <= distance)) {
                index = i;
                distance = dist2;
            }
        }
        color[index] = Color.GRAY;
        init();
    }


    public float disten(BoundingBox boundingBox,Ray ray){
        boundingBox.getCenter(center);
        boundingBox.getDimensions(dimensions);
        Vector3 min = new Vector3(boundingBox.min);



        if (Intersector.intersectRayBoundsFast(ray, min, dimensions)){
            return ray.origin.dst2(min);
        }
        return -1f;

    }

}