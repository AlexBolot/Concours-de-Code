/*................................................................................................................................
 . Copyright (c)
 .
 . The b_bulletin	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 18/10/17 19:38
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.Scanner;

public class b_bulletin
{
    public static void main (String... args)
    {
        Scanner sc = new Scanner(System.in);

        int note = Integer.parseInt(sc.nextLine());

        String[] split = sc.nextLine().split(" ");

        int noteMin = Integer.parseInt(split[0]);
        int noteMax = Integer.parseInt(split[1]);

        float moyenneClasse = Float.parseFloat(sc.nextLine());

        int nCamarades = Integer.parseInt(sc.nextLine());

        String[] allNotes = sc.nextLine().split(" ");
        int[] intNotes = new int[nCamarades + 1];

        for (int i = 0; i < nCamarades; i++)
        {
            intNotes[i] = Integer.parseInt(allNotes[i]);
        }

        intNotes[intNotes.length - 1] = note;

        float moyenne = moyenne(intNotes);
        boolean moyenneEquals = moyenne == moyenneClasse || Math.abs(moyenne - moyenneClasse) < 0.02;

        if (moyenneEquals && min(intNotes) == noteMin && max(intNotes) == noteMax) System.out.print("RAS");
        else System.out.print("Jack ! Viens ici !");
    }

    public static float moyenne (int[] tab)
    {
        int sum = 0;

        for (int i = 0; i < tab.length; i++)
        {
            sum += tab[i];
        }

       return (float) sum / tab.length;
    }

    public static int min (int[] tab)
    {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < tab.length; i++)
        {
            if (tab[i] < min) min = tab[i];
        }

        return min;
    }

    public static int max (int[] tab)
    {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < tab.length; i++)
        {
            if (tab[i] > max) max = tab[i];
        }

        return max;
    }
}
