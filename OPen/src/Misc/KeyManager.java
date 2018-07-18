package Misc;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	public boolean[] keys,nums=new boolean[10];
	public boolean w,a,s,d,re,up,down,left,right,space,z,x,i;
	public boolean one,two,three,four,zero;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void tick(){
		d=keys[KeyEvent.VK_D];
		a=keys[KeyEvent.VK_A];
		s=keys[KeyEvent.VK_S];
		w=keys[KeyEvent.VK_W];
		x=keys[KeyEvent.VK_X];
		z=keys[KeyEvent.VK_Z];
		i=keys[KeyEvent.VK_I];
		zero=keys[KeyEvent.VK_0];
		up=keys[KeyEvent.VK_UP];
		down=keys[KeyEvent.VK_DOWN];
		left=keys[KeyEvent.VK_LEFT];
		right=keys[KeyEvent.VK_RIGHT];
		re=keys[KeyEvent.VK_ENTER];
		space=keys[KeyEvent.VK_SPACE];
		nums[0]=keys[KeyEvent.VK_0];
		nums[1]=keys[KeyEvent.VK_1];
		nums[2]=keys[KeyEvent.VK_2];
		nums[3]=keys[KeyEvent.VK_3];
		nums[4]=keys[KeyEvent.VK_4];
		nums[5]=keys[KeyEvent.VK_5];
		nums[6]=keys[KeyEvent.VK_6];
		nums[7]=keys[KeyEvent.VK_7];
		nums[8]=keys[KeyEvent.VK_8];
		nums[9]=keys[KeyEvent.VK_9];
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
