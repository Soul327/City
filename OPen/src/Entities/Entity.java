package Entities;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import GameState.World;
import Main.Game;
import Misc.Assets;

public abstract class Entity {
	public int x=0,y=0,sx=1,sy=1,tx=0,ty=0,tsx=0,tsy=0,cost=0,fontSize=12;
	String name="Missing Name";
	public void tick(){
		
	}
	public void prerender(){
		tx=(x*World.scale)+((-World.x-1)*World.scale)+Game.width/2+(World.scale/2);
		ty=(y*World.scale)+((-World.y-1)*World.scale)+Game.height/2+(World.scale/2);
		tsx=World.scale*sx;
		tsy=World.scale*sy;
	}
	public void timeTick(){}
	public void buy(){
		if(World.money>=cost){
			World.money-=cost;
		}else{
			World.entity.remove(this);
		}
	}
	public void render(Graphics g){
		prerender();
		g.setColor(Color.ORANGE);
		g.fillRect(tx,ty,tsx,tsy);
		//g.setColor(Color.BLACK);
		//g.drawRect(tx,ty,tsx,tsy);
	}
	public void renderDebug(Graphics g){
		int z=1;
		g.setColor(Color.BLUE);
		g.drawRect(tx,ty,tsx,tsy);
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman",Font.PLAIN,fontSize));
		g.drawString(name,tx,ty+(fontSize*z)+tsy);z++;
		g.drawString("x:"+x+" y:"+y+" tx:"+tx+" ty:"+ty,tx,ty+(fontSize*z)+tsy);z++;
	}
	public void remove(){}
	public void upgrade(){}
}
