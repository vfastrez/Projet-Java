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

    @Override
    public final void play() throws InterruptedException {
        while (this.getModel().getMyHero().isAlive()) {
            Thread.sleep(speed);
            this.getView().parcourirTableau();
            int xHero = getModel().getMyHero().getX();
            int yHero = getModel().getMyHero().getY();
            switch (this.getStackOrder()) {
                case RIGHT:
                	this.checkDeplacement(xHero + 1, yHero, "Right");
                    break;
                    
                case LEFT:
                	this.checkDeplacement(xHero - 1, yHero, "Left");
                    break;
                    
                case UP:
                	this.checkDeplacement(xHero, yHero - 1, "Up");
                    break;
                    
                case DOWN:
                	this.checkDeplacement(xHero, yHero + 1, "Down");
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
    
    public void checkDeplacement(int xHero, int yHero, String Direction)
    {
    	if (this.getModel().getMap().getOnTheMapXY(xHero, yHero).getPermeability() == this.getModel().getMap().getTerre().getPermeability())
    	{
    		
    		
    		this.moveTerre(xHero, yHero, Direction);
    	}
    	
    	else if (this.getModel().getMap().getOnTheMapXY(xHero, yHero).getPermeability() == this.getModel().getMap().getDiamant().getPermeability())
    	{
    		
    		this.moveDiamant(xHero, yHero, Direction);
    	}
    }
    
    public void moveTerre(int xHero, int yHero, String Direction)
    {
        this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,xHero , yHero);
       
		
		if(Direction == "Right") {
			this.getModel().getMyHero().moveRight();
		}
			
		else if(Direction == "Left") {
			this.getModel().getMyHero().moveLeft();
		}
			
		else if(Direction == "Up") {
			this.getModel().getMyHero().moveUp();
		}
			
		else if(Direction == "Down") {
			this.getModel().getMyHero().moveDown();
		}
			
		
		
    }
    
    public void moveDiamant(int xHero, int yHero, String Direction)
    {
    	this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,xHero , yHero);
    	
    	if(Direction == "Right") {
			this.getModel().getMyHero().moveRight();
		}
			
		else if(Direction == "Left") {
			this.getModel().getMyHero().moveLeft();
		}
			
		else if(Direction == "Up") {
			this.getModel().getMyHero().moveUp();
		}
			
		else if(Direction == "Down") {
			this.getModel().getMyHero().moveDown();
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
