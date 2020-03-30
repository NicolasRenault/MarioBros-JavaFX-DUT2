package Persistance;

import Enumeration.FormeEntite;
import Enumeration.TypeBloc;
import Enumeration.TypeBonus;
import Interface.IStrategiePersistance;
import Metier.*;
import Outils.NombreMagique;

import java.util.ArrayList;

public class Stub implements IStrategiePersistance {
    @Override
    public void sauvegarder(Score score) {
        System.out.println("Score enregistré : \n" + score);
    }

    /**
     * Données pour la création d'une partie
     * @param listeObjet
     * @param listeEntite
     * @param score
     */
    @Override
    public void lire(ArrayList<ObjetJeu> listeObjet, ArrayList<Entite> listeEntite, Score score) {
        //Personnage luigi = new Personnage(150,0, NombreMagique.widthDefaut, NombreMagique.heightDefaut, FormeEntite.MARIO, NombreMagique.vieDeMarioDefaut, NombreMagique.tailleDeMarioDefaut);
        Monstre goomba = new Monstre(200, NombreMagique.Bloc.Sol.positionVerticaleDuSol-NombreMagique.Monstre.height, NombreMagique.Monstre.width, NombreMagique.Monstre.height, FormeEntite.GOOMBA);
        Bonus champignon = new Bonus(500, NombreMagique.Bloc.Sol.positionVerticaleDuSol-NombreMagique.Bonus.height, NombreMagique.Bonus.width, NombreMagique.Bonus.height, FormeEntite.CHAMPIGNON, TypeBonus.CHAMPIGNON);
        Bonus fleur = new Bonus(1300, NombreMagique.Bloc.Sol.positionVerticaleDuSol-NombreMagique.Bonus.height, NombreMagique.Bonus.width, NombreMagique.Bonus.height, FormeEntite.FLEUR, TypeBonus.FLEUR);
        Bloc drapeau = new Bloc(1790, 720, NombreMagique.Bloc.Drapeau.width, NombreMagique.Bloc.Drapeau.height, TypeBloc.DRAPEAU);
        Bloc drapeau2 = new Bloc(100, 900, NombreMagique.Bloc.Drapeau.width, NombreMagique.Bloc.Drapeau.height, TypeBloc.DRAPEAU);
        Bloc sol1 = new Bloc(0, NombreMagique.Bloc.Sol.positionVerticaleDuSol, NombreMagique.Bloc.Sol.width, NombreMagique.Bloc.Sol.height, TypeBloc.SOL);
        Bloc sol2 = new Bloc(200, NombreMagique.Bloc.Sol.positionVerticaleDuSol, NombreMagique.Bloc.Sol.width, NombreMagique.Bloc.Sol.height, TypeBloc.SOL);
        Bloc sol3 = new Bloc(400, NombreMagique.Bloc.Sol.positionVerticaleDuSol, NombreMagique.Bloc.Sol.width, NombreMagique.Bloc.Sol.height, TypeBloc.SOL);
        Bloc sol4 = new Bloc(600, NombreMagique.Bloc.Sol.positionVerticaleDuSol, NombreMagique.Bloc.Sol.width, NombreMagique.Bloc.Sol.height, TypeBloc.SOL);
        Bloc sol5 = new Bloc(800, NombreMagique.Bloc.Sol.positionVerticaleDuSol, NombreMagique.Bloc.Sol.width, NombreMagique.Bloc.Sol.height, TypeBloc.SOL);
        Bloc sol6 = new Bloc(1000, NombreMagique.Bloc.Sol.positionVerticaleDuSol, NombreMagique.Bloc.Sol.width, NombreMagique.Bloc.Sol.height, TypeBloc.SOL);
        Bloc sol7 = new Bloc(1200, NombreMagique.Bloc.Sol.positionVerticaleDuSol, NombreMagique.Bloc.Sol.width, NombreMagique.Bloc.Sol.height, TypeBloc.SOL);
        Bloc sol8 = new Bloc(1400, NombreMagique.Bloc.Sol.positionVerticaleDuSol, NombreMagique.Bloc.Sol.width, NombreMagique.Bloc.Sol.height, TypeBloc.SOL);
        Bloc sol9 = new Bloc(1600, NombreMagique.Bloc.Sol.positionVerticaleDuSol, NombreMagique.Bloc.Sol.width, NombreMagique.Bloc.Sol.height, TypeBloc.SOL);
        Bloc sol10 = new Bloc(1800, NombreMagique.Bloc.Sol.positionVerticaleDuSol, NombreMagique.Bloc.Sol.width, NombreMagique.Bloc.Sol.height, TypeBloc.SOL);
        //Bloc sol11 = new Bloc(1600, NombreMagique.Bloc.Sol.positionVerticaleDuSol-50, 50, 50, TypeBloc.SOL);

        //listeObjet.add(luigi);
        listeObjet.add(goomba);
        listeObjet.add(champignon);
        listeObjet.add(fleur);
        listeObjet.add(drapeau);
        listeObjet.add(sol1);
        listeObjet.add(sol2);
        listeObjet.add(sol3);
        listeObjet.add(sol4);
        listeObjet.add(sol5);
        listeObjet.add(sol6);
        listeObjet.add(sol7);
        listeObjet.add(sol8);
        listeObjet.add(sol9);
        listeObjet.add(sol10);
        //listeObjet.add(sol11);
        // listeObjet.add(drapeau2);
        listeEntite.add(goomba);
        listeEntite.add(champignon);
        listeEntite.add(fleur);

        score.setPoint(0);
        score.setNomScore("Score de Thomas");
    }
}
