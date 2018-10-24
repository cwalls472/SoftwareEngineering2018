package edu.nd.se2018.homework.ChipsChallenge.view;

import java.util.ArrayList;

import edu.nd.se2018.homework.ChipsChallenge.keyWalls.KeyWall;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class KeyWallDisplay implements IDisplay {
	ObservableList<Node> root;
	int scalingFactor;
	ArrayList<KeyWall> keyWalls;
	
	public KeyWallDisplay(ObservableList<Node> root, int scalingFactor, ArrayList<KeyWall> keyWalls) {
		this.root = root;
		this.scalingFactor = scalingFactor;
		this.keyWalls = keyWalls;
	}
	
	@Override
	public void draw() {
		for (KeyWall keyWall : keyWalls) {
			ImageView keyImageView = keyWall.getImageView();
			keyImageView.setX(keyWall.getX()*scalingFactor);
			keyImageView.setY(keyWall.getY()*scalingFactor);
			root.add(keyImageView);
		}
	}
}
