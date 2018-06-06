package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Produto;
import model.Utensilio;

public class UtensilioDao {
	public void insert(Utensilio utensilio) {
		try {
			 Connection connection = (Connection) GenericDao.getInstance().getConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO utensilio (nome,quant,preco_uni) VALUES (?,?,?)");
	            preparedStatement.setString(1,  utensilio.getNome());
	            preparedStatement.setInt(2,  utensilio.getQuant());
	            preparedStatement.setFloat(3,  utensilio.getPreco());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException | ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}

	public Utensilio pesquisarPorNome(String nome) throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM utensilio WHERE nome= ?");
			ps.setString(1,  nome);
			ResultSet rs = ps.executeQuery();
			Utensilio u = null;
			if (rs.next()) { 
				u = new Utensilio();
				u.setNome(rs.getString("nome"));
				u.setQuant(rs.getInt("quant"));
				u.setPreco(rs.getFloat("preco_uni"));
			}
			return u;
	}
	public void alterar (Utensilio u)  throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("UPDATE utensilio SET nome=?, quant=?, preco=? WHERE nome= ?");
			ps.setString(1,  u.getNome());
			ps.setInt(2, u.getQuant());
			ps.setFloat(3, u.getPreco());
			ps.setString(4,  u.getNome());
			ps.execute();
			ps.close();
	}
	
	public void Delete(String nome) throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) GenericDao.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement("DELETE FROM utensilio WHERE nome= ?");
			ps.setString(1,  nome);
			ps.execute();
			ps.close();
	}
	
}