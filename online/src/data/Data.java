package src.data;

import src.exceptions.InvalidSizeException;


import java.util.Iterator;



public class Data {
    private Example[] data;
    private int numberOfExamples;

    public Data() {
        data = new Example[5];


        Example e = new Example();
        e.add(1.0);
        e.add(2.0);
        e.add(0.0);
        data[0] = e;

        e = new Example();
        e.add(0.0);
        e.add(1.0);
        e.add(-1.0);
        data[1] = e;

        e = new Example();
        e.add(1.0);
        e.add(3.0);
        e.add(5.0);
        data[2] = e;

        e = new Example();
        e.add(1.0);
        e.add(3.0);
        e.add(4.0);
        data[3] = e;

        e = new Example();
        e.add(2.0);
        e.add(2.0);
        e.add(0.0);

        Example e = new Example(3);
        e.set(0, 1.0);
        e.set(1, 2.0);
        e.set(2, 0.0);
        data[0] = e;

        e = new Example(3);
        e.set(0, 0.0);
        e.set(1, 1.0);
        e.set(2, -1.0);
        data[1] = e;

        e = new Example(3);
        e.set(0, 1.0);
        e.set(1, 3.0);
        e.set(2, 5.0);
        data[2] = e;

        e = new Example(3);
        e.set(0, 1.0);
        e.set(1, 3.0);
        e.set(2, 4.0);
        data[3] = e;

        e = new Example(3);
        e.set(0, 2.0);
        e.set(1, 2.0);
        e.set(2, 0.0);

        data[4] = e;

        numberOfExamples = 5;
    }

    public int getNumberOfExamples() {
        return numberOfExamples;
    }

    public Example getExample(int exampleIndex) {
        return data[exampleIndex];
    }

    public double[][] distance() throws InvalidSizeException {
        int n = getNumberOfExamples();
        double[][] distances = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                distances[i][j] = data[i].distance(data[j]);
            }
        }
        return distances;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Example> iterator = new Iterator<Example>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < numberOfExamples;
            }

            @Override
            public Example next() {
                return data[index++];
            }
        };

        int index = 0;
        while (iterator.hasNext()) {
            Example example = iterator.next();
            sb.append(index++).append(":").append(example).append("\n");
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfExamples; i++) {
            sb.append(i).append(":").append(data[i]).append("\n");

        }
        return sb.toString();
    }
}
