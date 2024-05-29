public class Dendrogram {
    private ClusterSet[] tree;

    public Dendrogram(int depth) {
        tree = new ClusterSet[depth];
    }

    public void setClusterSet(ClusterSet c, int level) {
        if (level >= 0 && level < tree.length) {
            tree[level] = c;
        }
    }

    public ClusterSet getClusterSet(int level) {
        if (level >= 0 && level < tree.length) {
            return tree[level];
        }
        return null;
    }

    public int getDepth() {
        return tree.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tree.length; i++) {
            sb.append("level").append(i).append(":\n").append(tree[i]).append("\n");
        }
        return sb.toString();
    }

    public String toString(Data data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                sb.append("level").append(i).append(":\n").append(tree[i].toString(data)).append("\n");
            }
        }
        return sb.toString();
    }
}
