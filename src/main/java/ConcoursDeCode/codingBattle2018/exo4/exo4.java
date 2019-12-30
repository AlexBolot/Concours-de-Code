package ConcoursDeCode.codingBattle2018.exo4;

/*................................................................................................................................
 . Copyright (c)
 .
 . The exo4	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 27/03/18 21:03
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class exo4
{
    public static void main (String... args)
    {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> sizes = IntStream.range(0, 6).mapToObj(i -> sc.nextInt()).collect(Collectors.toCollection(ArrayList::new));

        int count = 0;

        while (!isSorted(sizes))
        {
            int val = sizes.stream().max(Integer::compareTo).get();
            int indexOfVal = sizes.indexOf(val);

            if (indexOfVal != sizes.size() - 1)
            {
                if (indexOfVal != 0)
                {
                    flip(sizes, indexOfVal);
                    count++;
                    if (isSorted(sizes)) break;
                }

                flip(sizes, sizes.size() - 1);

                if (isSorted(sizes)) break;

                count ++;
            }
            sizes.remove(sizes.size() - 1);
        }

        System.out.println(count);
    }

    private static void flip (ArrayList<Integer> integers, int index)
    {
        ArrayList<Integer> newValues = new ArrayList<>();

        for (int i = index; i >= 0; i--)
        {
            newValues.add(integers.remove(i));
        }

        newValues.addAll(integers);

        integers.clear();
        integers.addAll(newValues);
    }

    private static boolean isSorted (ArrayList<Integer> list)
    {
        boolean sorted = true;

        for (int i = 1; i < list.size(); i++)
        {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) sorted = false;
        }

        return sorted;
    }
}
