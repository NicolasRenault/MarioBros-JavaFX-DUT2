package Controlleur;

import Enumeration.Direction;
import Interface.IControleur;
import Metier.ObjetJeu;
import Metier.Personnage;
import Outils.GestionnaireVue;
import Outils.NombreMagique;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class ControleurPersonnage implements IControleur {
    private boolean echap = false;

    /**
     * Gere les déplacements et action grace au touche du clavier
     * @param personnage
     * @param keyCode
     * @param animationTimer
     */
    public void actionClavier(Personnage personnage, KeyCode keyCode, AnimationTimer animationTimer){
        switch (keyCode) {
            case N: //start manuel debug
                animationTimer.start();
                System.out.println("Start debug");
                break;
            case ESCAPE:
                animationTimer.stop();
                try {
                    Stage stage = GestionnaireVue.vueEchap(animationTimer);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case UP:
            case SPACE:
            case Z:
                if(personnage.getY() + personnage.getHeight() == NombreMagique.Bloc.Sol.positionVerticaleDuSol)
                    personnage.deplacement(Direction.HAUT, NombreMagique.Deplacement.forceDeSaut);
                break;
            case DOWN:
            case S:
                personnage.deplacement(Direction.BAS, NombreMagique.Deplacement.deplacementDroiteGauche);
                break;
            case LEFT:
            case Q:
                personnage.deplacement(Direction.GAUCHE, NombreMagique.Deplacement.deplacementDroiteGauche);
                break;
            case RIGHT:
            case D:
                personnage.deplacement(Direction.DROITE, NombreMagique.Deplacement.deplacementDroiteGauche);
                break;
            default:
                break;
        }
    }

    /**
     * Arrete de déplacement du personnage
     * @param personnage
     */
    public void arretDeplacement(Personnage personnage){
        personnage.deplacement(Direction.NONE, NombreMagique.Deplacement.deplacementNone);
    }

    public boolean enColision(ObjetJeu objetTest, ObjetJeu objetTemoin) {
        return objetTest.getHitbox().enCollision(objetTemoin.getHitbox());
    }
}
