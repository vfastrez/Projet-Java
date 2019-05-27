package fr.exia.boulderdash.model.element.motionless;

import fr.exia.boulderdash.model.element.Element;
import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

abstract class MotionlessElement extends Element {

    MotionlessElement(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }

}
