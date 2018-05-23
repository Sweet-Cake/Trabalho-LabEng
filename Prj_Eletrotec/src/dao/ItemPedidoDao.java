package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.ItemPedido;

public class ItemPedidoDao implements IItemPedidoDao {

	@Override
	public void insert(ItemPedido itemPedido) {
		try {
			 Connection connection = (Connection) GenericDao.getInstance().getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO itempedido "
	            		+ "(qta, preco_produto) VALUES (?, ?)");
	            preparedStatement.setInt(1,  itemPedido.getQta());
	            preparedStatement.setDouble(2, itemPedido.getPreco_produto());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException | ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

	@Override
	public List<ItemPedido> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
