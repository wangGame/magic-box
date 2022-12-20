package group3;

import action.RotationAction;
import call.CallBack;

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

    public void backRotation90(int index) {
        update();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
//                cubeActors[x][y][0].addAction(new Ac);
//                cubeActors[x][y][0].modelInstance.transform.rotate(0,0,1,90);
                RotationAction action = new RotationAction(new CallBack() {
                    @Override
                    public void callBack(CubeActor cubeActor,CubeActor baseActor) {
                        cubeActor.rotationBackRotation(baseActor);
                    }
                });

                int tempx = (int) Math.round((x-1)*Math.cos(Math.toDegrees(90))-(y-1)*Math.sin(Math.toDegrees(90)) +1);
                int tempy = (int) Math.round((y-1)*Math.cos(Math.toDegrees(90))+(x-1)*Math.sin(Math.toDegrees(90))+1);
                action.setBaseActor(cubeActors[tempx][tempy][index]);
                action.setAngle(90);
                action.setTime(2);
                action.setAngleZ();
                cubeActors[x][y][index].addAction(action);
//                cubeActors[x][y][0].rotationBackRotation(cubeActors[tempx][tempy][0]);
                System.out.println(x+"  "+y +"-------->"+tempx+"  "+tempy);
            }
        }

    }


    public void backRotation90N(int index) {
        update();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
//                cubeActors[x][y][0].addAction(new Ac);
//                cubeActors[x][y][0].modelInstance.transform.rotate(0,0,1,90);
                RotationAction action = new RotationAction(new CallBack() {
                    @Override
                    public void callBack(CubeActor cubeActor,CubeActor baseActor) {
                        cubeActor.rotationBackRotationN(baseActor);
                    }
                });

                int tempx = (int) Math.round((x-1)*Math.cos(Math.toDegrees(-90))-(y-1)*Math.sin(Math.toDegrees(-90)) +1);
                int tempy = (int) Math.round((y-1)*Math.cos(Math.toDegrees(-90))+(x-1)*Math.sin(Math.toDegrees(-90))+1);
                action.setBaseActor(cubeActors[tempx][tempy][index]);
                action.setAngle(90);
                action.setTime(2);
                action.setAngleZ();
                cubeActors[x][y][index].addAction(action);
//                cubeActors[x][y][0].rotationBackRotation(cubeActors[tempx][tempy][0]);
                System.out.println(x+"  "+y +"-------->"+tempx+"  "+tempy);
            }
        }
    }

    public void leftRotation90(int index) {
        update();
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[0][y][z].modelInstance.transform.rotate(1,0,0,90);
//                cubeActors[0][y][z].rotate90(3);
                RotationAction action = new RotationAction(new CallBack() {
                    @Override
                    public void callBack(CubeActor cubeActor,CubeActor baseActor) {
                        cubeActor.leftRotation(baseActor);
                    }
                });
                int tempy = (int) Math.round((y-1)*Math.cos(Math.toDegrees(90))-(z-1)*Math.sin(Math.toDegrees(90)) +1);
                int tempz = (int) Math.round((z-1)*Math.cos(Math.toDegrees(90))+(y-1)*Math.sin(Math.toDegrees(90))+1);
                action.setBaseActor(cubeActors[index][tempy][tempz]);
                System.out.println(y+"  "+z +"-------->"+tempy+"  "+tempz);
                action.setAngle(90);
                action.setTime(2);
                action.setAngleX();
                cubeActors[index][y][z].addAction(action);
//                cubeActors[0][y][z].leftRotation(cubeActors[0][tempy][tempz]);
                System.out.println(y+"  "+z+"-------->"+tempy+"  "+tempz);
            }
        }
    }

    public void leftRotation90N(int index) {
        update();
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[0][y][z].modelInstance.transform.rotate(1,0,0,90);
//                cubeActors[0][y][z].rotate90(3);
                RotationAction action = new RotationAction(new CallBack() {
                    @Override
                    public void callBack(CubeActor cubeActor,CubeActor baseActor) {
                        cubeActor.leftRotation(baseActor);
                    }
                });
                int tempy = (int) Math.round((y-1)*Math.cos(Math.toDegrees(-90))-(z-1)*Math.sin(Math.toDegrees(-90)) +1);
                int tempz = (int) Math.round((z-1)*Math.cos(Math.toDegrees(-90))+(y-1)*Math.sin(Math.toDegrees(-90))+1);
                action.setBaseActor(cubeActors[index][tempy][tempz]);
                System.out.println(y+"  "+z +"-------->"+tempy+"  "+tempz);
                action.setAngle(90);
                action.setTime(2);
                action.setAngleX();
                cubeActors[index][y][z].addAction(action);
//                cubeActors[0][y][z].leftRotation(cubeActors[0][tempy][tempz]);
                System.out.println(y+"  "+z+"-------->"+tempy+"  "+tempz);
            }
        }
    }

    public void bottomRotation90(int index) {
        update();
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[x][0][z].modelInstance.transform.rotate(0,1,0,90);
//                cubeActors[x][0][z].rotate90(6);
                RotationAction action = new RotationAction(new CallBack() {
                    @Override
                    public void callBack(CubeActor cubeActor,CubeActor baseActor) {
                        cubeActor.bottomRotation(baseActor);
                    }
                });


                int tempx = (int) Math.round((x-1)*Math.cos(Math.toDegrees(-90))-(z-1)*Math.sin(Math.toDegrees(-90)) +1);
                int tempz = (int) Math.round((z-1)*Math.cos(Math.toDegrees(-90))+(x-1)*Math.sin(Math.toDegrees(-90))+1);
                action.setBaseActor(cubeActors[tempx][index][tempz]);

                action.setAngle(90);
                action.setTime(2);
                action.setAngleY();
                cubeActors[x][index][z].addAction(action);
//                cubeActors[x][0][z].bottomRotation(cubeActors[tempx][0][tempz]);
                System.out.println(x+"  "+z+"-------->"+tempx+"  "+tempz);
            }
        }
    }

    public void bottomRotation90N(int index) {
        update();
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[x][0][z].modelInstance.transform.rotate(0,1,0,90);
//                cubeActors[x][0][z].rotate90(6);
                RotationAction action = new RotationAction(new CallBack() {
                    @Override
                    public void callBack(CubeActor cubeActor,CubeActor baseActor) {
                        cubeActor.bottomRotationN(baseActor);
                    }
                });


                int tempx = (int) Math.round((x-1)*Math.cos(Math.toDegrees(90))-(z-1)*Math.sin(Math.toDegrees(90)) +1);
                int tempz = (int) Math.round((z-1)*Math.cos(Math.toDegrees(90))+(x-1)*Math.sin(Math.toDegrees(90))+1);
                action.setBaseActor(cubeActors[tempx][index][tempz]);

                action.setAngle(90);
                action.setTime(2);
                action.setAngleY();
                cubeActors[x][index][z].addAction(action);
//                cubeActors[x][0][z].bottomRotation(cubeActors[tempx][0][tempz]);
                System.out.println(x+"  "+z+"-------->"+tempx+"  "+tempz);
            }
        }
    }

    public void update(){
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    cubeActors[x][y][z].updateEndColor();
                }
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
