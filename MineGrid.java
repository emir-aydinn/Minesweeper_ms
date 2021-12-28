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
     public void shareButtons(JButton buttonArray[][]) {
        buttonInformation = buttonArray;
        System.out.println("Row : " + buttonInformation.length + " Col : " + buttonInformation[0].length);
    }
     private void initializeCells() {
        for (int i = 0; i < mineInformation.length; i++) {
            for (int j = 0; j < mineInformation[0].length; j++) {
                mineInformation[i][j] = 0;
            }
        }
     }
     private void placeMines(int numMines) {
        Random random = new Random();
        for (int i = 0; i < numMines; i++) {
            int r = random.nextInt(mineInformation.length);
            int c = random.nextInt(mineInformation[0].length);
            if (mineInformation[r][c] != MINE) {
                mineInformation[r][c] = MINE;
            } else {
                i--;
            }
        }
     }
     public void openRemainCells() {

        for (int i = 0; i < mineInformation.length; i++) {
            for (int j = 0; j < mineInformation[0].length; j++) {
                if (buttonInformation[i][j].getText().length()==0) {
                    buttonInformation[i][j].setText("" + mineInformation[i][j]);
                }

            }
        }
    }
    public boolean isClear() {
        int counter = 0;
        for (int i = 0; i < mineInformation.length; i++) {
            for (int j = 0; j < mineInformation[0].length; j++) {
                if (buttonInformation[i][j].getText().length()== 0) {
                    continue;
                }
                if ((buttonInformation[i][j].getText().charAt(0) == 'F' && mineInformation[i][j] == -1)
                        || (buttonInformation[i][j].getText().charAt(0) == '-')) {
                    counter++;
                }
            }
        }
        System.out.println("Count : " + counter);
        if (counter == numOfMine) {
            openRemainCells();
            return true;
        } else {
            return false;
        }
    }

    public boolean isMINE(int i, int j) {
        return mineInformation[i][j] == MINE;
    }

    private void setMineInformation() {
        for (int i = 0; i < mineInformation.length; i++) {
            for (int j = 0; j < mineInformation[0].length; j++) {
                if (mineInformation[i][j] == MINE) {
                    incrementMineCountAt(i - 1, j - 1);
                    incrementMineCountAt(i - 1, j);
                    incrementMineCountAt(i - 1, j + 1);

                    incrementMineCountAt(i, j - 1);
                    incrementMineCountAt(i, j + 1);

                    incrementMineCountAt(i + 1, j - 1);
                    incrementMineCountAt(i + 1, j);
                    incrementMineCountAt(i + 1, j + 1);
                }
            }
        }
    }
public void showMine(){
        String s=System.getProperty("user.dir");
        s+="/Data/rsz_unnamed.png";
    ImageIcon TmpIcon=new ImageIcon(s);
    for(int r=0; r<mineInformation.length; r++){
        for(int c=0; c<mineInformation[0].length; c++){
            if(mineInformation[r][c]==-1){
                
               
                 buttonInformation[r][c].setIcon(TmpIcon);
                  
            }
        }
    }
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
