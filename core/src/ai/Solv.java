package ai;

import com.badlogic.gdx.graphics.Color;

import cubesolve.Cube;
import cubesolve.Cubelet;
import cubesolve.PlainCubelet;
import kw.test.Search;

public class Solv {

    public static void s(Cube cube){
//U1 上 U2 ... U9 R1 ... R9 F1 ... F9 D1 ... D9 L1 ... L9 B1 ... B9
//        DUUBULDBFRBFRRULLLBRDFFFBLURDBFDFDRFRULBLUFDURRBLBDUDL"
//        DUBLFR
        Cubelet[][][] cubelets = cube.getCubelets();
        int size = 3;
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 =new StringBuilder();
        // Check top
        int index = 1;
//        U1 上
        PlainCubelet.CubeletColor topColor = cubelets[0][size-1][0].getColor(PlainCubelet.CubeletSide.TOP);
        System.out.println(topColor.getGdxColor().toString());
        for(int z = 0; z < size; z++) {
            for(int x = 0; x < size; x++) {///TOP, BOTTOM, WEST, EAST, NORTH, SOUTH
                PlainCubelet.CubeletColor color = cubelets[x][size - 1][z].getColor(PlainCubelet.CubeletSide.TOP);
                utils(color,builder1,index);
                System.out.println(color);
            }
        }
        for (int i = 0; i < builder1.length(); i++) {
            builder.append(builder1.charAt(i));
        }


        builder1.setLength(0);
        // Check east
//        R1 ... R9 右边
        PlainCubelet.CubeletColor eastColor = cubelets[size-1][0][0].getColor(PlainCubelet.CubeletSide.EAST);
        System.out.println(eastColor.getGdxColor().toString());
        for(int y = 0; y < size; y++) {
            for(int z = 0; z < size; z++) {
//                if(!cubelets[size-1][y][z].getColor(PlainCubelet.CubeletSide.EAST).equals(eastColor))
//                    return false;
                PlainCubelet.CubeletColor color = cubelets[size - 1][y][z].getColor(PlainCubelet.CubeletSide.EAST);
                utils(color,builder1,index);
                System.out.println(color);
            }
        }
        for (int i = 0; i < builder1.length(); i++) {
            builder.append(builder1.charAt(builder1.length() - 1 - i));
        }


        builder1.setLength(0);
        // Check north qian
        PlainCubelet.CubeletColor northColor = cubelets[0][0][size-1].getColor(PlainCubelet.CubeletSide.NORTH);
        System.out.println(northColor.getGdxColor());
        for(int y = 0; y < size; y++) {
            for(int x = 0; x < size; x++) {
                PlainCubelet.CubeletColor color1 = cubelets[x][y][size - 1].getColor(PlainCubelet.CubeletSide.NORTH);
                utils(color1,builder1,index);
                System.out.println(color1);
            }
        }
        for (int i = 6; i < 9; i++) {
            builder.append(builder1.charAt(i));
        }
        for (int i = 3; i < 6; i++) {
            builder.append(builder1.charAt(i));
        }
        for (int i = 0; i < 3; i++) {
            builder.append(builder1.charAt(i));
        }
        builder1.setLength(0);
        // Check bottom
        PlainCubelet.CubeletColor bottomColor = cubelets[0][0][0].getColor(PlainCubelet.CubeletSide.BOTTOM);
        System.out.println(bottomColor.getGdxColor());
        for(int z = 0; z < size; z++) {
            for(int x = 0; x < size; x++) {
            //                if(!cubelets[x][0][z].getColor(PlainCubelet.CubeletSide.BOTTOM).equals(bottomColor))
//                    return false;
                PlainCubelet.CubeletColor color = cubelets[x][0][z].getColor(PlainCubelet.CubeletSide.BOTTOM);
                utils(color,builder1,index);

                System.out.println(color);
            }
        }
        for (int i = 6; i < 9; i++) {
            builder.append(builder1.charAt(i));
        }
        for (int i = 3; i < 6; i++) {
            builder.append(builder1.charAt(i));
        }
        for (int i = 0; i < 3; i++) {
            builder.append(builder1.charAt(i));
        }
        builder1.setLength(0);

        // Check west   l
        PlainCubelet.CubeletColor westColor = cubelets[0][0][0].getColor(PlainCubelet.CubeletSide.WEST);
        System.out.println(westColor.toString());
        for(int y = 0; y < size; y++) {
            for(int z = 0; z < size; z++) {
//                if(!cubelets[0][y][z].getColor(PlainCubelet.CubeletSide.WEST).equals(westColor))
//                    return false;
                PlainCubelet.CubeletColor color = cubelets[0][y][z].getColor(PlainCubelet.CubeletSide.WEST);
                utils(color,builder1,index);

                System.out.println(color);

            }
        }


        for (int i = 6; i < 9; i++) {
            builder.append(builder1.charAt(i));
        }
        for (int i = 3; i < 6; i++) {
            builder.append(builder1.charAt(i));
        }
        for (int i = 0; i < 3; i++) {
            builder.append(builder1.charAt(i));
        }
        builder1.setLength(0);




        // Check south  h  dui
        PlainCubelet.CubeletColor southColor = cubelets[0][0][0].getColor(PlainCubelet.CubeletSide.SOUTH);
        System.out.println(southColor.getGdxColor().toString());
        for(int y = 0; y < size; y++) {
            for(int x = 0; x < size; x++) {
                PlainCubelet.CubeletColor color = cubelets[x][y][0].getColor(PlainCubelet.CubeletSide.SOUTH);
                utils(color,builder1,index);

                System.out.println(color);
            }
        }



        for (int i = 0; i < 9; i++) {
            builder.append(builder1.charAt(8-i));
        }
        builder1.setLength(0);




        System.out.println(builder.toString());
        solver(builder.toString());
    }

    private static void utils(PlainCubelet.CubeletColor color,StringBuilder builder,int index){
        System.out.println(index +"  "+ index);
        if(color.equals(PlainCubelet.CubeletColor.BLUE)){
            builder.append("U");
        }else if(color.equals(PlainCubelet.CubeletColor.WHITE)){
            builder.append("B");
        }else if(color.equals(PlainCubelet.CubeletColor.GREEN)){
            builder.append("F");
        }else if(color.equals(PlainCubelet.CubeletColor.ORANGE)){
            builder.append("L");
        }else if(color.equals(PlainCubelet.CubeletColor.YELLOW)){
            builder.append("R");
        }else if(color.equals(PlainCubelet.CubeletColor.RED)){
            builder.append("D");
        }
    }

    public static String solver(String scrambledCube){
        Search.init();
        String result = new Search().solution(scrambledCube, 21, 100000000, 0, 0);
        System.out.println(result);
        return result;
    }

}
