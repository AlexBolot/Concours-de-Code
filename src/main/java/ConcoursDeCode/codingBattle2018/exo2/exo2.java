package ConcoursDeCode.codingBattle2018.exo2;

/*................................................................................................................................
 . Copyright (c)
 .
 . The exo2	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/03/18 20:22
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.ArrayList;
import java.util.Scanner;

public class exo2 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        int menuPrice = Integer.parseInt(firstLine);
        int peoplecount = Integer.parseInt(secondLine);

        ArrayList<Integer> peoplePerTable = new ArrayList<>();
        for (int i = 0; i < peoplecount; i++) {
            Integer nextInt = scanner.nextInt();
            peoplePerTable.add(nextInt);
        }


        double totalPrice = 0d;

        for (Integer value : peoplePerTable) {
            if (value >= 10) totalPrice += value * .7 * menuPrice;
            else if (value >= 6) totalPrice += value * .8 * menuPrice;
            else if (value >= 4) totalPrice += value * .9 * menuPrice;
            else totalPrice += value * menuPrice;
        }

        System.out.println(Math.ceil(totalPrice));
    }
}
