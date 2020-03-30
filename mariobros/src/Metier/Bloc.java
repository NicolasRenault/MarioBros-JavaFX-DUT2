package Metier;

import Enumeration.TypeBloc;
import javafx.scene.image.Image;

public class Bloc extends ObjetJeu {
    private TypeBloc typeBloc;

    public Bloc(int x, int y, int width, int height, TypeBloc typeBloc) {
        super(x, y, width, height, false);
        this.typeBloc = typeBloc;
        apparance(typeBloc);
    }

    public TypeBloc getTypeBloc() {
        return typeBloc;
    }

    public void setTypeBloc(TypeBloc typeBloc) {
        this.typeBloc = typeBloc;
    }

    /**
     * Defini une apparence en fonction du type du bloc
     * @param typeBloc
     */
    public void apparance(TypeBloc typeBloc){
        switch (typeBloc){
            case CASSABLE:
            case SOLIDE:
            case CASSEE:
            case SURPRISE:
            case SOL:
                setImage(new Image("Images/sol.png"));
                break;
            case TUYAU:
                break;
            case DRAPEAU:
                setImage(new Image("Images/drapeau.png"));
                break;
            case NONE:
            default:
                setImage(new Image("Images/inconnu.jpg"));
                break;
        }
    }
}
