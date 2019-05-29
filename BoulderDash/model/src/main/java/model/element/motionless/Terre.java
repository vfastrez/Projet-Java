package model.element.motionless;

import contract.Permeability;
import contract.Sprite;

class Terre extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('X', "terre.png");

    Terre() {
        super(SPRITE, Permeability.TERRE);
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
