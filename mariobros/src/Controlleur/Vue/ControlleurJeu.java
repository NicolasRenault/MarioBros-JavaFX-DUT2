package Controlleur.Vue;

import Outils.NombreMagique;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.Text;

public class ControlleurJeu {

    @FXML
    private Canvas dessin;
    private Text score;

    @FXML
    private void initialize() {
        dessin.setWidth(NombreMagique.Ecran.widthScreen);
        dessin.setHeight(NombreMagique.Ecran.heightScreen);
        //setScore("0");
    }

    public Canvas getCanvas() throws Exception {
        if(dessin == null)
            throw new Exception("Dessin null !");
        return dessin;
    }

    public void setScore(String score) {
        this.score.setText(score);
    }
}
