package Grafo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Entidades.Personagem;
import Entidades.Relacionamento;

public class Vertice {
	public Personagem personagem;
	public int Px, Py;
	public int Fx, Fy;
	public int Tx, Ty;
	public int FONT = 30;
	public Color corVertice = Color.white;

	public boolean wasCreated = false;
	public boolean showThis = false;
	public String textView = "";

	public int indexCreatePerson = 1;
	public boolean addRelacion = false;

	public Vertice(Personagem personagem, int px, int py, int tx, int ty) {
		this.personagem = personagem;
		Px = px;
		Py = py;
		Tx = tx;
		Ty = ty;
		Fx = px + tx;
		Fy = py + ty;
	}

	public void render(Graphics g) {
		if (wasCreated) {
			if (addRelacion) 
				corVertice = Color.red;
			else
				corVertice = Color.white;
			g.setColor(corVertice);
			Tx = personagem.nome.length() * 19;
			Fx = Px + Tx;
			Fy = Py + Ty;
			g.drawRect(Px, Py, Tx, Ty);

			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, FONT));
			g.drawString(personagem.nome, Px + 20, Py + 30);

			if (personagem.cicloDeRelacionamento.size() > 0) {
				for (int j = 0; j < personagem.cicloDeRelacionamento.size(); j++) {
					Relacionamento r = personagem.cicloDeRelacionamento.get(j);
					r.render(g, this);
				}
			}
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

	public void showPerson(Graphics g) {
		if (showThis) {
			g.setColor(Color.white);
			g.fillRect(Px, Py, 300, 500);

			g.setColor(Color.black);
			g.setFont(new Font("arial", Font.BOLD, FONT));
			g.drawString("Nom: " + personagem.nome, Px + 20, Py + 30);

			g.setColor(Color.black);
			g.setFont(new Font("arial", Font.BOLD, FONT));
			g.drawString("Id: " + personagem.idade, Px + 20, Py + 80);

			g.setColor(Color.black);
			g.setFont(new Font("arial", Font.BOLD, FONT));
			g.drawString("Ci: " + personagem.cidade, Px + 20, Py + 130);

			g.setColor(Color.black);
			g.setFont(new Font("arial", Font.BOLD, FONT));
			g.drawString("''" + personagem.historia + "''", Px + 20, Py + 180);

			g.setColor(Color.black);
			g.setFont(new Font("arial", Font.BOLD, FONT));
			if (personagem.cicloDeRelacionamento.size() > 0)
				g.drawString("''" + personagem.cicloDeRelacionamento.get(0).relacao + "''", Px + 20, Py + 230);
		}
	}

	public void personClicked(int x, int y) {
		if ((x > Px && x < Fx) && (y > Py && y < Fy)) {
			showThis = true;
		} else {
			showThis = false;
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
