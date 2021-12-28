package MineSweepR;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MineSweeperGUI extends JPanel {
  
  public MineGrid grid;
  public int col, row;
  public JButton[][] myButton;
  
  public MineSweeperGUI(int numRows,int numCols,int numMines){
    setSize(1200,850);
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    
    grid=new MineGrid(numRows,numCols,numMines);
        myButton = new JButton[numRows][numCols];
        for(int i=0; i<numRows; i++){
            for(int j=0; j<numCols; j++){
                myButton[i][j] =new JButton();
                ButtonHandler bHandler = new ButtonHandler(i,j,grid, myButton);
                myButton[i][j].addActionListener(bHandler);
                myButton[i][j].addMouseListener(bHandler);
                panel1.add(myButton[i][j]);
            }
        }
        grid.shareButtons(myButton);
    
  }
  
  
}
