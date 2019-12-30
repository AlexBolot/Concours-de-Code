/*................................................................................................................................
 . Copyright (c)
 .
 . The c_analexes	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 18/10/17 20:20
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.Arrays;
import java.util.Scanner;

public class c_analexes {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        String[] split1 = sc.nextLine().replaceAll("[.,:;!?^+=_]", " ").replaceAll("\\s+", " ").toLowerCase().trim().split(" ");
        String[] split2 = sc.nextLine().replaceAll("[.,:;!?^+=_]", " ").replaceAll("\\s+", " ").toLowerCase().trim().split(" ");

        if (split1.length != split2.length) {
            System.out.println("NON");
            return;
        }

        Arrays.sort(split1);
        Arrays.sort(split2);

        for (int i = 0; i < split1.length; i++) {
            if (!split1[i].equals(split2[i])) {
                System.out.println("NON");
                return;
            }
        }

        System.out.println("ANALEXES");
    }
}
