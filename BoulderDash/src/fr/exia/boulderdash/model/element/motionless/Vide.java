package fr.exia.boulderdash.model.element.motionless;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

class Vide extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite(' ', "vide.png");

    Vide() {
        super(SPRITE, Permeability.VIDE);
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
