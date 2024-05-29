package src.clustering;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import src.data.Data;

public class Cluster implements Iterable<Integer>, Cloneable {
    //MODIFICHE: cambiato da List a Set
    private Set<Integer> clusteredData = new TreeSet<>();

    public void addData(int id) {
        clusteredData.add(id);
    }

    public int getSize() {
        return clusteredData.size();
    }

    // MODIFICHE EFFETTUATE= Rimozione del metodo getElement(int i) poiché non più utilizzato
    // MODIFICHE EFFETTUATE= Aggiunta metodo clone
    // Metodo clone per creare una copia del Cluster
    @Override
    public Object clone() {
        try {
            Cluster copy = (Cluster) super.clone();
            copy.clusteredData = new TreeSet<>(this.clusteredData);
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Questo non dovrebbe mai accadere poiché stiamo implementando Cloneable
        }
    }

    // Metodo mergeCluster modificato per usare gli iteratori
    //adesso utilizza un ciclo for-each che internamente usa un iteratore per scorrere gli elementi del cluster
    //attuale "this" e del cluster passato come parametro "c
    public Cluster mergeCluster(Cluster c) {
        Cluster newC = new Cluster();
        for (Integer id : this) {
            newC.addData(id);
        }
        for (Integer id : c) {
            newC.addData(id);

import src.data.Data;
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

    public Iterator<Integer> iterator() {
        return clusteredData.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iterator = clusteredData.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(",");
            }

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


    // Metodo toString(Data data) modificato per usare gli iteratori
    //adesso utilizza "iterator" per scorrere gli elementi del "clusterdata" 
    //per ogni elemento il metodo aggiunge la rappresentazione dell'esempio dal "data" passato come parametro alla stringa risultate
    
    public String toString(Data data) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iterator = clusteredData.iterator();
        while (iterator.hasNext()) {
            Integer id = iterator.next();
            sb.append("<").append(data.getExample(id)).append(">");
            if (iterator.hasNext()) {
                sb.append(",");
            }

    public String toString(Data data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < clusteredData.length; i++) {
            sb.append("<").append(data.getExample(clusteredData[i])).append(">");

        }
        return sb.toString();
    }
}
