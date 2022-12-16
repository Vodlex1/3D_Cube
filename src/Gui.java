import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Gui extends JPanel implements KeyListener{
	double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
	double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;
	Cube[] cubes;

	public Gui(int cubeNum) {
		int temp1 = 50;

		if(cubeNum > 9) System.out.println("number too high");
		cubes = new Cube[cubeNum];
		for (int i = 0; i < cubeNum; i++) {
			cubes[i] = new Cube (200, new double[] {temp1, 300, 200}, (int)width, (int)height);
			temp1 += 200;
		}
		
		setFocusable(true);
		requestFocus();
		this.addKeyListener(this);
	}


	@Override
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();

		for (int i = 0; i < cubes.length; i++) {
			drawCube(g2d, cubes[i]);		
		}
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }
	

	void drawCube(Graphics2D g2d, Cube cube) {
		
		// g2d.setColor(Color.red);
		// g2d.fillPolygon(cube.sides[0]);
		// g2d.setColor(Color.green);
		// g2d.fillPolygon(cube.sides[2]);
		// g2d.setColor(Color.blue);
		// g2d.fillPolygon(cube.sides[3]);
		// g2d.setColor(Color.black);
		// g2d.fillPolygon(cube.sides[5]);
		// g2d.setColor(Color.yellow);
		// g2d.fillPolygon(cube.sides[1]);
		// g2d.setColor(Color.cyan);
		// g2d.fillPolygon(cube.sides[4]);
		for(int i = 0; i<6; i++) g2d.drawPolygon(cube.sides[i]);

		
	}

	@Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) cubes[0].moveRight();
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) cubes[0].moveLeft();
		else if(e.getKeyCode() == KeyEvent.VK_UP) cubes[0].moveUp();
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) cubes[0].moveDown();
		else if(e.getKeyCode() == KeyEvent.VK_A) cubes[0].rotateLeft();
		else if(e.getKeyCode() == KeyEvent.VK_D) cubes[0].rotateRight();
		else if(e.getKeyCode() == KeyEvent.VK_W) cubes[0].rotateFront();
		else if(e.getKeyCode() == KeyEvent.VK_S) cubes[0].rotateBehind();
		else if(e.getKeyCode() == KeyEvent.VK_Q) cubes[0].moveBackward();
		else if(e.getKeyCode() == KeyEvent.VK_E) cubes[0].moveForward();
		repaint();
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}


}
