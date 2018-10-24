package edu.nd.se2018.homework.ChipsChallenge.keyWalls;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BlueKeyWall implements KeyWall {
	int x;
	int y;
	int type = 2;
	Image keyImage = new Image("images\\blueKeyWall.png",30,30,true,true);
	ImageView keyImageView = new ImageView(keyImage);
	
	public BlueKeyWall(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int getX(){
		return x;
	}
	@Override
	public int getY() {
		return y;
	}
	@Override
	public int getType() {
		return type;
	}
	@Override
	public ImageView getImageView() {
		return keyImageView;
	}
}
