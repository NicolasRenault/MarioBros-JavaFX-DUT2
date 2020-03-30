package Controlleur.Vue;

import Metier.Score;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControleurScore {
    public ControleurScore(){

    }

    @FXML
    private TextField textScore;
    private IntegerProperty point = new SimpleIntegerProperty(10);
    private IntegerProperty point2 = new SimpleIntegerProperty();
    private Score score;

    public TextField getScore() {
        return textScore;
    }

    public void setScore(TextField textScore) {
        this.textScore = textScore;
    }

    /*@FXML
    public void initialize(){
        setPoint2(50);
    }

    public void setPoint2(int i){
        point2.set(i);
        point.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                System.out.println("point changé : "+ oldValue + " -> "+ newValue);
                textScore.setText(String.valueOf(newValue));
            }
        });
        point.bind(point2);
    }*/
}
