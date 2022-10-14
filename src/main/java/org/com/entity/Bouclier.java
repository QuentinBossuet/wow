package org.com.entity;

public class Bouclier extends Objet{
    private int ptEncaissementDegat;

    public Bouclier(String nom, int poids, int ptEncaissementDegat) {
        super(nom, poids);
        this.ptEncaissementDegat = ptEncaissementDegat;
    }

    public Bouclier() {
        super();
    }

    public int getPtEncaissementDegat() {
        return ptEncaissementDegat;
    }

    public void setPtEncaissementDegat(int ptEncaissementDegat) {
        this.ptEncaissementDegat = ptEncaissementDegat;
    }

    @Override
    public String toString() {
        return "Bouclier{" +
                "ptEncaissementDegat=" + ptEncaissementDegat +
                '}';
    }
}
