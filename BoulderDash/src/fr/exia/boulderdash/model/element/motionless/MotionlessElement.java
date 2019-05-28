package fr.exia.boulderdash.model.element.motionless;

import java.awt.Point;

import fr.exia.boulderdash.model.IMap;
import fr.exia.boulderdash.model.element.Element;
import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

abstract class MotionlessElement extends Element{

    MotionlessElement(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }
    
    MotionlessElement(final Sprite sprite, final IMap map, final Permeability permeability) {
        super(sprite, permeability);
        new Point();
    }

    MotionlessElement(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
        this(sprite, map, permeability);

    }

}
