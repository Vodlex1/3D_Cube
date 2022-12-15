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