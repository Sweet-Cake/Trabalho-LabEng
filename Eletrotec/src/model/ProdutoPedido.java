package model;

public class ProdutoPedido {
	private int id_pedido;
	private int id_produto;
	private int qta;
	private double preco_uni;
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public int getQta() {
		return qta;
	}
	public void setQta(int qta) {
		this.qta = qta;
	}
	public double getPreco_uni() {
		return preco_uni;
	}
	public void setPreco_uni(double preco_uni) {
		this.preco_uni = preco_uni;
	}
	
}
