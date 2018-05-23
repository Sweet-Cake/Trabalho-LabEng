package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Utensilio;

public class UtensilioDao implements IUtensilioDao {

	@Override
	public void insert(Utensilio utensilio) {
		try {
			 Connection connection = (Connection) GenericDao.getInstance().getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO utensilio "
	            		+ "(nome ,preco) VALUES (?, ?)");
	            preparedStatement.setString(1,  utensilio.getNome());
	            preparedStatement.setDouble(2, utensilio.getPreco());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException | ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Utensilio> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
