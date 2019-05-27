package fr.exia.boulderdash.model.element;

import java.awt.Image;

import fr.exia.showboard.ISquare;

public interface IElement extends ISquare {

    Sprite getSprite();

    Permeability getPermeability();

    @Override
    Image getImage();

}
