package ConcoursDeCode.battledev2019.exo1;

/*................................................................................................................................
 . Copyright (c)
 .
 . The exo1	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 3/26/19 8:04 PM
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.Scanner;

public class exo1 {
    public static void main(String[] argv) throws Exception {

        Scanner sc = new Scanner(System.in);

        int position = Integer.parseInt(sc.nextLine());

        for (int i = 2; i < 43; i++) {
            String s = sc.nextLine();

            position += Integer.parseInt(s.split(" ")[0]);
            position -= Integer.parseInt(s.split(" ")[1]);
        }

        if (position <= 100)
            System.out.println("1000");

        else if (position == 10001)
            System.out.println("100");

        else if (position < 10000)
            System.out.println("100");

        else
            System.out.println("KO");

        System.out.println(position);

    }
}