package edu.nd.se2018.homework.ChipsChallenge;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Portal {
	int x;
	int y;
	Image portalImage = new Image("images\\portal.png",30,30,true,true);
	ImageView portalImageView = new ImageView(portalImage);
	public Portal(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return x;
	}
	public int getY() {
		return y;
	}
	public ImageView getImageView() {
		return portalImageView;
	}
}
