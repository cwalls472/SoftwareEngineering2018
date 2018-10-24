package edu.nd.se2018.homework.ChipsChallenge.view;


import edu.nd.se2018.homework.ChipsChallenge.Chip;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChipDisplay implements IDisplay{
	
	ObservableList<Node> root;
	int scalingFactor;
	Chip chip;
	Image chipImage;
	ImageView chipImageView;
	
	public ChipDisplay(ObservableList<Node> root, int scalingFactor, Chip chip) {
		this.root = root;
		this.scalingFactor = scalingFactor;
		this.chip = chip;
		chipImage = new Image(chip.getImagePath(),30,30,true,true);
		chipImageView = new ImageView(chipImage);
	}
	
	@Override
	public void draw() {
		root.remove(chipImageView);
		chipImage = new Image(chip.getImagePath(),30,30,true,true);
		chipImageView = new ImageView(chipImage);
		chipImageView.setX(chip.getX()*scalingFactor);
		chipImageView.setY(chip.getY()*scalingFactor);
		root.add(chipImageView);
	}

}
