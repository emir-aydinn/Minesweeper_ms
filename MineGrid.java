import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MineGrid {
    public ButtonHandler handler;
    private static final int MINE = -1;
    private int[][] mineInformation;
    private JButton[][] buttonInformation;
    private int numOfMine;

    public MineGrid(int numRows, int numCols, int numMines) {
        mineInformation = new int[numRows][numCols];
        numOfMine = numMines;
        initializeCells();
        placeMines(numMines);
        setMineInformation();
    }
     private void initializeCells() {
       
     }
     private void placeMines(int numMines) {
       
     }
     private void setMineInformation() {
       
     }
}
