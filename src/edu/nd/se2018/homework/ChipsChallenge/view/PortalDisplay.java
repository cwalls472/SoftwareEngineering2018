package edu.nd.se2018.homework.ChipsChallenge.view;

import edu.nd.se2018.homework.ChipsChallenge.Portal;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class PortalDisplay implements IDisplay {
	ObservableList<Node> root;
	int scalingFactor;
	Portal portal;
	
	public PortalDisplay(ObservableList<Node> root, int scalingFactor, Portal portal) {
		this.root = root;
		this.scalingFactor = scalingFactor;
		this.portal = portal;
	}
	
	@Override
	public void draw() {
		ImageView portalImageView = portal.getImageView();
		portalImageView.setX(portal.getX()*scalingFactor);
		portalImageView.setY(portal.getY()*scalingFactor);
		root.add(portalImageView);
	}
}
