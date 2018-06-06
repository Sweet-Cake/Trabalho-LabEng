package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import dao.ProdutoDao;
import model.Produto;
import model.Utensilio;

/**
 * Servlet implementation class controleProduto
 */
@WebServlet("/controleProduto")
public class controleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controleProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String nome = request.getParameter("nome");
		String marca = request.getParameter("marca");
		String tipo=request.getParameter("tipo");
		int polegada = Integer.parseInt(request.getParameter("poleg"));
		Float preco = Float.parseFloat(request.getParameter("preco"));
		ProdutoDao dao = new ProdutoDao();
		if ("Adicionar".equalsIgnoreCase(cmd)) { 
			Produto p=new Produto();
			p.setNome(nome);
			p.setMarca(marca);
			p.setPolegada(polegada);
			p.setPreco(preco);
			p.setTipo(tipo);
			try {
				dao.insert(p);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if ("Consultar".equalsIgnoreCase(cmd)) {
			try {
				Produto p = dao.pesquisarProduto(nome);
				request.setAttribute("PRODUTO" , p );
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("Alterar".equalsIgnoreCase(cmd)) {
			Produto p=new Produto();
			try {
				p.setNome(nome);
				p.setMarca(marca);
				p.setPolegada(polegada);
				p.setPreco(preco);
				p.setTipo(tipo);
				dao.alterar(p);
				System.out.println("oi");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("Deletar".equalsIgnoreCase(cmd)) {
			try {
				dao.Delete(nome);
				System.out.println("passei");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Fazer o forward de volta para a pagina de produto
		RequestDispatcher rd = request.getRequestDispatcher("./Produto.jsp");
		rd.forward(request, response);
	}

}
