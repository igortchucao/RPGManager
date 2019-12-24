package Grafo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Personagens.Personagem;

public class Vertice {
	public Personagem personagem;
	public int Px, Py;
	public int Tx, Ty;
	public int FONT = 30;

	public boolean wasCreated = false;
	public String textView = "";
	public int indexCreatePerson = 1;

	public Vertice(Personagem personagem, int px, int py, int tx, int ty) {
		this.personagem = personagem;
		Px = px;
		Py = py;
		Tx = tx;
		Ty = ty;
	}

	public void render(Graphics g) {
		if (wasCreated) {
			g.setColor(Color.white);
			g.drawRect(Px, Py, personagem.nome.length() * 19, Ty);
			
			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, FONT));
			g.drawString(personagem.nome, Px + 20, Py + 30);
		} else {
			g.setColor(Color.white);
			g.drawRect(Px, Py, Tx + 100, Ty + 300);

			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, FONT));
			switch (indexCreatePerson) {
			case 1:
				g.drawString("Nome :", Px, Py);
				break;
			case 2:
				g.drawString("Idade :", Px, Py);
				break;
			case 3:
				g.drawString("Cidade :", Px, Py);
				break;
			}
			g.drawString(textView, Px + 120, Py);
		}
	}

	public void create(String text) {
		textView = text;
	}
	
	public void atribuicaoDeValor() {
		switch (indexCreatePerson) {
		case 1:
			personagem.nome = textView;
			indexCreatePerson += 1;
			break;
		case 2:
			personagem.idade = textView;
			indexCreatePerson += 1;
			break;
		case 3:
			personagem.cidade = textView;
			indexCreatePerson += 1;
			wasCreated = true;
			break;
		}
	}
}
