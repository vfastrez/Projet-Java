package model.element.mobile;

import java.awt.Point;

import contract.IMap;
import contract.IMobile;
import contract.Permeability;
import contract.Sprite;
import fr.exia.showboard.IBoard;
import model.element.Element;

abstract class Mobile extends Element implements IMobile {

    private Point   position;

    private Boolean alive = true;
    
    private Boolean sortir = false;

    private IMap   map;

    private IBoard  board;

    Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
        super(sprite, permeability);
        this.setMap(map);
        this.position = new Point();
    }

    Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
        this(sprite, map, permeability);
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void moveUp() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }

    @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
    }

    @Override
    public void moveDown() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
    }

    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }

    @Override
    public void doNothing() {
        this.setHasMoved();
    }

    private void setHasMoved() {
        this.getMap().setMobileHasChanged();
    }

    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }

    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    public final void setY(final int y) {
        this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
        if (this.isCrashed()) {
            this.die();
        }
    }

    public IMap getMap() {
        return this.map;
    }

    private void setMap(final IMap map) {
        this.map = map;
    }

    @Override
    public Boolean isAlive() {
        return this.alive;
    }
    
    public boolean sortir()
    {
    	return this.sortir;
    }
    
    public void setSortir(boolean sortir)
    {
    	this.sortir = sortir;
    }

    public void die() {
        this.alive = false;
        this.setHasMoved();
    }

    @Override
    public Boolean isCrashed() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    public void setPosition(final Point position) {
        this.position = position;
    }

    protected IBoard getBoard() {
        return this.board;
    }

}
