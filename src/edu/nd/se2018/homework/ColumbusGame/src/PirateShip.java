import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;


public class PirateShip implements Observer{
	
	Point shipLocation; //location of CC's ship
	Point pShipLocation; // location of the pirate ship
	OceanMap oceanMap;
	Boolean moved;
	
	public PirateShip(OceanMap oceanMap) {
		Random rand = new Random();
		int x=rand.nextInt(25);
		int y=rand.nextInt(25);
		while(oceanMap.oceanGrid[x][y]!=false) {
			if (x>13) {
				x++;
			}else {
				x--;
			}
		}
		pShipLocation = new Point(x,y);
		this.oceanMap = oceanMap;
	}
	
	public Point getpShipLocation() {
		return pShipLocation;
	}
	
	public void moveShip() {
		moved=false;
		if (shipLocation.x - pShipLocation.x >0) {
			goEast();
		}
		if (shipLocation.x - pShipLocation.x <0 && moved == false) {
			goWest();
		}		
		if (shipLocation.y - pShipLocation.y <0 && moved == false) {
			goNorth();
		}
		if (shipLocation.y - pShipLocation.y >0 && moved == false) {
			goSouth();
		}
		
	}
	
	@Override
	public void update(Observable s, Object arg1) {
		if (s instanceof Ship){
			shipLocation = ((Ship)s).getShipLocation();
			moveShip();			
		}		
		
	}
	
	public void goEast() {
		if (pShipLocation.x <24 && oceanMap.oceanGrid[pShipLocation.x+1][pShipLocation.y]==false) {
			pShipLocation.x+=1;
			moved=true;
		}
	}
	public void goWest() {
		if (pShipLocation.x >0 && oceanMap.oceanGrid[pShipLocation.x-1][pShipLocation.y]==false) {
			pShipLocation.x-=1;
			moved=true;
		}
	}
	public void goNorth() {
		if (pShipLocation.y >0 && oceanMap.oceanGrid[pShipLocation.x][pShipLocation.y-1]==false) {
			pShipLocation.y-=1;
			moved=true;
		}
	}
	public void goSouth() {
		if (pShipLocation.y <24 && oceanMap.oceanGrid[pShipLocation.x][pShipLocation.y+1]==false) {
			pShipLocation.y+=1;
			moved = true;
		}
	}
}
