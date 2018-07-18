package Entities;

import java.awt.Color;
import java.awt.Graphics;

import GameState.World;
import Misc.Assets;

public class PokeMart extends Entity{
	public int tick=0,income=-100,image;
	public PokeMart(int x,int y){
		this.x=x;
		this.y=y;
		sx=2;sy=2;
		cost=5000;
		name="PokeMart";
	}
	public void timeTick(){
		income=-100;
		income+=(GameState.World.trainers*1000*Math.random());
		GameState.World.money+=income;
	}
	public void tick(){
		World.need+=10;
	}
	public void render(Graphics g){
		prerender();
		g.drawImage(Assets.assets[11],tx,ty,tsx,tsy,null);
		g.setColor(Color.BLACK);
		g.drawRect(tx,ty,tsx,tsy);
	}
}
