package model.element.motionless;

import contract.Permeability;
import contract.Sprite;

class Sortie extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('/', "Sortie.png");

    Sortie() {
        super(SPRITE, Permeability.SORTIE);
    }

	@Override
	public void setTombe(Boolean tombe) {
		
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
