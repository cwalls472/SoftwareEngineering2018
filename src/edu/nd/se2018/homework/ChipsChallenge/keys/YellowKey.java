package edu.nd.se2018.homework.ChipsChallenge.keys;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class YellowKey implements Key {
	int x;
	int y;
	int type = 3;
	String imagePath;
	Image keyImage = new Image("images\\yellowKey.png",30,30,true,true);
	ImageView keyImageView = new ImageView(keyImage);
	
	public YellowKey(int x, int y) {
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
