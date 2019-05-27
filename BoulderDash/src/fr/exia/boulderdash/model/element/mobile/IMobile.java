package fr.exia.boulderdash.model.element.mobile;

import java.awt.Point;

import fr.exia.boulderdash.model.element.IElement;
import fr.exia.showboard.IPawn;

public interface IMobile extends IPawn, IElement {

    void moveUp();

    void moveLeft();

    void moveDown();

    void moveRight();

    void doNothing();

    @Override
    int getX();

    @Override
    int getY();

    Boolean isAlive();

    Boolean isCrashed();

    @Override
    Point getPosition();
}
