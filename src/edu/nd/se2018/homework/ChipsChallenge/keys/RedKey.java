package edu.nd.se2018.homework.ChipsChallenge.keys;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RedKey implements Key{
	int x;
	int y;
	int type = 1;
	Image keyImage = new Image("images\\redKey.png",30,30,true,true);
	ImageView keyImageView = new ImageView(keyImage);
	
	public RedKey(int x, int y) {
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
