package org.com;

import org.com.entity.*;
import org.com.service.ArmeUtilite;
import org.com.service.BouclierUtilite;
import org.com.service.NourritureUtilite;
import org.com.service.PersonnageUtilite;

import java.util.Random;


public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Equipe e1 = new Equipe();
        Equipe e2 = new Equipe();

        Arme a1 = new Arme("épée", 1500, 20, 100);
        Bouclier b1 = new Bouclier("bouclier", 25000, 5);
        Nourriture n1 = new Nourriture("pomme", 250, 15);

        Personnage p1 = new Heros(100, 100, "roger", 10, a1, 0,0);
        Personnage p2 = new Monstre(100, 100, "didier", 10, a1, 0, 1);

        e1.ajoutEquipe(p1);
        e2.ajoutEquipe(p2);

        p1.getSacoche().ajoutSacoche(n1);
        p1.getSacoche().ajoutSacoche(n1);
        p2.getSacoche().ajoutSacoche(n1);
        p2.getSacoche().ajoutSacoche(n1);


        p1.setArmeEquipe(a1);
        p1.setBouclierEquipe(b1);
        p2.setArmeEquipe(a1);
        p2.setBouclierEquipe(b1);
        p2.getSacoche().getSacoche();
//        PersonnageUtilite.seDeplacer(p2, 2, "nord");

        while (e1.tailleEquipe() > 0 && e2.tailleEquipe() > 0) {
            boolean choixEquipe = random.nextBoolean();
            if (choixEquipe) {
                int choixAction = random.nextInt(0, 2);

                if (choixAction == 0 && p1.getEndurance() != 0) {
                    BouclierUtilite.defendre(p2);
                    ArmeUtilite.attaquer(p1, p2);
                }
                if (choixAction == 1 || p1.getEndurance() == 0) {
                    NourritureUtilite.manger(p1, n1);
                    ArmeUtilite.attaquer(p2, p1);
                }
                if (choixAction == 2 && p1.getEndurance() != 0) {
                    NourritureUtilite.manger(p1, n1);
                    NourritureUtilite.manger(p2, n1);
                }
            } else {
                int choixAction = random.nextInt(0, 1);
                if (choixAction == 0 && p2.getEndurance() != 0) {
                    BouclierUtilite.defendre(p1);
                    ArmeUtilite.attaquer(p2, p1);
                }
                if (choixAction == 1 || p2.getEndurance() != 0) {
                    NourritureUtilite.manger(p2, n1);
                    ArmeUtilite.attaquer(p1, p2);
                }

            }
            if (p1.estMort()) {
                e1.retireEquipe(p1);
            }
            if (p2.estMort()) {
                e2.retireEquipe(p2);
            }
        }
    }
}