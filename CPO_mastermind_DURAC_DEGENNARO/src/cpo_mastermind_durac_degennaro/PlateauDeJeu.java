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

import java.util.Arrays;

 

public class PlateauDeJeu {

    private Combinaison combinaisonSecrete;

    private ArrayList<Combinaison> tentatives;

    private ArrayList<String> reponses;

    private int nbToursMax;

    private Pion[][] grille;

    public int getNbLignes() {
        return grille.length;
    }

    // Méthode pour obtenir le nombre de colonnes
    public int getNbColonnes() {
        return grille[0].length;
    }

    // Méthode pour obtenir la grille entière
    public Pion[][] obtenirGrille() {
        return grille;
    }
 
    
    public Pion obtenirPionAuxCoord(int x, int y) {
        return grille[x][y];
    }
    
    private static final ArrayList<Character> COULEURS_DISPONIBLES =

        new ArrayList<>(Arrays.asList('R', 'V', 'B', 'J', 'N', 'O'));

 

    public PlateauDeJeu(Combinaison combinaisonSecrete, int nbToursMax) {

        this.combinaisonSecrete = combinaisonSecrete;

        this.tentatives = new ArrayList<>();

        this.reponses = new ArrayList<>();

        this.nbToursMax = nbToursMax;

        this.grille = new Pion[nbToursMax][combinaisonSecrete.getElements().length];

    }

 

    public PlateauDeJeu(int nbLignes, int nbColonnes) {

        this.combinaisonSecrete = Combinaison.genererAleatoire(nbColonnes, COULEURS_DISPONIBLES);

        this.tentatives = new ArrayList<>();

        this.reponses = new ArrayList<>();

        this.nbToursMax = nbLignes;

        this.grille = new Pion[nbLignes][nbColonnes];

    }

 

    public void proposerCombinaison(Combinaison tentative) {

        this.tentatives.add(tentative);

 

        int[] indices = combinaisonSecrete.comparer(tentative);

        reponses.add(indices[0] + " noirs, " + indices[1] + " blancs");

 

       

        remplirGrille(tentative);

    }

 

    private void remplirGrille(Combinaison combinaison) {

        Pion[] elements = combinaison.getElements();

        for (int i = 0; i < grille.length; i++) {

            if (grille[i][0] == null) {

                System.arraycopy(elements, 0, grille[i], 0, elements.length);

                break;

            }

        }

    }

 

    public void afficherPlateau() {

    System.out.println("Plateau de jeu :");

    for (int i = 0; i < grille.length; i++) {

        System.out.print("Ligne " + (i + 1) + ": ");

        if (grille[i][0] == null) {

            System.out.println("....");

        } else {

            for (Pion pion : grille[i]) {

                // Afficher uniquement la couleur du pion

                System.out.print(pion.getCouleur() + " ");

            }

            System.out.println();

        }

    }

 

    // Affichage des tentatives avec les réponses

    for (int i = 0; i < tentatives.size(); i++) {

        System.out.print("Tentative " + (i + 1) + ": ");

        Combinaison tentative = tentatives.get(i);

        for (Pion pion : tentative.getElements()) {

            // Afficher uniquement la couleur du pion

            System.out.print(pion.getCouleur() + " ");

        }

        // Affichage de la réponse

        System.out.println("-> Reponse: " + reponses.get(i));

    }

}

 

 

    public boolean estVictoire() {

        if (tentatives.isEmpty()) {

            return false;

        }

        Combinaison derniereTentative = tentatives.get(tentatives.size() - 1);

        return combinaisonSecrete.toString().equals(derniereTentative.toString());

    }

 

    public boolean estDefaite() {

        return tentatives.size() >= nbToursMax;

    }

 

    public Combinaison getCombinaisonSecrete() {

        return combinaisonSecrete;

    }

 

    public int getNbToursMax() {

        return nbToursMax;

    }

}



