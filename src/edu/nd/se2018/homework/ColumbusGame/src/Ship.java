import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Ship extends Observable {
	List<Observer> observers = new LinkedList<Observer>();
	Point shipLocation;
	OceanMap oceanMap;
	
	public Ship(OceanMap oceanMap) {
		shipLocation = new Point(2,2);
		this.oceanMap = oceanMap;
	}
	
	public Point getShipLocation() {
		return shipLocation;
	}
	
	public void goEast() {
		if (shipLocation.x <24 && oceanMap.oceanGrid[shipLocation.x+1][shipLocation.y]==false) {
			shipLocation.x+=1;
			setChanged();
			notifyObservers();
		}
	}
	public void goWest() {
		if (shipLocation.x >0 && oceanMap.oceanGrid[shipLocation.x-1][shipLocation.y]==false) {
			shipLocation.x-=1;
			setChanged();
			notifyObservers();
		}
	}
	public void goNorth() {
		if (shipLocation.y >0 && oceanMap.oceanGrid[shipLocation.x][shipLocation.y-1]==false) {
			shipLocation.y-=1;
			setChanged();
			notifyObservers();
		}
	}
	public void goSouth() {
		if (shipLocation.y <24 && oceanMap.oceanGrid[shipLocation.x][shipLocation.y+1]==false) {
			shipLocation.y+=1;
			setChanged();
			notifyObservers();
		}
	}
	
}
