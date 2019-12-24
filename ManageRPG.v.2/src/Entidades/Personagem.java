package Entidades;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Personagem {
	public String nome;
	public String idade;
	public String cidade;
	public String historia;

	// private Spritesheet spritesheet;// = new
	// Spritesheet("/Freeway_Atari_cover.png");
	// public BufferedImage LOGO_ACT = spritesheet.spritesheet;

	public List<Relacionamento> cicloDeRelacionamento = new ArrayList<Relacionamento>();

	public Personagem(String nome, String idade, String cidade) {
		this.nome = nome;
		this.idade = idade;
		this.cidade = cidade;
		this.historia = "";
		// this.spritesheet = sprite;
	}

	public void render(Graphics g) {
		// g.drawImage(LOGO_ACT, 0, 0, 100, 100, null);
	}
}
