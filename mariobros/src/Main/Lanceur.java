package Main;

import Outils.GestionnaireVue;
import javafx.application.Application;
import javafx.stage.Stage;

public class Lanceur extends Application {
    private static Stage mainStage;

    public static Stage getMainStage() {return mainStage;}

    /**
     * Demmare l'application et lance le menu démarrer
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception{
        this.mainStage = stage;
        Stage fenetreDemarage = GestionnaireVue.vueDemarage();
        fenetreDemarage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}