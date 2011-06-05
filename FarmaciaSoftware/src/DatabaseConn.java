import java.sql.*;

/*
 * class written by Philippe Gabriel Souza Moraes Ribeiro
 * Department of Computer Science, University of Minnesota
 * Minneapolis, Minnesota, USA - 55455
 * 
 * class DatabaseConn establishes a database Connection to a MySQL db
 * 
 */
public class DatabaseConn {

	// element to establish a connection
	private Connection conn;

	/*
	 * default constructor, only initializes the values
	 */
	public DatabaseConn(){
		this.conn = null;
	}
	
	/*
	 * establishes a connection and returns 
	 * a variable of the type Connection
	 * if an error happen, it throws a SQLException
	 * 
	 * SQLException needs to be handled appropriated
	 * 
	 */
	public Connection getConnection() throws SQLException {
		
		try{
			String userName = "philippe";
	        String password = ".E5TOMcC";
	        String url = "jdbc:mysql://localhost/test";
	        Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	        this.conn = DriverManager.getConnection (url, userName, password);
	        System.out.println ("Database connection established");
	    }
	    catch (Exception e){
	        System.err.println ("Cannot connect to database server");
	    }
	    
	    return this.conn;
	  }

	/*
	 *	function closeConnection closes the db connection
	 *	returns a void value.
	 * 
	 */
	public void closeConnection(){
		
		if(this.conn != null){
			
			try{
				//closes the database Connection
				this.conn.close();
				System.out.println("Database connection terminated successfully");
			}
			
			catch(Exception e){
				System.out.println("An error happened during the attempt to close the connection");
			}
		}
		else{
			System.out.println("Connection was an invalid value (null)");
		}
	}
	
}
