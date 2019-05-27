package fr.exia.boulderdash.model.element.semimobile;

import java.awt.Point;

import fr.exia.boulderdash.model.IMap;
import fr.exia.boulderdash.model.element.Element;
import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;
import fr.exia.showboard.IBoard;

abstract class SemiMobile extends Element implements ISemiMobile {

    private Point   position;

    private IMap   map;

    private IBoard  board;

    SemiMobile(final Sprite sprite, final IMap map, final Permeability permeability) {
        super(sprite, permeability);
        this.setMap(map);
        this.position = new Point();
    }

    SemiMobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
        this(sprite, map, permeability);
        this.setX(x);
        this.setY(y);
    }

    public final int getX() {
        return this.getPosition().x;
    }

    public final void setX(final int x) {
        this.getPosition().x = x;
    }

    public final int getY() {
        return this.getPosition().y;
    }

    public final void setY(final int y) {
        this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
    }

    public IMap getMap() {
        return this.map;
    }

    private void setMap(final IMap map) {
        this.map = map;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(final Point position) {
        this.position = position;
    }

    protected IBoard getBoard() {
        return this.board;
    }

}
