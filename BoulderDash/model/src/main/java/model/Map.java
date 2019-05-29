package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

import contract.IElement;
import contract.IMap;
import model.element.motionless.MotionlessElementsFactory;



class Map extends Observable implements IMap {

    private int          width;
    private int          height;
    private IElement[][] onTheMap;
    public static String Map = "";
	public static int i = 0;
	
    Map(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
    }

    private void loadFile(final String fileName) throws IOException {
    	

    	final String sql = "{call SelectionMap(?)}";
    		CallableStatement call;
    		try {
    			call = DBConnection.getInstance().getConnection().prepareCall(sql);
    			call.setInt(1, 1);
    			call.execute();
    			ResultSet resultSet = call.getResultSet();
    	
    			while (resultSet.next()) {
    				Map = Map + resultSet.getString("Objet");
    				i = i + 1;
    				if(i==20) {
    					i = 0;
    					Map = Map +"\r\n";
    				}
    				PrintWriter writer = new PrintWriter("C:\\Users\\vince\\Desktop\\Projet-Java-6b643cfee387314fc553cb87801d3b2d6a0a8ea4\\JPU-BlankProject\\JPU-BlankProject\\Map.txt", "UTF-8");
    				writer.println("20\r\n20");
    				writer.println(Map);
    				writer.close();
    				
    		}
    			}
    		
    		catch (SQLException e) {
    			e.printStackTrace();
    		}
    	
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }

    @Override
    public final int getWidth() {
        return this.width;
    }

    private void setWidth(final int width) {
        this.width = width;
    }

    @Override
    public final int getHeight() {
        return this.height;
    }

    private void setHeight(final int height) {
        this.height = height;
    }

    @Override
    public final IElement getOnTheMapXY(final int x, final int y) {
        return this.onTheMap[x][y];
    }

    public void setOnTheMapXY(final IElement element, final int x, final int y) {
        this.onTheMap[x][y] = element;
    }

    @Override
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public Observable getObservable() {
        return this;
    }
    
    public IElement getTerre() {
    	return MotionlessElementsFactory.createTerre();
    }
    
    public IElement getVide() {
    	return MotionlessElementsFactory.createVide();
    }
    
    public IElement getDiamant() {
    	return MotionlessElementsFactory.createDiamant();
    }
    
    public IElement getRocher() {
    	return MotionlessElementsFactory.createRocher();
    }
    
    public IElement getBordure() {
    	return MotionlessElementsFactory.createBordure();
    }

	@Override
	public IElement getEnnemi() {
		return MotionlessElementsFactory.createEnnemi();
	}
	
	public IElement getSortie() {
		return MotionlessElementsFactory.sortie();
	}
}
