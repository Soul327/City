package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import Entities.BasicHouse;
import Entities.Entity;
import Entities.Flower;
import Entities.Gym;
import Entities.Ledge;
import Entities.PokeCenter;
import Entities.PokeMart;
import Entities.Road;
import Entities.TallGrass;
import Entities.Tree;
import Entities.WareHouse;
import Main.Game;
import Misc.Assets;

public class World {
	int[][] land;
	public static int x=0,y=0,scale=50,tick=0,tick2=0,timeTick=0,pop=0,maxPop=0,trainers=0,tempPop=0,need=50,happy=0;
	public static long money=20000;
	public static double pre=0,tr=1,tickrate;
	int y1=0,y2=0;
	double v=0;
	public static ArrayList<Entity> entity=new ArrayList<Entity>();
	public World(){
		tickrate=600;
		gen(50);
	}
	public void gen(int size){
		land=new int[size][size];
		for(int y=0;y<land.length;y++){
			for(int x=0;x<land[y].length;x++){
				land[y][x]=(int)(Math.random()*3);
			}
		}
		x=size/2;
		y=size/2;
		entity.add(new Road(x,y));
		//entity.add(new WareHouse(x+2,y+2));
	}
	public void tick(){
		need=50;
		y1++;
		pre=0;maxPop=0;tempPop=pop;
		if(tick!=0){tick++;}if(tick>10){tick=0;}
		if(tick2!=0){tick2++;}if(tick2>10){tick2=0;}
		if(timeTick!=0){timeTick++;}
		if(timeTick>tickrate){timeTick=0;}
		for(int z=0;z<entity.size();z++){entity.get(z).tick();}
		if(timeTick==0){
			//System.out.println("");
			y2=y1;
			y1=0;
			v=Math.random();
			for(int z=0;z<entity.size();z++){
				entity.get(z).timeTick();
			}
			timeTick++;
		}
		if(need<0){need=0;}
		if(need>100){need=100;}
		if(Game.keyManager.w&tick==0){y--;tick++;}
		if(Game.keyManager.s&tick==0){y++;tick++;}
		if(Game.keyManager.a&tick==0){x--;tick++;}
		if(Game.keyManager.d&tick==0){x++;tick++;}
		if(Game.keyManager.x&tick==0&scale>2){scale--;tick++;}
		if(Game.keyManager.z&tick==0&scale<200){scale++;tick++;}
		if(Game.keyManager.i&tick==0){}
		if(Game.keyManager.space&tick==0){Game.debug=!Game.debug;tick++;}
		//Delete
		if(Game.keyManager.zero&tick==0){
			Entity temp=isHover(x,y);
			if(temp!=null){
				temp.remove();
				money+=temp.cost/3;
				entity.remove(temp);
				tick++;
			}
		}
		//Create
		if(tick2==0){
			boolean t=false;
			Entity temp=null,temp2=null;
			if(Game.keyManager.nums[1]){temp2=new BasicHouse(x,y);}
			if(Game.keyManager.nums[2]){temp2=new PokeCenter(x,y);}
			if(Game.keyManager.nums[3]){temp2=new PokeMart(x,y);}
			if(Game.keyManager.nums[4]){temp2=new Gym(x,y);}
			if(Game.keyManager.nums[5]){temp2=new Tree(x,y);}
			if(Game.keyManager.nums[6]){temp2=new Road(x,y);}
			if(Game.keyManager.nums[7]){temp2=new WareHouse(x,y);}
			if(Game.keyManager.nums[8]){temp2=new TallGrass(x,y);}
			if(Game.keyManager.nums[9]){temp2=new Ledge(x,y);}
			if(Game.keyManager.nums[0]){temp2=new Flower(x,y);}
			
			if(temp2!=null){
				for(int t1=0;t1<temp2.sx;t1++){
					for(int t2=0;t2<temp2.sy;t2++){
						if(temp==null)
							temp=isHover(x+t1,y+t2);
					}
				}
				if(temp==null){
					entity.add(temp2);
					t=true;
				}else{
					temp2.remove();
				}
			}
			if(t){
				if(temp==null) {
					entity.get(entity.size()-1).buy();
					tick2++;
				}else{
					entity.get(entity.size()-1).remove();
					entity.remove(entity.size()-1);
				}
			}
			/*
			if(Game.keyManager.upgrade&tick==0){
				temp.upgrade();
				tick++;
			};
			*/
		}
		sort();
		if(pre<0){pre=0;}
		trainers=(int)((v*1)*pre);
	}
	public Entity isHover(int x,int y){
		Entity temp=null;
		for(int z=0;z<entity.size();z++){
			for(int t1=0;t1<entity.get(z).sx;t1++){
				for(int t2=0;t2<entity.get(z).sy;t2++){
					if(entity.get(z).x+t1==x & entity.get(z).y+t2==y){
						temp=entity.get(z);
					}
				}
			}
		}
		return temp;
	}
	public void sort(){
		for(int z=0;z<entity.size()-1;z++){
			if(entity.get(z).y>entity.get(z+1).y){
				Entity temp=entity.get(z);
				entity.remove(z);
				entity.add(temp);
			}
		}
	}
	public void render(Graphics g){
		for(int y=0;y<land.length;y++){
			for(int x=0;x<land[y].length;x++){
				int tx=(x*scale)+((-World.x-1)*scale)+Game.width/2+(scale/2);
				int ty=(y*scale)+((-World.y-1)*scale)+Game.height/2+(scale/2);
				if(!(tx>-scale&ty>-scale&tx+scale>Game.width&ty+scale>Game.height)){
					switch(land[y][x]){
						case 0:g.drawImage(Assets.assets[1],tx,ty,scale,scale,null);break;
						case 1:g.drawImage(Assets.assets[2],tx,ty,scale,scale,null);break;
						case 2:g.drawImage(Assets.assets[3],tx,ty,scale,scale,null);break;
						case 3:g.drawImage(Assets.assets[4],tx,ty,scale,scale,null);break;
						default:g.setColor(Color.WHITE);
					}
					//g.setColor(Color.green);g.fillRect(tx,ty,scale,scale);
				}
				//g.setColor(Color.BLACK);
				//g.drawRect(tx,ty,scale,scale);
			}
		}
		for(int z=0;z<entity.size();z++){
			entity.get(z).render(g);
		}
		g.setColor(Color.BLACK);
		g.fillRect(Game.width/2-5,Game.height/2-5,10,10);
		g.setFont(new Font("TimesRoman",Font.PLAIN,Game.fontSize));
		g.drawString("$"+money+" Tran:"+trainers+" Happy:"+happy+" fps"+Game.fps,0,Game.fontSize);
		g.drawString("X:"+(x+1)+"Y:"+(y+1)+" tick:"+y1+" "+y2,0,Game.fontSize*2);
	}
}
