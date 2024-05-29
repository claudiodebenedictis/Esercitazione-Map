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
        }
        return sb.toString();
    }
}
