package fr.exia.boulderdash.model.element.motionless;

public abstract class MotionlessElementsFactory {

    private static final Sortie           sortie           = new Sortie();

    private static final Bordure   bordure   = new Bordure();

    private static final Terre  terre  = new Terre();

    private static final Ennemi  ennemi  = new Ennemi();

    private static final Diamant                DIAMANT                = new Diamant();

    private static final Vide             VIDE             = new Vide();

    private static final Rocher            ROCHER            = new Rocher();

    private static MotionlessElement[]       motionlessElements  = {
        sortie,
        bordure,
        terre,
        ennemi,
        VIDE,
        ROCHER,
        DIAMANT, };
    
    public static MotionlessElement sortie() {
        return sortie;
    }

    public static MotionlessElement createBordure() {
        return bordure;
    }

    public static MotionlessElement createTerre() {
        return terre;
    }

    public static MotionlessElement createEnnemi() {
        return ennemi;
    }

    public static MotionlessElement createMacadam() {
        return VIDE;
    }

    public static MotionlessElement createObstacle() {
        return ROCHER;
    }

    public static MotionlessElement createDiamant() {
        return DIAMANT;
    }

    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return VIDE;
    }
}
