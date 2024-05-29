public class Cluster {
    private Integer[] clusteredData = new Integer[0];

    public void addData(int id) {
        for (int i = 0; i < clusteredData.length; i++) {
            if (id == clusteredData[i]) {
                return;
            }
        }
        Integer[] clusteredDataTemp = new Integer[clusteredData.length + 1];
        System.arraycopy(clusteredData, 0, clusteredDataTemp, 0, clusteredData.length);
        clusteredData = clusteredDataTemp;
        clusteredData[clusteredData.length - 1] = id;
    }

    public int getSize() {
        return clusteredData.length;
    }

    public int getElement(int i) {
        return clusteredData[i];
    }

    public Cluster createACopy() {
        Cluster copyC = new Cluster();
        for (int i = 0; i < getSize(); i++) {
            copyC.addData(clusteredData[i]);
        }
        return copyC;
    }

    public Cluster mergeCluster(Cluster c) {
        Cluster newC = new Cluster();
        for (int i = 0; i < getSize(); i++) {
            newC.addData(getElement(i));
        }
        for (int i = 0; i < c.getSize(); i++) {
            newC.addData(c.getElement(i));
        }
        return newC;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < clusteredData.length - 1; i++) {
            sb.append(clusteredData[i]).append(",");
        }
        if (clusteredData.length > 0) {
            sb.append(clusteredData[clusteredData.length - 1]);
        }
        return sb.toString();
    }

    public String toString(Data data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < clusteredData.length; i++) {
            sb.append("<").append(data.getExample(clusteredData[i])).append(">");
        }
        return sb.toString();
    }
}
