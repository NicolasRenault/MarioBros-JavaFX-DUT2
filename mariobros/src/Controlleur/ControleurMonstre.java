package Controlleur;

import Enumeration.Direction;
import Enumeration.TypeBonus;
import Interface.IControleur;
import Metier.Monstre;
import Metier.ObjetJeu;
import Metier.Personnage;
import Metier.Score;
import Outils.NombreMagique;
import Outils.GestionnaireVue;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ControleurMonstre implements IControleur {

    /**
     * Appel les méthode pour donner un dégat au personnage
     * change en fonction de la taille du personnage
     * @param personnage
     * @param animationTimer
     * @param score
     * @param stageJeu
     */
    public void prendreDegat(Personnage personnage, AnimationTimer animationTimer, Score score, Stage stageJeu){
        System.out.println("Tu as touché un Goomba... T'as forme étais : "+ personnage.getFormeEntite().toString());
        switch (personnage.getFormeEntite()){
            case GRAND:
                animationTimer.stop();
                personnage.activerBonusPersonnage(TypeBonus.MARIO);
                score.setPoint(score.getPoint() + NombreMagique.Score.degatChampignon);
                //personnage.setY(20);
                animationTimer.start();
                break;
            case FEU:
                animationTimer.stop();
                personnage.activerBonusPersonnage(TypeBonus.MARIO);
                personnage.activerBonusPersonnage(TypeBonus.CHAMPIGNON);
                score.setPoint(score.getPoint() + NombreMagique.Score.degatFleur);
                //personnage.setY(20);
                animationTimer.start();
                break;
            case MARIO:
                animationTimer.stop();
                try {
                    score.setPoint(score.getPoint() - NombreMagique.Score.mario);
                    boolean vie = personnage.prendreUnDegat();
                    if (vie) {
                        animationTimer.start();
                        personnage.setY(0);
                        personnage.setX(0);
                    } else {
                        afficherDefaite(stageJeu);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case NONE:
            default:
        }
        System.out.println(score);
    }

    /**
     * Gere les déplacements du monstres
     * qui change a chaque colision
     * @param monstre
     * @param objetJeus
     */
    public void deplacementMonstre(Monstre monstre, ArrayList<ObjetJeu> objetJeus){
        if(monstre.isDeplacementDroite()){
            monstre.deplacement(Direction.DROITE, (NombreMagique.Deplacement.deplacementDroiteGauche - 5d));
            if(monstre.getX() + monstre.getWidth() == NombreMagique.Ecran.widthScreen){
                monstre.setDeplacementDroite(false);
                return;
            }
            objetJeus.forEach(objetJeu -> {
                if(monstre.getHitbox().enCollision(objetJeu.getHitbox())){
                    monstre.setDeplacementDroite(false);
                    return;
                }
            });
        }
        else{
            monstre.deplacement(Direction.GAUCHE, (NombreMagique.Deplacement.deplacementDroiteGauche - 5d));
            if(monstre.getX() == 0){
                monstre.setDeplacementDroite(true);
                return;
            }
            objetJeus.forEach(objetJeu -> {
                if(monstre.getHitbox().enCollision(objetJeu.getHitbox())){
                    monstre.setDeplacementDroite(true);
                    return;
                }
            });
        }
    }

    /**
     * Appel la page de défaite quand le joueur meurs
     * @param stageJeu
     * @throws IOException
     */
    public void afficherDefaite(Stage stageJeu) throws IOException {
        Stage fenetreDefaite = GestionnaireVue.vueDefaite();

        fenetreDefaite.show();
    }
}
