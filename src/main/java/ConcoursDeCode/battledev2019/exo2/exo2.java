package ConcoursDeCode.battledev2019.exo2;

/*................................................................................................................................
 . Copyright (c)
 .
 . The exo2	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 3/26/19 8:24 PM
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.Scanner;

public class exo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amount = Integer.parseInt(sc.nextLine());
        int moves = 0;
        int local = 0;

        for (int i = 0; i < amount; i++) {

            int box = Integer.parseInt(sc.nextLine());

            System.err.println(box);

            if (local + box > 100) {
                moves++;
                local = box;
            } else if (local + box == 100) {
                moves++;
                local = 0;
            } else {
                local += box;
            }
        }

        if (local != 0)
            moves++;

        System.out.println(moves);

        System.err.println("----");


    }
}
