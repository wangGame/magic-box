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
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Array;

/**
 * 绘制原理：
 * 一个正方形有6个面，每个main单独设置颜色，
 * rgb  uv   就这些参数一个一个放上去的
 */
public class CubeActor extends Actor3D {
    //    public Model model;
    private Color[] color;
    private Color[] endColor;
    private MeshBuilder builder;
    private ModelBuilder modelBuilder;
    private Material cubeMaterial;
    private Model model;

    public Model getModel() {
        return model;
    }

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
        Texture cubeletTexture = new Texture(Gdx.files.internal("cubelet.png"));
        cubeMaterial = new Material(ColorAttribute.createSpecular(Color.WHITE),
                TextureAttribute.createDiffuse(cubeletTexture));
        cubeMaterial.id = "upMater";
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
        Mesh mesh = builder.end();
        modelBuilder.part("cube1", mesh, GL20.GL_TRIANGLES, cubeMaterial);


        cubeletTexture = new Texture(Gdx.files.internal("cubelet.png"));
        cubeMaterial = new Material(ColorAttribute.createSpecular(Color.WHITE),
                TextureAttribute.createDiffuse(cubeletTexture));
        builder.begin(VertexAttributes.Usage.Position |
                VertexAttributes.Usage.TextureCoordinates | VertexAttributes.Usage.ColorPacked | VertexAttributes.Usage.Normal, GL20.GL_TRIANGLES);

//


        cubeletTexture = new Texture(Gdx.files.internal("cubelet.png"));
        cubeMaterial = new Material(ColorAttribute.createSpecular(Color.WHITE),
                TextureAttribute.createDiffuse(cubeletTexture));


//        //下
        builder.setColor(color[1]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z,
                x + depth, y, z,
                x + depth, y, z + depth,
                x, y, z + depth,
                0, -1, 0);
        mesh = builder.end();
        modelBuilder.part("cube2", mesh, GL20.GL_TRIANGLES, cubeMaterial);
//
        builder.begin(VertexAttributes.Usage.Position |
                VertexAttributes.Usage.TextureCoordinates | VertexAttributes.Usage.ColorPacked | VertexAttributes.Usage.Normal, GL20.GL_TRIANGLES);



        cubeletTexture = new Texture(Gdx.files.internal("cubelet.png"));
        cubeMaterial = new Material(ColorAttribute.createSpecular(Color.WHITE),
                TextureAttribute.createDiffuse(cubeletTexture));

        //后
        builder.setColor(color[2]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y + depth, z,
                x + depth, y + depth, z,
                x + depth, y, z,
                x, y, z,
                0, 0, -1);
        mesh = builder.end();
        modelBuilder.part("cube2", mesh, GL20.GL_TRIANGLES, cubeMaterial);

        builder.begin(VertexAttributes.Usage.Position |
                VertexAttributes.Usage.TextureCoordinates | VertexAttributes.Usage.ColorPacked | VertexAttributes.Usage.Normal, GL20.GL_TRIANGLES);



        cubeletTexture = new Texture(Gdx.files.internal("cubelet.png"));
        cubeMaterial = new Material(ColorAttribute.createSpecular(Color.WHITE),
                TextureAttribute.createDiffuse(cubeletTexture));

        //qian
        builder.setColor(color[3]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z + depth,
                x + depth, y, z + depth,
                x + depth, y + depth, z + depth,
                x, y + depth, z + depth,
                0, 0, 1);
        mesh = builder.end();
        modelBuilder.part("cube3", mesh, GL20.GL_TRIANGLES, cubeMaterial);

        builder.begin(VertexAttributes.Usage.Position |
                VertexAttributes.Usage.TextureCoordinates | VertexAttributes.Usage.ColorPacked | VertexAttributes.Usage.Normal, GL20.GL_TRIANGLES);



        cubeletTexture = new Texture(Gdx.files.internal("cubelet.png"));
        cubeMaterial = new Material(ColorAttribute.createSpecular(Color.WHITE),
                TextureAttribute.createDiffuse(cubeletTexture));

        //left
        builder.setColor(color[4]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x, y, z + depth,
                x, y + depth, z + depth,
                x, y + depth, z,
                x, y, z,
                -1, 0, 0);
        mesh = builder.end();
        modelBuilder.part("cube1", mesh, GL20.GL_TRIANGLES, cubeMaterial);

        builder.begin(VertexAttributes.Usage.Position |
                VertexAttributes.Usage.TextureCoordinates | VertexAttributes.Usage.ColorPacked | VertexAttributes.Usage.Normal, GL20.GL_TRIANGLES);


        cubeletTexture = new Texture(Gdx.files.internal("cubelet.png"));
        cubeMaterial = new Material(ColorAttribute.createSpecular(Color.WHITE),
                TextureAttribute.createDiffuse(cubeletTexture));

        //you
        builder.setColor(color[5]);
        builder.setUVRange(0, 0, width, height);
        builder.rect(x + depth, y, z,
                x + depth, y + depth, z,
                x + depth, y + depth, z + depth,
                x + depth, y, z + depth,
                1, 0, 0);
        mesh = builder.end();
        modelBuilder.part("cube6", mesh, GL20.GL_TRIANGLES, cubeMaterial);
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
//        init();

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
//        init();
    }


    public float disten(BoundingBox boundingBox,Ray ray){
//        boundingBox.getCenter(center);
//        boundingBox.getDimensions(dimensions);
//        Vector3 min = new Vector3(boundingBox.min);



//        if (Intersector.intersectRayBoundsFast(ray, min, dimensions)){
//            return ray.origin.dst2(min);
//        }
        return -1f;

    }

    Vector3 temp = new Vector3();
    Vector3 end = new Vector3();
    //绕着某点 转动
    public void rotateRad(Vector3 centerPoint,Vector3 axis,float angle){
        modelInstance.transform.getTranslation(temp);
        temp.rotate(axis,angle);
        modelInstance.transform.translate(temp);
    }

    public void Rotate3(Vector3 center,
                        double alphaX, double alphaY, double alphaZ) {
        Vector3 temp = new Vector3();

//        final float cos = (float)Math.cos(rotation * degreesToRadians);
//        /** multiply by this to convert from degrees to radians */
//        final float sin = (float)Math.sin(rotation * degreesToRadians);

        modelInstance.transform.getTranslation(temp);
        //Z Axis Rotation
        double x3 = 1.0f;
        double y3 = 1.0f;
        double z3 = 1.0f;
        double x4 = temp.x;
        double y4 = temp.y;
        double z4 = temp.z;


//        x3 = (temp.x - center.x) * Math.cos(alphaZ)
//                - (temp.y - center.y) * Math.sin(alphaZ);
//        y3 = (temp.x - center.x )* Math.sin(alphaZ) +
//                (temp.y - center.y) * Math.cos(alphaZ);
//        z3 = temp.z;

        //Y Axis Rotation
        z4 = (z3) * (float)Math.cos(alphaY) -
                (x3) * (float)Math.sin(alphaY);
        x4 = (z3) * (float)Math.cos(alphaY) +
                (x3) * (float)Math.sin(alphaY);
        y4 = y3;
        //X Axis Rotation
//        end.y = (float) ((float) (y4 - center.y) * Math.cos(alphaX) - (z4 -center.z)* Math.sin(alphaX));
//        end.z = (float) ((y4 - center.y) * Math.sin(alphaX) + (z4-center.z) * Math.cos(alphaX));
//        end.x = (float) x4;
//        modelInstance.transform.translate(0,0,0);
//        modelInstance.transform.translate((float) x4,(float) y4,(float) z4);
//        modelInstance.transform.rotateRad(Vector3.X,0.06f);
        Quaternion quaternion = new Quaternion(1,0,0,0);
        System.out.println(alphaY);
        quaternion.setFromAxisRad(1,1,0, (float) alphaY);
//        modelInstance.transform.setToTranslation(quaternion.x,quaternion.y,quaternion.z);
//        modelInstance.transform.getRotation(quaternion);
        quaternion.mul(20);
//

        float v = (float) (Math.cos(alphaY*0.1));
        float v1 = (float) (Math.sin(alphaY*0.1));
        Quaternion quaternion1 = new Quaternion();
        quaternion1.x = v;
        quaternion1.y = v1;
        quaternion1.setEulerAngles(3,1,1);
        modelInstance.transform.setToTranslation(quaternion1.x,quaternion1.y,quaternion.z);
//        modelInstance.transform.setToRotation(Vector3.Z, (float) alphaY);
        //        quaternion.mul(1);
        System.out.println(quaternion.x + "   "+ quaternion.y +"  "+quaternion.z);

//        modelInstance.transform.translate(-old.x,-old.y,-old.z);
//        old.set(quaternion);
    }
    Quaternion old = new Quaternion();
//    public void test(){
//        float PI = 3.1415927f;
//        float degreesToRadians = PI / 180;
//        float rotation = 90;
//        final float cos = (float)Math.cos(rotation * degreesToRadians);
//        /** multiply by this to convert from degrees to radians */
//        final float sin = (float)Math.sin(rotation * degreesToRadians);
//        final float originX = center.x;
//        final float originY = center.y;
////        final float tox = (point.x - originX) ;
////        final float toy = (point.y - originY) ;
//        float endX = (tox * cos + toy * sin) + originX;
//        float endY = (tox * -sin + toy * cos) + originY;
//    }

    private void rotate(Vector2 temp, Vector3 centerPoint, float angle) {
        int tempx = (int) Math.round((x-1)*Math.cos(Math.toDegrees(angle))-(y-1)*Math.sin(Math.toDegrees(-angle)) +1);
        int tempy = (int) Math.round((y-1)*Math.cos(Math.toDegrees(-angle))+(x-1)*Math.sin(Math.toDegrees(-angle))+1);
        temp.set(tempx,tempy);
    }

}