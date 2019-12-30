package ConcoursDeCode.nntesting;

import java.util.ArrayList;
import java.util.Arrays;

/*................................................................................................................................
 . Copyright (c)
 .
 . The TrainSet	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 09/11/17 19:08
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

/**
 Created by Luecx on 09.08.2017.
 */
public class TrainSet
{
    private final int inputSize;
    private final int outputSize;

    //double[][] <- index1: 0 = input, 1 = output || index2: index of element
    private ArrayList<double[][]> data = new ArrayList<>();

    public TrainSet (int inputSize, int outputSize)
    {
        this.inputSize = inputSize;
        this.outputSize = outputSize;
    }

    public static void main (String[] args)
    {
        TrainSet set = new TrainSet(3, 2);

        for (int i = 0; i < 8; i++)
        {
            double[] a = new double[3];
            double[] b = new double[2];
            for (int k = 0; k < 3; k++)
            {
                a[k] = (double) ((int) (Math.random() * 10)) / (double) 10;
                if (k < 2) b[k] = (double) ((int) (Math.random() * 10)) / (double) 10;
            }
            set.addData(a, b);
        }

        System.out.println(set);
        System.out.println(set.extractBatch(3));
    }

    public void addData (double[] in, double[] expected)
    {
        if (in.length != inputSize || expected.length != outputSize) return;
        data.add(new double[][]{in, expected});
    }

    public TrainSet extractBatch (int size)
    {
        if (size > 0 && size <= this.size())
        {
            TrainSet set = new TrainSet(inputSize, outputSize);
            Integer[] ids = NeuralNetworkTools.randomValues(0, this.size() - 1, size);

            Arrays.stream(ids).forEach(i -> set.addData(this.getInput(i), this.getOutput(i)));

            return set;
        }
        else return this;
    }

    public String toString ()
    {
        StringBuilder s = new StringBuilder("TrainSet [" + inputSize + " ; " + outputSize + "]\n");
        int index = 0;

        for (double[][] r : data)
        {
            s.append(index).append(":   ").append(Arrays.toString(r[0])).append("  >-||-<  ").append(Arrays.toString(r[1])).append("\n");
            index++;
        }
        return s.toString();
    }

    public int size ()
    {
        return data.size();
    }

    public double[] getInput (int index)
    {
        return index >= 0 && index < size() ? data.get(index)[0] : null;
    }

    public double[] getOutput (int index)
    {
        return index >= 0 && index < size() ? data.get(index)[1] : null;
    }

    public int inputSize ()
    {
        return inputSize;
    }

    public int outputSize ()
    {
        return outputSize;
    }
}
