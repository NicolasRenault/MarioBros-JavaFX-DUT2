package Metier;

import Interface.IDessinable;
import Outils.NombreMagique;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public abstract class ObjetJeu implements IDessinable {
    private int x, y, width, height;
    private HitBox hitbox;
    private Image image;
    private boolean gravite;

    /**
     * Créer un nouvel ObjetJeu
     * @param x
     * @param y
     * @param width
     * @param height
     * @param gravite
     */
    public ObjetJeu(int x, int y, int width, int height, boolean gravite){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gravite = gravite;
        this.hitbox = new HitBox(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public HitBox getHitbox() {
        return hitbox;
    }

    public Image getImage() {
        return image;
    }

    public boolean isGravite() {
        return gravite;
    }

    public void setX(int x) {
        if(x < 0)
            x = 0;
        if(x + width > NombreMagique.Ecran.widthScreen)
            x = NombreMagique.Ecran.widthScreen - width;
        this.x = x;
        miseAJourHitBox();
    }

    public void setY(int y) {
        if(y < 0)
            y = 0;
        if(y + height > NombreMagique.Ecran.heightScreen)
            y = NombreMagique.Ecran.heightScreen - height;
        this.y = y;
        miseAJourHitBox();
    }

    public void setWidth(int width) {
        if(width < 0)
            width = 0;
        this.width = width;
        miseAJourHitBox();
    }

    public void setHeight(int height) {
        if(height < 0)
            height = 0;
        this.height = height;
        miseAJourHitBox();
    }

    public void setHitbox(HitBox hitbox) {
        this.hitbox = hitbox;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setGravite(boolean gravite) {
        this.gravite = gravite;
    }

    /**
     * Dessine l'objetjeu sur le canvas
     * @param canvas
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.getGraphicsContext2D().drawImage(image, x, y, width, height);
    }

    /**
     * Met a jour la hitbox de l'objetJeu
     */
    public void miseAJourHitBox(){
        setHitbox(new HitBox(getX(), getY(), getWidth(), getHeight()));
    }
}
