package Entities;

import java.awt.Color;
import java.awt.Graphics;

import Misc.Assets;

public class Road extends Entity{
	public Road(int x,int y){
		this.x=x;
		this.y=y;
		cost=20;
		GameState.World.tickrate-=.1;
	}
	public void render(Graphics g){
		prerender();
		g.drawImage(Assets.assets[5],tx,ty,tsx,tsy,null);
		g.setColor(Color.BLACK);
		g.drawRect(tx,ty,tsx,tsy);
	}
	public void remove() {
		GameState.World.tickrate+=.1;
	}
}
