package edu.nd.se2018.homework.ChipsChallenge;

import java.util.ArrayList;

import edu.nd.se2018.homework.ChipsChallenge.keyWalls.KeyWall;
import edu.nd.se2018.homework.ChipsChallenge.keys.Key;

public interface Level {
	public void addKeys();
	public ArrayList<Key> getKeys();
	public ArrayList<KeyWall> getKeyWalls();
	public ArrayList<ChipItem> getChipItems();
	public Portal getPortal();
	public Chip getChip();
	public boolean[][] getLevelGrid();
	public int getDimensions();
	public Inventory getInventory();
}
