package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;
import model.Utensilio;

public class ClienteDao {
	
	public void adicionar(Cliente cliente) {
		try {
			Connection connection = (Connection) GenericDao.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cliente "
					+ "(nome ,cpf,telefone, celular, logradouro, numero, bairro, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCPF());
			preparedStatement.setString(3, cliente.getTelefone());
			preparedStatement.setString(4, cliente.getCelular());
			preparedStatement.setString(5, cliente.getLogradouro());
			preparedStatement.setInt(6, cliente.getNumero());
			preparedStatement.setString(7, cliente.getBairro());
			preparedStatement.setString(8, cliente.getCidade());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Cliente pesquisaCliente(String cpf) throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM cliente WHERE cpf= ?");
			ps.setString(1,  cpf);
			ResultSet rs = ps.executeQuery();
			Cliente c = null;
			if (rs.next()) { 
				c = new Cliente();
				c.setNome(rs.getString("nome"));
				c.setCPF(rs.getString("cpf"));
				c.setTelefone(rs.getString("telefone"));
				c.setCelular(rs.getString("celular"));
				c.setLogradouro(rs.getString("logradouro"));
				c.setNumero(rs.getInt("numero"));
				c.setBairro(rs.getString("bairro"));
				c.setCidade(rs.getString("cidade"));
			}
			return c;
	}
	
	public void alterar(Cliente cliente) {
		try {
			Connection connection = (Connection) GenericDao.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cliente SET telefone = ?, celular = ?, logradouro = ?, numero = ?, bairro = ?, cidade = ? WHERE cpf = ?");
			preparedStatement.setString(1, cliente.getTelefone());
			preparedStatement.setString(2, cliente.getCelular());
			preparedStatement.setString(3, cliente.getLogradouro());
			preparedStatement.setInt(4, cliente.getNumero());
			preparedStatement.setString(5, cliente.getBairro());
			preparedStatement.setString(6, cliente.getCidade());
			preparedStatement.setString(7, cliente.getCPF());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
