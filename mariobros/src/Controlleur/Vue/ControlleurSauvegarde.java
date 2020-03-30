package Controlleur.Vue;

import Metier.Score;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlleurSauvegarde implements Initializable {

    @FXML
    public Text scoreAffichage;

    private Score score;

    public ControlleurSauvegarde(Score score) {
        this.score = score;
    }


    public void sauvegarde(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scoreAffichage.textProperty().bind(score.pointProperty().asString());
    }

    public void setScore(Score s){
        score = s;
    }
}
