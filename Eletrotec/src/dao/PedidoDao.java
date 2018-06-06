package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import model.Utensilio;

public class PedidoDao {
	public Cliente buscaCliente(String cpf) throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM cliente WHERE cpf = ?");
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();
		Cliente c = null;
		if (rs.next()) {
			c = new Cliente();
			c.setNome(rs.getString("nome"));
			c.setCPF(rs.getString("cpf"));
		}
		return c;
	}

	public Produto buscaProduto(String nome) throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM produto WHERE nome = ?");
		ps.setString(1, nome);
		ResultSet rs = ps.executeQuery();
		Produto p = null;
		if (rs.next()) {
			p = new Produto();
			p.setNome(rs.getString("nome"));
			p.setPreco(rs.getFloat("preco_uni"));
		}
		return p;
	}

	public Utensilio buscaUtensilio(String nome) throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM utensilio WHERE nome = ?");
		ps.setString(1, nome);
		ResultSet rs = ps.executeQuery();
		Utensilio u = null;
		if (rs.next()) {
			u = new Utensilio();
			u.setNome(rs.getString("nome"));
			u.setPreco(rs.getFloat("preco_uni"));
		}
		return u;
	}

	public void AdicionaPedido(Pedido p, UtensilioPedido[] up, ProdutoPedido [] pp)
			throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
		PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO pedidos (id ,estado,cpf) VALUES ( ?, ?, ?)");
		ps.setInt(1, p.getIdPedido());
		ps.setString(2, p.getStatus());
		ps.setString(3, p.getCpf());
		ps.setDouble(4, p.getPrecoFinal());
		ps.executeQuery();
		for (UtensilioPedido utp : up){
			ps = connection.prepareStatement(
					"INSERT INTO utensiliopedido (id_pedido ,id_utensilio,qtd_utensilio, precou ) VALUES (?, ?, ?, ?)");
			ps.setInt(1, p.getIdPedido());
			ps.setInt(2, utp.getId_utensilio());
			ps.setInt(3, utp.getQta());
			ps.setDouble(4, utp.getPreco_uni());
			ps.executeQuery();
		}
		for (ProdutoPedido prp : pp){
			ps = connection.prepareStatement(
					"INSERT INTO produtopedido (id_pedido ,id_produto,qtd_produto, precop ) VALUES (?, ?, ?, ?)");
			ps.setInt(1, p.getIdPedido());
			ps.setInt(2, prp.getId_produto());
			ps.setInt(3, prp.getQta());
			ps.setDouble(4, prp.getPreco_uni());
			ps.executeQuery();
		}
		ps.close();
	}
	
	public void AlteraPedido(Pedido p, UtensilioPedido [] up, ProdutoPedido [] pp)
			throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
		PreparedStatement ps = connection.prepareStatement(
				"UPDATE pedidos SET estado =  ? WHERE id = ?");
		ps.setString(1, p.getStatus());
		ps.setInt(2, p.getIdPedido());
		ps.executeQuery();
		for (UtensilioPedido utp : up){
			ps = connection.prepareStatement(
					"INSERT INTO utensiliopedido (id_pedido ,id_utensilio,qtd_utensilio, precou ) VALUES (?, ?, ?, ?)");
			ps.setInt(1, p.getIdPedido());
			ps.setInt(2, utp.getId_utensilio());
			ps.setInt(3, utp.getQta());
			ps.setDouble(4, utp.getPreco_uni());
			ps.executeQuery();
		}
		for (ProdutoPedido prp : pp){
			ps = connection.prepareStatement(
					"INSERT INTO produtopedido (id_pedido ,id_produto,qtd_produto, precop ) VALUES (?, ?, ?, ?)");
			ps.setInt(1, p.getIdPedido());
			ps.setInt(2, prp.getId_produto());
			ps.setInt(3, prp.getQta());
			ps.setDouble(4, prp.getPreco_uni());
			ps.executeQuery();
		}
		ps.close();
	}
	
}