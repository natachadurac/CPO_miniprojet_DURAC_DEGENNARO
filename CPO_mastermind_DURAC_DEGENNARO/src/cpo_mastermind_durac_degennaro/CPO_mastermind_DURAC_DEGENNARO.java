/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cpo_mastermind_durac_degennaro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natac
 */
public class CPO_mastermind_DURAC_DEGENNARO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pion pionRouge = new Pion('R');
        Pion pionBleu = new Pion('B');
        Pion pionJaune = new Pion('J');
        Pion pionVert = new Pion('V');
        Pion pionBlanc = new Pion('W');
        Pion pionNoir = new Pion('N');
        
        System.out.println("Couleur du pion Rouge: " + pionRouge.getCouleur());
        System.out.println("Couleur du pion Bleu: " + pionBleu.getCouleur());
        System.out.println("Couleur du pion Jaune: " + pionJaune.getCouleur());
        System.out.println("Couleur du pion Vert: " + pionVert.getCouleur());
        System.out.println("Couleur du pion Blanc: " + pionBlanc.getCouleur());
        System.out.println("Couleur du pion Noir: " + pionNoir.getCouleur());
        
        ArrayList<Character> couleursDisponibles = new ArrayList<>();
        couleursDisponibles.add('R');
        couleursDisponibles.add('B');
        couleursDisponibles.add('J');
        couleursDisponibles.add('V');
        couleursDisponibles.add('W');
        couleursDisponibles.add('N');
        
        
        Combinaison combinaison1 = Combinaison.genererAleatoire(6, couleursDisponibles);
        Combinaison combinaison2 = Combinaison.genererAleatoire(6, couleursDisponibles);
        
        // Afficher les combinaisons générées
        System.out.println("Combinaison 1 : " + combinaison1);
        System.out.println("Combinaison 2 : " + combinaison2);
        
       
        int[] indices = combinaison1.comparer(combinaison2);
        System.out.println("Bien places : " + indices[0]);
        System.out.println("Mal places : " + indices[1]);

        Partie partie = new Partie(4, 10, couleursDisponibles);
        partie.afficherRegles();
        partie.lancerPartie();
    }
    }
    