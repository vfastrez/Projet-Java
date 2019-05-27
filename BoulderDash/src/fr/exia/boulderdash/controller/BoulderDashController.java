package fr.exia.boulderdash.controller;

import java.io.IOException;

import fr.exia.boulderdash.model.IBoulderDashModel;
import fr.exia.boulderdash.view.IBoulderDashView;

public class BoulderDashController implements IBoulderDashController, IOrderPerformer {

    private static final int     speed = 350;

    private IBoulderDashView  view;
    
    private IBoulderDashModel model;

    private UserOrder            stackOrder;

    public BoulderDashController(final IBoulderDashView view, final IBoulderDashModel model) {
        this.setView(view);
        this.setModel(model);
        this.clearStackOrder();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#play()
     */
    @Override
    public final void play() throws InterruptedException {
        while (this.getModel().getMyHero().isAlive()) {
            Thread.sleep(speed);
            this.getView().parcourirTableau();
            switch (this.getStackOrder()) {
                case RIGHT:
                	this.checkTerre();
                    this.getModel().getMyHero().moveRight();
                    break;
                    
                case LEFT:
                	this.checkTerre();
                    this.getModel().getMyHero().moveLeft();
                    break;
                    
                case UP:
                	this.checkTerre();
                    this.getModel().getMyHero().moveUp();
                    break;
                    
                case DOWN:
                	int xVehicle4 = this.getModel().getMyHero().getX();
                	int yVehicle4 = this.getModel().getMyHero().getY();
                	if (this.getModel().getMap().getOnTheMapXY(xVehicle4, yVehicle4 + 1).getPermeability() == this.getModel().getMap().getTerre().getPermeability())
                	{
                		this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,xVehicle4 , yVehicle4 + 1);
                	}
                    this.getModel().getMyHero().moveDown();
                    break;
                    
                case NOP:
                default:
                    this.getModel().getMyHero().doNothing();
                    break;
                 
            }
            this.clearStackOrder();
        }
        this.getView().displayMessage("CRASH !!!!!!!!!.");
    }
    
    public void checkTerre()
    {
    	int xHero = this.getModel().getMyHero().getX();
    	int yHero = this.getModel().getMyHero().getY();
    	
    	switch(this.getStackOrder())
    	{
    	case DOWN :
    		if (this.getModel().getMap().getOnTheMapXY(xHero, yHero + 1).getPermeability() == this.getModel().getMap().getTerre().getPermeability())
        	{
        		this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,xHero , yHero);
        	}
            break;
            
    	case RIGHT:
        	if (this.getModel().getMap().getOnTheMapXY(xHero + 1 , yHero).getPermeability() == this.getModel().getMap().getTerre().getPermeability())
        	{
        		this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,xHero +1 , yHero);
        	}
            break;
            
        case LEFT:
        	if (this.getModel().getMap().getOnTheMapXY(xHero - 1 , yHero).getPermeability() == this.getModel().getMap().getTerre().getPermeability())
        	{
        		this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,xHero -1 , yHero);
        	}
            break;
            
        case UP:
        	if (this.getModel().getMap().getOnTheMapXY(xHero, yHero - 1).getPermeability() == this.getModel().getMap().getTerre().getPermeability())
        	{
        		this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,xHero , yHero - 1);
        	}
            break;
            
        case NOP:
        default:
            this.getModel().getMyHero().doNothing();
            break;
    	}
    }

    @Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

    private IBoulderDashView getView() {
        return this.view;
    }

    private void setView(final IBoulderDashView view) {
        this.view = view;
    }

    private IBoulderDashModel getModel() {
        return this.model;
    }

    private void setModel(final IBoulderDashModel model) {
        this.model = model;
    }

    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

}
