package Controlleur.Vue;

import Outils.GestionnaireVue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControlleurMort {
    @FXML public Button bouttonRelancer;

    /**
     * Quand l'utilisateur appuie sur le bouton "Relancer"
     * Relance la partie et ferme la fernetre de mort
     */
    @FXML
    public void lancerJeu() {
        try {
            Stage fenetreJeu = GestionnaireVue.vueJeu();
            fenetreJeu.show();
            close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Quand l'utilisateur appuie sur le bouton "Retour au bureau"
     * Quitte l'application
     */
    public void quitterAppli() {
        System.exit(1);
    }

    /**
     * Quand l'utilisateur appuie sur le bouton "Sauvegarder"
     * Ouvre la page de sauvegarde
     */
    public void sauvegarderScore() {
        /*Stage fenetreSauvegarde = null;
        try {
            fenetreSauvegarde = GestionVue.vueSauvegarde();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fenetreSauvegarde.show();*/
    }
    /**
     * Quand l'utilisateur appuie sur le bouton "Retour au menu"
     * Ouvre la fenetre de menu et ferme la fernetre de mort
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
