package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Produto;
import model.Utensilio;
public class ProdutoDao {
	public void insert(Produto produto) {
		try {
			 Connection connection = (Connection) GenericDao.getInstance().getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produto (nome,marca,preco_uni,tipo,polegada) VALUES (?,?,?,?,?)");
	            preparedStatement.setString(1,  produto.getNome());
	            preparedStatement.setString(2,  produto.getMarca());
	            preparedStatement.setFloat(3,  produto.getPreco());
	            preparedStatement.setString(4,  produto.getTipo());
	            preparedStatement.setInt(5,  produto.getPolegada());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException | ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
	
	public Produto pesquisarProduto(String nome) throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM produto WHERE nome= ?");
			ps.setString(1,  nome);
			ResultSet rs = ps.executeQuery();
			Produto p = null;
			if (rs.next()) { 
				p = new Produto();
				p.setNome(rs.getString("nome"));
				p.setMarca(rs.getString("marca"));
				p.setPreco(rs.getFloat("preco_uni"));
				p.setTipo(rs.getString("tipo"));
				p.setPolegada(rs.getInt("polegada"));
			}
			return p;
		}
	public void alterar (Produto p)  throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("UPDATE produto SET marca=?, preco_uni=?, tipo=?, polegada=? WHERE nome= ?");
			ps.setString(1,  p.getMarca());
			ps.setFloat(2,  p.getPreco());
			ps.setString(3, p.getTipo());
			ps.setFloat(4, p.getPolegada());
			ps.setString(5,  p.getNome());
			ps.execute();
			ps.close();
	}
	
	public void Delete(String nome) throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("DELETE FROM produto WHERE nome= ?");
			ps.setString(1,  nome);
			ps.execute();
			ps.close();
	}
}
