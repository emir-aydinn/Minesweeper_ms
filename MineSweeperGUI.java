import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MineSweeperGUI extends JPanel {
  
  public MineGrid grid;
  public int col, row;
  public JButton[][] myButton;
  public static Timer timer;
  public static int seconds = 0;
  public static int minutes = 0;
  final private int delay = 1000;
  public static String username;
  JTextField counter = new JTextField();
  JTextField user = new JTextField();
  
  public MineSweeperGUI(int numRows,int numCols,int numMines){
    setSize(1200,850);
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    username =JOptionPane.showInputDialog(null, "Enter your username");
        while (username.equals("")){
            JOptionPane.showMessageDialog(null, "You must enter a username");
            username =JOptionPane.showInputDialog(null, "Enter your username");
        }
    
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
     panel.setLayout(new java.awt.FlowLayout());
     panel.setSize(950, 750);
     panel1.setLayout(new java.awt.GridLayout(20, 20));
     panel1.setPreferredSize(new Dimension(1000, 700));
     panel2.setLayout(new java.awt.GridLayout(2,1, 100, 100));
     panel2.setSize(200,400);
     counter.setHorizontalAlignment(JTextField.CENTER);
     counter.setEditable(false);
     counter.setText("Counter");
     Font font1 = new Font("SansSerif", Font.BOLD, 30);
     counter.setFont(font1);

     user.setHorizontalAlignment(JTextField.CENTER);
     user.setEditable(false);
     user.setText(username);
     user.setFont(font1);

     panel2.add(counter);
     panel2.add(user);

     panel.add(panel1, FlowLayout.LEFT);
     panel.add(panel2);
     timer = new Timer(delay, taskPerformer);
     timer.start();
     panel.add(panel1);
     add(panel, FlowLayout.LEFT);
    
  }
  
    final private ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            if(seconds < 59) {
                seconds++;
            }
            else {
                minutes++;
                seconds = 0;
            }
            counter.setText(minutes + " : " + seconds);
        }
    };
  
  
}
