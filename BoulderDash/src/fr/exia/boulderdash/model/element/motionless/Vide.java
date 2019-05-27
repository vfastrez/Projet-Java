package fr.exia.boulderdash.model.element.motionless;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

class Vide extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite(' ', "vide.png");

    Vide() {
        super(SPRITE, Permeability.TERRE);
    }
}
