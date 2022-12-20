import java.awt.Color;
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
	int cubeID = 0; 

	public Gui(int cubeNum) {
		int temp1 = 50;

		if(cubeNum > 9) System.out.println("number too high");
		cubes = new Cube[cubeNum];
		for (int i = 0; i < cubeNum; i++) {
			cubes[i] = new Cube (100, new double[] {temp1, 300, 200}, (int)width, (int)height);
			temp1 += 100;
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
		g2d.setColor(Color.green);
		if(cube.sideOrder[3] < cube.sideOrder[5]) g2d.fillPolygon(cube.sides[3]);
		else g2d.fillPolygon(cube.sides[5]);

		g2d.setColor(Color.cyan);
		if(cube.sideOrder[0] < cube.sideOrder[1]) g2d.fillPolygon(cube.sides[0]);
		else g2d.fillPolygon(cube.sides[1]);

		g2d.setColor(Color.red);
		if(cube.sideOrder[2] < cube.sideOrder[4]) g2d.fillPolygon(cube.sides[2]);
		else g2d.fillPolygon(cube.sides[4]);

		g2d.setColor(Color.black);
		for(int i = 0; i<6; i++) g2d.drawPolygon(cube.sides[i]);
	}

	@Override
	public void keyPressed(KeyEvent e){

		int[] pressedNum = {KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9};
		for (int i = 0; i < 9; i++) {
			if(e.getKeyCode() == pressedNum[i]){
				cubeID = i;
			}
		}

		if(e.getKeyCode() == KeyEvent.VK_RIGHT) cubes[cubeID].moveRight();
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) cubes[cubeID].moveLeft();
		else if(e.getKeyCode() == KeyEvent.VK_UP) cubes[cubeID].moveUp();
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) cubes[cubeID].moveDown();
		else if(e.getKeyCode() == KeyEvent.VK_A) cubes[cubeID].rotateLeft();
		else if(e.getKeyCode() == KeyEvent.VK_D) cubes[cubeID].rotateRight();
		else if(e.getKeyCode() == KeyEvent.VK_W) cubes[cubeID].rotateFront();
		else if(e.getKeyCode() == KeyEvent.VK_S) cubes[cubeID].rotateBehind();
		else if(e.getKeyCode() == KeyEvent.VK_Q) cubes[cubeID].moveBackward();
		else if(e.getKeyCode() == KeyEvent.VK_E) cubes[cubeID].moveForward();
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

}
