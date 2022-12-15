import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Gui extends JPanel implements KeyListener{
	double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
	double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;
	
	public Gui() {
		setFocusable(true);
		requestFocus();
		this.addKeyListener(this);
	}

	Cube cube = new Cube(200, new double[] {60, 300, 200}, (int)width, (int)height);
	Cube cube2 = new Cube(200, new double[] {260.0, 300.0, 200.0}, (int)width, (int)height);
	Cube cube3 = new Cube(200, new double[] {460.0, 300.0, 200.0}, (int)width, (int)height);
	Cube cube4 = new Cube(200, new double[] {660.0, 300.0, 200.0}, (int)width, (int)height);
	Cube cube5 = new Cube(200, new double[] {860.0, 300.0, 200.0}, (int)width, (int)height);
	Cube cube6 = new Cube(200, new double[] {1060.0, 300.0, 200.0}, (int)width, (int)height);

	@Override
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();
		drawCube(g2d, cube);
		drawCube(g2d, cube2);
		drawCube(g2d, cube3);
		drawCube(g2d, cube4);
		drawCube(g2d, cube5);
		drawCube(g2d, cube6);

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
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			cube.moveRight();
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			cube.moveLeft();
		}else if(e.getKeyCode() == KeyEvent.VK_UP){
			cube.moveUp();
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			cube.moveDown();
		}

		repaint();
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}


}
