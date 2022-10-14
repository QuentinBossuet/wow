package org.com.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.com.entity.Nourriture;
import org.com.entity.Objet;
import org.com.entity.Personnage;

public class NourritureUtilite extends Objet {

    private static final Logger LOG = LogManager.getLogger();

    /**
     * Methode qui redonne le nombre d'endurances de la nourriture en paramètre au personnage
     **/
    public static void manger(Personnage personnage, Nourriture nourriture) {
        // Vérification que le Personnage a bien la nourriture dans sa sacoche
        if (personnage.getSacoche().getObjet(nourriture)) {
            personnage.getSacoche().retireSacoche(nourriture);
            int ptEndu = nourriture.getRecuPtEndurance();

            // Verification que l'endurance finale ne dépassera pas l'endurance max du perosnnage
            if (personnage.getEndurance() + ptEndu >= personnage.getMaxEndurance()) {
                personnage.setEndurance(personnage.getMaxEndurance());
            } else {
                personnage.setEndurance(personnage.getEndurance() + ptEndu);
                LOG.debug("{} mange {}", personnage.getNom(), nourriture.getNom());
            }
        }
    }
}
