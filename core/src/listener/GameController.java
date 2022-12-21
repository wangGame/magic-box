package listener;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;

public class GameController implements InputProcessor {
   protected Camera camera;
   private float zoom = 1.0f;
   private boolean started = false;
   public static final float CAMERA_HEIGHT = 25f;
   private Vector3 cameraPosition = new Vector3(50f, CAMERA_HEIGHT, 50f);
   private float aspectRatio;
   final Vector3 curr = new Vector3();
   final Vector3 last = new Vector3(-1, -1, -1);
   final Vector3 delta = new Vector3();


   /**
    * near 近處可以看到什麽位置
    * far 遠處可以看到什麽位置
    */
   public GameController(PerspectiveCamera camera) {
      this.camera = camera;
   }

   public float getZoom() {
      return zoom;
   }

   public void setZoom(float zoom) {
      this.zoom = zoom;
   }

   public void resize(int width, int height) {
      aspectRatio = (float) width / (float) height;
   }

   private Vector3 vector3 = new Vector3();
   public void updateLookAt(float x,float y,float z){
      vector3.set(x,y,z);
   }

   public void update() {
      if (!started) {
         camera.position.set(cameraPosition);
         camera.lookAt(vector3.x,0.2f, vector3.z);
         if (camera instanceof OrthographicCamera) {
            OrthographicCamera ocam = (OrthographicCamera) camera;
            ocam.zoom = 4.4f;
         }
         started = true;
      }
      camera.update();
   }

   public Matrix4 getCombined() {
      return camera.combined;
   }

   @Override
   public boolean scrolled(int amount) {
      if (camera instanceof OrthographicCamera) {
         OrthographicCamera ocam = (OrthographicCamera) camera;
         ocam.zoom += amount * 0.2f;
      }

      return false;
   }
   final Plane xzPlane = new Plane(new Vector3(0, 0, 1), 0);

   @Override
   public boolean touchDragged(int x, int y, int pointer) {
      Ray pickRay = camera.getPickRay(x, y);
      Intersector.intersectRayPlane(pickRay, xzPlane, curr);
      if (!(last.x == -1 && last.y == -1 && last.z == -1)) {
         pickRay = camera.getPickRay(last.x, last.y);
         Intersector.intersectRayPlane(pickRay, xzPlane, delta);
         delta.sub(curr);
         camera.position.add(delta.x, 0, delta.z);
      }
      last.set(x, y, 0);
      return false;
   }

   @Override
   public boolean mouseMoved(int i, int i1) {
      return false;
   }

   public Plane getXzPlane() {
      return xzPlane;
   }

   @Override
   public boolean touchUp(int x, int y, int pointer, int button) {
      last.set(-1, -1, -1);
      return false;
   }


   @Override
   public boolean keyDown(int i) {
      return false;
   }

   @Override
   public boolean keyUp(int i) {
      return false;
   }

   @Override
   public boolean keyTyped(char character) {
      if (character == 'w') {
         cameraPosition.z += 1f;
      }
      if (character == 'a') {
         cameraPosition.x += 1f;
      }
      if (character == 's') {
         cameraPosition.z -= 1f;
      }
      if (character == 'd') {
         cameraPosition.x -= 1f;
      }
      camera.position.set(cameraPosition);
      return false;
   }

   @Override
   public boolean touchDown(int i, int i1, int i2, int i3) {
      return false;
   }

   public Ray getPickRay(int x, int y) {
      return camera.getPickRay(x,y);
   }
}
