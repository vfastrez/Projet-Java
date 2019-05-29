package contract;

import java.awt.Point;
import fr.exia.showboard.IPawn;

public interface IMobile extends IPawn, IElement {

    void moveUp();

    void moveLeft();

    void moveDown();

    void moveRight();

    void doNothing();
    
    void die();

    @Override
    int getX();

    @Override
    int getY();

    Boolean isAlive();

    Boolean isCrashed();

    @Override
    Point getPosition();

	boolean sortir();
	
	void setSortir(boolean sortir);
}
