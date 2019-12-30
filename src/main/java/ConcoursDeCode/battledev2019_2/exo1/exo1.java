package ConcoursDeCode.battledev2019_2.exo1;

/*................................................................................................................................
 . Copyright (c)
 .
 . The exo1	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 3/26/19 8:04 PM
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class exo1 {
    public static void main(String[] argv) throws Exception {
        String line;
        Scanner sc = new Scanner(System.in);

        double amount = Double.parseDouble(sc.nextLine());
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            line = sc.nextLine();
            if (line.isEmpty()) break;
            String name = line.split(" ")[0];
            Integer value = Integer.valueOf(line.split(" ")[1]);
            list1.add(name);
            list2.add(value);
        }

        List<Integer> arrayList = new ArrayList<>(list2).stream().sorted().collect(Collectors.toList());

        System.out.println(list1.get(list2.indexOf(arrayList.get(0))));
    }
}