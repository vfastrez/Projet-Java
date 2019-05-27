package fr.exia.boulderdash.model.element.semimobile;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;
import fr.exia.boulderdash.model.element.semimobile.SemiMobileElement;

class Diamant extends SemiMobileElement {

    private static final Sprite SPRITE = new Sprite('^', "diamant.png");
    
    Diamant() {
        super(SPRITE, Permeability.DIAMANT);
    }
}
