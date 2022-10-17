package org.com.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.com.entity.Personnage;

public class PersonnageUtilite {

    private static final Logger LOG = LogManager.getLogger();

    /**
     * methode qui va faire avancer le personnage dans la direction précisée
    **/
     public static void seDeplacer(Personnage personnage, int nbCase, String direction) {

        // Controle que le personnage a asser d'endurance pour se déplacer
        int enduranceConsome = personnage.getSacoche().poidsSacoche() + personnage.getArmeEquipe().getPoids() + personnage.getBouclierEquipe().getPoids();
        enduranceConsome = enduranceConsome / (personnage.getForce() * 1000);
        enduranceConsome = enduranceConsome * nbCase;
        if (personnage.getEndurance() - enduranceConsome > 0) {

            personnage.setEndurance(personnage.getEndurance() - enduranceConsome);


            // Bloque de controle de direction du déplacement
            if (direction.equals("Nord") || direction.equals("nord") && (personnage.getX() + nbCase <= 9)) {
                personnage.setX(personnage.getX() + nbCase);
                LOG.debug("{} se déplace de {} case(s) vers le Nord", personnage.getNom(), nbCase);
            }
            if (direction.equals("Sud") || direction.equals("sud") && (personnage.getX() - nbCase <= 0)) {
                personnage.setX(personnage.getX() + nbCase);
                LOG.debug("{} se déplace de {} case(s) vers le Sud", personnage.getNom(), nbCase);
            }
            if (direction.equals("Est") || direction.equals("est") && (personnage.getY() + nbCase <= 0)) {
                personnage.setX(personnage.getX() + nbCase);
                LOG.debug("{} se déplace de {} case(s) vers le Est", personnage.getNom(), nbCase);
            }
            if (direction.equals("Ouest") || direction.equals("ouest") && (personnage.getY() - nbCase <= 0)) {
                personnage.setX(personnage.getX() + nbCase);
                LOG.debug("{} se déplace de {} case(s) vers le Ouest", personnage.getNom(), nbCase);
            }
        }


        else {
            LOG.debug("{} ne peut pas se déplacer de {} case(s) dans la direction {}", personnage.getNom(), nbCase, direction);
        }
    }



    /**
    * methode de fuite, déplace de deux case dans la permière direction ou c'est possible
    **/
    public void fuir(Personnage personnage) {

        // Controle que le personnage a asser d'endurance pour se déplacer
        int enduranceConsome = personnage.getSacoche().poidsSacoche() + personnage.getArmeEquipe().getPoids() + personnage.getBouclierEquipe().getPoids();
        enduranceConsome = enduranceConsome / (personnage.getForce() * 1000);
        enduranceConsome = enduranceConsome * 2;

        if (personnage.getEndurance() - enduranceConsome > 0) {

            // Choix de la direction à prendre
            if (personnage.getX() <= 7) {
                personnage.setX(personnage.getX() + 2);
                LOG.debug("{} a fuit de 2 cases vers le Nord", personnage.getNom());
            }
            if (personnage.getX() >= 2) {
                personnage.setX(personnage.getX() - 2);
                LOG.debug("{} a fuit de 2 cases vers le Sud", personnage.getNom());
            }
            if (personnage.getY() <= 7) {
                personnage.setY(personnage.getY() + 2);
                LOG.debug("{} a fuit de 2 cases vers le Est", personnage.getNom());
            }
            if (personnage.getY() >= 2) {
                personnage.setY(personnage.getY() - 2);
                LOG.debug("{} a fuit de 2 cases vers le Ouest", personnage.getNom());
            }
        }
    }



    /**
    * methode dormir, rend 2 pts d'endurance et un pt Pv par tour éfféctué
    **/
    public void dormir(Personnage personnage) {
        if (personnage.getEndurance() + 2 < personnage.getMaxEndurance()) {
            personnage.setEndurance(personnage.getEndurance() + 2);
        }
        if (personnage.getPv() + 1 < personnage.getMaxPv()) {
            personnage.setPv(personnage.getPv() + 1);

        }
        LOG.debug("{} a dormi et récupère 1 point de vie et 2 points d'endurance", personnage.getNom());
    }

    /**
    * methode de controle si un p2 est acoller à p1
    * **/
    public static boolean aCote(Personnage p1, Personnage p2) {
        if (p2.getX() + 1 == p1.getX() || p2.getX() - 1 == p1.getX() || p2.getY() + 1 == p1.getY() || p2.getY() - 1 == p1.getY()) {
            return true;
        }
        return false;
    }
}


