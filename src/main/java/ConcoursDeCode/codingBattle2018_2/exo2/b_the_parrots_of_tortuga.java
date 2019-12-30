import java.util.ArrayList;
import java.util.Scanner;

/*................................................................................................................................
 . Copyright (c)
 .
 . The b_the_parrots_of_tortuga	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 17/10/18 19:08
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class b_the_parrots_of_tortuga {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int gold = sc.nextInt();
        int count = sc.nextInt();
        ArrayList<Triplet> map = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            map.add(new Triplet(sc.next(), sc.nextInt(), sc.nextInt()));
        }

        String maxName = "";
        int maxCount = 0;

        for (Triplet entry : map) {

            count = (gold - entry.val2) / entry.val1;

            if (count > maxCount) {
                maxCount = count;
                maxName = entry.key;
            }
        }

        if (maxName.isEmpty()) {
            System.out.println("Impossible");
        } else {
            System.out.println(maxCount);
            System.out.println(maxName);
        }

    }


}

class Triplet {
    String key;
    int val1;
    int val2;

    public Triplet(String key, int val1, int val2) {
        this.key = key;
        this.val1 = val1;
        this.val2 = val2;
    }
}