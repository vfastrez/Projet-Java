package fr.exia.boulderdash.model.element.motionless;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

class Diamant extends MotionlessElement {

	boolean tombe;
	
    private static final Sprite SPRITE = new Sprite('^', "diamant.png");
    
    Diamant() {
        super(SPRITE, Permeability.DIAMANT);
    }
    
    public boolean getTombe()
    {
    	return this.tombe;
    }

	@Override
	public void setTombe(Boolean tombe) {
		this.tombe = tombe;
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
