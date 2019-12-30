/*................................................................................................................................
 . Copyright (c)
 .
 . The d_fractale	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 18/10/17 20:52
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.Scanner;

public class d_fractale {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        int a = Integer.parseInt(sc.nextLine());

        switch (a) {
            case 0:
                System.out.println("X");
                break;

            case 1:
                System.out.println("X X");
                System.out.println(" X ");
                System.out.println("X X");
                break;

            case 2:
                System.out.println("X X   X X");
                System.out.println(" X     X ");
                System.out.println("X X   X X");

                System.out.println("   X X   ");
                System.out.println("    X    ");
                System.out.println("   X X   ");

                System.out.println("X X   X X");
                System.out.println(" X     X ");
                System.out.println("X X   X X");
                break;
        }
    }

}
