package org.com.entity;

public class Objet {
    private String nom;
    private int poids;

    public Objet(String nom, int poids) {
        this.nom = nom;
        this.poids = poids;
    }

    public Objet() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "Objet{" +
                "nom='" + nom + '\'' +
                ", poids=" + poids +
                '}';
    }
}
