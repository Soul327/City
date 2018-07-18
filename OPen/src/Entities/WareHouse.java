package Entities;

import java.awt.Graphics;

import GameState.World;
import Misc.Assets;

public class WareHouse extends Entity{
	public int tick=0,income=-300;
	public double hold=0;
	public WareHouse(int x,int y){
		this.x=x;
		this.y=y;
		sx=2;sy=2;
		cost=1000;
		name="Ware House";
		happy=-20;
		World.happy+=happy;
	}
	public void timeTick(){
		GameState.World.money+=income;
		hold=-(Math.random()*10);
	}
	public void tick(){
		GameState.World.pre+=hold;
		World.need+=10;
	}
	public void render(Graphics g){
		prerender();
		g.drawImage(Assets.assets[19],tx,ty,tsx,tsy,null);
	}
}
