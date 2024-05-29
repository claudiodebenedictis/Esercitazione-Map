public class Example {
    private Double[] example;

    public Example(int length) {
        example = new Double[length];
    }

    public void set(int index, Double v) {
        example[index] = v;
    }

    public Double get(int index) {
        return example[index];
    }

    public double distance(Example newE) {
        double sum = 0;
        for (int i = 0; i < this.example.length; i++) {
            sum += Math.pow(this.example[i] - newE.get(i), 2);
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < example.length - 1; i++) {
            sb.append(example[i]).append(",");
        }
        sb.append(example[example.length - 1]).append("]");
        return sb.toString();
    }
}
