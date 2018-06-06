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

import dao.ClienteDao;
import dao.ProdutoDao;
import model.Cliente;
import model.Produto;

/**
 * Servlet implementation class controleCliente
 */
@WebServlet("/controleCliente")
public class controleCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controleCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String nome= request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		String celular=request.getParameter("celular");
		String logradouro=request.getParameter("logradouro");
		int numero=Integer.parseInt(request.getParameter("numero"));
		String bairro=request.getParameter("bairro");
		String cidade=request.getParameter("cidade");
		ClienteDao dao = new ClienteDao();
		if ("Adicionar".equalsIgnoreCase(cmd)) { 
			Cliente c= new Cliente();
			c.setNome(nome);
			c.setCPF(cpf);
			c.setTelefone(telefone);
			c.setCelular(celular);
			c.setLogradouro(logradouro);
			c.setNumero(numero);
			c.setBairro(bairro);
			c.setCidade(cidade);
			try {
				dao.adicionar(c);
				System.out.println("Passei Aqui");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if ("Consultar".equalsIgnoreCase(cmd)) {
			try {
				Cliente c =dao.pesquisaCliente(cpf);
				request.setAttribute("CLIENTE" , c );
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("Alterar".equalsIgnoreCase(cmd)) {
			Cliente c= new Cliente();
			c.setCPF(cpf);
			c.setTelefone(telefone);
			c.setCelular(celular);
			c.setLogradouro(logradouro);
			c.setNumero(numero);
			c.setBairro(bairro);
			c.setCidade(cidade);
			dao.alterar(c);
			System.out.println("oi");
		}
		// Fazer o forward de volta para a pagina de produto
		RequestDispatcher rd = request.getRequestDispatcher("./Cliente.jsp");
		rd.forward(request, response);
	}

}
