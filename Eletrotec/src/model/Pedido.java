package model;

public class Pedido {

private int idPedido;
	
	private String status;
	
	private String cpf;
	
	private String nomeCliente;
	
	/*private String nomeProduto;
	
	private int qtdProduto;
	
	private float precoProduto;
	
	private String nomeUtensilio;
	
	private int qtdUtensilio;
	
	private float precoUtensilio;
	*/
	private float precoFinal;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public float getPrecoFinal() {
		return precoFinal;
	}

	public void setPrecoFinal(float precoFinal) {
		this.precoFinal = precoFinal;
	}

}
