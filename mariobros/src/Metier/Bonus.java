package Metier;

import Enumeration.FormeEntite;
import Enumeration.TypeBonus;

public class Bonus extends Entite {
    private TypeBonus type;
    private boolean deplacementDroite = true;

    public Bonus(int x, int y, int width, int height, FormeEntite formeEntite, TypeBonus type) {
        super(x, y, width, height, formeEntite);
        this.type = type;
    }

    public TypeBonus getType() {
        return type;
    }

    public boolean isDeplacementDroite() {
        return deplacementDroite;
    }

    public void setType(TypeBonus type) {
        this.type = type;
    }

    public void setDeplacementDroite(boolean deplacementDroite) {
        this.deplacementDroite = deplacementDroite;
    }

    /**
     * Donne une description en fonction du Type
     * @return
     */
    public String getDescription(){
        switch (type){
            case MARIO:
                return TypeBonus.MARIO.getDescription();
            case CHAMPIGNON:
                return TypeBonus.CHAMPIGNON.getDescription();
            case FLEUR:
                return TypeBonus.FLEUR.getDescription();
            default:
                return "Type inconnu !!";
        }
    }
}
