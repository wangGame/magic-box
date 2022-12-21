package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

import cubesolve.CubeSolve;
import group3.CubeManager;
import listener.ClickListener3D;

public class GameScreen extends BaseScreen{
    private CubeManager manager;
    public GameScreen(CubeSolve cubeSolve) {
        super(cubeSolve);
        manager = new CubeManager(stage3D.getRoot());
        multiplexer.addProcessor(new ClickListener3D(manager));
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
