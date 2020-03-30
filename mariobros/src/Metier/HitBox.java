package Metier;

import javafx.geometry.Rectangle2D;

public class HitBox {
    private Rectangle2D rectangle2D;

    public HitBox(int x, int y, int width, int height) {
        rectangle2D = new Rectangle2D(x, y, width, height);
    }

    public Rectangle2D getRectangle2D() {
        return rectangle2D;
    }

    public void setRectangle2D(Rectangle2D rectangle2D) {
        this.rectangle2D = rectangle2D;
    }

    /**
     * Vérifie  si l'objet et en collison grace a la hitbox
     * @param hitbox
     * @return boolean
     */
    public boolean enCollision(HitBox hitbox){
        if(this==hitbox)
            return false;
        return rectangle2D.intersects(hitbox.getRectangle2D());
    }
}
