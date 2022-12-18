package group3;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import action.RotationAction;

public class CubeManager{

    private CubeActor[][][] cubeActors;
    public CubeManager(Group3D root){
        cubeActors = new CubeActor[3][3][3];
        for (int x = 0; x< 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    CubeActor actor = new CubeActor();
                    actor.setX(x-1.5f);
                    actor.setY(y-1.5f);
                    actor.setZ(z-1.5f);
                    actor.setWidth(1);
                    actor.setHeight(1);
                    actor.setDepth(1);
                    actor.init();
                    root.addActor3d(actor);
                    cubeActors[x][y][z] = actor;
                }
            }
        }
    }

    public void backRotation90() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
//                cubeActors[x][y][0].addAction(new Ac);
//                cubeActors[x][y][0].modelInstance.transform.rotate(0,0,1,90);
                RotationAction action = new RotationAction();
                action.setAngle(90);
                action.setTime(2);
                action.setAngleZ();
                cubeActors[x][y][0].addAction(action);
            }
        }
    }

    public void backMiddleRotation90() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
//                cubeActors[x][y][1].modelInstance.transform.rotate(0,0,1,90);
//                cubeActors[x][y][0].rotate90(1);
                RotationAction action = new RotationAction();
                action.setAngle(90);
                action.setTime(2);
                action.setAngleZ();
                cubeActors[x][y][1].addAction(action);
            }
        }
    }

    public void frontRotation90() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
//                cubeActors[x][y][2].modelInstance.transform.rotate(0,0,1,90);
//                cubeActors[x][y][0].rotate90(2);
                RotationAction action = new RotationAction();
                action.setAngle(90);
                action.setTime(2);
                action.setAngleZ();
                cubeActors[x][y][2].addAction(action);
            }
        }
    }


    public void leftRotation90() {
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[0][y][z].modelInstance.transform.rotate(1,0,0,90);
//                cubeActors[0][y][z].rotate90(3);
                RotationAction action = new RotationAction();
                action.setAngle(90);
                action.setTime(2);
                action.setAngleX();
                cubeActors[0][y][z].addAction(action);
            }
        }
    }


    public void leftMiddleRotation90() {
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[1][y][z].modelInstance.transform.rotate(1,0,0,90);
//                cubeActors[1][y][z].rotate90(4);
                RotationAction action = new RotationAction();
                action.setAngle(90);
                action.setTime(2);
                action.setAngleX();
                cubeActors[1][y][z].addAction(action);
            }
        }
    }


    public void rightRotation90() {
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[2][y][z].modelInstance.transform.rotate(1,0,0,90);
//                cubeActors[2][y][z].rotate90(5);
                RotationAction action = new RotationAction();
                action.setAngle(90);
                action.setTime(2);
                action.setAngleX();
                cubeActors[2][y][z].addAction(action);
            }
        }
    }

    public void bottomRotation90() {
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[x][0][z].modelInstance.transform.rotate(0,1,0,90);
//                cubeActors[x][0][z].rotate90(6);
                RotationAction action = new RotationAction();
                action.setAngle(90);
                action.setTime(2);
                action.setAngleY();
                cubeActors[x][0][z].addAction(action);
            }
        }
    }


    public void bottomMiddleRotation90() {
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[x][1][z].modelInstance.transform.rotate(0,1,0,90);
//                cubeActors[x][1][z].rotate90(7);

                RotationAction action = new RotationAction();
                action.setAngle(90);
                action.setTime(2);
                action.setAngleY();
                cubeActors[x][1][z].addAction(action);
            }
        }
    }


    public void upRotation90() {
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[x][2][z].modelInstance.transform.rotate(0,1,0,90);
//                cubeActors[x][2][z].rotate90(8);

                RotationAction action = new RotationAction();
                action.setAngle(90);
                action.setTime(2);
                action.setAngleY();
                cubeActors[x][2][z].addAction(action);
            }
        }
    }

    public void showF() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                CubeActor actor = cubeActors[x][y][2];
                System.out.println(actor.getAgree());
            }
        }
    }
}
