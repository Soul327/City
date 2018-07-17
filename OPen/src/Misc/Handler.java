package Misc;

import Main.Game;

public class Handler{
	public Game game;
	public static KeyManager keyManager;
	public void setGame(Game g){game=g;}
	public void setKeyManager(KeyManager k){keyManager=k;}
	public void test(){System.out.println("Handler");}
}