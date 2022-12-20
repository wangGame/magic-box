package group3;

import com.badlogic.gdx.graphics.Color;

import action.RotationAction;
import action.RotationActionN;
import ai.Solv;
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
        getPageStr();
    }

    public void backRotation90(int index) {
        getPageStr();
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
        getPageStr();
        update();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
//                cubeActors[x][y][0].addAction(new Ac);
//                cubeActors[x][y][0].modelInstance.transform.rotate(0,0,1,90);
                RotationActionN action = new RotationActionN(new CallBack() {
                    @Override
                    public void callBack(CubeActor cubeActor,CubeActor baseActor) {
                        cubeActor.rotationBackRotationN(baseActor);
                    }
                });
                int tempx = (int) Math.round((x-1)*Math.cos(Math.toDegrees(-90))-(y-1)*Math.sin(Math.toDegrees(-90)) +1);
                int tempy = (int) Math.round((y-1)*Math.cos(Math.toDegrees(-90))+(x-1)*Math.sin(Math.toDegrees(-90))+1);
                action.setBaseActor(cubeActors[tempx][tempy][index]);
                action.setAngle(-90);
                action.setTime(2);
                action.setAngleZ();
                cubeActors[x][y][index].addAction(action);
//                cubeActors[x][y][0].rotationBackRotation(cubeActors[tempx][tempy][0]);
                System.out.println(x+"  "+y +"-------->"+tempx+"  "+tempy);
            }
        }
    }

    public void leftRotation90(int index) {
        getPageStr();
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
        getPageStr();
        update();
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[0][y][z].modelInstance.transform.rotate(1,0,0,90);
//                cubeActors[0][y][z].rotate90(3);
                RotationActionN action = new RotationActionN(new CallBack() {
                    @Override
                    public void callBack(CubeActor cubeActor,CubeActor baseActor) {
                        cubeActor.leftRotationN(baseActor);
                    }
                });
                int tempy = (int) Math.round((y-1)*Math.cos(Math.toDegrees(-90))-(z-1)*Math.sin(Math.toDegrees(-90)) +1);
                int tempz = (int) Math.round((z-1)*Math.cos(Math.toDegrees(-90))+(y-1)*Math.sin(Math.toDegrees(-90))+1);
                action.setBaseActor(cubeActors[index][tempy][tempz]);
                System.out.println(y+"  "+z +"-------->"+tempy+"  "+tempz);
                action.setAngle(-90);
                action.setTime(2);
                action.setAngleX();
                cubeActors[index][y][z].addAction(action);
//                cubeActors[0][y][z].leftRotation(cubeActors[0][tempy][tempz]);
                System.out.println(y+"  "+z+"-------->"+tempy+"  "+tempz);
            }
        }
    }

    public void bottomRotation90(int index) {
        getPageStr();
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
        getPageStr();
        update();
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
//                cubeActors[x][0][z].modelInstance.transform.rotate(0,1,0,90);
//                cubeActors[x][0][z].rotate90(6);
                RotationActionN action = new RotationActionN(new CallBack() {
                    @Override
                    public void callBack(CubeActor cubeActor,CubeActor baseActor) {
                        cubeActor.bottomRotationN(baseActor);
                    }
                });


                int tempx = (int) Math.round((x-1)*Math.cos(Math.toDegrees(90))-(z-1)*Math.sin(Math.toDegrees(90)) +1);
                int tempz = (int) Math.round((z-1)*Math.cos(Math.toDegrees(90))+(x-1)*Math.sin(Math.toDegrees(90))+1);
                action.setBaseActor(cubeActors[tempx][index][tempz]);

                action.setAngle(-90);
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
//    BUB FUF FUF
//    RRL RRL RRL
//    DDD FFB DDD
//    BDBBDBFDFRLLRLLRLLUUUFBBUUU
    public boolean check(){
        //shang
        Color upColor = cubeActors[1][2][1].getColor(0);
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
                if (!upColor.equals(cubeActors[x][2][z].getColor(0))) {
                    return false;
                }
            }
        }

        Color bottomColor = cubeActors[1][0][1].getColor(1);
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
                if (!bottomColor.equals(cubeActors[x][0][z].getColor(1))) {
                    return false;
                }
            }
        }

        Color backColor = cubeActors[1][1][0].getColor(2);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (!backColor.equals(cubeActors[x][y][0].getColor(2))) {
                    return false;
                }
            }
        }

        Color frontColor = cubeActors[1][1][2].getColor(3);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (!frontColor.equals(cubeActors[x][y][2].getColor(3))) {
                    return false;
                }
            }
        }

        Color leftColor = cubeActors[0][1][1].getColor(4);
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                if (!leftColor.equals(cubeActors[0][y][z].getColor(4))) {
                    return false;
                }
            }
        }

        Color rightColor = cubeActors[2][1][1].getColor(5);
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                if (!rightColor.equals(cubeActors[0][y][z].getColor(5))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void getPageStr(){
        StringBuilder builder = new StringBuilder();
        //up
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
                builder.append(extracted(cubeActors[z][0][x].getColor(0)));
            }
        }

        //right
        StringBuilder buildTemp = new StringBuilder();
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                buildTemp.append(extracted(cubeActors[2][y][z].getColor(5)));
            }
        }
//        123   987
//        456   654
//        789   321
        for (int i = 0; i < buildTemp.length(); i++) {
            builder.append(buildTemp.charAt(buildTemp.length()-1-i));
        }
//        789   123
//        456   456
//        123   789
//        FUF FUF FUF
//        RRR RRR RRR
//        DFD DFD DFD
//        BDB BDB BDB
//        LLL LLL LLL
//        UUU BBB UUU
        //F
        buildTemp.setLength(0);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                buildTemp.append(extracted(cubeActors[y][x][2].getColor(3)));
            }
        }
        builder.append(buildTemp.charAt(6));
        builder.append(buildTemp.charAt(7));
        builder.append(buildTemp.charAt(8));
        builder.append(buildTemp.charAt(3));
        builder.append(buildTemp.charAt(4));
        builder.append(buildTemp.charAt(5));
        builder.append(buildTemp.charAt(0));
        builder.append(buildTemp.charAt(1));
        builder.append(buildTemp.charAt(2));

        //D
        buildTemp.setLength(0);
        for (int x = 0; x < 3; x++) {
            for (int z = 0; z < 3; z++) {
                buildTemp.append(extracted(cubeActors[z][0][x].getColor(1)));
            }
        }

        builder.append(buildTemp.charAt(6));
        builder.append(buildTemp.charAt(7));
        builder.append(buildTemp.charAt(8));
        builder.append(buildTemp.charAt(3));
        builder.append(buildTemp.charAt(4));
        builder.append(buildTemp.charAt(5));
        builder.append(buildTemp.charAt(0));
        builder.append(buildTemp.charAt(1));
        builder.append(buildTemp.charAt(2));
        //L
        buildTemp.setLength(0);
        for (int y = 0; y < 3; y++) {
            for (int z = 0; z < 3; z++) {
                buildTemp.append(extracted(cubeActors[0][y][z].getColor(4)));
            }
        }

        builder.append(buildTemp.charAt(6));
        builder.append(buildTemp.charAt(7));
        builder.append(buildTemp.charAt(8));
        builder.append(buildTemp.charAt(3));
        builder.append(buildTemp.charAt(4));
        builder.append(buildTemp.charAt(5));
        builder.append(buildTemp.charAt(0));
        builder.append(buildTemp.charAt(1));
        builder.append(buildTemp.charAt(2));
        //B
        buildTemp.setLength(0);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
               buildTemp.append(extracted(cubeActors[y][x][0].getColor(2)));
            }
        }
        for (int i = 0; i < buildTemp.length(); i++) {
            builder.append(buildTemp.charAt(buildTemp.length()-1-i));
        }
        System.out.println(builder.toString());
        Solv.solver(builder.toString());
    }

    private String extracted(Color color) {
        StringBuilder builder = new StringBuilder();
        Color upColor = cubeActors[1][2][1].getColor(0);
        Color bottomColor = cubeActors[1][0][1].getColor(1);
        Color backColor = cubeActors[1][1][0].getColor(2);
        Color frontColor = cubeActors[1][1][2].getColor(3);
        Color leftColor = cubeActors[0][1][1].getColor(4);
        Color rightColor = cubeActors[2][1][1].getColor(5);
        if (color.equals(upColor)) {
            builder.append("U");
        }else if (color.equals(bottomColor)){
            builder.append("D");
        }else if (color.equals(backColor)){
            builder.append("B");
        }else if (color.equals(frontColor)){
            builder.append("F");
        }else if (color.equals(leftColor)){
            builder.append("L");
        }else if (color.equals(rightColor)){
            builder.append("R");
        }
        return builder.toString();
    }
}
