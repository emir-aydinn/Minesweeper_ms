import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestClass {
    private static final int NUMBER_OF_MINES = 15;
    public static final int SIZE = 20;
    static Connection connection;
    
    public static void getConnection() {
    	String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Ms;instance=MSSQLSERVER;encrypt=true;TrustServerCertificate=true;";
    	String user = "fth";
    	String pass = "fth1234";
    	try {
    	connection = DriverManager.getConnection(dbURL,user,pass);
    	
    	
    	System.out.println("Connected to db");
    	}
    	catch (SQLException e) {
    		System.out.println("Oops, there is an error:");
    		e.printStackTrace();
    	}
    }
    public static void insertSQL() {
    	try {
    	String sql = "INSERT INTO Ms (name,time)" 
    			+ "VALUES (?, ?)";
    	PreparedStatement statement = connection.prepareStatement(sql);
    	statement.setString(1,MineSweeperGUI.username);
    	statement.setInt(2,MineSweeperGUI.seconds + MineSweeperGUI.minutes*60);
    	int data = statement.executeUpdate();
    	if(data > 0) {
    		System.out.println("Data has been inserted");
    }
   }
    	catch (SQLException e) {
    		System.out.println("Oops, there is an error:");
    		e.printStackTrace();
    	}
    }
    
    public static void main(String[] args) {
        getConnection();
        JFrame frame = new JFrame("Mine sweeper " + NUMBER_OF_MINES);
        frame.add(new MineSweeperGUI(SIZE,SIZE,NUMBER_OF_MINES));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setVisible(true);
        
    }
  
}
