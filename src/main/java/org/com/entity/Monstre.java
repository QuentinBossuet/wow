package org.com.entity;

public class Monstre extends Personnage{
    public Monstre(int maxPv, int maxEndurance, String nom, int force, Arme armeEquipe) {
        super(maxPv, maxEndurance, nom, force, armeEquipe);
    }

    public Monstre(int maxPv, int maxEndurance, String nom, int force, Arme armeEquipe, Bouclier bouclierEquipe) {
        super(maxPv, maxEndurance, nom, force, armeEquipe, bouclierEquipe);
    }

    public Monstre(int maxPv, int maxEndurance, String nom, int force, Arme armeEquipe, int x, int y) {
        super(maxPv, maxEndurance, nom, force, armeEquipe, x, y);
    }

    public Monstre() {
        super();
    }
}
