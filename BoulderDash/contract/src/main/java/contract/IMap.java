package contract;

import java.util.Observable;

public interface IMap {

    boolean getEnnemi = false;
	int getWidth();

    int getHeight();

    IElement getOnTheMapXY(int x, int y);
 
    void setMobileHasChanged();

    Observable getObservable();
    IElement getVide();
    IElement getTerre();
    IElement getDiamant();
    IElement getRocher();
    IElement getBordure();
	IElement getEnnemi();
	IElement getSortie();
    void setOnTheMapXY(final IElement element, final int x, final int y);

	
}
