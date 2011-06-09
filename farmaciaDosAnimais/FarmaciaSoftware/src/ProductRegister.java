
import java.sql.*;

public class ProductRegister extends Register {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;
	private Connection conn;
	
	public ProductRegister() throws SQLException {
		// TODO Auto-generated constructor stub
		super();
	}
	
	/*
	 * sets up the product and makes the database connection;
	 */
	public ProductRegister(Product product) throws SQLException{
		this.product = product;
		this.conn = this.getConnection();
	}
	
	public void createProductTable(){
		String query =  "CREATE TABLE IF NOT EXISTS Products(id INT NOT NULL AUTO_INCREMENT, " +
		"PRIMARY KEY(id)," +
		"name VARCHAR(100)" + 	
		"unity VARCHAR(7) NOT NULL," +
		"quantity INT NOT NULL," +
		"priceCash FLOAT NOT NULL," +
		"priceTerm FLOAT NOT NULL," +
		"finalPrice FLOAT NOT NULL," +
		"description VARCHAR(100) NOT NULL)ENGINE=INNODB";

		try{

			try{
				Statement st = this.conn.createStatement();
				st.execute(query);
				System.out.println("Table Products created with success!");
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
	
	public void updateProductInformation(){
		
		try{
			Statement st = this.conn.createStatement();
			String query = "UPDATE Produtcs SET col_string='a new string' WHERE col_string = 'a string'";
		    int updateCount = st.executeUpdate(query);
		    System.out.println(updateCount);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public int addNewProduct(){
		try{
			Statement st = this.conn.createStatement();
			
			String count = "SELECT COUNT(*) FROM Products";
			ResultSet resultSet = st.executeQuery(count);
			// Get the number of rows from the result set
			resultSet.next();
			// this is the employee's id
			Integer rowcount = resultSet.getInt(1);
			String query = "INSERT INTO Products VALUES(" + rowcount.toString() + ", " + this.product.formatToString() + ")";
			st.execute(query);
			
			return 0;
		}
		catch(SQLException e){
			
			return -1;
		}
	}
	
	public int deleteProduct(Integer id){
		try{
			Statement st = this.conn.createStatement();
			String query = "DELETE * FROM Products WHERE id=" + id.toString();
			st.execute(query);
			
			System.out.println("Successful deleted");
			return 0;
		}
		catch(SQLException e){
			return -1;
		}
	}
	

}