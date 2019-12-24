package Entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Grafo.Vertice;

public class Relacionamento {
	public int FONT = 30;
	public int porcRelacao;
	public String relacao;
	public Vertice personagem;
	public Color cor = Color.white;

	private int Px, Py;
	private int Fx, Fy;

	public Relacionamento(int porcRelacao, Vertice personagem, int px, int py) {
		this.porcRelacao = porcRelacao;
		this.personagem = personagem;
		Px = px;
		Py = py;
		Fx = Px + 20;
		Fy = Py + 20;
	}

	public void render(Graphics g, Vertice v) {
		g.setColor(Color.white);
		if (v.Fx < personagem.Px) {
			g.drawLine(v.Fx, v.Fy, personagem.Px, personagem.Py);

			g.setColor(cor);
			g.setFont(new Font("arial", Font.BOLD, FONT));
			g.drawString("" + porcRelacao + "% | " + relacao + " ->", Px, Py);

			// g.setColor(Color.white);
			// g.drawRect(Px, Py - 40, 200, 50);

		} else if (v.Fx > personagem.Px) {
			g.drawLine(v.Px, v.Fy, personagem.Fx, personagem.Py);

			g.setColor(cor);
			g.setFont(new Font("arial", Font.BOLD, FONT));
			g.drawString("" + porcRelacao + "% | " + relacao + " <-", Px, Py + 100);

			// g.setColor(Color.white);
			// g.drawRect(Px, Py + 60, 200, 50);
		}
	}

	public boolean clicked(int x, int y) {
		if ((x > Px && x < Fx) && (y > Py && y < Fy)) {
			return true;
		} else {
			return false;
		}
	}

}
