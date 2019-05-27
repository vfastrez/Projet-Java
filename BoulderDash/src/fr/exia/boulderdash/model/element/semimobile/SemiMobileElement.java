package fr.exia.boulderdash.model.element.semimobile;

import fr.exia.boulderdash.model.element.Element;
import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

abstract class SemiMobileElement extends Element {

    SemiMobileElement(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }
}
