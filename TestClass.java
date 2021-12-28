package MineSweepR;

import javax.swing.JFrame;


public class TestClass {
    private static final int NUMBER_OF_MINES = 15;
    public static final int SIZE = 20;
    
    public static void main(String[] args) {
        
      JFrame frame = new JFrame("Mine sweeper " + NUMBER_OF_MINES);
        frame.add(new MineSweeperGUI(SIZE,SIZE,NUMBER_OF_MINES));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setVisible(true);
        
    }
  
}
