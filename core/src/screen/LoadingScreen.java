package screen;

import cubesolve.CubeSolve;
import group3.CubeActor;
import group3.CubeManager;
import listener.ClickListener3D;

public class LoadingScreen extends BaseScreen{

    private float time;
    public LoadingScreen(CubeSolve cubeSolve) {
        super(cubeSolve);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        time += delta;
        if (time > 1){
            solve.setSence(new GameScreen(solve));
        }
    }
}
