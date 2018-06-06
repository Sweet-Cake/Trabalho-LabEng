<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.*, dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/estilo.css"/>
	<title>Produto</title>
</head>
		<% 	
			Produto p = (Produto) request.getAttribute("PRODUTO");
		  	if( p == null) { 
				p = new Produto();
		   	}
		%>
<body>
	<div id='cssmenu'>
		<ul>
		   <li ><a href='Index.jsp'>Home</a></li>
		   <li><a href='Cliente.jsp'>Cliente</a></li>
		   <li class='active'><a href='#'>Produtos</a></li>
		   <li><a href='#'>Pedidos</a></li>
		   <li><a href='Utensilio.jsp'>Utensilio</a></li>
		</ul>
	</div>
	<h1 align="center">PRODUTO</h1>
	<div class="contain2" style="width:450px;">
		<form action="./controleProduto" method="POST">
				<label style="margin-left:0;">Nome:</label><input type="text" id="nome"name="nome" class="nome" value="<%=p.getNome() %>" placeholder="Nome:"/>
				<label style="margin-left:20px;">Marca:</label><input type="text" id="marca" name="marca" class="quant" value="<%=p.getMarca()%>"placeholder="Marca"/>
				<label style="margin-left:20px;">Preço</label><input type="text" id="preco"name="preco" class="quant" value="<%=p.getPreco()%>"placeholder="Preco Uni"/>	
				<label>Tipo:</label>
				<select name="tipo" id="tipo">
					<option value="<%=p.getTipo()%>"></option>
					<option>--</option>
					<option value="Televisao">Televisão</option>
					<option>Som</option>
					<option>DVD</option>
					<option>Auto Falante</option>
				</select>		
				<input type="text" id="poleg"name="poleg" class="quant" value="<%=p.getPolegada()%>"placeholder="Polegada"/>
				<input type="submit" name="cmd" value="Adicionar" class="btn_entrar2"/>
				<input type="submit"  name="cmd" value="Consultar" class="btn_entrar2"/>
				<input type="submit"  name="cmd" value="Alterar" class="btn_entrar2"/>
				<input type="submit"  name="cmd" value="Deletar" class="btn_entrar2"/>
		</form>
		<script src="https://code.jquery.com/jquery-1.10.1.js" integrity="sha256-663tSdtipgBgyqJXfypOwf9ocmvECGG8Zdl3q+tk+n0=" crossorigin="anonymous"></script>
		<script type="text/javascript">
			$(document).ready(function(){
			$('#tipo').change(function(){
			var ss=$('#tipo option:selected').val();
				if(ss=="Televisao"){
					 document.getElementById("poleg").disabled = false;
				}else{
					document.getElementById("poleg").value = 0;
				}
			});
			});
			$(document).ready(function(){
				$('#nome').click(function(){
					$('#nome').val("");
				});
			});
		</script>
	</div>	
</body>
</html>