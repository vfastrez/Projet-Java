package fr.exia.boulderdash.model.element.motionless;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

class Terre extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('X', "terre.png");

    Terre() {
        super(SPRITE, Permeability.TERRE);
    }
}
