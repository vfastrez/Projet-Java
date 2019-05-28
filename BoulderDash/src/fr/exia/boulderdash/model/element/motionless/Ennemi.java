package fr.exia.boulderdash.model.element.motionless;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

class Ennemi extends MotionlessElement {
	boolean moveEnnemi;
    private static final Sprite SPRITE = new Sprite('!', "Ennemi.png");

    Ennemi() {
        super(SPRITE, Permeability.BLOCKING);
    }
    
    @Override
		public boolean getmoveEnnemi() {
			return this.moveEnnemi;
		}
    
	@Override
	public void setMoveEnnemi(Boolean moveEnnemi) {
		this.moveEnnemi = moveEnnemi;
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
}
