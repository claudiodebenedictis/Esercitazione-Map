public class ClusterSet {
    private Cluster[] C;
    private int lastClusterIndex = 0;

    public ClusterSet(int k) {
        C = new Cluster[k];
    }

    public void add(Cluster c) {
        for (int j = 0; j < lastClusterIndex; j++) {
            if (c == C[j]) { // to avoid duplicates
                return;
            }
        }
        C[lastClusterIndex++] = c;
    }

    public Cluster get(int i) {
        return C[i];
    }

    /**
     * @param distance
     * @param data
     * @return
     */
    public ClusterSet mergeClosestClusters(ClusterDistance distance, Data data) {
        double minDistance = Double.MAX_VALUE;
        int minI = -1, minJ = -1;
        for (int i = 0; i < lastClusterIndex; i++) {
            for (int j = i + 1; j < lastClusterIndex; j++) {
                double d = distance.distance(C[i], C[j], data);
                if (d < minDistance) {
                    minDistance = d;
                    minI = i;
                    minJ = j;
                }
            }
        }

        if (minI == -1) return null; // no clusters to merge

        ClusterSet newClusterSet = new ClusterSet(C.length - 1);
        for (int i = 0; i < lastClusterIndex; i++) {
            if (i != minI && i != minJ) {
                newClusterSet.add(C[i]);
            } else if (i == minI) {
                newClusterSet.add(C[minI].mergeCluster(C[minJ]));
            }
        }
        return newClusterSet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C.length; i++) {
            if (C[i] != null) {
                sb.append("cluster").append(i).append(":").append(C[i]).append("\n");
            }
        }
        return sb.toString();
    }

    public String toString(Data data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C.length; i++) {
            if (C[i] != null) {
                sb.append("cluster").append(i).append(":").append(C[i].toString(data)).append("\n");
            }
        }
        return sb.toString();
    }
}
