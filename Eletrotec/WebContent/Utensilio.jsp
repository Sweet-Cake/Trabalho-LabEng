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
	<% 	
		Utensilio u = (Utensilio) request.getAttribute("UTENSILIO");
	  	if( u == null) { 
			u = new Utensilio();
	   	}
	   
	%>
	
</head>
<body>
	<div id='cssmenu'>
		<ul>
		   <li ><a href='Index.jsp'>Home</a></li>
		   <li><a href='Cliente.jsp'>Cliente</a></li>
		   <li><a href='Produto.jsp'>Produtos</a></li>
		   <li><a href='#'>Pedidos</a></li>
		   <li class='active'><a href='#'>Utensilio</a></li>
		</ul>
	</div>
	<h1 align="center">Utensílio</h1>
	<div class="contain" style="width:420px;">
		<form action="./controleUtensilio" method="POST">
			<label style="margin-left:1px;">Nome:</label>	<input type="text" id="nome" name="nome" class="nome" value="<%=u.getNome() %>" style="width:220px;"/>
			<label> Qtd:</label><input type="text" id="quant" name="quant" class="quant" value="<%=u.getQuant() %>"/>
				<label style="margin-left:1px;">Preço:</label><input type="text" id="preco"name="preco" class="quant" value="<%=u.getPreco() %>"/>			
				<input type="submit" name="cmd" value="Adicionar" class="btn_entrar2"/>
				<input type="submit"  name="cmd" value="Consultar" class="btn_entrar2"/>
				<input type="submit"  name="cmd" value="Alterar" class="btn_entrar2"/>
				<input type="submit"  name="cmd" value="Deletar" class="btn_entrar2"/>
		</form>
	</div>	
	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#nome').click(function(){
			$('#nome').val("");
		});
		});
	</script>
</body>
</html>