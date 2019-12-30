package ConcoursDeCode.battledev;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Main	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 07/11/17 20:02
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main (String... args)
    {
        Scanner sc = new Scanner(System.in);

        int side = Integer.parseInt(sc.nextLine());

        ArrayList<String> lines = new ArrayList<>();

        String[][] strings = new String[side][side];

        for (int i = 0; i < side; i++)
        {
            String line = sc.nextLine();

            lines.add(line);
            strings[i] = line.split("");
        }

        for (int i = 0; i < lines.size(); i++)
        {
            String[] chars2 = strings[i];
            String[] chars1 = (i > 0) ? strings[i - 1] : null;
            String[] chars3 = (i < lines.size() - 1) ? strings[i + 1] : null;

            for (int j = 0; j < chars2.length; j++)
            {
                if (chars2[j].equals("X"))
                {
                    if (chars1 != null && chars1[j].equals(".")) strings[i - 1][j] = "o";
                    if (chars3 != null && chars3[j].equals(".")) strings[i + 1][j] = "o";

                    if (j > 0)
                    {
                        if (chars1 != null && chars1[j - 1].equals(".")) strings[i - 1][j - 1] = "o";
                        if (chars3 != null && chars3[j - 1].equals(".")) strings[i + 1][j - 1] = "o";
                        if (chars2[j - 1].equals(".")) strings[i][j - 1] = "o";
                    }

                    if (j < chars2.length - 1)
                    {
                        if (chars1 != null && chars1[j + 1].equals(".")) strings[i - 1][j + 1] = "o";
                        if (chars3 != null && chars3[j + 1].equals(".")) strings[i + 1][j + 1] = "o";
                        if (chars2[j + 1].equals(".")) strings[i][j + 1] = "o";
                    }
                }
            }
        }

        StringBuilder str = new StringBuilder();

        Arrays.stream(strings).forEach(strings1 -> Arrays.stream(strings1).forEach(str::append));

        System.out.println(str.chars().filter(value -> value == 'o').count());
    }
}