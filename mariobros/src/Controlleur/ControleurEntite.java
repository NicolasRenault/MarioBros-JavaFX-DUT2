package Controlleur;

import Interface.IControleur;
import Metier.Bonus;
import Metier.Entite;
import Metier.Monstre;
import Metier.ObjetJeu;
import Outils.NombreMagique;

import java.util.ArrayList;

public class ControleurEntite implements IControleur {
    private ControleurMonstre controleurMonstre = new ControleurMonstre();
    private ControleurBonus controleurBonus = new ControleurBonus();

    /**
     * Applique un effet de gravité a l'entite
     * @param objetJeu
     */
    public void effetGravite(ObjetJeu objetJeu){
        if(objetJeu.isGravite()){
            Entite objetEntite = (Entite) objetJeu;
            if(objetEntite.getY() + objetEntite.getHeight() <= NombreMagique.Bloc.Sol.positionVerticaleDuSol){
                objetEntite.setY((int) (objetEntite.getY() + objetEntite.getVitesse()));
                objetEntite.setVitesse(objetEntite.getVitesse() + NombreMagique.Deplacement.gravite);
            }
            if(objetEntite.getY() + objetEntite.getHeight() > NombreMagique.Bloc.Sol.positionVerticaleDuSol){
                objetEntite.setY(NombreMagique.Bloc.Sol.positionVerticaleDuSol - objetEntite.getHeight());
                objetEntite.setVitesse(0);
            }
        }
    }

    /**
     * Gere le déplacement de l'entite
     * change a chaque colision
     * @param entites
     * @param objetJeus
     */
    public void deplacementEntite(ArrayList<Entite> entites, ArrayList<ObjetJeu> objetJeus){
        entites.forEach(entite -> {
            if(entite.getClass().getName() == "Metier.Bonus"){
                Bonus bonus = (Bonus) entite;
                controleurBonus.deplacementBonus(bonus, objetJeus);
            }
            if(entite.getClass().getName() == "Metier.Monstre"){
                Monstre monstre = (Monstre) entite;
                controleurMonstre.deplacementMonstre(monstre, objetJeus);
            }
        });
    }
}
