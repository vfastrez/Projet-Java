package fr.exia.boulderdash.model.element.semimobile;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;
import fr.exia.boulderdash.model.element.semimobile.SemiMobileElement;

class Ennemi extends SemiMobileElement {

    private static final Sprite SPRITE = new Sprite('!', "Ennemi.png");

    Ennemi() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
