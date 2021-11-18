package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.qa.shoegle.jdbc.ShoegleJDBC;
import com.qa.springbootsw.ShoegleGrail;
import com.qa.springbootsw.Shoegleportfolio;

public class ShoegleDAO {

	ShoegleJDBC jdbc = new ShoegleJDBC();

	Statement statement;
	Connection connection;

	public Shoegleportfolio portfolioResultSet(ResultSet resultSet) throws SQLException {
		Long shoeid = resultSet.getLong("shoeID");
		String brand = resultSet.getString("Brand");
		String sillouhette = resultSet.getString("Sillouhette");
		String colourway = resultSet.getString("Colourway");
		int size = resultSet.getInt("Size");
		boolean collab = resultSet.getBoolean("Collab");
		double retailPrice = resultSet.getDouble("RetailPrice");
		double aftermarketPrice = resultSet.getDouble("AftermarketPrice");
		return new Shoegleportfolio(shoeid, brand, sillouhette, colourway, size, collab, retailPrice, aftermarketPrice);
	}

	public ShoegleGrail grailResultSet(ResultSet resultSet) throws SQLException {
		Long grailid = resultSet.getLong("grailID");
		String brand = resultSet.getString("Brand");
		String sillouhette = resultSet.getString("Sillouhette");
		String colourway = resultSet.getString("Colourway");
		int size = resultSet.getInt("Size");
		boolean collab = resultSet.getBoolean("Collab");
		double retailPrice = resultSet.getDouble("RetailPrice");
		double aftermarketPrice = resultSet.getDouble("AftermarketPrice");
		return new ShoegleGrail(grailid, brand, sillouhette, colourway, size, collab, retailPrice, aftermarketPrice);
	}
    //Create methods
	public void addShoePortfolio(Shoegleportfolio shoegleportfolio) {

		// statement = jdbc_setup connection
		// put that code in createStatement()
		// statement = conn.createStatement();
		try {
			connection = jdbc.connect();
			statement = connection.createStatement(); // a blank statement, what we send to the database
			String query = "INSERT INTO portfolio (Brand, Sillouhette,Colourway,Size,Collab,RetailPrice,AftermarketPrice) VALUES ('"
					+ shoegleportfolio.getBrand() + "'," + shoegleportfolio.getSillouhette() + ", '"
					+ shoegleportfolio.getColourway() + "', '" + shoegleportfolio.getSize() + "', '"
					+ shoegleportfolio.isCollab() + "', '" + shoegleportfolio.getRetailPrice() + "', '"
					+ shoegleportfolio.getAftermarketPrice() + "' )";
			statement.executeUpdate(query); // With the statement we've created, run the query we've passed in
			System.out.println(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void addShoeGrail(ShoegleGrail shoegleGrail) {

		// statement = jdbc_setup connection
		// put that code in createStatement()
		// statement = conn.createStatement();
		try {
			connection = jdbc.connect();
			statement = connection.createStatement(); // a blank statement, what we send to the database
			String query = "INSERT INTO portfolio (Brand, Sillouhette,Colourway,Size,Collab,RetailPrice,AftermarketPrice) VALUES ('"
					+ shoegleGrail.getBrand() + "'," + shoegleGrail.getSillouhette() + ", '"
					+ shoegleGrail.getColourway() + "', '" + shoegleGrail.getSize() + "', '"
					+ shoegleGrail.isCollab() + "', '" + shoegleGrail.getRetailPrice() + "', '"
					+ shoegleGrail.getAftermarketPrice() + "' )";
			statement.executeUpdate(query); // With the statement we've created, run the query we've passed in
			System.out.println(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//Read methods
	
	public Shoegleportfolio readshoes(Long shoeID) {
		try {
			connection = jdbc.connect();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM portfolio WHERE id = " + shoeID);{
				resultSet.next();		//.next() is an inbuilt java method, that moves through the SQL table
				return portfolioResultSet(resultSet);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ShoegleGrail readGrail(Long grailID) {
		try {
			connection = jdbc.connect();
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM grails WHERE id = " + grailID);{
				resultSet.next();		//.next() is an inbuilt java method, that moves through the SQL table
				return grailResultSet(resultSet);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	

	//UPDATE
	
	public Shoegleportfolio updateshoe(Shoegleportfolio shoegleportfolio) {
		try {
			connection = jdbc.connect();
			statement = connection.createStatement();
			statement.executeUpdate("UPDATE portfolio SET Brand = '" + shoegleportfolio.getBrand() 
			+ "' , sillouhette = '" + shoegleportfolio.getSillouhette() 
			+ "', Colourway = '" + shoegleportfolio.getColourway()
			+ "', Size = '" + shoegleportfolio.getSize()
			+ "', Collab = '" + shoegleportfolio.isCollab()
			+ "', RetailPrice = '" + shoegleportfolio.getRetailPrice()
			+ "', AftermarketPrice = '" + shoegleportfolio.getColourway()
			+ "' WHERE id = " +shoegleportfolio.getShoeid());
			return readshoes(shoegleportfolio.getShoeid());
			
			} catch (SQLException e) {
				e.printStackTrace();
		}
		return null;
	}
	
	public ShoegleGrail updateGrail(ShoegleGrail shoegleGrail) {
		try {
			connection = jdbc.connect();
			statement = connection.createStatement();
			statement.executeUpdate("UPDATE portfolio SET Brand = '" + shoegleGrail.getBrand() 
			+ "' , sillouhette = '" + shoegleGrail.getSillouhette() 
			+ "', Colourway = '" + shoegleGrail.getColourway()
			+ "', Size = '" + shoegleGrail.getSize()
			+ "', Collab = '" + shoegleGrail.isCollab()
			+ "', RetailPrice = '" + shoegleGrail.getRetailPrice()
			+ "', AftermarketPrice = '" + shoegleGrail.getColourway()
			+ "' WHERE id = " +shoegleGrail.getGrailid());
			return readGrail(shoegleGrail.getGrailid());
			
			} catch (SQLException e) {
				e.printStackTrace();
		}
		return null;
	}
	
	
	//DELETE
	
		public Shoegleportfolio deleteshoe(Long shoeID) {
			try {
				connection = jdbc.connect();
				statement = connection.createStatement();
				statement.executeUpdate("DELETE FROM portfolio WHERE shoeID = " + shoeID);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public ShoegleGrail deleteGrail(Long grailID) {
			try {
				connection = jdbc.connect();
				statement = connection.createStatement();
				statement.executeUpdate("DELETE FROM grails WHERE shoeID = " + grailID);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}
