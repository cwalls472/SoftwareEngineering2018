package edu.nd.se2018.homework.ChipsChallenge.view;

import java.util.ArrayList;

import edu.nd.se2018.homework.ChipsChallenge.keys.Key;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class KeyDisplay implements IDisplay{
	ObservableList<Node> root;
	int scalingFactor;
	ArrayList<Key> keys;
	
	public KeyDisplay(ObservableList<Node> root, int scalingFactor, ArrayList<Key> keys) {
		this.root = root;
		this.scalingFactor = scalingFactor;
		this.keys = keys;
	}
	
	@Override
	public void draw() {
		for (Key key : keys) {
			ImageView keyImageView = key.getImageView();
			keyImageView.setX(key.getX()*scalingFactor);
			keyImageView.setY(key.getY()*scalingFactor);
			root.add(keyImageView);
		}
	}
	
}
