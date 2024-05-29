package src.distance;

import src.clustering.Cluster;
import src.data.Data;
import src.data.Example;
import src.exceptions.InvalidSizeException;
import src.clustering.ClusterDistance;

import java.util.Iterator;

public class SingleLinkDistance implements ClusterDistance {
    @Override
    public double distance(Cluster c1, Cluster c2, Data data) throws InvalidSizeException {
        double min = Double.MAX_VALUE;

        Iterator<Integer> c1Iterator = c1.iterator();
        while (c1Iterator.hasNext()) {
            Example e1 = data.getExample(c1Iterator.next());
            Iterator<Integer> c2Iterator = c2.iterator();
            while (c2Iterator.hasNext()) {
                double distance = e1.distance(data.getExample(c2Iterator.next()));
                if (distance < min) {
                    min = distance;
                }


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

}

