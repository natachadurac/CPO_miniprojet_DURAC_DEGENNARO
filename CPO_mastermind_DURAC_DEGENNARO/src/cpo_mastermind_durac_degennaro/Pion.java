/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_mastermind_durac_degennaro;

/**
 *
 * @author natac
 */
public class Pion {
    char couleur;

    public Pion(char couleur) {
        this.couleur = couleur;
    }
    public char getCouleur(){
        return couleur;
    }

    @Override
    public String toString() {
        return "Pion{" + "couleur=" + couleur + '}';
    }
    
    
}
