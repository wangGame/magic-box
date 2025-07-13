package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import cubesolve.CubeSolve;
import group3.BoxActor;
import group3.CubeActor;
import group3.CubeManager;
import group3.ObjActor;
import listener.ClickListener3D;

public class LoadingScreen extends BaseScreen{
    CubeActor cubeActor;
    public LoadingScreen(CubeSolve cubeSolve) {
        super(cubeSolve);
        for (int i = 0; i < 10; i++) {
            CubeActor cubeActor = new CubeActor();
            cubeActor.setX(0f);
            cubeActor.setY(0f);
            cubeActor.setZ(0f);
            cubeActor.init();
            addActor3d(cubeActor);
            cubeActor.translate(-9+i, 0, 0);
            cubeActor.translate(0, 0, 0);
            cubeActor.Rotate3(new Vector3(),0,90,0);
        }
        for (int i = 0; i < 10; i++) {
            CubeActor cubeActor = new CubeActor();
            cubeActor.setX(0f);
            cubeActor.setY(0f);
            cubeActor.setZ(0f);
            cubeActor.init();
            addActor3d(cubeActor);
            cubeActor.translate(0, 0, 0);
            Quaternion quaternion = new Quaternion(1,0,0,0);
            quaternion.setFromAxisRad(new Vector3(1.0f,0,0),90);
            cubeActor.getModelInstance().transform.set(quaternion);



//            cubeActor.translate(0, 0, 0);
//            float PI = 3.1415927f;
//            float degreesToRadians = PI / 180;
//            cubeActor.Rotate3(new Vector3(),0,degreesToRadians*-190,0);

//
//            Quaternion quaternion = new Quaternion();
//            quaternion.set()
        }
//        for (int i = 0; i < 10; i++) {
//            CubeActor cubeActor = new CubeActor();
//            cubeActor.setX(0f);
//            cubeActor.setY(0f);
//            cubeActor.setZ(0f);
//            cubeActor.init();
//            addActor3d(cubeActor);
//            cubeActor.translate(-9+i, 0, 0);
////            cubeActor.translate(0, 0, 0);
//            cubeActor.Rotate3(new Vector3(),0,Math.toDegrees(90),0);
//        }
//        Array<Material> materials = cubeActor.getModelInstance().materials;
////        Material attributes = materials.get(0);
////        attributes.set(TextureAttribute.createDiffuse(
////                new Texture(Gdx.files.internal("Bahnschrift-Regular_40_1.png"))));
//        System.out.println("-----------------");

//        Array<MeshPart> meshParts = cubeActor.getModelInstance().model.meshParts;
//        for (MeshPart meshPart : meshParts) {
//            meshPart.id = "cube1";
//            meshPart
//        }

//        BoxActor actor = new BoxActor();
//        addActor3d(actor);
//
//        ObjActor objActor = new ObjActor("mofan.obj");
//        addActor3d(objActor);
//        System.out.println("--------------------");
//        Array<Material> materials = objActor.getModelInstance().materials;
//        for (Material material : materials) {
//            material.set(TextureAttribute.createDiffuse(
//                new Texture(Gdx.files.internal("mofan.jpg"))));
//        }
//        cubeActor = new CubeActor();
//        cubeActor.setX(0f);
//        cubeActor.setY(0f);
//        cubeActor.setZ(0f);
//        cubeActor.init();
//        addActor3d(cubeActor);
//        cubeActor.translate(1, 0, 0);
    }

    float ff = 0;
    @Override
    public void render(float delta) {
        super.render(delta);
//        ff += delta;
//        float PI = 3.1415927f;
//            float degreesToRadians = PI / 180;
//            cubeActor.Rotate3(new Vector3(),0,Math.toDegrees(ff),0);
//        cubeActor.Rotate3(Vector3.Zero,0,0.1f,0);
//        time += delta;
//        if (time > 1){
//            solve.setSence(new GameScreen(solve));
//        }
    }
}
