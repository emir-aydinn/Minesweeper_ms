


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
    
}
