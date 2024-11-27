/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_mastermind_durac_degennaro;

/**
 *
 * @author natac
 */
import java.util.ArrayList;
import java.util.Random;

public class Combinaison {
     private Pion[] elements; 
    private int taille;       

    
    public Combinaison(Pion[] elements) {
        this.elements = elements;
        this.taille = elements.length;
    }

    
    public static Combinaison genererAleatoire(int taille, ArrayList<Character> couleursDisponibles) {
        Pion[] elements = new Pion[taille];
        Random rand = new Random();
        
        
        for (int i = 0; i < taille; i++) {
            char couleurAleatoire = couleursDisponibles.get(rand.nextInt(couleursDisponibles.size()));
            elements[i] = new Pion(couleurAleatoire);
        }
        
        return new Combinaison(elements);
    }

    
    public int[] comparer(Combinaison autre) {
        int bienPlaces = 0;
        int malPlaces = 0;

        
        boolean[] marqueCetteCombinaison = new boolean[taille];
        boolean[] marqueAutreCombinaison = new boolean[taille];

        
        for (int i = 0; i < taille; i++) {
            if (this.elements[i].getCouleur() == autre.elements[i].getCouleur()) {
                bienPlaces++;
                marqueCetteCombinaison[i] = true;
                marqueAutreCombinaison[i] = true;
            }
        }

        
        for (int i = 0; i < taille; i++) {
            if (!marqueCetteCombinaison[i]) {
                for (int j = 0; j < taille; j++) {
                    if (!marqueAutreCombinaison[j] && this.elements[i].getCouleur() == autre.elements[j].getCouleur()) {
                        malPlaces++;
                        marqueAutreCombinaison[j] = true;
                        break;
                    }
                }
            }
        }

        
        return new int[]{bienPlaces, malPlaces};
    }

   
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Pion pion : elements) {
            result.append(pion.toString());
        }
        return result.toString();
    }

    
    public Pion[] getElements() {
        return elements;
    }
}

import java.util.ArrayList;

public class TestCombinaison {
    public static void main(String[] args) {
        
        ArrayList<Character> couleursDisponibles = new ArrayList<>();
        couleursDisponibles.add('R');
        couleursDisponibles.add('B');
        couleursDisponibles.add('G');
        couleursDisponibles.add('Y');
        
        
        Combinaison combinaison1 = Combinaison.genererAleatoire(4, couleursDisponibles);
        Combinaison combinaison2 = Combinaison.genererAleatoire(4, couleursDisponibles);
        
        // Afficher les combinaisons générées
        System.out.println("Combinaison 1 : " + combinaison1);
        System.out.println("Combinaison 2 : " + combinaison2);
        
       
        int[] indices = combinaison1.comparer(combinaison2);
        System.out.println("Bien placés : " + indices[0]);
        System.out.println("Mal placés : " + indices[1]);
    }
}
}
