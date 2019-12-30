package ConcoursDeCode.codingBattle2018.exo1;

import java.util.ArrayList;
import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The a_loot_sharing	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/03/18 20:20
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class exo1 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        String firstLine = sc.nextLine();

        int restaurantAmount = Integer.parseInt(firstLine);

        ArrayList<Double[]> allRatings = new ArrayList<>();

        for (int i = 0; i < restaurantAmount; i++) {
            String[] split = sc.nextLine().split(" ");

            Double[] tmpRes = new Double[3];

            for (int j = 0; j < split.length; j++) {
                tmpRes[j] = Double.valueOf(split[j]);
            }

            allRatings.add(tmpRes);
        }

        ArrayList<Double> collect = new ArrayList<>();

        for (Double[] array : allRatings) {
            Double sum = 0.0;

            for (Double d : array) {
                sum += d;
            }

            Double aDouble = sum / array.length;
            collect.add(aDouble);
        }

        System.out.println(Math.ceil(collect.stream().max(Double::compareTo).get()));
    }
}
