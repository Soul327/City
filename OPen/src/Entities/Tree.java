package Entities;

import java.awt.Color;
import java.awt.Graphics;

import GameState.World;
import Main.Game;
import Misc.Assets;

public class Tree extends Entity{
	public int tick=0,income=0,image;
	public Tree(int x,int y){
		this.x=x;
		this.y=y;
		sx=2;sy=2;
		cost=100;
	}
	public void tick(){
		GameState.World.pre-=.1;
	}
	public void timeTick(){
		GameState.World.money+=income;
	}
	public void prerender(){
		tx=(x*World.scale)+((-World.x-1)*World.scale)+Game.width/2+(World.scale/2);
		ty=(y*World.scale)+((-World.y-1)*World.scale)+Game.height/2+(World.scale/2);
		tsx=World.scale*sx;
		tsy=World.scale*(sy+1);
	}
	public void render(Graphics g){
		prerender();
		g.drawImage(Assets.assets[13],tx,ty,tsx,tsy,null);
		g.setColor(Color.BLACK);
		g.drawRect(tx,ty,tsx,tsy);
	}
}
