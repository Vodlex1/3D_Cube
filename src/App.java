import javax.swing.JFrame;

public class App {

    public static void main(String[] args){
        JFrame frame = new JFrame("frame");
        Gui gui = new Gui();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(gui);
        gui.repaint();
        frame.setVisible(true);
    }
}

/*      TO DO
-fix rotation
-fix forward/backward
-make side order method
-put cube objects in list
-be able to switch through Cube objects and move them each
 */

