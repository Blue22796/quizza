package PACKAGE_NAME;
import java.sql.*;
import java.util.ArrayList;

public class PDBC {
	private static PDBC instance = null;
	private Connection cnct=null;
	
	public static PDBC getInstance() {
		if(instance==null)
			instance= new PDBC();
		return instance;
	}
	
	private PDBC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnct = DriverManager.getConnection(
					"jdbc:mysql://sql7.freemysqlhosting.net:3306/?user=sql7597598","sql7597598","d4qUFWuFHs");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertProblem(Problem prob) throws SQLException {
		Statement st = cnct.createStatement();
		st.execute("insert into sql7597598.problem(rate,statement) values ("
				+prob.getRate()+",'"+prob.getProblemStatement()+"')");
		}
	
	public ArrayList<Problem> getProblems(){
		ArrayList<Problem> probs= new ArrayList<Problem>();
		try {
			ResultSet rs = getInstance().cnct.createStatement().executeQuery("select statement,rate from sql7597598.problem");
			while(rs.next()) {
				probs.add(new Problem(rs.getFloat("rate"),rs.getString("statement")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return probs;
	}
	
}
