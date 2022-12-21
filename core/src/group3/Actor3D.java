package group3;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Array;

import action.Action;
import action.RotationAction;

public class Actor3D {
    protected Array<Action> array;
    protected ModelInstance modelInstance;
    protected float x,y,z,depth;
    protected float width;
    protected float height;
    protected BoundingBox boundingBox;
    protected BoundingBox boundingBoxs[];

    public Actor3D(){
        array = new Array<Action>();
        boundingBox = new BoundingBox();
        boundingBoxs = new BoundingBox[6];
    }

    public void act(float delta){
        Array<Action> remove = new Array<Action>();
        for (Action action : array) {
            if (action.act(delta)) {
                remove.add(action);
            }
        }
        for (Action action : remove) {
            array.removeValue(action,false);
        }
    }

//    private ModelInstance modelInstance;
    public void draw(ModelBatch batch, Environment environment){

    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public ModelInstance getModelInstance() {
        return modelInstance;
    }

    public void addAction(Action action) {
        action.setActor(this);
        array.add(action);
        action.begin();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    private Vector3 vector3 = new Vector3();

    private Vector3 position = new Vector3();
    public final Vector3 center = new Vector3();
    public final Vector3 dimensions = new Vector3();

    public float hit1(Ray pickRay){
        vector3.set(x,y,z);
        boundingBox.getCenter(center);
        boundingBox.getDimensions(dimensions);
        modelInstance.transform.getTranslation(position).add(center);
        if (Intersector.intersectRayBoundsFast(pickRay, position, dimensions)){
            return pickRay.origin.dst2(position);
        }
        return -1f;
    }

    public Actor3D hit(float x,float y,float z){
//        modelInstance.transform.getTranslation(vector3);
//        if ((x>=vector3.x && x<=vector3.x+width)
//                &&(y>=vector3.y && y<=vector3.y+height)
//                &&(z>=vector3.z && x<=vector3.z+depth)) {
//            return this;
//        }
//        return null;
        vector3.set(x,y,z);
        if (boundingBox.contains(vector3)) {
            return this;
        }return null;
    }

    public void rayTest(Ray ray){}
}
