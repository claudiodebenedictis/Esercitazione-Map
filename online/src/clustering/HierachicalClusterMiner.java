package src.clustering;

import src.data.Data;
import src.exceptions.InvalidDepthException;
import src.exceptions.InvalidSizeException;

// File: HierarchicalClusterMiner.java
public class HierachicalClusterMiner {
    private Dendrogram dendrogram;

    public HierachicalClusterMiner(int depth) throws InvalidDepthException {
        dendrogram = new Dendrogram(depth);
    }

    public void mine(Data data, ClusterDistance distance) throws InvalidSizeException {
        int depth = dendrogram.getDepth();
        if (depth < 1) return;

        // Livello 0: ogni esempio nel proprio cluster
        ClusterSet initialSet = new ClusterSet(data.getNumberOfExamples());
        for (int i = 0; i < data.getNumberOfExamples(); i++) {
            Cluster c = new Cluster();
            c.addData(i);
            initialSet.add(c);
        }
        dendrogram.setClusterSet(initialSet, 0);

        // Costruire i livelli successivi
        for (int level = 1; level < depth; level++) {
            ClusterSet previousSet = dendrogram.getClusterSet(level - 1);
            ClusterSet mergedSet = previousSet.mergeClosestClusters(distance, data);
            if (mergedSet == null) break; // Non ci sono più cluster da fondere
            dendrogram.setClusterSet(mergedSet, level);
        }
    }

    @Override
    public String toString() {
        return dendrogram.toString();
    }

    public String toString(Data data) {
        return dendrogram.toString(data);
    }
}
