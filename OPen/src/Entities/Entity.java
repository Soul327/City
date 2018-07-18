package Entities;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import GameState.World;
import Main.Game;
import Misc.Assets;

public abstract class Entity {
	public int x=0,y=0,sx=1,sy=1,tx=0,ty=0,tsx=0,tsy=0,cost=0,fontSize=12,incame=0;
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
	public void renderIncome(Graphics g,int incame){
		int platinum=0,gold=0,silver=0,bronze=incame,loc=0,inc=10,tot;
		silver=(int)(bronze/inc);
		bronze=(bronze%inc);
		gold=(int)(silver/inc);
		silver=(silver%inc);
		platinum=(int)(gold/inc);
		gold=(gold%inc);
		tot=bronze+silver+gold+platinum;
		for(int x=0;x<platinum;x++){
			g.drawImage(Assets.assets[18],(tx+(tsx/4)+(4*loc))-(tot*2),ty,tsx-(tsx/2),tsy-(tsy/2),null);loc++;}
		for(int x=0;x<gold;x++){
			g.drawImage(Assets.assets[17],(tx+(tsx/4)+(4*loc))-(tot*2),ty,tsx-(tsx/2),tsy-(tsy/2),null);loc++;}
		for(int x=0;x<silver;x++){
			g.drawImage(Assets.assets[16],(tx+(tsx/4)+(4*loc))-(tot*2),ty,tsx-(tsx/2),tsy-(tsy/2),null);loc++;}
		for(int x=0;x<bronze;x++){
			g.drawImage(Assets.assets[15],(tx+(tsx/4)+(4*loc))-(tot*2),ty,tsx-(tsx/2),tsy-(tsy/2),null);loc++;}
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
