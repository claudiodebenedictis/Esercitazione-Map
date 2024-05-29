package src.distance;

import src.clustering.Cluster;
import src.data.Data;
import src.data.Example;
import src.exceptions.InvalidSizeException;
import src.clustering.ClusterDistance;

public class SingleLinkDistance implements ClusterDistance {
    public double distance(Cluster c1, Cluster c2, Data d) throws InvalidSizeException {
        double min = Double.MAX_VALUE;

        for (int i = 0; i < c1.getSize(); i++) {
            Example e1 = d.getExample(c1.getElement(i));
            for (int j = 0; j < c2.getSize(); j++) {
                double distance = e1.distance(d.getExample(c2.getElement(j)));
                if (distance < min)
                    min = distance;
            }
        }
        return min;
    }
}