package Misc;

import java.awt.image.BufferedImage;
import java.io.File;
import Main.Game;

public class Assets {
	Game test=new Game();
	public static int x=1,y=1;
	public static BufferedImage[] assets=new BufferedImage[100];
	public static void init(){
		assets[0] = ImageLoader.loadImage("/Sprites/house1.png");
		assets[1] = ImageLoader.loadImage("/Sprites/grass1.png");
		assets[2] = ImageLoader.loadImage("/Sprites/grass2.png");
		assets[3] = ImageLoader.loadImage("/Sprites/grass3.png");
		assets[4] = ImageLoader.loadImage("/Sprites/grassTuft.png");
		assets[5] = ImageLoader.loadImage("/Sprites/road.png");
		assets[6] = ImageLoader.loadImage("/Sprites/house2.png");
		assets[7] = ImageLoader.loadImage("/Sprites/house3.png");
		assets[8] = ImageLoader.loadImage("/Sprites/house4.png");
		assets[9] = ImageLoader.loadImage("/Sprites/house5.png");
		assets[10] = ImageLoader.loadImage("/Sprites/pokecenter.png");
		assets[11] = ImageLoader.loadImage("/Sprites/pokemart.png");
		assets[12] = ImageLoader.loadImage("/Sprites/Gym.png");
		assets[13] = ImageLoader.loadImage("/Sprites/tree.png");
		assets[14] = ImageLoader.loadImage("/Sprites/Money1.png");
		assets[15] = ImageLoader.loadImage("/Sprites/bronzecoin.png");
		assets[16] = ImageLoader.loadImage("/Sprites/silvercoin.png");
		assets[17] = ImageLoader.loadImage("/Sprites/goldcoin.png");
		assets[18] = ImageLoader.loadImage("/Sprites/platinum.png");
		
		//File actual = new File("C:\\Users\\Soul327\\eclipse-workspace\\OPen\\res\\Sprites");
		//for( File f : actual.listFiles()){System.out.println( f.getName()+" "+f.getAbsolutePath());}
	}
}