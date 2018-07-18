package GameState;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;

public class UI {
	int width=Game.width,height=Game.height;
	public void tick(){}
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect((width/100),height-(height/20),100,100);
	}
}
