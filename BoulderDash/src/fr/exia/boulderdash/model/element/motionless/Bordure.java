package fr.exia.boulderdash.model.element.motionless;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

class Bordure extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('+', "Bordure.png");

    Bordure() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
