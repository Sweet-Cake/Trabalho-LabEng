package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDao {

	private Connection c;
	private static GenericDao instancia;

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		String hostName = "localhost";
		String dbName = "eletrotec";
		String user = "root";
		String senha = "1234";
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://" + hostName + ":3306/" + dbName, user, senha);

		return c;
	}

	public static GenericDao getInstance() {
		if (instancia == null)
			instancia = new GenericDao();
		return instancia;
	}

}