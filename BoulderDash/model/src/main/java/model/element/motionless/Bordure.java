package model.element.motionless;

import contract.Permeability;
import contract.Sprite;

class Bordure extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('+', "Bordure.png");

    Bordure() {
        super(SPRITE, Permeability.PENETRABLE);
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
