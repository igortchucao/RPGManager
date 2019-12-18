package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Graficos.Spritesheet;
import Grafo.Vertice;
import Personagens.Personagem;

public class Main extends Canvas implements KeyListener, Runnable, MouseListener {

	private static final long serialVersionUID = 1L;

	// DADOS DA JANELA DO JOGO
	public static JFrame frame;
	public static final int WIDTH = 350;
	public static final int HEIGHT = 190;
	public static final int SCALE = 4;
	public static final int TAM_IMG = 16;
	private Thread thread;
	public boolean isRunning = false;

	private BufferedImage image;
	public static Spritesheet spritesheet;

	private int frames = 0;
	private int maxFrames = 5;

	public static List<Vertice> entidades;
	private Menu menu;

	private String text;

	// DADOS DA TELA JFRAME
	public void initFrame() {
		frame = new JFrame();
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public Main() {
		// ATIVA O TECLADO E MOUSE PARA ESSA CLASSE
		this.addKeyListener(this);
		this.addMouseListener(this);

		// CRIA E ASSOCIA OS DADOS A TELA
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		// SPRITES
		// spritesheet = new Spritesheet("/sprite.png");

		// IMAGEM PARA O FUNDO DO JOGO, SEM ELA FICARIA NO VACOO
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

		menu = new Menu();

		text = "";

		entidades = new ArrayList<Vertice>();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initFrame();
		main.start();
	}

	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}

	// PARA A THREAD
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		// RENDERIZAÇÃO DO FUNDO DO JOGO
		Graphics g = image.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);

		menu.render(g);

		for (int i = 0; i < entidades.size(); i++) {
			Vertice v = entidades.get(i);
			v.render(g);
		}

		bs.show();
	}

	public void tick() {
		// ATUALIZA OS FRAMES DO JOGO
		frames++;
		if (frames > maxFrames) {
			frames = 0;
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();

		// CONSTANTE TICK POR SEG
		double amountOfTicks = 100.0;

		// CALCULO PARA O MOMENTO CERTO DE FAZER O UPDATE DO JOGO
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		double timer = System.currentTimeMillis();
		requestFocus();

		// LOOP DO JOGO
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				frames++;
				delta--;
				render();
				tick();
			}

			if (System.currentTimeMillis() - timer >= 1000) {
				frames = 0;
				timer += 1000;
			}
		}
		stop();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (entidades.size() > 0 && !entidades.get(entidades.size() - 1).wasCreated) {

			if (text.length() > 1 && e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				text = text.substring(0, text.length() - 1);
			} else if(e.getKeyCode() != KeyEvent.VK_SHIFT) {
				text += e.getKeyChar();
			}
			entidades.get(entidades.size() - 1).create(text);
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				Vertice v = entidades.get(entidades.size() - 1);
				v.atribuicaoDeValor();
				text = "";
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (menu.newIsCliked) {
			entidades.add(new Vertice(new Personagem(null, null, null, null), e.getX(), e.getY(), 100, 50));
			menu.newIsCliked = false;
		}
		menu.newClicked(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
