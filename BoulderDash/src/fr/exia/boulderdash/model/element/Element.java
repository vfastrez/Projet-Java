package fr.exia.boulderdash.model.element;

import java.awt.Image;
import java.awt.Point;

import fr.exia.boulderdash.model.IMap;
import fr.exia.showboard.IBoard;

//import fr.exia.showboard.ISquare;

public abstract class Element implements IElement {
	
    private Sprite       sprite;
    
    private Point   position;

    private IMap   map;

    private IBoard  board;

    private Permeability permeability;

    public Element(final Sprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }

    @Override
    public final Sprite getSprite() {
        return this.sprite;
    }

    protected final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public final Permeability getPermeability() {
        return this.permeability;
    }

    private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }

    @Override
    public final Image getImage() {
        return this.getSprite().getImage();
    }
    
    public int getX() {
        return this.getPosition().x;
    }

    public void setX(final int x) {
        this.getPosition().x = x;
    }

    public int getY() {
        return this.getPosition().y;
    }

    public void setY(final int y) {
        this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
    }

    public IMap getMap() {
        return this.map;
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
