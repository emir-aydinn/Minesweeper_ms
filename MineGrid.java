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
    
    public void openNeighbourCells(int r, int c) {
        if (r < 0 || r >= TestClass.SIZE || c < 0 || c >= TestClass.SIZE || buttonInformation[r][c].isEnabled() == false) {
            return;
        } else if (mineInformation[r][c] != 0) {
            buttonInformation[r][c].setText((String.valueOf(mineInformation[r][c])));
            buttonInformation[r][c].setEnabled(false);
        } else {
            buttonInformation[r][c].setEnabled(false);
            openNeighbourCells(r - 1, c);
            openNeighbourCells(r + 1, c);
            openNeighbourCells(r, c - 1);
            openNeighbourCells(r, c + 1);
            openNeighbourCells(r + 1, c + 1);
            openNeighbourCells(r - 1, c + 1);
            openNeighbourCells(r - 1, c - 1);
            openNeighbourCells(r + 1, c - 1);
        }
    }


    public int getCellContent(int i, int j) {
        return mineInformation[i][j];
    }

    private void incrementMineCountAt(int i, int j) {
        if (isInsideGrid(i, j) && !isMINE(i, j)) {
            mineInformation[i][j]++;
        }
    }

    private boolean isInsideGrid(int i, int j) {
        return (i >= 0 && i < mineInformation.length)
                && (j >= 0 && j < mineInformation[0].length);
    }

}
