package screen;

import cubesolve.CubeSolve;
import group3.CubeManager;
import listener.ClickListener3D;

public class GameScreen extends BaseScreen{
    public GameScreen(CubeSolve cubeSolve) {
        super(cubeSolve);
        CubeManager manager = new CubeManager(stage3D.getRoot());
        multiplexer.addProcessor(new ClickListener3D(manager));
    }
}
