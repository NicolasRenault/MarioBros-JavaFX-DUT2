package Metier;

import Enumeration.FormeEntite;
import Enumeration.TypeBonus;
import Outils.NombreMagique;
import javafx.scene.image.Image;

public class Personnage extends Entite {
    private int nombreDeVie;
    private int taille;

    /**
     * Créer un nouveau Personnage
     * @param x
     * @param y
     * @param width
     * @param height
     * @param formeEntite
     * @param nombreDeVie
     * @param taille
     */
    public Personnage(int x, int y, int width, int height, FormeEntite formeEntite, int nombreDeVie, int taille) {
        super(x, y, width, height, formeEntite);
        this.nombreDeVie = nombreDeVie;
        this.taille = taille;
    }

    public int getNombreDeVie() {
        return nombreDeVie;
    }

    public int getTaille() {
        return taille;
    }

    public void setNombreDeVie(int nombreDeVie) {
        if(nombreDeVie < 0)
            nombreDeVie = 0;
        this.nombreDeVie = nombreDeVie;
    }

    /**
     * Modifi la taille du personnage
     * @param taille
     */
    public void setTaille(int taille) {
        if(taille < 0)
            taille = 0;
        if(taille > NombreMagique.Personnage.tailleMaximal)
            taille = NombreMagique.Personnage.tailleMaximal;
        this.taille = taille;
    }

    /**
     * Applique le bonus sur le personnage
     * @param bonus
     */
    public void activerBonusPersonnage(TypeBonus bonus){
        switch (bonus){
            case MARIO:
                //score.setPoint(score.getPoint() + NombreMagique.scoreMario);
                setTaille(1);
                setHeight(NombreMagique.Personnage.height);
                setFormeEntite(FormeEntite.MARIO);
                apparance(FormeEntite.MARIO);
                break;
            case CHAMPIGNON:
                if(getFormeEntite()==FormeEntite.MARIO) {
                    setTaille(NombreMagique.Personnage.tailleMaximal);
                    setHeight(NombreMagique.Personnage.height * 2);
                    setFormeEntite(FormeEntite.GRAND);
                    setY(getY()-getHeight()/2);
                    //score.setPoint(score.getPoint() + NombreMagique.scoreChampignon);
                }
                break;
            case FLEUR:
                activerBonusPersonnage(TypeBonus.CHAMPIGNON);
                setFormeEntite(FormeEntite.FEU);
                apparance(FormeEntite.FEU);
                //score.setPoint(score.getPoint() + NombreMagique.scoreFleur);
                break;
            default:
                break;
        }
    }

    /**
     * Regarde si le personnage a encore des vies
     * @return boolean
     */
    public boolean enVie(){
        if(this.nombreDeVie > 0)
            return true;
        return false;
    }

    /**
     * Applique le coup a la vie du personnage
     * @return boolean
     */
    public boolean prendreUnDegat(){
        this.nombreDeVie --;
        return enVie();
    }
}
