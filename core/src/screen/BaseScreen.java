package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

import cubesolve.Constant;
import cubesolve.CubeSolve;
import cubesolve.CubeSolveInputProcessor;
import group3.Actor3D;
import sence.Sence3D;
import stage3D.Stage3D;

public class BaseScreen implements Sence3D {
    protected InputMultiplexer multiplexer;
    private CubeSolveInputProcessor camController;

    protected Stage3D stage3D;
    private Stage stage;
    private Label fps;
    protected CubeSolve solve;

    public BaseScreen(CubeSolve cubeSolve){
        this.solve = cubeSolve;
        multiplexer = new InputMultiplexer();
        camController = new CubeSolveInputProcessor(cubeSolve.getViewport3D().getCamera());

        stage3D = new Stage3D(cubeSolve.getViewport3D(),cubeSolve.getModelBatch());
        stage = new Stage(cubeSolve.getViewport(),cubeSolve.getHudBatch());
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(camController);

        Gdx.input.setInputProcessor(multiplexer);

        fps = new Label("",new Label.LabelStyle(){
            {
                font = new BitmapFont(Gdx.files.internal("Bahnschrift-Regular_40_1.fnt"),
                        Gdx.files.internal("Bahnschrift-Regular_40_1.png"),false);
            }
        });
        fps.setPosition(30,Constant.height - 30, Align.topLeft);
        stage.addActor(fps);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        fps.setText(Gdx.graphics.getFramesPerSecond()+" :fps");
        stage.act();
        stage.draw();

        stage3D.act();
        stage3D.draw();
    }

    @Override
    public void resize(int width, int height) {


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void addActor(Actor actor){
        stage.addActor(actor);
    }

    public void addActor3d(Actor3D actor3D){
        stage3D.addActor(actor3D);
    }

}
