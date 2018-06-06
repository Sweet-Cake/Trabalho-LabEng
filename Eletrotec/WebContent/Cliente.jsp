<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.*, dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link rel="stylesheet" type="text/css" href="css/estilo.css"/>
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   	<script src="script.js"></script>
	<title>EletroTec Cliente</title>
<head>
<body>
	<div id='cssmenu'>
		<ul>
		   <li><a href='Index.jsp'>Home</a></li>
		   <li class='active'><a href='#'>Cliente</a></li>
		   <li><a href='Produto.jsp'>Produtos</a></li>
		   <li><a href='Pedido.jsp'>Pedidos</a></li>
		   <li><a href='Utensilio.jsp'>Utensilio</a></li>
		</ul>
	</div>
	<div class="cont" style="width:450px; height:480px;">
		<form method="POST" action="./controleCliente">
		<% 	
			Cliente c = (Cliente) request.getAttribute("CLIENTE");
		  	if( c == null) { 
				c = new Cliente();
		   	}
		%>
			<label style="margin:0;">Nome:</label>	<input type="text" name="nome"value="<%=c.getNome()%>" class="input_login" placeholder="Nome:"/>
			<label style="margin:0;">CPF:</label>	<input type="text" id="cpf"name="cpf"value="<%=c.getCPF()%>" class="cpf" placeholder="CPF:"/>
			<label style="margin:0;">Tel:</label>	<input type="text" name="telefone"value="<%=c.getTelefone()%>" class="tel" placeholder="Telefone1:"/>
				<label style="margin:0;">Cel:</label><input type="text" name="celular"value="<%=c.getCelular()%>" class="tel" placeholder="Telefone2:" style="margin-right:28%;"/>
				<label style="margin:15px;">Logradouro:</label><input type="text" name="logradouro"value="<%=c.getLogradouro()%>" class="input_login" placeholder="Logadouro:" style="width:200px;margin-left:0%;"/>
				<label style="margin:0;">N°:</label><input type="text" name="numero"value="<%=c.getNumero()%>" class="input_login" placeholder="N°" style="width:50px;margin-left:5%;"/>
				<label style="margin:0;">Bairro:</label><input type="text" name="bairro"value="<%=c.getBairro()%>" class="cpf" placeholder="bairro"/>
			<label style="margin:0;">Cidade:</label>	<input type="text" name="cidade"value="<%=c.getCidade()%>" class="cpf" placeholder="Cidade"  style="width:100px;"/>
				<input type="submit" name="cmd" value="Adicionar"class="btn_entrar" style="width:70px;"/>	
				<input type="submit" name="cmd"value="Consultar" class="btn_entrar" style="width:70px;"/>
				<input type="submit" name="cmd"value="Alterar" class="btn_entrar" style="width:70px;"/>				
		</form>	
	</div>
			<script src="https://code.jquery.com/jquery-1.10.1.js" integrity="sha256-663tSdtipgBgyqJXfypOwf9ocmvECGG8Zdl3q+tk+n0=" crossorigin="anonymous"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#cpf').click(function(){
					$('#cpf').val("");
				});
			});
		</script>
</body>
</html>