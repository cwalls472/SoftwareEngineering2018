package edu.nd.se2018.homework.ChipsChallenge;

import java.util.ArrayList;

import edu.nd.se2018.homework.ChipsChallenge.keys.Key;

public class Inventory {
	ArrayList<Key> keys;
	ArrayList<Key> greenKeys;
	ArrayList<Key> redKeys;
	ArrayList<Key> blueKeys;
	ArrayList<Key> yellowKeys;
	
	public Inventory(){
		keys = new ArrayList<Key>();
		greenKeys = new ArrayList<Key>();
		redKeys = new ArrayList<Key>();
		blueKeys = new ArrayList<Key>();
		yellowKeys = new ArrayList<Key>();
	}
	
	public void addKey(Key key){
		keys.add(key);
		if (key.getType() ==0) {
			greenKeys.add(key);
		}
		else if (key.getType()==1) {
			redKeys.add(key);
		}
		else if (key.getType()==2) {
			blueKeys.add(key);
		}
		else if (key.getType()==3) {
			yellowKeys.add(key);
		}
		
	}
	
	public void removeKey(Key key) {
		keys.remove(key);
		if (key.getType() ==0) {
			greenKeys.remove(key);
		}
		else if (key.getType()==1) {
			redKeys.remove(key);
		}
		else if (key.getType()==2) {
			blueKeys.remove(key);
		}
		else if (key.getType()==3) {
			yellowKeys.remove(key);
		}
	}
	
	public ArrayList<Key> getKeys(){
		return keys;
	}
	
	public ArrayList<Key> getGreenKeys(){
		return greenKeys;
	}
	public ArrayList<Key> getRedKeys(){
		return redKeys;
	}
	public ArrayList<Key> getBlueKeys(){
		return blueKeys;
	}
	public ArrayList<Key> getYellowKeys(){
		return yellowKeys;
	}
}
