package model.element.mobile;

import java.io.IOException;

import contract.IMap;
import contract.Permeability;
import contract.Sprite;

public class MyHero extends Mobile {

    private static final Sprite spriteBas          = new Sprite('H', "Bas.png");

    private static final Sprite spriteGauche  = new Sprite('H', "Gauche1.png");

    private static final Sprite spriteDroite = new Sprite('H', "Droite3.png");

    private static final Sprite spriteMort   = new Sprite('H', "Mort1.png");
    
    private static final Sprite spriteHaut	= new Sprite('H', "Haut.png");
    
    private static final Sprite spriteImmobile = new Sprite('H', "Immobile.png");

    public MyHero(final int x, final int y, final IMap map) throws IOException {
        super(x, y, spriteBas, map, Permeability.HERO);
        spriteHaut.loadImage();
        spriteBas.loadImage();
        spriteGauche.loadImage();
        spriteDroite.loadImage();
        spriteMort.loadImage();
        spriteImmobile.loadImage();
    }

    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteGauche);
    }

    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteDroite);
    }

    @Override
    public final void die() {
        super.die();
        this.setSprite(spriteMort);
    }

    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(spriteImmobile);
    }
    
    @Override
    public final void moveUp() {
    	super.moveUp();
    	this.setSprite(spriteHaut);
    }
    
    @Override
    public final void moveDown() {
    	super.moveDown();
    	this.setSprite(spriteBas);
    }

	@Override
	public void setTombe(Boolean tombe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getTombe() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setMoveEnnemi(Boolean moveEnnemi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getmoveEnnemi() {
		// TODO Auto-generated method stub
		return false;
	}
    
}
