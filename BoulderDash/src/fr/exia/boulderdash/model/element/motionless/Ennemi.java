package fr.exia.boulderdash.model.element.motionless;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

class Ennemi extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('!', "Ennemi.png");

    Ennemi() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
