package edu.nd.se2018.homework.ChipsChallenge;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChipItem {
	int x;
	int y;
	Image chipItemImage = new Image("images\\chipItem.png",30,30,true,true);
	ImageView chipItemImageView = new ImageView(chipItemImage);
	public ChipItem(int x, int y) {
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
		return chipItemImageView;
	}
}
