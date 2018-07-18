package GameState;

import java.awt.Color;
import java.awt.Graphics;

import Main.Game;

public class UI {
	int width=Game.width,height=Game.height;
	public void tick(){}
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(width-(width/2),200,100,100);
	}
}
