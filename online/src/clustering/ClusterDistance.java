package src.clustering;
import src.data.Data;
import src.exceptions.InvalidSizeException;

public interface ClusterDistance {
		double distance(Cluster c1, Cluster c2, Data d) throws InvalidSizeException;
}
