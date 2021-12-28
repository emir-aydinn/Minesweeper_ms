


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonHandler implements ActionListener, MouseListener {
    private int row, col;
    private MineGrid grid;
    public JButton[][] myButtons;

    public ButtonHandler(int x, int y, MineGrid g, JButton[][] myButtons) {
        row = x;
        col = y;
        grid = g;
        this.myButtons = myButtons;
    }
    public void actionPerformed(ActionEvent event) {
         if (e.getButton() == MouseEvent.BUTTON3) {
            JButton button = (JButton) e.getSource();
            String txt = button.getText();
            if (txt == "") {
                button.setText("F");
                if (grid.isClear()) {
                    MineSweeperGUI.timer.stop();
                    JOptionPane.showMessageDialog(null, "Bravo you did it");
                    
                }
            } else if (txt.charAt(0) == 'F') {
                button.setText("");
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
     @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }
}
