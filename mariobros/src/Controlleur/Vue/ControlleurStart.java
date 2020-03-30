package Controlleur.Vue;

import Outils.GestionnaireVue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ControlleurStart {
    @FXML
    public Button bouttonDemarer;

    /**
     * Quand l'utilisateur appuie sur le bouton "Nouvelle Partie"
     * lance le jeu
     */
    @FXML
    public void lancerJeu() {
        Stage stage = (Stage) bouttonDemarer.getScene().getWindow();
        try {
            Stage fenetreJeu = GestionnaireVue.vueJeu();
            fenetreJeu.show();
            stage.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Quite l'application
     */
    public void quitterAppli() {
        System.exit(1);
    }
}
