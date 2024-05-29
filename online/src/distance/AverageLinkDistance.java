package src.distance;

import src.clustering.Cluster;
import src.data.Data;
import src.data.Example;
import src.exceptions.InvalidSizeException;
import src.clustering.ClusterDistance;
import java.util.Iterator;

public class AverageLinkDistance implements ClusterDistance {
    @Override
    public double distance(Cluster c1, Cluster c2, Data data) throws InvalidSizeException {
    double totalDistance = 0;
        int count = 0;

        Iterator<Integer> c1Iterator = c1.iterator();
        while (c1Iterator.hasNext()) {
            Example e1 = data.getExample(c1Iterator.next());
            Iterator<Integer> c2Iterator = c2.iterator();
            while (c2Iterator.hasNext()) {
                Example e2 = data.getExample(c2Iterator.next());
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
