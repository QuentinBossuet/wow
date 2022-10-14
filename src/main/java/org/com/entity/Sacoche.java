package org.com.entity;

import java.util.ArrayList;
import java.util.List;

public class Sacoche {
    List<Objet> sacoche;

    public Sacoche() {
        sacoche = new ArrayList<>();
    }

    public void ajoutSacoche(Objet objet) {
        sacoche.add(objet);
    }

    public void retireSacoche(Objet objet) {
        sacoche.remove(objet);
    }

    /**
     * Methode qui retourne le poids total de la sacoche du personnage
    **/
    public int poidsSacoche() {
        int poidsTotal = 0;
        for (Objet o : this.sacoche) {
            poidsTotal += o.getPoids();
        }
        return poidsTotal;
    }

    public Boolean getObjet(Objet o) {
        return sacoche.contains(o);
    }

    public List<Objet> getSacoche() {
        return sacoche;
    }

    @Override
    public String toString() {
        return "Sacoche{" +
                "sacoche=" + sacoche +
                '}';
    }
}

