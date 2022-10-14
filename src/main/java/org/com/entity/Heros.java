package org.com.entity;

public class Heros extends Personnage {
    public Heros(int maxPv, int maxEndurance, String nom, int force, Arme armeEquipe) {
        super(maxPv, maxEndurance, nom, force, armeEquipe);
    }

    public Heros(int maxPv, int maxEndurance, String nom, int force, Arme armeEquipe, Bouclier bouclierEquipe) {
        super(maxPv, maxEndurance, nom, force, armeEquipe, bouclierEquipe);
    }

    public Heros(int maxPv, int maxEndurance, String nom, int force, Arme armeEquipe, int x, int y) {
        super(maxPv, maxEndurance, nom, force, armeEquipe, x, y);
    }

    public Heros() {
        super();
    }
}
