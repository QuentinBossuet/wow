package org.com.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.com.entity.Equipe;
import org.com.entity.Personnage;

import java.util.Random;
import java.util.random.RandomGenerator;


public class ArmeUtilite {
    static Random random = new Random();
    private static final Logger LOG = LogManager.getLogger();


    /**
     *Methode qui va permettre à un personnage d'en attaquer une autre en prenant en compte la defense de la cible ainsi que de faire contre-attaquer le personnage ciblé s'il est toujours en vie
    **/
    public static void attaquer(Personnage attaquant, Personnage uneCible) {

        if (!attaquant.estMort() && !uneCible.estMort() && attaquant.getEndurance() != 0 && PersonnageUtilite.aCote(attaquant, uneCible) ) {

            // Calcule des points de dégats à infliger
            int degatsCible = uneCible.getArmeEquipe().getPointDegats();
            int degatsAttaquant = attaquant.getArmeEquipe().getPointDegats();
            int enduranceUtilise = (attaquant.getArmeEquipe().getLongueur() * attaquant.getArmeEquipe().getPoids()) / (1000 * attaquant.getForce());

            // Contrôle si l'adversaire se defend
            if (uneCible.getPtBloque() != 0) {
                degatsAttaquant -= uneCible.getPtBloque();
                uneCible.setPtBloque(0);
            }

            // Verification que l'attaquant a asser d'endurance pour attaquer
            if (attaquant.getEndurance() - enduranceUtilise >= 0) {
                uneCible.setPv(uneCible.getPv() - degatsAttaquant);
                attaquant.setEndurance(attaquant.getEndurance() - enduranceUtilise);
                LOG.debug("{} à attaqué {} et lui a fait {} dégats, le laissant à {}hp", attaquant.getNom(), uneCible.getNom(), degatsAttaquant, uneCible.getPv());

                if (uneCible.getArmeEquipe() != null) {

                    if (random.nextBoolean() && uneCible.getPv() > 0) {
                        attaquant.setPv(attaquant.getPv() - degatsCible);
                        LOG.debug("{} à contre-attaqué {} et lui a fait {} dégats, le laissant à {}hp", uneCible.getNom(), attaquant.getNom(), degatsCible, attaquant.getPv());
                    }
                }
            } else {
                LOG.debug("{} n'a pas asser d'endurance pour attaquer", attaquant.getNom());
            }

        }
    }

}
