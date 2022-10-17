package org.com.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Personnage {
    private int maxPv, pv, maxEndurance, endurance, ptBloque, force, x, y;
    private String nom;
    private Arme armeEquipe;
    private Bouclier bouclierEquipe;
    private Sacoche sacoche;
    private static final Logger LOG = LogManager.getLogger();
    private Random random = new Random();

    public Personnage(int maxPv, int maxEndurance, String nom, int force, Arme armeEquipe) {
        this.maxPv = maxPv;
        this.pv = maxPv;
        this.maxEndurance = maxEndurance;
        this.endurance = maxEndurance;
        this.nom = nom;
        this.armeEquipe = armeEquipe;
        if (force > 0) {
            this.force = force;
        }else {
            this.force = 1;
        }
        this.bouclierEquipe = null;
        this.sacoche = new Sacoche();
        this.x = random.nextInt(0, 9);
        this.y = random.nextInt(0, 9);
    }

    public Personnage(int maxPv, int maxEndurance, String nom, int force, Arme armeEquipe, Bouclier bouclierEquipe) {
        this.maxPv = maxPv;
        this.pv = maxPv;
        this.maxEndurance = maxEndurance;
        this.endurance = maxEndurance;
        this.nom = nom;
        this.force = force;
        this.armeEquipe = armeEquipe;
        this.bouclierEquipe = bouclierEquipe;
        this.sacoche = new Sacoche();
        this.x = random.nextInt(0, 9);
        this.y = random.nextInt(0, 9);
    }
    public Personnage(int maxPv, int maxEndurance, String nom, int force, Arme armeEquipe,int x, int y) {
        this.maxPv = maxPv;
        this.pv = maxPv;
        this.maxEndurance = maxEndurance;
        this.endurance = maxEndurance;
        this.nom = nom;
        this.force = force;
        this.armeEquipe = armeEquipe;
        this.sacoche = new Sacoche();
        this.x = x;
        this.y = y;
    }

    public Personnage() {
        super();
    }


    /**
    * methode qui controle si le personnage est toujours en vie
    **/
    public boolean estMort() {
        if (this.pv <= 0) {
            LOG.debug("{} est mort.", this.nom);
            return true;
        }
        return false;
    }



    @Override
    public String toString() {
        return "Personnage{" +
                "maxPv=" + maxPv +
                ", pv=" + pv +
                ", maxEndurance=" + maxEndurance +
                ", endurance=" + endurance +
                ", ptBloque=" + ptBloque +
                ", Position=" + x + "," + y +
                ", nom='" + nom + '\'' +
                ", armeEquipe=" + armeEquipe +
                ", bouclierEquipe=" + bouclierEquipe +
                ", sacoche=" + sacoche +
                '}';
    }


    public int getForce() {
        return force;
    }

    public void setForce(int froce) {
        this.force = froce;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPtBloque() {
        return ptBloque;
    }

    public void setPtBloque(int ptBloque) {
        this.ptBloque = ptBloque;
    }

    public int getMaxPv() {
        return maxPv;
    }

    public void setMaxPv(int maxPv) {
        this.maxPv = maxPv;
    }

    public int getMaxEndurance() {
        return maxEndurance;
    }

    public void setMaxEndurance(int maxEndurance) {
        this.maxEndurance = maxEndurance;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Arme getArmeEquipe() {
        return armeEquipe;
    }

    public void setArmeEquipe(Arme armeEquipe) {
        this.armeEquipe = armeEquipe;
    }

    public Sacoche getSacoche() {
        return sacoche;
    }


    public Bouclier getBouclierEquipe() {
        return bouclierEquipe;
    }

    public void setBouclierEquipe(Bouclier bouclierEquipe) {
        this.bouclierEquipe = bouclierEquipe;
    }
}
