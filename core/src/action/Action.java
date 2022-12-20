package action;

import group3.Actor3D;

public class Action {
    protected Actor3D actor3D;

    public boolean act(float delta){
        return false;
    }

    public void begin(){

    }


    public void setActor(Actor3D actor3D) {
        this.actor3D = actor3D;
    }

}
