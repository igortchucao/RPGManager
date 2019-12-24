package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Entidades.Personagem;
import Grafo.Vertice;

public class Menu {
	public int Px, Py;
	public int Tx, Ty = 50;
	public int FONT = 18;

	public int PxNew = 10, PyNew = 10;
	public int FxNew = 110, FyNew = 40;
	public Color colorNew = Color.white;
	public boolean newIsCliked = false;
	
	public int PxRelac = 210, PyRelac = 10;
	public int FxRelac = 310, FyRelac = 40;
	public Color colorRelac = Color.white;
	public int relacIsCliked = 0;
	
	public int PxEditR = 410, PyEditR = 10;
	public int FxEditR = 510, FyEditR = 40;
	public Color colorEditR = Color.white;
	public int editRIsCliked = 0;

	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, Main.WIDTH * Main.SCALE, Ty);
		g.setColor(Color.black);
		g.drawRect(0, 1, Main.WIDTH * Main.SCALE - 1, Ty - 1);

		if (newIsCliked)
			colorNew = Color.red;
		else
			colorNew = Color.white;

		g.setColor(colorNew);
		g.fillRect(PxNew, PyNew, (FxNew - PxNew), (FyNew - PyNew));
		g.setColor(Color.black);
		g.setFont(new Font("arial", Font.BOLD, FONT));
		g.drawString("Novo", PxNew + 15, PyNew + 20);
		
		if (relacIsCliked != 0)
			colorRelac = Color.red;
		else
			colorRelac = Color.white;

		g.setColor(colorRelac);
		g.fillRect(PxRelac, PyRelac, (FxRelac - PxRelac), (FyRelac - PyRelac));
		g.setColor(Color.black);
		g.setFont(new Font("arial", Font.BOLD, FONT));
		g.drawString("Relação", PxRelac + 15, PyRelac + 20);
		
		if (editRIsCliked != 0)
			colorEditR = Color.red;
		else
			colorEditR = Color.white;

		g.setColor(colorEditR);
		g.fillRect(PxEditR, PyEditR, (FxEditR - PxEditR), (FyEditR - PyEditR));
		g.setColor(Color.black);
		g.setFont(new Font("arial", Font.BOLD, FONT));
		g.drawString("E.Relac", PxEditR + 15, PyEditR + 20);
	}

	public void newClicked(int x, int y) {
		if ((x > PxNew && x < FxNew) && (y > PyNew && y < FyNew))
			newIsCliked = true;
	}
	
	public void relacClicked(int x, int y) {
		if ((x > PxRelac && x < FxRelac) && (y > PyRelac && y < FyRelac))
			relacIsCliked = 1;
	}
	
	public void editRClicked(int x, int y) {
		if ((x > PxEditR && x < FxEditR) && (y > PyEditR && y < FyEditR))
			editRIsCliked = 1;
	}
}
