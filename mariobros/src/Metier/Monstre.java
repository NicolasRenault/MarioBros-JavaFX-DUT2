package Metier;

import Enumeration.FormeEntite;

public class Monstre extends Entite {
    private boolean deplacementDroite = true;

    public Monstre(int x, int y, int width, int height, FormeEntite formeEntite) {
        super(x, y, width, height, formeEntite);
    }

    public boolean isDeplacementDroite() {
        return deplacementDroite;
    }

    public void setDeplacementDroite(boolean deplacementDroite) {
        this.deplacementDroite = deplacementDroite;
    }
}
