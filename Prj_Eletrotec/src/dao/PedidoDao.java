package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Pedido;

public class PedidoDao implements IPedidoDao {

	@Override
	public void insert(Pedido pedido) {
		try {
			 Connection connection = (Connection) GenericDao.getInstance().getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pedido "
	            		+ "(data_inicio, data_final, valor_total) VALUES (?, ?, ?)");
	            preparedStatement.setDate(1,  (Date)pedido.getData_inicio());
	            preparedStatement.setDate(2, (Date)pedido.getData_final());
	            preparedStatement.setDouble(3,  pedido.getValor_total());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException | ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Pedido> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
