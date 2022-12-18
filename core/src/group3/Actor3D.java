package group3;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.utils.Array;

import action.Action;
import action.RotationAction;

public class Actor3D {
    protected Array<Action> array;
    protected ModelInstance modelInstance;
    protected float x,y,z,depth;
    protected float width;
    protected float height;
    public Actor3D(){
        array = new Array<Action>();
    }

    public void act(float delta){
        System.out.println(array.size);
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

    public void addAction(RotationAction action) {
        action.setActor(this);
        array.add(action);
        action.begin();
        System.out.println(array.size);
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
}
