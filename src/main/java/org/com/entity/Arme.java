package org.com.entity;

public class Arme extends Objet{
    private int pointDegats, longueur;

    public Arme(String nom, int poids, int pointDegats, int longueur) {
        super(nom, poids);
        this.pointDegats = pointDegats;
        this.longueur = longueur;
    }

    public Arme() {
        super();
    }


    public int getPointDegats() {
        return pointDegats;
    }

    public void setPointDegats(int pointDegats) {
        this.pointDegats = pointDegats;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    @Override
    public String toString() {
        return "Arme{" + super.toString()+
                "pointDegats=" + pointDegats +
                ", longueur=" + longueur +
                '}';
    }
}
