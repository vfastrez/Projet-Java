package contract;

import fr.exia.showboard.BoardFrame;

public interface IBoulderDashView {
	
    void displayMessage(String message);
    
    void followMyHero();
    
	void parcourirTableau();
	
	public BoardFrame getBoardFrame();
}
