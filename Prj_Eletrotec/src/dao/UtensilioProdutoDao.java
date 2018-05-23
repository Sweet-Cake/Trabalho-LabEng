package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.UtensilioProduto;

public class UtensilioProdutoDao implements IUtensilioProdutoDao {

	@Override
	public void insert(UtensilioProduto utensilioProduto) {
		try {
			 Connection connection = (Connection) GenericDao.getInstance().getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Utensilioproduto "
	            		+ "(qta) VALUES (?)");
	            preparedStatement.setInt(1,  utensilioProduto.getQta());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException | ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

	@Override
	public List<UtensilioProduto> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
