package fr.exia.boulderdash.model.element.semimobile;

public abstract class SemiMobileElementFactory {

    private static final Ennemi ennemi = new Ennemi();
    private static final Diamant DIAMANT = new Diamant();
    private static final Rocher ROCHER = new Rocher();
    
    private static SemiMobileElement[] semiMobileElements= {
            ennemi,
            ROCHER,
            DIAMANT};
    
    public static SemiMobileElement createEnnemi() {
        return ennemi;
    }
    
    public static SemiMobileElement createRocher() {
        return ROCHER;
    }
   
    public static SemiMobileElement createDiamant() {
        return DIAMANT;
    }
    
    public static SemiMobileElement getFromFileSymbol(final char fileSymbol) {
        for (final SemiMobileElement semiMobileElement : semiMobileElements) {
            if (semiMobileElement.getSprite().getConsoleImage() == fileSymbol) {
                return semiMobileElement;
            }
        }
		return null;
    }
}
