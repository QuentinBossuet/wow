package org.com.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private List<Personnage> equipe;

    private static final Logger LOG = LogManager.getLogger();

    public Equipe() {
        this.equipe = new ArrayList<>();
    }

    public void ajoutEquipe (Personnage personnage) {
        equipe.add(personnage);
        LOG.debug("ajout d'un personne dans l'equipe");
    }

    public void retireEquipe (Personnage personnage) {
        equipe.remove(personnage);
    }

    public int tailleEquipe (){
        return equipe.size();
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "equipe=" + equipe +
                '}';
    }
}
