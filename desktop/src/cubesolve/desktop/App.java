package cubesolve.desktop;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class App {
    public static void main(String[] args) {
        Quaternion quaternion = new Quaternion(1.0f,0,0,0);
        float angleAround = quaternion.getAngleAround(10, 0, 0);
//        System.out.println(angleAround);
        quaternion.setFromAxisRad(new Vector3(0,0,1), 91.5f);
        quaternion.mul(10);
        System.out.println(quaternion.x + "   "+quaternion.y+"  "+quaternion.z);
    }
}
