import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/*................................................................................................................................
 . Copyright (c)
 .
 . The c_sea_storm	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 17/10/18 19:19
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class c_sea_storm {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int longPont = sc.nextInt();
        int nbPirates = sc.nextInt();

        ArrayList<Integer> pont = new ArrayList<>();
        ArrayList<Integer> places = new ArrayList<>();
        ArrayList<Integer> hatSizes = new ArrayList<>();

        for (int i = 0; i < longPont; i++) {
            pont.add(0);
        }

        for (int i = 0; i < nbPirates; i++) {
            places.add(sc.nextInt());
        }

        for (int i = 0; i < nbPirates; i++) {
            hatSizes.add(sc.nextInt());
        }

        hatSizes.sort(Integer::compareTo);

        int lastIndexCovered = 0;

        for (int pIndex = 0; pIndex < nbPirates; pIndex++) {

            int position = places.get(pIndex) - 1;

            System.out.println("pos : " + position);

            for (int hIndex = 0; hIndex < nbPirates; hIndex++) {

                int hatSize = hatSizes.get(hIndex);

                System.out.println("hat : " + hatSize);

                int hatRadius = (hatSize - 1) / 2;

                if (position - hatRadius >= lastIndexCovered) {

                    System.out.println("selected " + hatSize);

                    for (int k = Math.max(position - hatRadius, 0); k <= Math.min(position + hatRadius, pont.size() - 1); k++) {
                        pont.set(k, 1);
                    }

                    lastIndexCovered = position + hatRadius;

                    hatSizes.remove(hIndex);

                    break;
                }
            }
        }

        System.out.println(Arrays.toString(pont.toArray()));

        System.out.println(pont.contains(0) ? "NO" : "YES");
    }
}
