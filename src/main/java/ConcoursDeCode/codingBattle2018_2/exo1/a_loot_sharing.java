/*................................................................................................................................
 . Copyright (c)
 .
 . The a_loot_sharing	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 17/10/18 19:02
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.Scanner;

public class a_loot_sharing {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int b = sc.nextInt();
        int t = sc.nextInt();
        int n = sc.nextInt();

        int bgold = b * 2;

        int tgold = t * 3;

        System.out.println(n >= (bgold + tgold) ? "LOOT!" : "RHUM!");

    }


}
