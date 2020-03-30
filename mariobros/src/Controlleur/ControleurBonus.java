package Controlleur;

import Enumeration.Direction;
import Interface.IControleur;
import Metier.Bonus;
import Metier.ObjetJeu;
import Outils.NombreMagique;

import java.util.ArrayList;

public class ControleurBonus implements IControleur {

    /**
     * Gere les déplacements du bonus
     * change a chaque colision
     * @param bonus
     * @param objetJeus
     */
    public void deplacementBonus(Bonus bonus, ArrayList<ObjetJeu> objetJeus){
        if(bonus.isDeplacementDroite()){
            bonus.deplacement(Direction.DROITE, NombreMagique.Deplacement.deplacementDroiteGauche);
            if(bonus.getX() + bonus.getWidth() == NombreMagique.Ecran.widthScreen){
                bonus.setDeplacementDroite(false);
                return;
            }
            objetJeus.forEach(objetJeu -> {
                if(bonus.getHitbox().enCollision(objetJeu.getHitbox())){
                    bonus.setDeplacementDroite(false);
                    return;
                }
            });
        }
        else{
            bonus.deplacement(Direction.GAUCHE, NombreMagique.Deplacement.deplacementDroiteGauche);
            if(bonus.getX() == 0){
                bonus.setDeplacementDroite(true);
                return;
            }
            objetJeus.forEach(objetJeu -> {
                if(bonus.getHitbox().enCollision(objetJeu.getHitbox())){
                    bonus.setDeplacementDroite(true);
                    return;
                }
            });
        }
    }
}
