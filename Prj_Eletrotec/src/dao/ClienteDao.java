package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Cliente;

public class ClienteDao implements IClienteDao {

	@Override
	public void insert(Cliente cliente) {
		 try {
			 Connection connection = (Connection) GenericDao.getInstance().getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cliente "
	            		+ "(nome ,telefone, celular, cep, logradouro, numero, bairro, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	            preparedStatement.setString(1,  cliente.getNome());
	            preparedStatement.setString(2, cliente.getTelefone());
	            preparedStatement.setString(3,  cliente.getCelular());
	            preparedStatement.setString(4,  cliente.getCep());
	            preparedStatement.setString(5, cliente.getLogradouro());
	            preparedStatement.setInt(6, cliente.getNumero());
	            preparedStatement.setString(7, cliente.getBairro());
	            preparedStatement.setString(8, cliente.getCep());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException | ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

	@Override
	public List<Cliente> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
