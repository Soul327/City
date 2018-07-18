package Entities;

import java.awt.Graphics;

import GameState.World;
import Misc.Assets;

public class Flower extends Entity{
	public int tick=0,income=0;
	public Flower(int x,int y){
		this.x=x;
		this.y=y;
		sx=1;sy=1;
		cost=20;
		happy=0;
		World.happy+=happy;
	}
	public void tick(){}
	public void render(Graphics g){
		prerender();
		g.drawImage(Assets.assets[23],tx,ty,tsx,tsy,null);
	}
}
