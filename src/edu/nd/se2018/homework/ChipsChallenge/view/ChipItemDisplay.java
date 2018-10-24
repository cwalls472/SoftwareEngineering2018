package edu.nd.se2018.homework.ChipsChallenge.view;

import java.util.ArrayList;

import edu.nd.se2018.homework.ChipsChallenge.ChipItem;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class ChipItemDisplay implements IDisplay {
	ObservableList<Node> root;
	int scalingFactor;
	ArrayList<ChipItem> chipItems;
	
	public ChipItemDisplay(ObservableList<Node> root, int scalingFactor, ArrayList<ChipItem> chipItems) {
		this.root = root;
		this.scalingFactor = scalingFactor;
		this.chipItems = chipItems;
	}
	
	@Override
	public void draw() {
		for (ChipItem chipItem : chipItems) {
			ImageView chipItemImageView = chipItem.getImageView();
			chipItemImageView.setX(chipItem.getX()*scalingFactor);
			chipItemImageView.setY(chipItem.getY()*scalingFactor);
			root.add(chipItemImageView);
		}
	}
	
}
