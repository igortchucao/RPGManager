package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Menu {
	public int Px, Py;
	public int Tx, Ty = 50;
	public int FONT = 18;
	
	public int PxNew = 10, PyNew = 10;
	public int FxNew = 110, FyNew = 40;
	public Color colorNew = Color.white;
	public boolean newIsCliked = false;
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, Main.WIDTH * Main.SCALE, Ty);
		g.setColor(Color.black);
		g.drawRect(0, 1, Main.WIDTH * Main.SCALE - 1, Ty - 1);
		
		if(newIsCliked)
			colorNew = Color.red;
		else
			colorNew = Color.white;
		
		g.setColor(colorNew);
		g.fillRect(PxNew, PyNew, (FxNew - PxNew), (FyNew - PyNew));
		g.setColor(Color.black);
		g.setFont(new Font("arial", Font.BOLD, FONT));
		g.drawString("Novo", (FxNew - PxNew) /3, (FxNew - PxNew)/3);
	}
	
	public void newClicked(int x, int y) {
		if((x > PxNew && x < FxNew) && (y > PyNew && y < FyNew)) 
			newIsCliked = true;
	}
}
