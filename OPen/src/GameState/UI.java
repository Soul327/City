package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import Entities.BasicHouse;
import Entities.Entity;
import Main.Game;
import Misc.Assets;

public class UI {
	int w=Game.width,h=Game.height;
	int x=16,y=9;
	public UI(){
	}
	public void tick(){
	}
	public void render(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		g.setColor(Color.GREEN);
		g.fillRect(x,y*77,x*20,y*2);
		g.setColor(Color.BLUE);
		g.fillRect(x,y*77,(int)((x*20)*(World.need/100.0)),y*2);
		g.setColor(Color.BLACK);
		g.drawRect(x,y*77,x*20,y*2);
		int temp=0;
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman",Font.PLAIN,30));
		g.drawImage(Assets.assets[0],0,y*(10+(temp*5)),x*3,y*5,null);temp++;
		g.drawString(""+temp,x*3,y*(10+(temp*5)));
		g.drawImage(Assets.assets[10],0,y*(10+(temp*5)),x*3,y*5,null);temp++;
		g.drawString(""+temp,x*3,y*(10+(temp*5)));
		g.drawImage(Assets.assets[11],0,y*(10+(temp*5)),x*3,y*5,null);temp++;
		g.drawString(""+temp,x*3,y*(10+(temp*5)));
		g.drawImage(Assets.assets[12],0,y*(10+(temp*5)),x*3,y*5,null);temp++;
		g.drawString(""+temp,x*3,y*(10+(temp*5)));
		g.drawImage(Assets.assets[13],x/2,y*(10+(temp*5)),x*2,y*5,null);temp++;
		g.drawString(""+temp,x*3,y*(10+(temp*5)));
		g.drawImage(Assets.assets[5],0,y*(10+(temp*5)),x*3,y*5,null);temp++;
		g.drawString(""+temp,x*3,y*(10+(temp*5)));
		//g.drawImage(Assets.assets[0],0,y*(10+(temp*5)),x*3,y*5,null);temp++;
		if(Game.debug){
			//devRender(g);
			for(int z=0;z<World.entity.size();z++){World.entity.get(z).renderDebug(g);}
		}
	}
	public void devRender(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		for(int x2=0;x2<w;){
			g.drawLine(x2,0,x2,h);
			x2+=x;
		}
		for(int y2=0;y2<h;){
			g.drawLine(0,y2,w,y2);
			y2+=y;
		}
	}
}
