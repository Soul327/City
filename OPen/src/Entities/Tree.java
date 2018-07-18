package Entities;

import java.awt.Color;
import java.awt.Graphics;

import GameState.GameState;
import GameState.World;
import Main.Game;
import Misc.Assets;

public class Tree extends Entity{
	public int tick=0,income=0,image;
	public Tree(int x,int y){
		this.x=x;
		this.y=y-1;
		sx=2;sy=2;
		cost=100;
		name="Tree";
	}
	public void tick(){
		World.pre-=.1;
		World.need-=1;
	}
	public void timeTick(){
		World.money+=income;
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
		g.setColor(Color.BLUE);
		tx=(x*World.scale)+((-World.x-1)*World.scale)+Game.width/2+(World.scale/2);
		ty=((y+1)*World.scale)+((-World.y-1)*World.scale)+Game.height/2+(World.scale/2);
		tsx=World.scale*sx;
		tsy=World.scale*sy;
	}
}
