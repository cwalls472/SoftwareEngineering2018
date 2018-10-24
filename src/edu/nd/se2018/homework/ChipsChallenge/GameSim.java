package edu.nd.se2018.homework.ChipsChallenge;

import java.util.ArrayList;

import edu.nd.se2018.homework.ChipsChallenge.keyWalls.KeyWall;
import edu.nd.se2018.homework.ChipsChallenge.keys.Key;
import edu.nd.se2018.homework.ChipsChallenge.view.LevelDisplay;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.canvas.*;

public class GameSim extends Application {
	AnchorPane root;
	int scalingFactor = 30;
	Level currentLevel;
	boolean[][] levelGrid;
	LevelDisplay levelDisplay;
	Scene scene;
	Chip chip;
	Canvas canvas;
	GraphicsContext gc;
	Inventory inventory;
	private ArrayList<Key> keys;
	private ArrayList<KeyWall> keyWalls;
	private ArrayList<ChipItem> chipItems;
	private Portal portal;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage chipsStage) throws Exception{
		root = new AnchorPane();
		
		currentLevel = new Level1();
		levelGrid = currentLevel.getLevelGrid();
		chip = currentLevel.getChip();
		inventory = currentLevel.getInventory();
		keys = currentLevel.getKeys();
		keyWalls = currentLevel.getKeyWalls();
		chipItems = currentLevel.getChipItems();
		portal = currentLevel.getPortal();
		
		canvas = new Canvas(750,200);
		gc = canvas.getGraphicsContext2D();
		
		levelDisplay = new LevelDisplay(root, scalingFactor, currentLevel.getKeys(), currentLevel.getKeyWalls(), currentLevel.getChipItems(), currentLevel.getPortal(), currentLevel.getChip(), currentLevel.getInventory(), currentLevel.getLevelGrid(), currentLevel.getDimensions(), canvas, gc);
		levelDisplay.drawLevel();
		
		
		
		scene = new Scene(root,750,750);
		
		
		
		chipsStage.setScene(scene);
		chipsStage.setTitle("Chips Challenge");
		chipsStage.show();
		
		
		startGame(chipsStage);
	}
	
	private void startGame(Stage chipsStage) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				
				allowKeyWallPassage();
				allowPortalPassage();
				
				switch(ke.getCode()) {
				case RIGHT:
					chip.goRight();
					break;
				case LEFT:
					chip.goLeft();
					break;
				case UP:
					chip.goUp();
					break;
				case DOWN:
					chip.goDown();
					break;
				case ESCAPE:
					chipsStage.close();
				default:
					break;
				}
				
				pickupChipItems();
				pickupKeys();
				passKeyWalls();
				levelDisplay.drawChip();
				passPortal(chipsStage);
				
			}
		});
	}
	
	public void pickupKeys() {
		for (Key key : keys) {
			if ( key.getX() == chip.getX() && key.getY() == chip.getY() ) {
				inventory.addKey(key);
				root.getChildren().remove(key.getImageView());
			}
		}
		for (Key key : inventory.getKeys()) {
			keys.remove(key);
		}
		root.getChildren().remove(canvas);
		levelDisplay.drawInventory();
	}
	
	public void pickupChipItems() {
		ArrayList<ChipItem> toDelete = new ArrayList<ChipItem>();
		for (ChipItem chipItem : chipItems) {
			if ( chipItem.getX() == chip.getX() && chipItem.getY() == chip.getY() ) {
				toDelete.add(chipItem);
				root.getChildren().remove(chipItem.getImageView());
			}
		}
		for (ChipItem chipItem : toDelete) {
			chipItems.remove(chipItem);
		}
		root.getChildren().remove(canvas);
		levelDisplay.drawInventory();
	}
	
	public void allowPortalPassage() {
		if (chipItems.size()==0) {
			levelGrid[portal.getX()][portal.getY()]=false;
		}
	}
	
	public void allowKeyWallPassage() {
		int gKeyCount = inventory.getGreenKeys().size();
		int rKeyCount = inventory.getRedKeys().size();
		int bKeyCount = inventory.getBlueKeys().size();
		int yKeyCount = inventory.getYellowKeys().size();
		for (KeyWall keyWall : keyWalls) {
			if (keyWall.getType() == 0) {
				if( gKeyCount > 0) {
					levelGrid[keyWall.getX()][keyWall.getY()]=false;
				}
				else levelGrid[keyWall.getX()][keyWall.getY()]=true;
			}
			else if (keyWall.getType() == 1) {
				if( rKeyCount > 0) {
					levelGrid[keyWall.getX()][keyWall.getY()]=false;
				}
				else levelGrid[keyWall.getX()][keyWall.getY()]=true;
			}
			else if (keyWall.getType() == 2) {
				if( bKeyCount > 0) {
					levelGrid[keyWall.getX()][keyWall.getY()]=false;
				}
				else levelGrid[keyWall.getX()][keyWall.getY()]=true;
			}
			else if (keyWall.getType() == 3) {
				if( yKeyCount > 0) {
					levelGrid[keyWall.getX()][keyWall.getY()]=false;
				}
				else levelGrid[keyWall.getX()][keyWall.getY()]=true;
			}
		}
	}
	
	public void passKeyWalls() {
		ArrayList<KeyWall> toDelete = new ArrayList<KeyWall>();
		for (KeyWall keyWall : keyWalls) {
			if ( keyWall.getX() == chip.getX() && keyWall.getY() == chip.getY() ) {
				toDelete.add(keyWall);
				root.getChildren().remove(keyWall.getImageView());
				levelDisplay.drawFloorTile(keyWall.getX(), keyWall.getY());
			}
		}
		for (KeyWall keyWall : toDelete) {
			for (Key key: inventory.getKeys()) {
				if (keyWall.getType()== key.getType()) {
					inventory.removeKey(key);
					break;
				}
			}
			keyWalls.remove(keyWall);
		}
		root.getChildren().remove(canvas);
		levelDisplay.drawInventory();
	}
	
	public void passPortal(Stage chipsStage) {
		if (chip.getX() == portal.getX() && chip.getY() == portal.getY()) {
			
			currentLevel = new Level2();
			levelGrid = currentLevel.getLevelGrid();
			chip = currentLevel.getChip();
			inventory = currentLevel.getInventory();
			keys = currentLevel.getKeys();
			keyWalls = currentLevel.getKeyWalls();
			chipItems = currentLevel.getChipItems();
			portal = currentLevel.getPortal();
			
			
			root.getChildren().remove(canvas);
			
			levelDisplay = new LevelDisplay(root, scalingFactor, currentLevel.getKeys(), currentLevel.getKeyWalls(), currentLevel.getChipItems(), currentLevel.getPortal(), currentLevel.getChip(), currentLevel.getInventory(), currentLevel.getLevelGrid(), currentLevel.getDimensions(), canvas, gc);
			levelDisplay.drawLevel();
			
			
			
			System.out.print("Congrats, you beat the level");
		}
	}

}