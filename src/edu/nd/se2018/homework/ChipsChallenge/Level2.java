package edu.nd.se2018.homework.ChipsChallenge;

import java.util.ArrayList;

import edu.nd.se2018.homework.ChipsChallenge.keyWalls.BlueKeyWall;
import edu.nd.se2018.homework.ChipsChallenge.keyWalls.GreenKeyWall;
import edu.nd.se2018.homework.ChipsChallenge.keyWalls.KeyWall;
import edu.nd.se2018.homework.ChipsChallenge.keyWalls.RedKeyWall;
import edu.nd.se2018.homework.ChipsChallenge.keyWalls.YellowKeyWall;
import edu.nd.se2018.homework.ChipsChallenge.keys.BlueKey;
import edu.nd.se2018.homework.ChipsChallenge.keys.GreenKey;
import edu.nd.se2018.homework.ChipsChallenge.keys.Key;
import edu.nd.se2018.homework.ChipsChallenge.keys.RedKey;
import edu.nd.se2018.homework.ChipsChallenge.keys.YellowKey;

public class Level2 implements Level {
	private ArrayList<Key> keys;
	private ArrayList<KeyWall> keyWalls;
	ArrayList<ChipItem> chipItems;
	Portal portal;
	Chip chip;
	Inventory inventory;
	boolean[][] levelGrid = new boolean[25][25];
	final int dimensions = 25;
	
	public Level2() {
		keys = new ArrayList<Key>();
		keyWalls = new ArrayList<KeyWall>();
		chipItems = new ArrayList<ChipItem>();
		
		//initialize boolean array to false values
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				levelGrid[x][y]=false;
			}
		}
		
		addWalls();
		addKeys();
		addKeyWalls();
		addChipItems();
		addPortal();
		
		chip = new Chip(12,12, levelGrid);
		inventory = new Inventory();
	}
	
	
	
	public void addWalls() {
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				if (x==0 || x==24 || y==0 || y==24) {
					levelGrid[x][y]=true;
				}
				if (x==8 || x==16 || y==8 || y==16) {
					levelGrid[x][y]=true;
				}
			}
		}
	}
	
	
	public void addKeys() {
		Key key = new GreenKey(14, 14);
		keys.add(key);
		key = new GreenKey(10, 14);
		keys.add(key);
		key = new RedKey(15,20);
		keys.add(key);
		key = new RedKey(23,20);
		keys.add(key);
		key = new BlueKey(12, 2);
		keys.add(key);
		key = new BlueKey(9, 20);
		keys.add(key);
		key = new YellowKey(6,4);
		keys.add(key);
		key = new YellowKey(17,20);
		keys.add(key);
	}
	
	public void addKeyWalls() {
		int x, y;
		x=12; y=8;
		KeyWall keyWall = new GreenKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=16; y=4;
		keyWall = new GreenKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=10; y=16;
		keyWall = new GreenKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=20; y=8;
		keyWall = new RedKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=8; y=20;
		keyWall = new RedKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=8; y=4;
		keyWall = new BlueKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=14; y=16;
		keyWall = new BlueKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=20; y=16;
		keyWall = new YellowKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=8; y=12;
		keyWall = new YellowKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
	}
	
	public void addChipItems() {
		ChipItem chipItem = new ChipItem(4,20);
		chipItems.add(chipItem);
		chipItem = new ChipItem(12,20);
		chipItems.add(chipItem);
		chipItem = new ChipItem(20,20);
		chipItems.add(chipItem);
		chipItem = new ChipItem(4,12);
		chipItems.add(chipItem);
		chipItem = new ChipItem(20,12);
		chipItems.add(chipItem);
		chipItem = new ChipItem(4,4);
		chipItems.add(chipItem);
		chipItem = new ChipItem(12,4);
		chipItems.add(chipItem);
		chipItem = new ChipItem(20,4);
		chipItems.add(chipItem);
	}
	
	public void addPortal() {
		int x,y;
		x=7; y=14;
		portal = new Portal(x,y);
		levelGrid[x][y]=true;
	}
	
	public ArrayList<Key> getKeys() {
		return keys;
	}
	
	public ArrayList<KeyWall> getKeyWalls() {
		return keyWalls;
	}
	
	public ArrayList<ChipItem> getChipItems() {
		return chipItems;
	}
	
	@Override
	public Portal getPortal() {
		return portal;
	}
	
	public Chip getChip() {
		return chip;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public boolean[][] getLevelGrid() {
		return levelGrid;
	}
	
	public int getDimensions() {
		return dimensions;
	}
}
