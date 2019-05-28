package fr.exia.boulderdash.model.element.motionless;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

class Rocher extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('O', "rocher.png");

    Rocher() {
        super(SPRITE, Permeability.ROCHER);
    }
}
