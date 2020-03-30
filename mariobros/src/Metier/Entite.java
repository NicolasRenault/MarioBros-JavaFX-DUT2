package Metier;

import Enumeration.Direction;
import Enumeration.FormeEntite;
import javafx.scene.image.Image;

public abstract class Entite extends ObjetJeu {
    private FormeEntite formeEntite;
    private double vitesse;

    public Entite(int x, int y, int width, int height, FormeEntite formeEntite) {
        super(x, y, width, height, true);
        this.formeEntite = formeEntite;
        this.vitesse = 0d;
        apparance(formeEntite);
    }

    public FormeEntite getFormeEntite() {
        return formeEntite;
    }

    public double getVitesse() {
        return vitesse;
    }

    public void setFormeEntite(FormeEntite formeEntite) {
        this.formeEntite = formeEntite;
    }

    public void setVitesse(double vitesse){
        this.vitesse = vitesse;
    }

    /**
     * Deplace l'entite en fonction de la direction
     * @param direction
     * @param vitesseDeplacement
     */
    public void deplacement(Direction direction, double vitesseDeplacement){
        switch(direction){
            case HAUT:
                setY((int) (getY() - vitesseDeplacement));
                break;
            case BAS:
                setY((int) (getY() + vitesseDeplacement));
                break;
            case DROITE:
                setX((int) (getX() + vitesseDeplacement));
                break;
            case GAUCHE:
                setX((int) (getX() - vitesseDeplacement));
                break;
            case NONE:
                break;
        }
    }

    /**
     * Donne une apparence a l'entite en fonction de la forme
     * @param forme
     */
    public void apparance(FormeEntite forme){
        switch (forme){
            case MARIO:
            case GRAND:
                setImage(new Image("Images/mario.png"));
                break;
            case FEU:
                setImage(new Image("Images/feu.png"));
                break;
            case GOOMBA:
                setImage(new Image("Images/goomba.png"));
                break;
            case CHAMPIGNON:
                setImage(new Image("Images/champignon.png"));
                break;
            case FLEUR:
                setImage(new Image("Images/fleur.png"));
                break;
            case NONE:
            default:
                setImage(new Image("Images/inconnu.jpg"));
                break;
        }
    }
}
