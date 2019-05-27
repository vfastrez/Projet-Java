package fr.exia.boulderdash.model.element.motionless;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

class Diamant extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('^', "diamant.png");
    
    Diamant() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
