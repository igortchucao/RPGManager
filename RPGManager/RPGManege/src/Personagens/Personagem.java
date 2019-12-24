package Personagens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import Graficos.Spritesheet;

public class Personagem {
	public String nome;
	public String idade;
	public String cidade;

	private Spritesheet spritesheet;// = new Spritesheet("/Freeway_Atari_cover.png");
	//public BufferedImage LOGO_ACT = spritesheet.spritesheet;

	public List<Relacionamento> cicloDeRelacionamento;
	
	public Personagem(String nome, String idade, String cidade, Spritesheet sprite) {
		this.nome = nome;
		this.idade = idade;
		this.cidade = cidade;
		this.spritesheet = sprite;
	}
	
	public void render(Graphics g) {
		//g.drawImage(LOGO_ACT, 0, 0, 100, 100, null);
	}
}
