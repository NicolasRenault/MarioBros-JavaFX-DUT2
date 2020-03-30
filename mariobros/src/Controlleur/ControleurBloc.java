package Controlleur;

import Enumeration.TypeBloc;
import Interface.IControleur;
import Metier.Score;
import Outils.GestionnaireVue;
import Outils.NombreMagique;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

import java.io.IOException;

public class ControleurBloc implements IControleur {

    /**
     * Verifie la colision avec le personnage et un bloc
     * change en fonction du type de bloc
     * @param animationTimer
     * @param typeBloc
     * @param stageJeu
     * @param score
     */
    public void colisionBloc(AnimationTimer animationTimer, TypeBloc typeBloc, Stage stageJeu, Score score){
        switch (typeBloc){
            case DRAPEAU:
                System.out.println("Victoire");
                animationTimer.stop();
                score.setPoint(score.getPoint() + NombreMagique.Score.drapeau);
                try {
                    afficherVictoire(stageJeu, score);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    /**
     * Appel la page de défaite quand le joueur touche le DRAPEAU
     * @param stageJeu
     * @param score
     * @throws IOException
     */
    public void afficherVictoire(Stage stageJeu, Score score) throws IOException {
        Stage fenetreVictoire = GestionnaireVue.vueVictoire(score);

        fenetreVictoire.show();
    }
}
