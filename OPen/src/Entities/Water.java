package Entities;

import java.awt.Graphics;

import GameState.World;
import Misc.Assets;

public class Water extends Entity{
	public int tick=0,income=0;
	public Water(int x,int y){
		this.x=x;
		this.y=y;
		sx=1;sy=1;
		cost=20;
		happy=0;
		World.happy+=happy;
		name="Water";
	}
	public void tick(){
		GameState.World.pre+=.1;
	}
	public void render(Graphics g){
		prerender();
		g.drawImage(Assets.assets[23],tx,ty,tsx,tsy,null);
	}
}
