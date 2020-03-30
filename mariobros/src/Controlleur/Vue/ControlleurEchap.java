package Controlleur.Vue;

import Outils.GestionnaireVue;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControlleurEchap {
    public AnimationTimer animationTimer;
    @FXML
    public Button bouttonRelancer;

    public ControlleurEchap(AnimationTimer animationTimer) {
        setAnimationTimer(animationTimer);
    }

    public void setAnimationTimer(AnimationTimer animationTimer) {
        this.animationTimer = animationTimer;
    }

    /**
     * Quand l'utilisateur appuie sur le bouton "Relancer"
     * Relance la partie et ferme la fernetre de pause
     */
    @FXML
    public void relancerJeu() {
        animationTimer.start();
        close();
    }
    /**
     * Quand l'utilisateur appuie sur le bouton "Retour au menu"
     * Ouvre la fenetre de menu et ferme la fernetre de pause
     */
    public void quitterAuMenu() {
        try {
            Stage fenetreMenu = GestionnaireVue.vueDemarage();
            fenetreMenu.show();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Ferme la fenetre
     */
    private void close() {
        Stage stage = (Stage) bouttonRelancer.getScene().getWindow();
        stage.close();
    }
}
