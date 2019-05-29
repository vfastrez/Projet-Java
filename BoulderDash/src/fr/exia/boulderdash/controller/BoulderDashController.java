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
				checkPoussableDroite();
                this.checkDeplacement(xHero + 1, yHero, "Right");
                checkTombable();
                break;

            case LEFT:
            	checkPoussableGauche();
                this.checkDeplacement(xHero - 1, yHero, "Left");
                checkTombable();
                break;
                    
                case UP:
                	this.checkDeplacement(xHero, yHero - 1, "Up");
                	checkTombable();
                	MoveEnnemi();
                    break;
                    
                case DOWN:
                	this.checkDeplacement(xHero, yHero + 1, "Down");
                	checkTombable();
                	MoveEnnemi();
                    break;
                    
                case NOP:
                default:
                    this.getModel().getMyHero().doNothing();
                    checkTombable();
                    MoveEnnemi();
                    break;
                 
            }
            this.clearStackOrder();
        }
        this.getView().displayMessage("MORT !");
    }
    
    
    public void checkDeplacement(int xHero, int yHero, String Direction)
    {
    	if (this.getModel().getMap().getOnTheMapXY(xHero, yHero).getPermeability() == this.getModel().getMap().getTerre().getPermeability()||this.getModel().getMap().getOnTheMapXY(xHero, yHero).getPermeability() == this.getModel().getMap().getVide().getPermeability())
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
    	this.getModel().getMap().setOnTheMapXY(this.getModel().getMap().getVide() ,xHero , yHero);
    	
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

    public void checkTombable()
    {
    	for (int x = this.getModel().getMap().getWidth()-1; x > 0 ; x--) {
            for (int y = this.getModel().getMap().getHeight() -1; y > 0 ; y--) {
                getView().getBoardFrame().addSquare(this.getModel().getMap().getOnTheMapXY(x, y), x, y);
                if(this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == this.getModel().getMap().getDiamant().getPermeability() || this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == this.getModel().getMap().getRocher().getPermeability())
                {
                	if(this.getModel().getMyHero().getY() != y + 1 || this.getModel().getMyHero().getX() != x) 
                	{
                		if(this.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == this.getModel().getMap().getVide().getPermeability())
                    	{
                    		if(this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == this.getModel().getMap().getRocher().getPermeability())
                    		{
                    			this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,x , y);
                    			this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getRocher() ,x , y+1);
                    			this.getModel().getMap().getOnTheMapXY(x, y+1).setTombe(true);
                    		}
                    		else if(this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == this.getModel().getMap().getDiamant().getPermeability())
                    		{
                    			this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,x , y);
                    			this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getDiamant() ,x , y+1);
                    			this.getModel().getMap().getOnTheMapXY(x, y+1).setTombe(true);
                    		}
                		}	
                	
                		else 
                		{
                			this.getModel().getMap().getOnTheMapXY(x, y).setTombe(false);
                		}
                		
                }
                	if ((this.getModel().getMyHero().getY() == y + 1) && (this.getModel().getMyHero().getX() == x) && (this.getModel().getMap().getOnTheMapXY(x, y).getTombe() == true))
                	{
                		this.getModel().getMyHero().die();
                	}	
                }
                	
              }
            }
    }
    
    public void MoveEnnemi() {
    
    for (int x = this.getModel().getMap().getWidth()-1; x > 0 ; x--) 
    {
        for (int y = this.getModel().getMap().getHeight() -1; y > 0 ; y--) 
        {
            getView().getBoardFrame().addSquare(this.getModel().getMap().getOnTheMapXY(x, y), x, y);
            if(this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == this.getModel().getMap().getEnnemi().getPermeability())
            {
                if(this.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == this.getModel().getMap().getVide().getPermeability())
                {
                    this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,x , y);
                    this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getEnnemi() ,x + 1, y);
                    
                    if(this.getModel().getMap().getOnTheMapXY(x , y - 1).getPermeability() == this.getModel().getMap().getVide().getPermeability())
                    {
                        this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,x , y);
                        this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getEnnemi() ,x , y - 1);
                    
                        if(this.getModel().getMap().getOnTheMapXY(x - 1 , y).getPermeability() == this.getModel().getMap().getVide().getPermeability())
                        {
                        	this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,x , y);
                        	this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getEnnemi() ,x - 1 , y);
                        
                        	if(this.getModel().getMap().getOnTheMapXY(x , y + 1).getPermeability() == this.getModel().getMap().getVide().getPermeability())
                        	{
                        		this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,x , y);
                        		this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getEnnemi() ,x , y + 1);
                        	}
                        }
                    }
                }
             }
         }
    }
}
    
    public void checkPoussableDroite()
    {
        for (int x = this.getModel().getMap().getWidth()-1; x > 0 ; x--) {
            for (int y = this.getModel().getMap().getHeight() -1; y > 0 ; y--) {
                getView().getBoardFrame().addSquare(this.getModel().getMap().getOnTheMapXY(x, y), x, y);
                if( this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == this.getModel().getMap().getRocher().getPermeability())
                {
                    if(this.getModel().getMyHero().getX() == x - 1 && this.getModel().getMyHero().getY() == y)
                    {
                        if(this.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == this.getModel().getMap().getVide().getPermeability())
                        {
                            this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,x , y);
                            this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getRocher() ,x + 1, y);
                        }
                    }

                }

              }
            }
    }

    public void checkPoussableGauche()
    {
        for (int x = 0; x < this.getModel().getMap().getWidth()-1 ; x++) {
            for (int y = this.getModel().getMap().getHeight() -1; y > 0 ; y--) {
                getView().getBoardFrame().addSquare(this.getModel().getMap().getOnTheMapXY(x, y), x, y);
                if( this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == this.getModel().getMap().getRocher().getPermeability())
                {
                    if(this.getModel().getMyHero().getX() == x + 1 && this.getModel().getMyHero().getY() == y)
                    {
                        if(this.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == this.getModel().getMap().getVide().getPermeability())
                        {
                            this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getVide() ,x , y);
                            this.getModel().getMap().setOnTheMapXY( this.getModel().getMap().getRocher() ,x - 1, y);
                        }
                    }

                }

              }
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

