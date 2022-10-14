package org.com.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.com.entity.Objet;
import org.com.entity.Personnage;

public class BouclierUtilite extends Objet {
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Methode qui va récupérer les points d'encaissement de dommage du bouclier équipé et les stocker dans les informations du personnage
     **/
    public static void defendre(Personnage personnage) {

        if (personnage.getBouclierEquipe() != null && personnage.getEndurance() != 0) {

            // Verification que le personnage a asser d'endurance pour se défendre
            int enduranceUtilise = personnage.getBouclierEquipe().getPoids() / (1000 * personnage.getForce());

            // Calcule et stockage des points d'encaissement de dégats du bouclier
            if (personnage.getEndurance() - enduranceUtilise >= 0) {
                personnage.setPtBloque(personnage.getBouclierEquipe().getPtEncaissementDegat());
                personnage.setEndurance(personnage.getEndurance() - enduranceUtilise);
                LOG.debug("{} se défend !", personnage.getNom());
            } else {
                LOG.debug("{} n'a pas asser d'endurance pour se défendre !", personnage.getNom());
            }
        }
    }
}
