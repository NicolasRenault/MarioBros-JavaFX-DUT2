package Outils;

import Controlleur.Vue.ControlleurEchap;
import Controlleur.Vue.ControlleurJeu;
import Controlleur.Vue.ControlleurSauvegarde;
import Metier.Score;
import Modele.Partie;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import Main.Lanceur;
import javafx.stage.StageStyle;

import java.io.IOException;

public class GestionnaireVue {

    /**
     * Lance un nouveau stage pour le démarrage
     * @return Stage
     * @throws IOException
     */
    public static Stage vueDemarage() throws IOException {
        final FXMLLoader loader = new FXMLLoader(GestionnaireVue.class.getResource("/Vue/start.fxml"));
        Stage fenetreDemarage = new Stage();
        fenetreDemarage.centerOnScreen();
        fenetreDemarage.setTitle("Menu Mariobros");
        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        fenetreDemarage.initStyle(StageStyle.TRANSPARENT);
        fenetreDemarage.setScene(scene);

        return fenetreDemarage;
    }

    /**
     * Lance un nouveau stage pour le score
     * @param score
     * @return Stage
     * @throws IOException
     */
    public static Stage vueVictoire(Score score) throws IOException {
        final FXMLLoader loader = new FXMLLoader(GestionnaireVue.class.getResource("/Vue/victoire.fxml"));
        Stage fenetreVictoire = new Stage();
        fenetreVictoire.centerOnScreen();
        fenetreVictoire.setTitle("Victoire");
        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        fenetreVictoire.initStyle(StageStyle.TRANSPARENT);
        fenetreVictoire.setScene(scene);

        return fenetreVictoire;
    }

    /**
     * Lance un nouveau stage pour la défaite
     * @return Stage
     * @throws IOException
     */
    public static Stage vueDefaite() throws IOException {
        final FXMLLoader loader = new FXMLLoader(GestionnaireVue.class.getResource("/Vue/mort.fxml"));
        Stage fenetreMort = new Stage();
        fenetreMort.centerOnScreen();
        fenetreMort.setTitle("Defaite");
        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        fenetreMort.initStyle(StageStyle.TRANSPARENT);
        fenetreMort.setScene(scene);

        return fenetreMort;
    }

    /**
     * Lance un nouveau stage pour le score
     * @return Stage
     * @throws IOException
     */
    public static Stage vueScore() throws IOException {
        final FXMLLoader loader = new FXMLLoader(GestionnaireVue.class.getResource("/Vue/score.fxml"));
        Stage fenetreScore = new Stage();
        fenetreScore.centerOnScreen();
        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        fenetreScore.initStyle(StageStyle.TRANSPARENT);
        fenetreScore.setScene(scene);

        return fenetreScore;
    }

    /**
     * Lance un nouveau stage pour le jeu
     * @return Stage
     * @throws Exception
     */
    public static Stage vueJeu() throws Exception {
        final FXMLLoader loader = new FXMLLoader(GestionnaireVue.class.getResource("/Vue/jeu.fxml"));
        final ControlleurJeu controller = new ControlleurJeu();
        Stage fenetreJeu = Lanceur.getMainStage();
        loader.setController(controller);
        fenetreJeu.setResizable(false);
        fenetreJeu.setTitle("Mariobros");
        Scene scene = new Scene(loader.load());
        //scene.setFill(Color.TRANSPARENT);
        //fenetreJeu.initStyle(StageStyle.TRANSPARENT);
        fenetreJeu.setScene(scene);

        Canvas canvas = controller.getCanvas();


        new Partie(scene, canvas);

        return fenetreJeu;
    }

    /**
     * Lance un nouveau stage pour le sauvegarde
     * @param score
     * @return Stage
     * @throws IOException
     */
    public static Stage vueSauvegarde(Score score) throws IOException {
        final FXMLLoader loader = new FXMLLoader(GestionnaireVue.class.getResource("/Vue/sauvegarde.fxml"));
        Stage fenetreSauvegarde = new Stage();
        ControlleurSauvegarde controller = new ControlleurSauvegarde(score);
        loader.setController(controller);
        fenetreSauvegarde.centerOnScreen();
        fenetreSauvegarde.setTitle("Sauvegade");
        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        fenetreSauvegarde.initStyle(StageStyle.TRANSPARENT);
        fenetreSauvegarde.setScene(scene);

        return fenetreSauvegarde;
    }

    /**
     * Lance un nouveau stage pour la pause
     * @param animationTimer
     * @return Stage
     * @throws IOException
     */
    public static Stage vueEchap(AnimationTimer animationTimer) throws IOException {
        final FXMLLoader loader = new FXMLLoader(GestionnaireVue.class.getResource("/Vue/echap.fxml"));
        Stage fenetreEchap = new Stage();
        ControlleurEchap controlleur = new ControlleurEchap(animationTimer);
        loader.setController(controlleur);
        fenetreEchap.centerOnScreen();
        fenetreEchap.setTitle("Pause");
        Scene scene = new Scene(loader.load());
        scene.setFill(Color.TRANSPARENT);
        fenetreEchap.initStyle(StageStyle.TRANSPARENT);
        fenetreEchap.setScene(scene);

        return fenetreEchap;
    }
}
