/*................................................................................................................................
 . Copyright (c)
 .
 . The a_paris	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 18/10/17 19:00
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.Arrays;
import java.util.Scanner;

public class a_paris {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        int p = Integer.parseInt(sc.nextLine());

        int n = Integer.parseInt(sc.nextLine());

        String[] split = sc.nextLine().split(" ");

        if (n != split.length) return;

        int[] tab = new int[n];

        String s;
        int val;

        for (int i = 0; i < n; i++) {
            s = split[i];

            val = Integer.parseInt(s);

            tab[i] = val;
        }

        Arrays.sort(tab);

        float mediane;

        if (n % 2 == 0) {
            mediane = ((float) (tab[(n / 2) - 1] + tab[(n / 2)])) / 2;
        } else {
            mediane = tab[n / 2];
        }

        if (mediane < p) System.out.print("Parie !");
        else System.out.print("Jockey suivant !");
    }
}