package action;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

import call.CallBack;
import group3.Actor3D;
import group3.CubeActor;

public class RotationAction extends Action{
    private Vector3 vector3 = new Vector3();
    private float angle;
    private float startAngle;
    private float time;
    private float endAngle;
    private CallBack runnable;
    private Actor3D baseActor;

    public RotationAction(CallBack runnable){
        this.runnable = runnable;
    }

    public void begin(){
        Quaternion quaternion = new Quaternion();
        actor3D.getModelInstance().transform.getRotation(quaternion);
        startAngle = quaternion.getAngleAround(vector3);
        endAngle = startAngle + angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setTime(float time) {
        this.time = time;
    }

    @Override
    public boolean act(float delta) {
        ModelInstance modelInstance = actor3D.getModelInstance();
        if (modelInstance!=null){
            float v = angle / time;
            startAngle+=delta*v;
            if (startAngle>endAngle){
                startAngle = endAngle;
            }
            modelInstance.transform.setToRotation(vector3,startAngle);
            if (startAngle>=endAngle){
                modelInstance.transform.setToRotation(vector3,0);
                runnable.callBack((CubeActor) actor3D,(CubeActor) baseActor);
                return true;
            }
            return false;
        }
        return true;
    }

    public void setAngleX() {
        vector3.set(1,0,0);
    }

    public void setAngleZ() {
        vector3.set(0,0,1);
    }

    public void setAngleY() {
        vector3.set(0,1,0);
    }

    public void setBaseActor(Actor3D actor) {
        this.baseActor = actor;
    }
}
