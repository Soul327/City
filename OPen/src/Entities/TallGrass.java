package Entities;

import java.awt.Graphics;

import GameState.World;
import Misc.Assets;

public class TallGrass extends Entity{
	public int tick=0,income=0;
	public TallGrass(int x,int y){
		this.x=x;
		this.y=y;
		sx=1;sy=1;
		cost=20;
		happy=-1;
		World.happy+=happy;
		name="Tall Grass";
	}
	public void tick(){
		GameState.World.pre+=.1;
	}
	public void render(Graphics g){
		prerender();
		g.drawImage(Assets.assets[20],tx,ty,tsx,tsy,null);
	}
}
