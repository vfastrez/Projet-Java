package fr.exia.boulderdash.model.element.motionless;

public abstract class MotionlessElementsFactory {

    private static final Sortie           sortie           = new Sortie();

    private static final Bordure   bordure   = new Bordure();

    private static final Terre  terre  = new Terre();

    private static final Vide             VIDE             = new Vide();

    private static MotionlessElement[]       motionlessElements  = {
        sortie,
        bordure,
        terre,

        VIDE,};
    
    public static MotionlessElement sortie() {
        return sortie;
    }

    public static MotionlessElement createBordure() {
        return bordure;
    }

    public static MotionlessElement createTerre() {
        return terre;
    }

    public static MotionlessElement createVide() {
        return VIDE;
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
