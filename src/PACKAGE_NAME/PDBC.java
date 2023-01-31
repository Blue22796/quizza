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
					"jdbc:mysql://localhost:3300/?user=root","root","zinji6mil");
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
		st.execute("insert into aaa.problem(rate,statement) values ("
				+prob.getRate()+",'"+prob.getProblemStatement()+"')");
		}
	
	public ArrayList<Problem> getProblems(){
		ArrayList<Problem> probs= new ArrayList<Problem>();
		try {
			ResultSet rs = getInstance().cnct.createStatement().executeQuery("select statement,rate from aaa.problem");
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
