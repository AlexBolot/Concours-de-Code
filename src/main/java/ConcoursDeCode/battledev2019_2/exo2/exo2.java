package ConcoursDeCode.battledev2019_2.exo2;

/*................................................................................................................................
 . Copyright (c)
 .
 . The exo2	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 3/26/19 8:24 PM
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class exo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> lengths = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            lengths.add(sc.nextInt());
        }

        int min = Collections.min(lengths);

        Integer integer = lengths.stream().map(i -> i - min).reduce(Integer::sum).get();

        System.out.println(integer);
    }
}
