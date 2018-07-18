package GameState;

import java.awt.Graphics;

public class GameState{
	World world=new World();
	UI ui=new UI();
	public void tick(){
		world.tick();
		ui.tick();
	}
	public void render(Graphics g){
		world.render(g);
		ui.render(g);
	}
}
