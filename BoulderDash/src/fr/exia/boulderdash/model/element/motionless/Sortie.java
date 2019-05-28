package fr.exia.boulderdash.model.element.motionless;

import fr.exia.boulderdash.model.element.Permeability;
import fr.exia.boulderdash.model.element.Sprite;

class Sortie extends MotionlessElement {

    private static final Sprite SPRITE = new Sprite('/', "Sortie.png");

    Sortie() {
        super(SPRITE, Permeability.PENETRABLE);
    }

	@Override
	public void setTombe(Boolean tombe) {
		
	}

	@Override
	public boolean getTombe() {
		// TODO Auto-generated method stub
		return false;
	}
}
