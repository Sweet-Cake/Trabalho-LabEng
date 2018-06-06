package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDao;
import dao.UtensilioDao;
import model.Cliente;
import model.Pedido;
import model.Produto;
import model.Utensilio;

/**
 * Servlet implementation class controlePedido
 */
@WebServlet("/controlePedido")
public class controlePedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controlePedido() {
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
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");
		String cpf = request.getParameter("cpf");
		//String nomeCliente=request.getParameter("nomeCliente");
		String nomeProduto=request.getParameter("produto");
		//int qtdP=Integer.parseInt(request.getParameter("quant"));
		//float precoP = Float.parseFloat(request.getParameter("price"));
		String nomeUtensilio = request.getParameter("utensilio");
		//int qtdU= Integer.parseInt(request.getParameter("qtd"));
		//float precoU = Float.parseFloat(request.getParameter("preco"));
		PedidoDao dao= new PedidoDao();
		System.out.println(cmd);
		if ("Consultar".equalsIgnoreCase(cmd)) { 
			try {
				Cliente c=dao.buscaCliente(cpf);
				out.print(c.getNome());
				out.flush();
				out.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("BuscarProduto".equalsIgnoreCase(cmd)) {
			try {
				Produto p=dao.buscaProduto(nomeProduto);
				out.print(p.getPreco());
				out.flush();
				out.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("BuscarUtensilio".equalsIgnoreCase(cmd)) {
			try {
				Utensilio u=dao.buscaUtensilio(nomeUtensilio);
				out.print(u.getPreco());
				out.flush();
				out.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("Salvar".equalsIgnoreCase(cmd)) {
			Pedido p = new Pedido();
			p.setIdPedido(Integer.parseInt(request.getParameter("idpedido")));
			p.setCpf(cpf);
			System.out.println(p.getIdPedido());
		}
	}
	

}
