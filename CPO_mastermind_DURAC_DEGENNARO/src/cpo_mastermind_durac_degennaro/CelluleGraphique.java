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
    int x; 
    int y;
    Pion[][] plateauAssocie;
 
    public CelluleGraphique(Pion[][] plateauAssocie, int l,int h) {
        this.x = l;
        this.y = h;
        this.plateauAssocie = plateauAssocie;
    }

    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Pion pion = plateauAssocie[x][y];
    if (pion == null) {
        this.setText(""); // Pas de texte si la case est vide
        this.setBackground(Color.GRAY); // Couleur neutre pour case vide
    } else {
        this.setText(String.valueOf(pion.getCouleur()));
        this.setBackground(Color.WHITE); // Réinitialiser la couleur
    }
}
    
}

