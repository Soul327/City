package Entities;

import java.awt.Color;
import java.awt.Graphics;

import Misc.Assets;

public class Gym extends Entity{
	public int tick=0,income=-10000,image;
	public Gym(int x,int y){
		this.x=x;
		this.y=y;
		sx=4;sy=4;
		cost=500000;
	}
	public void timeTick(){
		GameState.World.money+=income;
	}
	public void tick(){
		GameState.World.pre+=10;
	}
	public void render(Graphics g){
		prerender();
		g.drawImage(Assets.assets[12],tx,ty,tsx,tsy,null);
		g.setColor(Color.BLACK);
		g.drawRect(tx,ty,tsx,tsy);
	}
}
