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

public class Level1 implements Level{
	private ArrayList<Key> keys;
	private ArrayList<KeyWall> keyWalls;
	ArrayList<ChipItem> chipItems;
	Portal portal;
	Chip chip;
	Inventory inventory;
	boolean[][] levelGrid = new boolean[25][25];
	final int dimensions = 25;
	
	public Level1() {
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
		
		chip = new Chip(9,20, levelGrid);
		inventory = new Inventory();
	}
	
	
	
	public void addWalls() {
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				if (x==0 || x==24 || y==0 || y==24) {
					levelGrid[x][y]=true;
				}
				if (y>=14 && y<=15) {
					levelGrid[x][y]=true;
				}
				if (x == 12) {
					levelGrid[x][y]=true;
				}
				if (y==7 && x<12) {
					levelGrid[x][y]=true;
				}
			}
		}
		levelGrid[12][19]=false;
		levelGrid[12][20]=false;
	}
	
	
	public void addKeys() {
		Key key = new GreenKey(15, 23);
		keys.add(key);
		key = new GreenKey(4,18);
		keys.add(key);
		key = new RedKey(15,13);
		keys.add(key);
		key = new BlueKey(20, 3);
		keys.add(key);
		key = new YellowKey(23,17);
		keys.add(key);
	}
	
	public void addKeyWalls() {
		int x, y;
		x=15; y=15;
		KeyWall keyWall = new GreenKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=18; y=15;
		keyWall = new GreenKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=18; y=14;
		keyWall = new YellowKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=12; y=3;
		keyWall = new BlueKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
		x=12; y=11;
		keyWall = new RedKeyWall(x,y);
		keyWalls.add(keyWall);
		levelGrid[x][y]=true;
	}
	
	public void addChipItems() {
		ChipItem chipItem = new ChipItem(9,16);
		chipItems.add(chipItem);
		chipItem = new ChipItem(14,16);
		chipItems.add(chipItem);
		chipItem = new ChipItem(10,6);
		chipItems.add(chipItem);
		chipItem = new ChipItem(9,6);
		chipItems.add(chipItem);
		chipItem = new ChipItem(10,1);
		chipItems.add(chipItem);
		chipItem = new ChipItem(11,1);
		chipItems.add(chipItem);
		chipItem = new ChipItem(1,5);
		chipItems.add(chipItem);
		chipItem = new ChipItem(1,4);
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
