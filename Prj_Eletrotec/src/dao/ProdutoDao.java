package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Produto;

public class ProdutoDao implements IProdutoDao {

	@Override
	public void insert(Produto produto) {
		 try {
			 Connection connection = (Connection) GenericDao.getInstance().getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto "
	            		+ "(nome ,polegada, preco_unitario) VALUES (?, ?, ?)");
	            preparedStatement.setString(1,  produto.getNome());
	            preparedStatement.setInt(2, produto.getPolegada());
	            preparedStatement.setDouble(3,  produto.getPreco_unitario());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException | ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Produto> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
