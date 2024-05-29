public class AverageLinkdistance implements ClusterDistance {
    @Override
    public double distance(Cluster c1, Cluster c2, Data data) {
        double totalDistance = 0;
        int count = 0;

        for (int i = 0; i < c1.getSize(); i++) {
            Example e1 = data.getExample(c1.getElement(i));
            for (int j = 0; j < c2.getSize(); j++) {
                Example e2 = data.getExample(c2.getElement(j));
                totalDistance += e1.distance(e2);
                count++;
            }
        }

        if (count == 0) {
            return Double.MAX_VALUE;  // Evita la divisione per zero nel caso di cluster vuoti.
        }
        return totalDistance / count;
    }
}
