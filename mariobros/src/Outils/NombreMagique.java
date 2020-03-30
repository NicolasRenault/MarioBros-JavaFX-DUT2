package Outils;

import java.awt.*;

public class NombreMagique {


    /***
     * Données static des dimensions de l'écran utilisé
     */
    public static class Ecran{
        public static final Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        public static final int heightScreen = (int) dimension.getHeight();
        public static final int widthScreen = (int) dimension.getWidth();
    }

    /**
     * Données static en dur pour les valeurs du personnage
     */
    public static class Personnage{
        public static final int height = 50;
        public static final int width = 50;
        public static final int vieDeMario = 3;
        public static final int tailleDeMario = 1;
        public static final int tailleMaximal = 2;
    }

    /**
     * Données static en dur pour les valeurs des monstres
     */
    public static class Monstre{
        public static final int height = 50;
        public static final int width = 50;
    }

    /**
     * Données static en dur pour les valeurs des bonus
     */
    public static class Bonus{
        public static final int width = 25;
        public static final int height = 25;
    }

    /**
     * Données static en dur pour les valeurs des blocs
     */
    public static class Bloc{
        public static class Drapeau{
            public static final int width = 100;
            public static final int height = 300;
        }

        public static class Sol{
            public static final int positionVerticaleDuSol = 1000;
            public static final int width = 200;
            public static final int height = 50;
        }
    }

    /**
     * Données static en dur pour les valeurs des déplacements
     */
    public static class Deplacement {
        public static final double gravite = 0.2d;
        public static final double deplacementDroiteGauche = 10d;
        public static final double forceDeSaut = 500d;
        public static final double deplacementNone = 0d;
    }

    /**
     * Données static en dur pour les valeurs des scores
     */
    public static class Score{
        public static final int bonus = +100;
        public static final int mario = -100;
        public static final int degatChampignon = -50;
        public static final int degatFleur = -20;
        public static final int drapeau = +500;
    }
}
