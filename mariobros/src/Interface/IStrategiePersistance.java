package Interface;

import Metier.Entite;
import Metier.ObjetJeu;
import Metier.Score;

import java.util.ArrayList;

public interface IStrategiePersistance {
    public void sauvegarder(Score score);
    public void lire(ArrayList<ObjetJeu> listeObjet, ArrayList<Entite> listeEntite, Score score);
}
