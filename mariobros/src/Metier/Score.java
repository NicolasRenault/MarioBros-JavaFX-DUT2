package Metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Score {
    private String nomScore;
    private IntegerProperty point = new SimpleIntegerProperty();

    public String getNomScore() {
        return nomScore;
    }

    public IntegerProperty pointProperty(){
        return point;
    }

    public int getPoint() {
        return pointProperty().get();
    }

    public void setNomScore(String nomScore) {
        this.nomScore = nomScore;
    }

    public void setPoint(int point) {
        pointProperty().set(point);
    }

    @Override
    public String toString() {
        return ("Nom du score : " + getNomScore() + "\nPoint du score : " + getPoint());
    }
}
