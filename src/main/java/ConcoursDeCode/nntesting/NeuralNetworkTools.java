package ConcoursDeCode.nntesting;

/*................................................................................................................................
 . Copyright (c)
 .
 . The NeuralNetworkTools	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 09/11/17 00:43
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class NeuralNetworkTools
{
    public static double[] createArray (int size, double init_value)
    {
        return size < 1 ? null : IntStream.range(0, size).mapToDouble(i -> init_value).toArray();
    }

    public static double[] createRandomArray (int size, double lower_bound, double upper_bound)
    {
        return size < 1 ? null : IntStream.range(0, size).mapToDouble(i -> randomValue(lower_bound, upper_bound)).toArray();
    }

    public static double[][] createRandomArray (int sizeX, int sizeY, double lower_bound, double upper_bound)
    {
        return sizeX < 1 || sizeY < 1 ? null : IntStream.range(0, sizeX)
                                                        .mapToObj(i -> createRandomArray(sizeY, lower_bound, upper_bound))
                                                        .toArray(double[][]::new);
    }

    public static double randomValue (double lower_bound, double upper_bound)
    {
        return Math.random() * (upper_bound - lower_bound) + lower_bound;
    }

    public static Integer[] randomValues (int lowerBound, int upperBound, int amount)
    {
        Set<Integer> set = new HashSet<>();

        while (set.size() < amount)
        {
            set.add(new Random().nextInt(upperBound - lowerBound + 1) + lowerBound);
        }

        return set.toArray(new Integer[0]);
    }


}
