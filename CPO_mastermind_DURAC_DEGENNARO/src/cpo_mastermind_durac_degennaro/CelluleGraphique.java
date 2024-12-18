

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_mastermind_durac_degennaro;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author natac
 */
public class CelluleGraphique extends JButton {
    private Pion[][] grille;
    private int ligne, colonne;

    public CelluleGraphique(Pion[][] grille, int ligne, int colonne) {
        this.grille = grille;
        this.ligne = ligne;
        this.colonne = colonne;

        // Initialement, aucune couleur
        this.setBackground(Color.GRAY);
        this.setOpaque(true);
        this.setBorderPainted(false);
    }

    // Mise à jour de la couleur en fonction de la grille
    public void updateColor() {
        Pion pion = grille[ligne][colonne];
        if (pion != null) {
            this.setBackground(getColorFromChar(pion.getCouleur()));
        } else {
            this.setBackground(Color.LIGHT_GRAY);
        }
    }
    private Color getColorFromChar(char couleur) {
    switch (couleur) {
        case 'R': return Color.RED;    // Rouge
        case 'B': return Color.BLUE;   // Bleu
        case 'J': return Color.YELLOW; // Jaune
        case 'V': return Color.GREEN;  // Vert
        case 'W': return Color.WHITE;  // Blanc
        case 'O': return Color.ORANGE; // Orange
        default: return Color.GRAY;    // Couleur par défaut si inconnue
    }
}
}