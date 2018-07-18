package Entities;

import java.awt.Color;
import java.awt.Graphics;

import GameState.World;
import Misc.Assets;

public class PokeCenter extends Entity{
	public int tick=0,income=-1000,image;
	public double hold=0;
	public PokeCenter(int x,int y){
		this.x=x;
		this.y=y;
		sx=3;sy=3;
		cost=5000;
		name="PokeCenter";
	}
	public void timeTick(){
		GameState.World.money+=income;
		hold=(Math.random()*10)+(Math.random()*10)+(Math.random()*10)+(Math.random()*10)+(Math.random()*10);
	}
	public void tick(){
		GameState.World.pre+=hold;
		World.need+=10;
	}
	public void render(Graphics g){
		prerender();
		g.drawImage(Assets.assets[10],tx,ty,tsx,tsy,null);
	}
}
