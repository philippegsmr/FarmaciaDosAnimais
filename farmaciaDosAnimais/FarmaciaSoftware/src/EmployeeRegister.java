import java.sql.*;

public class EmployeeRegister extends Register{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Employee employee;
	
	public EmployeeRegister() throws SQLException{
		super();
		this.employee = new Employee();
	}
	
	public EmployeeRegister(Employee employee) throws SQLException{
		super();
		this.employee = employee;
		this.conn = this.getConnection();
	}
	/*
	 * creates the Employee Table, if it has not been created
	 * otherwise just skipps it
	 */
	public void createTableEmployee() throws SQLException{
		
		String query =  "CREATE TABLE IF NOT EXISTS Employees(id INT NOT NULL AUTO_INCREMENT, " +
						"PRIMARY KEY(id)," +
						"name VARCHAR(100) NOT NULL," +
						"previousEmployed BOOL NOT NULL," +
						"birthday DATE NOT NULL," +
						"socialSecurity VARCHAR(30)," +
						"salary FLOAT NOT NULL," +
						"startingDate DATE NOT NULL," +
						"telephone VARCHAR(20) NOT NULL" + 
						"region VARCHAR(50) NOT NULL," +
						"city VARCHAR(50) NOT NULL," +
						"state VARCHAR(50) NOT NULL," +
						"country VARCHAR(50) NOT NULL,	" +
						"address VARCHAR(100) NOT NULL)ENGINE=INNODB";
			
		try{
			
			try{
					Statement st = this.conn.createStatement();
					st.execute(query);
					System.out.println("Table Employee created with success!");
				}
			catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Table already exists");
				}
			this.conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	/*
	 * MySQL query to add a new employee into the database
	 */
	public int addNewEmployee(){
		String count = "SELECT COUNT(*) from Employees";
		
		try{
			Statement st = this.conn.createStatement();
			ResultSet resultSet = st.executeQuery(count);

			// Get the number of rows from the result set
			resultSet.next();
			// this is the employee's id
			Integer rowcount = resultSet.getInt(1);
			
			String query =  "INSERT INTO Employees VALUES("+ rowcount.toString() + ", " + this.employee.formatToString() + ")";
			
			st.execute(query);
			
			return 0;
							
		}
		catch(SQLException e){
			System.out.println("Failed to add a new employee");
			return -1;
			
		}

	}
	
	public int updateEmployeeInformation(){
		
		try{
			Statement st = this.conn.createStatement();
			String query = "UPDATE Employees SET col_string='a new string' WHERE col_string = 'a string'";
		    int updateCount = st.executeUpdate(query);
		    System.out.println(updateCount);
		    return 0;
		}
		catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public int deleteEmployee(Integer employeeId){
		
		try{
			Statement st = this.conn.createStatement();
			String query = "DELETE * FROM Employees WHERE employeeId=" + employeeId.toString();
			st.execute(query);
			return 0;
		}
		catch(SQLException e){
			System.out.println("Failed to add a new employee");
			return -1;
		}
		
	}
}
