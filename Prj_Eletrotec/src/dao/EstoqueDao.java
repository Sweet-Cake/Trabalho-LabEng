package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Estoque;

public class EstoqueDao implements IEstoqueDao {

	@Override
	public void insert(Estoque estoque) {
		try {
			 Connection connection = (Connection) GenericDao.getInstance().getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO estoque "
	            		+ "(qta) VALUES (?)");
	            preparedStatement.setInt(1,  estoque.getQta());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException | ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Estoque> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
