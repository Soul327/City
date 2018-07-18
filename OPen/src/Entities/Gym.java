package Entities;

import java.awt.Color;
import java.awt.Graphics;

import GameState.World;
import Misc.Assets;

public class Gym extends Entity{
	public int tick=0,income=-10000,image;
	public Gym(int x,int y){
		this.x=x;
		this.y=y;
		sx=4;sy=4;
		cost=500000;
		happy=100;
		World.happy+=happy;
	}
	public void timeTick(){
		GameState.World.money+=income;
	}
	public void tick(){
		GameState.World.pre+=40;
		World.need+=20;
	}
	public void render(Graphics g){
		prerender();
		g.drawImage(Assets.assets[12],tx,ty,tsx,tsy,null);
	}
}
