package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author jane
 *
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	private int direction = 0;
	
	public Train(int x, int y, int dir){
		this.currentX = x;
		this.currentY = y;
		originalX = x;
		direction = dir;
		img = new Image("images\\Train.PNG",120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public int getTrainDir() {
		return direction;
	}
	
	public void move(){
		if (direction == 0)
			currentX-=2;
		else if (direction == 1)
			currentX+=2;
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if (direction==0) {
			if (currentX < -200)
				return true;
			else
				return false;
		}
		else {
			if (currentX > 1400)
				return true;
			else
				return false;
		}
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
}