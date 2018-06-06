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

import dao.UtensilioDao;
import model.Utensilio;

/**
 * Servlet implementation class controleUtensilio
 */
@WebServlet("/controleUtensilio")
public class controleUtensilio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controleUtensilio() {
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
		int quant = Integer.parseInt(request.getParameter("quant"));
		Float preco = Float.parseFloat(request.getParameter("preco"));
		UtensilioDao dao = new UtensilioDao();
		if ("Adicionar".equalsIgnoreCase(cmd)) { 
			Utensilio uten = new Utensilio();
			uten.setNome( nome );
			uten.setQuant ( quant );
			uten.setPreco(preco);
			try {
				dao.insert(uten);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if ("Consultar".equalsIgnoreCase(cmd)) {
			try {
				Utensilio u = dao.pesquisarPorNome(nome);
				request.setAttribute("UTENSILIO" , u );
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("Alterar".equalsIgnoreCase(cmd)) {
			Utensilio u=new Utensilio();
			try {
				u.setNome(nome);
				u.setPreco(preco);
				u.setQuant(quant);
				dao.alterar(u);
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
		RequestDispatcher rd = request.getRequestDispatcher("./Utensilio.jsp");
		rd.forward(request, response);
	}
}

