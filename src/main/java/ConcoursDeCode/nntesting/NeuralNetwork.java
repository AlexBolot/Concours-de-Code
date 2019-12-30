package ConcoursDeCode.nntesting;

/*................................................................................................................................
 . Copyright (c)
 .
 . The NeuralNetwork	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 08/11/17 22:19
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.Arrays;
import java.util.stream.IntStream;

public class NeuralNetwork
{
    // weights[layer][neuron][previousNeuron]
    // output[layer][neuron]
    // bias[layer][neuron]

    private double[][]   output;
    private double[][][] weights;
    private double[][]   bias;

    private double[][] errorSignals;
    private double[][] outputDerivative;

    private final int[] NETWORK_LAYER_SIZES;
    private final int   INPUT_SIZE;
    private final int   OUTPUT_SIZE;
    private final int   NETWORK_SIZE;

    public NeuralNetwork (int... network_layer_sizes)
    {
        NETWORK_LAYER_SIZES = network_layer_sizes;
        NETWORK_SIZE = network_layer_sizes.length;
        INPUT_SIZE = network_layer_sizes[0];
        OUTPUT_SIZE = network_layer_sizes[NETWORK_SIZE - 1];

        output = new double[NETWORK_SIZE][];
        errorSignals = new double[NETWORK_SIZE][];
        outputDerivative = new double[NETWORK_SIZE][];
        weights = new double[NETWORK_SIZE][][];
        bias = new double[NETWORK_SIZE][];

        for (int i = 0; i < NETWORK_SIZE; i++)
        {
            output[i] = new double[NETWORK_LAYER_SIZES[i]];
            errorSignals[i] = new double[NETWORK_LAYER_SIZES[i]];
            outputDerivative[i] = new double[NETWORK_LAYER_SIZES[i]];
            bias[i] = NeuralNetworkTools.createRandomArray(NETWORK_LAYER_SIZES[i], 0.3, 0.7);

            if (i > 0) weights[i] = NeuralNetworkTools.createRandomArray(NETWORK_LAYER_SIZES[i], NETWORK_LAYER_SIZES[i - 1], -0.3, 0.5);
        }
    }

    private double[] calculate (double... input)
    {
        if (input.length != INPUT_SIZE) return null;

        output[0] = input;

        for (int layer = 1; layer < NETWORK_SIZE; layer++)
        {
            for (int neuron = 0; neuron < NETWORK_LAYER_SIZES[layer]; neuron++)
            {
                double sum = bias[layer][neuron];

                for (int prevNeuron = 0; prevNeuron < NETWORK_LAYER_SIZES[layer - 1]; prevNeuron++)
                {
                    sum += output[layer - 1][prevNeuron] * weights[layer][neuron][prevNeuron];
                }

                output[layer][neuron] = sigmoid(sum);
                outputDerivative[layer][neuron] = output[layer][neuron] * (1 - output[layer][neuron]);
            }
        }

        return output[NETWORK_SIZE - 1];
    }

    private double sigmoid (double x)
    {
        return 1d / (1 + Math.exp(-x));
    }

    public void train (TrainSet trainSet, int loops, int batchSize)
    {
        for (int i = 0; i < loops; i++)
        {
            TrainSet batch = trainSet.extractBatch(batchSize);

            IntStream.range(0, batchSize).forEach(b -> train(batch.getInput(b), batch.getOutput(b), 0.3));
        }
    }

    public void train (double[] input, double[] target, double eta)
    {
        if (input.length != INPUT_SIZE || target.length != OUTPUT_SIZE) return;
        calculate(input);
        backPropError(target);
        updateWeights(eta);
    }

    private void backPropError (double[] target)
    {
        IntStream.range(0, NETWORK_LAYER_SIZES[NETWORK_SIZE - 1])
                 .forEach(neuron -> errorSignals[NETWORK_SIZE - 1][neuron] = (output[NETWORK_SIZE - 1][neuron] - target[neuron]));

        for (int layer = NETWORK_SIZE - 2; layer > 0; layer--)
        {
            for (int neuron = 0; neuron < NETWORK_LAYER_SIZES[layer]; neuron++)
            {
                double sum = 0;

                for (int nextNeuron = 0; nextNeuron < NETWORK_LAYER_SIZES[layer + 1]; nextNeuron++)
                {
                    sum += weights[layer + 1][nextNeuron][neuron] * errorSignals[layer + 1][nextNeuron];
                }

                errorSignals[layer][neuron] = sum * outputDerivative[layer][neuron];
            }
        }
    }

    private void updateWeights (double eta)
    {
        for (int layer = 1; layer < NETWORK_SIZE; layer++)
        {
            for (int neuron = 0; neuron < NETWORK_LAYER_SIZES[layer]; neuron++)
            {
                for (int prevNeuron = 0; prevNeuron < NETWORK_LAYER_SIZES[layer - 1]; prevNeuron++)
                {
                    double delta = -eta * output[layer - 1][prevNeuron] * errorSignals[layer][neuron];

                    weights[layer][neuron][prevNeuron] += delta;
                }

                double delta = -eta * errorSignals[layer][neuron];

                bias[layer][neuron] += delta;
            }
        }
    }

    public static void main (String... args)
    {
        NeuralNetwork neuralNetwork = new NeuralNetwork(4, 3, 3, 2);

        TrainSet set = new TrainSet(4, 2);
        set.addData(new double[]{0.1, 0.2, 0.3, 0.4}, new double[]{1.0, 0.0});
        set.addData(new double[]{0.9, 0.8, 0.7, 0.6}, new double[]{0.0, 1.0});
        set.addData(new double[]{0.3, 0.8, 0.1, 0.4}, new double[]{0.3, 0.7});
        set.addData(new double[]{0.9, 0.8, 0.1, 0.2}, new double[]{0.7, 0.3});

        neuralNetwork.train(set, 100000, 4);

        double[] tab = new double[]{0.1, 0.3, 0.3, 0.4};

        for (int i = 0; i < 4; i++)
        {
            System.out.println(Arrays.toString(neuralNetwork.calculate(set.getInput(i))));
        }

        System.out.println(Arrays.toString(neuralNetwork.calculate(tab)));
    }
}
