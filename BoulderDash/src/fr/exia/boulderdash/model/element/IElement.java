package fr.exia.boulderdash.model.element;

import java.awt.Image;

import fr.exia.showboard.ISquare;

public interface IElement extends ISquare {

    Sprite getSprite();

    Permeability getPermeability();

    @Override
    Image getImage();

    public void setY(final int y);
    
    public void setMoveEnnemi(Boolean moveEnnemi);
	
	public boolean getmoveEnnemi();
    
	public void setTombe(Boolean tombe);
    
    public boolean getTombe();

	
}
