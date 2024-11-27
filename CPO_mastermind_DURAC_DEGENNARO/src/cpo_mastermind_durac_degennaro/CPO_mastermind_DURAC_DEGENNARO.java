/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cpo_mastermind_durac_degennaro;

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
        
        System.out.println("Couleur du pion Rouge: " + pionRouge.getCouleur());
        System.out.println("Couleur du pion Bleu: " + pionBleu.getCouleur());
        System.out.println("Couleur du pion Jaune: " + pionJaune.getCouleur());
        System.out.println("Couleur du pion Vert: " + pionVert.getCouleur());
        System.out.println("Couleur du pion Blanc: " + pionBlanc.getCouleur());
    }
    
}
