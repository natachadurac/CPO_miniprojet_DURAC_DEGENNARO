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
public class PlateauDeJeu {
    private Combinaison combinaisonSecrete; 
    private ArrayList<Combinaison> tentatives;  
    private ArrayList<String> reponses; 
    private int nbToursMax; 

    public PlateauDeJeu(Combinaison combinaisonSecrete, int nbToursMax) {
        this.combinaisonSecrete = combinaisonSecrete;
        this.tentatives = new ArrayList<>();
        this.reponses = new ArrayList<>();
        this.nbToursMax = nbToursMax;
    }

    public void proposerCombinaison(Combinaison tentative) {
        this.tentatives.add(tentative);
        
        int[] indices = combinaisonSecrete.comparer(tentative);
        
        reponses.add(indices[0] + " noirs, " + indices[1] + " blancs");
    }

    public void afficherPlateau() {
        System.out.println("Plateau de jeu :");
        for (int i = 0; i < tentatives.size(); i++) {
            System.out.println("Tentative " + (i + 1) + ": " + tentatives.get(i) + " -> Réponse: " + reponses.get(i));
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

