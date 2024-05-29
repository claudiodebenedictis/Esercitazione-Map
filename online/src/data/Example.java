package src.data;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Example implements Iterable<Double> {
    private List<Double> example;

    Example() {
        example = new LinkedList<>();
    }

    @Override
    public Iterator<Double> iterator() {
        return example.iterator();
    }

    // Il metodo "set" è stato rimpiazzato dal metodo "add"
    void add(Double v) {
        example.add(v);
    }

    Double get(int index) {
        return example.get(index);
    }

    public double distance(Example newE) {
        // Inizializza la somma a 0
        double sum = 0;
        // Crea gli iteratori una sola volta
        Iterator<Double> thisIterator = this.example.iterator();
        Iterator<Double> newEIterator = newE.example.iterator();

        while (thisIterator.hasNext() && newEIterator.hasNext()) {
            // Usa gli iteratori per ottenere i prossimi elementi
            double diff = thisIterator.next() - newEIterator.next();

            // Aggiunge il quadrato della differenza alla somma
            sum += diff * diff;
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Double> iterator = example.iterator(); // Crea un iteratore per scorrere la lista
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(",");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1); // Rimuove l'ultima virgola
        }
        sb.append("]");
        return sb.toString();
    }
}
