package model.element.motionless;

import contract.Permeability;
import contract.Sprite;

class Rocher extends MotionlessElement {
	boolean tombe;
    private static final Sprite SPRITE = new Sprite('O', "rocher.png");

    Rocher() {
        super(SPRITE, Permeability.ROCHER);
    }
    
    public boolean getTombe()
    {
    	return this.tombe;
    }

	@Override
	public void setTombe(Boolean tombe) {
		this.tombe = tombe;
		//System.out.print("toto");
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
