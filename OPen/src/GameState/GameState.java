package GameState;

import java.awt.Graphics;

public class GameState{
	World world=new World();
	public void tick(){
		world.tick();
	}
	public void render(Graphics g){
		world.render(g);
	}
}
