package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

import cubesolve.CubeSolve;
import group3.CubeManager;
import listener.ClickListener3D;

public class GameScreen extends BaseScreen{
    private CubeManager manager;
    public GameScreen(CubeSolve cubeSolve) {
        super(cubeSolve);
        manager = new CubeManager(stage3D.getRoot());
        multiplexer.addProcessor(new ClickListener3D(manager));
        Image slove = new Image(new Texture("cubelet.png"));
        addActor(slove);
        slove.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                String pageStr = manager.getPageStr();
                showStep(pageStr);
            }
        });
    }

    private void showStep(String pageStr) {

        index= 0;
        String[] s = pageStr.split(" ");
        final Array<String> end = new Array<String>();
        for (String s1 : s) {
            if (s1.contains("2")){
                char c = s1.charAt(0);
                for (int i = 0; i < 2; i++) {
                    end.add(c+"");
                }
            }else {
                end.add(s1);
            }
        }
        Image left = new Image(new Texture("cubelet.png"));
        addActor(left);
        left.setSize(20,20);
        left.setX(30);
        Image right = new Image(new Texture("cubelet.png"));
        addActor(right);
        right.setSize(20,20);
        right.setX(100);
        left.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (index<0){
                    return;
                }
                if (index>=end.size){
                    index = end.size-1;
                }
                String s1 = end.get(index);
                jiexi(s1);
                index --;
            }
        });
        right.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if (index>=end.size){
                    return;
                }
                String s1 = end.get(index);
                jiexi(s1);
                index++;
            }
        });
    }

    int index = 0;

//    F F' F2
//    U U' U2
//    D D' D2
//    B B' B2
//    R R' R2
//    L L' L2
    public void jiexi(String str){
         if (str.equals("F")) {
            manager.backRotation90N(2);
        } else if(str.equals("F'")) {
            manager.backRotation90(2);
        }else if(str.equals("U")) {
             manager.bottomRotation90N(2);
         }else if(str.equals("U'")) {
             manager.bottomRotation90(2);
         }else if(str.equals("D")) {
             manager.bottomRotation90(0);
         }else if(str.equals("D'")) {
             manager.bottomRotation90N(0);
         }else if(str.equals("B")) {
             manager.backRotation90(0);
         }else if (str.equals("B'")) {
             manager.backRotation90N(0);
         }else if (str.equals("R")) {
             manager.leftRotation90N(2);
         }else if (str.equals("R'")) {
             manager.leftRotation90(2);
         }else if (str.equals("L")) {
             manager.leftRotation90(0);
         }else if (str.equals("L'")) {
             manager.leftRotation90N(0);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        manager.render(delta);
    }

    //    final Vector3 intersection = new Vector3();
//    private void checkTileTouched() {
//        if (Gdx.input.justTouched()) {
//            Ray pickRay = stage3D.getCamera().getPickRay(Gdx.input.getX(), Gdx.input.getY());
//            Intersector.intersectRayPlane(pickRay, stage3D.getCamera().getXzPlane(), intersection);
//            int x = (int) intersection.x;
//            int z = (int) intersection.z;
//            if (x >= 0 && x < Constance.MAP_WIDTH && z >= 0 && z < Constance.MAP_HEIGHT) {
////                if (lastSelectedTile != null) {
////                    lastSelectedTile.setUseLighting(true);
////                }
//                Cube[][][] cubes = dlevel.getCubes();
//                Cube cube = cubes[x][z][0];
//                if (cube != null) {
//                    cube.setUseLighting(false);
//                }
////                lastSelectedTile = cube;
////                if (actor.getCurrentPath() == null) {
////                    NavPath path = dlevel.getPath(actor.getPos().x, actor.getPos().z, x, z);
////                    if (path != null) {
////                        actor.setCurrentPath(path);
////                    }
////                }
//                System.out.println(cube);
//            }
//        }
//    }


}
