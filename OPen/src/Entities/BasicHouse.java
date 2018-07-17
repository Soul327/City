package Entities;

import java.awt.Color;
import java.awt.Graphics;

import Misc.Assets;

public class BasicHouse extends Entity{
	public int tick=0,income=100,image;
	public boolean ting=false;
	public BasicHouse(int x,int y){
		this.x=x;
		this.y=y;
		sx=2;sy=2;
		cost=1000;
		image=(int)(Math.random()*5);
	}
	public void tick(){
		GameState.World.maxPop+=4;
	}
	public void timeTick(){
		ting=true;tick=10;
		GameState.World.money+=income;
	}
	public void render(Graphics g){
		prerender();
		switch(image){
		case 0:g.drawImage(Assets.assets[0],tx,ty,tsx,tsy,null);break;
		case 1:g.drawImage(Assets.assets[6],tx,ty,tsx,tsy,null);break;
		case 2:g.drawImage(Assets.assets[7],tx,ty,tsx,tsy,null);break;
		case 3:g.drawImage(Assets.assets[8],tx,ty,tsx,tsy,null);break;
		case 4:g.drawImage(Assets.assets[9],tx,ty,tsx,tsy,null);break;
		}
		//g.fillRect(tx,ty,tsx,tsy);
		if(tick>0){
			tick--;
			g.drawImage(Assets.assets[14],tx,ty,tsx,tsy,null);
		}
		ting=false;
		g.setColor(Color.BLACK);
		g.drawRect(tx,ty,tsx,tsy);
	}
}
