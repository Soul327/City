package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import GameState.GameState;
import Misc.Assets;
import Misc.Handler;
import Misc.KeyManager;
import Misc.MouseManager;

public class Game implements Runnable {

	public static int ticks = 0,fps=0;
	static int size=150;
	int my,mx,state=0;
	int[] temp=new int[5];
	public static int width, height,fontSize=30;
	public String title;
	String[] info= {"","","",""};
	boolean in=false;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private JFrame frame;
	private Canvas canvas;
	
	public static KeyManager keyManager;
	MouseManager mouseManager;
	Handler handler;
	GameState gameState;
	
	public Game(String title, int width, int height){
		Game.width = width;
		Game.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	public Game(){}

	private void init(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.addMouseListener(mouseManager);
		frame.addMouseMotionListener(mouseManager);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		canvas.addMouseListener(mouseManager);
		canvas.addMouseMotionListener(mouseManager);
		frame.add(canvas);
		frame.pack();
		frame.addKeyListener(keyManager);
		Assets.init();
		gameState=new GameState();
	}
	private void tick(){
		width=frame.getWidth();
		height=frame.getHeight();
		keyManager.tick();
		gameState.tick();
	}
	private void render(){
		bs = canvas.getBufferStrategy();
		if(bs == null){
			canvas.createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.fillRect(0,0,width,height);
		//Draw Here!
		gameState.render(g);
		//End Drawing!
		bs.show();
		g.dispose();
	}
	public void run(){
		init();
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000){
				//System.out.println("Ticks and Frames: " + ticks);
				Game.fps=ticks;
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	public KeyManager getKeyManager(){return keyManager;}
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}