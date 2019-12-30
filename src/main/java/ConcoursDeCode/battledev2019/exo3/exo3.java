package ConcoursDeCode.battledev2019.exo3;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The exo2	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 3/26/19 8:48 PM
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings("ALL")
public class exo3 {

    public static void main(String[] args) {

        ArrayList<String> res = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int lines = Integer.parseInt(sc.nextLine());

        System.err.println("---- " + lines);

        String[][] grid = new String[lines][lines];

        Point pos = new Point(0, 0);

        ArrayList<Point> coins = new ArrayList<>();
        ArrayList<Point> mult = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            String line = sc.nextLine();
            System.err.println(line);
            grid[i] = line.split("");

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].contains("o"))
                    coins.add(new Point(j, i));

                if (grid[i][j].contains("*"))
                    mult.add(new Point(j, i));
            }
        }

        for (Point coin : coins) {
            int deltaX = coin.x - pos.x;
            int deltaY = coin.y - pos.y;

            pos = coin;

            System.err.println(deltaX + " - " + deltaY);

            for (int i = 0; i < Math.abs(deltaX); i++) {
                if (deltaX > 0) {
                    res.add(">");
                    System.err.println(">");
                }
                if (deltaX < 0) {
                    res.add("<");
                    System.err.println("<");
                }
            }

            for (int i = 0; i < Math.abs(deltaY); i++) {
                if (deltaY > 0) {
                    res.add("v");
                    System.err.println("v");
                }
                if (deltaY < 0) {
                    res.add("^");
                    System.err.println("^");
                }
            }

            res.add("x");
            System.err.println("x");
        }

        for (Point m : mult) {
            int deltaX = m.x - pos.x;
            int deltaY = m.y - pos.y;

            pos = m;

            System.err.println(deltaX + " - " + deltaY);

            for (int i = 0; i < Math.abs(deltaX); i++) {
                if (deltaX > 0) {
                    res.add(">");
                    System.err.println(">");
                }
                if (deltaX < 0) {
                    res.add("<");
                    System.err.println("<");
                }
            }

            for (int i = 0; i < Math.abs(deltaY); i++) {
                if (deltaY > 0) {
                    res.add("v");
                    System.err.println("v");
                }
                if (deltaY < 0) {
                    res.add("^");
                    System.err.println("^");
                }
            }

            res.add("x");
            System.err.println("x");
        }


        System.out.println(Arrays.toString(res.toArray()).replaceAll(",", "").replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", ""));
        System.err.println(Arrays.toString(res.toArray()).replaceAll(",", "").replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", ""));

        System.err.println("-------");
        System.err.println("-------");
        System.err.println("-------");
    }

}


//  >x>>x<<vvxvx>>>x
//  >x>>x<<<vxvxvvx>vvx<vx>vx>>>x