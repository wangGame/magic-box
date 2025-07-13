package screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

import cubesolve.CubeSolve;
import group3.CubeManager;
import listener.ClickListener3D;

public class GameScreen extends BaseScreen{
    private CubeManager manager;
    private Label label;
    public GameScreen(CubeSolve cubeSolve) {
        super(cubeSolve);
        manager = new CubeManager(stage3D.getRoot());
        label = new Label("",new Label.LabelStyle(){{
            font = new BitmapFont(
                    Gdx.files.internal("Bahnschrift-Regular_40_1.fnt"),
                    Gdx.files.internal("Bahnschrift-Regular_40_1.png"),false
            );
        }});
        addActor(label);
        label.setPosition(100,100);
        multiplexer.addProcessor(new ClickListener3D(manager));
        Image slove = new Image(new Texture("cubelet.png"));
        addActor(slove);
        slove.setX(0);
        slove.setSize(50,50);
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
        StringBuilder stringBuilder = new StringBuilder();
        for (String s1 : s) {
            if (s1.contains("2")){
                char c = s1.charAt(0);
                for (int i = 0; i < 2; i++) {
                    end.add(c+"");
                    stringBuilder.append(c+" ");
                }
            }else {
                end.add(s1);
                stringBuilder.append(s1+" ");
            }
        }
        label.setText(stringBuilder.toString());
        Image left = new Image(new Texture("cubelet.png"));
        addActor(left);
        left.setSize(50,50);
        left.setX(150);
        Image right = new Image(new Texture("cubelet.png"));
        addActor(right);
        right.setSize(50,50);
        right.setX(450);
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
                jiexi(convert(s1));
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
                if (index<0){
                    index =0;
                }
                String s1 = end.get(index);
                jiexi(s1);
                index++;
            }
        });
    }

    public String convert(String str){
        System.out.println("-----");
        if (str.equals("F")) {
            return "F'";
        } else if(str.equals("F'")) {
            return "F";
        }else if(str.equals("U")) {
            return "U'";
        }else if(str.equals("U'")) {
            return "U";
        }else if(str.equals("D")) {
            return "D'";
        }else if(str.equals("D'")) {
            return "D";
        }else if(str.equals("B")) {
            return "B'";
        }else if (str.equals("B'")) {
            return "B";
        }else if (str.equals("R")) {
            return "R'";
        }else if (str.equals("R'")) {
            return "R";
        }else if (str.equals("L")) {
            return "L'";
        }else if (str.equals("L'")) {
            return "L";
        }
        return "err";
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


}
