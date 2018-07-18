package Entities;

import java.awt.Color;
import java.awt.Graphics;

import GameState.World;
import Misc.Assets;

public class BasicHouse extends Entity{
	public int tick=0,income=4,image,level=1,temp=0;
	public boolean ting=false;
	public BasicHouse(int x,int y){
		this.x=x;
		this.y=y;
		sx=2;sy=2;
		cost=1000;
		image=(int)(Math.random()*5);
		name="Basic House";
	}
	public void tick(){
		GameState.World.maxPop+=4;
		World.need-=5;
	}
	public void timeTick(){
		//ting=true;
		temp=income*level*World.need;
		GameState.World.money+=temp;
		if(temp!=0){tick=10;}
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
		if(tick>0){
			tick--;
			renderIncome(g,temp);
		}
		//ting=false;
	}
	public void upgrade(){
		int upcost=(int)(cost*(Math.pow(level+1, 2)));
		if(World.money>=upcost){
			GameState.World.money-=upcost;
			level++;
		}
	}
}
