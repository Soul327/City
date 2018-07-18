package GameState;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;

public class UI {
	int w=Game.width,h=Game.height;
	int x=16,y=9;
	public void tick(){}
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x,y*77,x*20,y*2);
		g.setColor(Color.BLUE);
		g.fillRect(x,y*74,x*20,y*2);
		//devRender(g);
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
