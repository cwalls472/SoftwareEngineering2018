package edu.nd.se2018.homework.ChipsChallenge.view;

import java.util.ArrayList;

import edu.nd.se2018.homework.ChipsChallenge.Chip;
import edu.nd.se2018.homework.ChipsChallenge.ChipItem;
import edu.nd.se2018.homework.ChipsChallenge.Inventory;
import edu.nd.se2018.homework.ChipsChallenge.Portal;
import edu.nd.se2018.homework.ChipsChallenge.keyWalls.KeyWall;
import edu.nd.se2018.homework.ChipsChallenge.keys.Key;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class LevelDisplay{
	AnchorPane root;
	int scalingFactor;
	boolean[][] levelGrid;
	final int dimensions;
	ArrayList<Key> keys;
	KeyDisplay keyDisplay;
	ArrayList<KeyWall> keyWalls;
	KeyWallDisplay keyWallDisplay;
	ArrayList<ChipItem> chipItems;
	ChipItemDisplay chipItemDisplay;
	Portal portal;
	PortalDisplay portalDisplay;
	Chip chip;
	ChipDisplay chipDisplay;
	final Canvas canvas;
	GraphicsContext gc;
	Inventory inventory;
	InventoryDisplay inventoryDisplay;
	
	
	public LevelDisplay(AnchorPane root, int scalingFactor, ArrayList<Key> keys, ArrayList<KeyWall> keyWalls, ArrayList<ChipItem> chipItems, Portal portal, Chip chip, Inventory inventory, boolean[][] levelGrid, int dimensions, Canvas canvas, GraphicsContext gc) { //Collection<Road> roads, Collection<RailwayTracks> tracks, Collection<CrossingGate> gates){
		this.root = root;
		this.scalingFactor = scalingFactor;
		this.keys = keys;
		this.keyWalls = keyWalls;
		this.chip = chip;
		this.inventory = inventory;
		this.levelGrid = levelGrid;
		this.dimensions = dimensions;
		this.canvas = canvas;
		this.gc = gc;
		this.chipItems = chipItems;
		this.portal = portal;
		
		keyDisplay = new KeyDisplay(root.getChildren(), scalingFactor, keys);
		keyWallDisplay = new KeyWallDisplay(root.getChildren(), scalingFactor, keyWalls);
		chipItemDisplay =  new ChipItemDisplay(root.getChildren(), scalingFactor, chipItems);
		chipDisplay = new ChipDisplay(root.getChildren(),scalingFactor, chip);
		inventoryDisplay = new InventoryDisplay(root.getChildren(), canvas, gc, inventory.getGreenKeys(), inventory.getRedKeys(), inventory.getBlueKeys(), inventory.getYellowKeys(), chipItems);
		portalDisplay = new PortalDisplay(root.getChildren(), scalingFactor, portal);
	}
	
	
	
	public void drawLevel() {
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				if (levelGrid[x][y]==false) {
					Image tileImage = new Image("images\\BlankTile.png",30,30,true,true);
					ImageView tileImageView = new ImageView(tileImage);
					tileImageView.setX(x*scalingFactor);
					tileImageView.setY(y*scalingFactor);
					root.getChildren().add(tileImageView);
				}
				else {
					Image wallImage = new Image("images\\wallTile.png",30,30,true,true);
					ImageView wallImageView = new ImageView(wallImage);
					wallImageView.setX(x*scalingFactor);
					wallImageView.setY(y*scalingFactor);
					root.getChildren().add(wallImageView);
				}
			}
		}
		drawKeys();
		drawKeyWalls();
		drawChipItems();
		drawPortal();
		drawChip();
		drawInventory();
	}
	
	public void drawFloorTile(int x, int y) {
		Image tileImage = new Image("images\\BlankTile.png",30,30,true,true);
		ImageView tileImageView = new ImageView(tileImage);
		tileImageView.setX(x*scalingFactor);
		tileImageView.setY(y*scalingFactor);
		root.getChildren().add(tileImageView);
	}
	
	public void drawKeys() {
		keyDisplay.draw();
	}
	
	public void drawKeyWalls() {
		keyWallDisplay.draw();
	}
	
	public void drawChipItems() {
		chipItemDisplay.draw();
	}
	
	public void drawPortal() {
		portalDisplay.draw();
	}
	
	public void drawChip() {
		chipDisplay.draw();
	}
	
	public void drawInventory() {
		inventoryDisplay.draw();
	}

}
