package edu.nd.se2018.homework.ChipsChallenge.view;

import java.util.ArrayList;

import edu.nd.se2018.homework.ChipsChallenge.ChipItem;
import edu.nd.se2018.homework.ChipsChallenge.keys.Key;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class InventoryDisplay implements IDisplay{
	final Canvas canvas;
	GraphicsContext gc;
	boolean bold = true;
	int fontSize = 16;
	ObservableList<Node> root;
	ArrayList<Key> greenKeys;
	ArrayList<Key> redKeys;
	ArrayList<Key> blueKeys;
	ArrayList<Key> yellowKeys;
	ArrayList<ChipItem> chipItems;
	
	public InventoryDisplay(ObservableList<Node> root, Canvas canvas, GraphicsContext gc, ArrayList<Key> greenKeys, ArrayList<Key> redKeys, ArrayList<Key> blueKeys, ArrayList<Key> yellowKeys, ArrayList<ChipItem> chipItems) {
		this.root = root;
		this.canvas = canvas;
		this.gc = gc;
		this.greenKeys = greenKeys;
		this.redKeys = redKeys;
		this.blueKeys = blueKeys;
		this.yellowKeys = yellowKeys;
		this.chipItems = chipItems;
	}
	
	@Override
	public void draw() {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.setStroke(Color.DARKGRAY);
		if (bold)
			gc.setFont(Font.font("Arial", FontWeight.BOLD, fontSize));
		else
			gc.setFont(Font.font("Arial", FontWeight.NORMAL, fontSize));
		gc.fillText("Green Keys: " + greenKeys.size() , 35, 50);
		gc.fillText("Red Keys: " + redKeys.size() , 170, 50);
		gc.fillText("Blue Keys: " + blueKeys.size() , 35, 80);
		gc.fillText("Yellow Keys: " + yellowKeys.size() , 170, 80);
		gc.fillText("Chips remaining: " + chipItems.size() , 560, 50);
		root.add(canvas);
	}
	
	
}
