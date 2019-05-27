package fr.exia.boulderdash.model.element.semimobile;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;
import fr.exia.boulderdash.model.element.semimobile.SemiMobileElement;

class Rocher extends SemiMobileElement {

    private static final Sprite SPRITE = new Sprite('O', "rocher.png");

    Rocher() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
