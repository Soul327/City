package Entities;

import java.awt.Color;
import java.awt.Graphics;

import GameState.World;
import Main.Game;
import Misc.Assets;

public class Road extends Entity{
	public Road(int x,int y){
		this.x=x;
		this.y=y;
		cost=20;
		GameState.World.tickrate-=(1.0/60)*GameState.World.tickrate;
		name="Road";
		happy=1;
		World.happy+=happy;
	}
	public void timeTick(){
		GameState.World.money-=10;
	}
	public void render(Graphics g){
		prerender();
		g.drawImage(Assets.assets[5],tx,ty,tsx,tsy,null);
	}
	public void remove() {
		World.happy-=happy;
		GameState.World.tickrate+=(1.0/59)*GameState.World.tickrate;
	}
}
