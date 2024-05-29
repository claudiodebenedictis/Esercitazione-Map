package src.main;

import src.distance.*;
import src.clustering.*;
import src.data.*;
import src.exceptions.InvalidDepthException;
import src.exceptions.InvalidSizeException;


public class MainTest {
    public static void main(String[] args) {
        Data data = new Data();
        System.out.println(data);

        // Inserimento profondità del dendrogramma
        System.out.println("Inserisci la profondità del dendrogramma:");
        int depth = Keyboard.readInt();

        if (depth <= 0) {
            System.out.println("La profondità deve essere un numero positivo.");
            return;
        }

        // Scelta del tipo di misura di distanza tra cluster
        System.out.println("Scegli il tipo di misura di distanza tra cluster:");
        System.out.println("1. Single Link Distance");
        System.out.println("2. Average Link Distance");
        int choice = Keyboard.readInt();

        ClusterDistance distance;

        switch (choice) {
            case 1:
                distance = new SingleLinkDistance();
                break;
            case 2:

                distance = new AverageLinkDistance();

                distance = new AverageLinkdistance();

                break;
            default:
                System.out.println("Scelta non valida. Verrà usata la Single Link Distance.");
                distance = new SingleLinkDistance();
        }

        try {
            // Esecuzione del clustering gerarchico
            HierachicalClusterMiner clustering = new HierachicalClusterMiner(depth);

            double[][] distancematrix = data.distance();
            System.out.println("Matrice delle distanze:\n");
            for (int i = 0; i < distancematrix.length; i++) {
                for (int j = 0; j < distancematrix.length; j++)
                    System.out.print(distancematrix[i][j] + "\t");
                System.out.println("");
            }

            clustering.mine(data, distance);
            System.out.println(clustering);
            System.out.println(clustering.toString(data));
        } catch (InvalidDepthException | InvalidSizeException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}