/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_mastermind_durac_degennaro;

/**
 *
 * @author natac
 */
public class CelluleGraphique extends JButton {
    int largeur; 
    int hauteur;
    Pion celluleLumineuseAssociee;
 
    public CelluleGraphique(Pion celluleLumineuseAssociee, int l,int h) {
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
    }
}

