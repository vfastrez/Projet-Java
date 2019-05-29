package model.element.motionless;

import java.awt.Point;

import contract.IMap;
import contract.Permeability;
import contract.Sprite;
import model.element.Element;

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
