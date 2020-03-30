package Modele;

import Controlleur.ControleurBloc;
import Controlleur.ControleurEntite;
import Controlleur.ControleurMonstre;
import Controlleur.ControleurPersonnage;
import Enumeration.FormeEntite;
import Interface.IControleur;
import Interface.IStrategiePersistance;
import Metier.*;
import Outils.NombreMagique;
import Persistance.Stub;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Partie {
    private IStrategiePersistance strategiePersistance;
    private Scene scene;
    private Canvas canvas;
    private Stage stage;
    private Score score= new Score();
    private ArrayList<ObjetJeu> listeObjet;
    private ArrayList<IControleur> listeControleur;
    private ArrayList<Entite> listeEntite;
    private Personnage mario = new Personnage(0,NombreMagique.Bloc.Sol.positionVerticaleDuSol-NombreMagique.Personnage.height, NombreMagique.Personnage.width, NombreMagique.Personnage.height, FormeEntite.MARIO, NombreMagique.Personnage.vieDeMario, NombreMagique.Personnage.tailleDeMario);
    private ControleurBloc controleurBloc = new ControleurBloc();
    private ControleurPersonnage controleurPersonnage = new ControleurPersonnage();
    private ControleurEntite controleurEntite = new ControleurEntite();
    private ControleurMonstre controleurMonstre = new ControleurMonstre();
    private long tempsPrecedent = 0;

    /**
     * Créer une nouvelle partie
     * Appel le chargement des données du STUB
     * Lance le jeu
     * @param scene
     * @param canvas
     */
    public Partie(Scene scene, Canvas canvas) {
        this.strategiePersistance = new Stub();
        this.scene = scene;
        this.canvas = canvas;

      // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! score.setPoint(0);
        listeObjet = new ArrayList<ObjetJeu>();
        listeControleur = new ArrayList<IControleur>();
        listeEntite = new ArrayList<Entite>();
        chargementDonnee();

        scene.setOnKeyPressed(keyEvent -> controleurPersonnage.actionClavier(mario, keyEvent.getCode(), boucleDuJeu));
        scene.setOnKeyReleased(keyEvent -> controleurPersonnage.arretDeplacement(mario));

        boucleDuJeu.start();
    }

    /**
     * Charge les données du STUB pour pouvoir
     * les chargées dans la partie
     */
    public void chargementDonnee(){
        strategiePersistance.lire(listeObjet, listeEntite, score);
        listeObjet.add(mario);
        listeEntite.add(mario);
    }

    public Scene getScene() {
        return scene;
    }

    public ArrayList<ObjetJeu> getListeObjet() {
        return listeObjet;
    }

    public ArrayList<IControleur> getListeControleur() {
        return listeControleur;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setListeObjet(ArrayList<ObjetJeu> listeObjet) {
        this.listeObjet = listeObjet;
    }

    public void setListeControleur(ArrayList<IControleur> listeControleur) {
        this.listeControleur = listeControleur;
    }

    /**
     * Met a jour tous les objets sur le canvas
     * en les dessinant
     * @param canvas
     */
    public void redessinerObjetJeu(Canvas canvas){
        canvas.getGraphicsContext2D().clearRect(0, 0, NombreMagique.Ecran.widthScreen, NombreMagique.Ecran.widthScreen);
        listeObjet.forEach((objetJeu -> objetJeu.draw(canvas)));
    }

    /**
     * Donne un effet a mario
     * et met a jour le score
     * @param objetBonus
     * @param score
     */
    public void activerEffet(Bonus objetBonus, Score score){
        mario.activerBonusPersonnage(objetBonus.getType());
        score.setPoint(score.getPoint() + NombreMagique.Score.bonus);
        System.out.println(score);
        listeObjet.remove(objetBonus);
    }

    /**
     * Bouble de jeu (mettre a jour + dessiner)
     */
    AnimationTimer boucleDuJeu = new AnimationTimer() {
        @Override
        public void handle(long tempsActuel) {

            controleurEntite.deplacementEntite(listeEntite, listeObjet);

            /**
             * Colision
             */

            listeObjet.forEach(objetJeu -> {
                if(mario.getHitbox().enCollision(objetJeu.getHitbox())) {
                    //System.out.println("Aïe !!");
                    if(objetJeu.getClass().getName() == "Metier.Monstre")
                        controleurMonstre.prendreDegat(mario, boucleDuJeu, score, stage);
                    if(objetJeu.getClass().getName() == "Metier.Bonus"){
                        Bonus objetBonus = (Bonus) objetJeu;
                        System.out.println("Ton bonus est : " + objetBonus.getDescription());
                        activerEffet(objetBonus, score);
                    }
                    if(objetJeu.getClass().getName() == "Metier.Bloc"){
                        Bloc objetBloc = (Bloc) objetJeu;
                        controleurBloc.colisionBloc(boucleDuJeu, objetBloc.getTypeBloc(), stage, score);
                    }
                }
            });
            /**
             * Gravité
             */

            listeObjet.forEach(objetJeu -> controleurEntite.effetGravite(objetJeu));

            /**
             * Dessiner
             */

            redessinerObjetJeu(canvas);

            /**
             * Temps de la boucle de jeu
             */
            try {
                Thread.sleep(28);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    };
}
