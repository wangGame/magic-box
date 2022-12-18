package screen;

import cubesolve.CubeSolve;
import group3.CubeActor;
import group3.CubeManager;
import listener.ClickListener3D;

public class LoadingScreen extends BaseScreen{

    public LoadingScreen(CubeSolve cubeSolve) {
        super(cubeSolve);
        CubeManager manager = new CubeManager(stage3D.getRoot());
        multiplexer.addProcessor(new ClickListener3D(manager));
    }
}
