package org.com.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Sacoche {
    private final List<Objet> sacoche;
    private static final Logger LOG = LogManager.getLogger();

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



    @Override
    public String toString() {
        return "Sacoche{" +
                "sacoche=" + sacoche +
                '}';
    }
}

