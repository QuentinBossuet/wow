package org.com.entity;

public class Nourriture extends Objet{
    private int recuPtEndurance;

    public Nourriture(String nom, int poids, int recuPtEndurance) {
        super(nom, poids);
        this.recuPtEndurance = recuPtEndurance;
    }

    public Nourriture() {
        super();
    }

    public int getRecuPtEndurance() {
        return recuPtEndurance;
    }

    public void setRecuPtEndurance(int recuPtEndurance) {
        this.recuPtEndurance = recuPtEndurance;
    }

    @Override
    public String toString() {
        return "Nourriture{" +super.toString() +
                "recuPtEndurance=" + recuPtEndurance +
                '}';
    }
}
