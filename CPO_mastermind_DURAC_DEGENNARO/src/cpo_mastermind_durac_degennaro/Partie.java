/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_mastermind_durac_degennaro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author natac
 */
public class Partie {
    private PlateauDeJeu plateau;
    private ArrayList<Character> couleursDisponibles;
    
    public Partie(int tailleCombinaison, int nbToursMax, List<Character> couleursDisponibles) {
        this.couleursDisponibles = new ArrayList<>(couleursDisponibles);
        Combinaison combinaisonSecrete = Combinaison.genererAleatoire(tailleCombinaison, this.couleursDisponibles);
        this.plateau = new PlateauDeJeu(combinaisonSecrete, nbToursMax);
    }
    
    public void afficherRegles() {
        System.out.println("Bienvenue dans le jeu de Mastermind !");
        System.out.println("Les règles du jeu sont simples :");
        System.out.println("1. Vous devez deviner la combinaison secrète.");
        System.out.println("2. La combinaison est composée de 4 pions de couleurs parmi les suivantes : ");
        for (Character couleur : couleursDisponibles) {
            System.out.print(couleur + " ");
        }
        System.out.println("\n3. À chaque tentative, vous recevrez des indices :");
        System.out.println("   - 'noirs' : le nombre de pions bien placés.");
        System.out.println("   - 'blancs' : le nombre de pions corrects mais mal placés.");
        System.out.println("4. Vous avez un nombre limité de tentatives.");
        System.out.println("Bonne chance !");
    }
    
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        int tour = 0;
        
        // Boucle de jeu
        while (true) {
            plateau.afficherPlateau();
           
            if (plateau.estVictoire()) {
                terminerPartie(true);
                break;
            }
            if (plateau.estDefaite()) {
                terminerPartie(false);
                break;
            }
            
            System.out.println("Tour " + (tour + 1) + ": Entrez votre combinaison (ex: RBGY): ");
            String entree = scanner.nextLine().toUpperCase();

            if (entree.length() == 4 && validateInput(entree)) {
                Pion[] tentativePions = new Pion[4];
                for (int i = 0; i < 4; i++) {
                    tentativePions[i] = new Pion(entree.charAt(i));
                }
                
                Combinaison tentative = new Combinaison(tentativePions);
                plateau.proposerCombinaison(tentative);
                tour++;
            } else {
                System.out.println("Entrée invalide. Veuillez entrer exactement 4 couleurs parmi " + couleursDisponibles);
            }
        }
        
        scanner.close();
    }
    
    private boolean validateInput(String input) {
        for (char c : input.toCharArray()) {
            if (!couleursDisponibles.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public void terminerPartie(boolean victoire) {
        if (victoire) {
            System.out.println("Félicitations, vous avez trouvé la combinaison secrète !");
        } else {
            System.out.println("Dommage, vous avez perdu. La combinaison secrète était : " + plateau.getCombinaisonSecrete());
        }
    }
}
