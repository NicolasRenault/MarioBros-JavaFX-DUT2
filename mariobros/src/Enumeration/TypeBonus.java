package Enumeration;

public enum TypeBonus {
    MARIO("Te remets à la forme normal"),
    CHAMPIGNON("Je te fais grandir en taille 2"),
    FLEUR("Je suis un champignon mais en plus te fais cracher du feu !");

    private String description;

    TypeBonus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
