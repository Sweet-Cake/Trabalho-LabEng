<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.*, dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Pedido</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
</head>
<body>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#cliente').click(function(){
					var cpf=$('#cpf').val();
					var cmd =$('#cliente').val();
					$('#prods tr td').each(function(){
					      var texto = $(this).text();
					      alert(texto);
					});
					$.ajax({
						type: 'POST',
						data:{cpf: cpf,
							cmd: cmd},
						url: 'controlePedido',
						success:function(result){
							$('#nomeCliente').val(result);
						}
						
					});
				});
				$('#product').click(function(){
					var produto=$('#produto').val();
					var cmd =$('#product').val();
					$.ajax({
						type: 'POST',
						data:{produto: produto,
							cmd: cmd},
						url: 'controlePedido',
						success:function(result){
							$('#price').val(result);
						}
						
					});
				});
				$('#utensilio').click(function(){
					var utensilio=$('#uten').val();
					var cmd =$('#utensilio').val();
					$.ajax({
						type: 'POST',
						data:{utensilio: utensilio,
							cmd: cmd},
						url: 'controlePedido',
						success:function(result){
							$('#preco').val(result);
						}
						
					});
				});
				$('#salvar').click(function(){
					var produto=$('#produto').val();
					var idpedido=$('#idpedido').val();
					var produtos = document.getElementById('prods');
					alert(produtos.rows[0].cells[2].innerHTML);
					var cmd =$('#salvar').val();
					alert(cmd);
					$.ajax({
						type: 'POST',
						data:{produto: produto,
							idpedido: idpedido,
							cmd: cmd},
						url: 'controlePedido',
						success:function(result){
							$('#price').val(result);
						}
						
					});
				});
				
			});
		</script>
	<div id='cssmenu'>
		<ul>
		   <li><a href='Index.jsp'>Home</a></li>
		   <li><a href='Cliente.jsp'>Cliente</a></li>
		   <li><a href='Produto.jsp'>Produtos</a></li>
		   <li class='active'><a href='#'>Pedidos</a></li>
		   <li><a href='Utensilio.jsp'>Utensilio</a></li>
		</ul>
	</div>
	<h1 style="margin-bottom:-42px;">Pedido</h1>
	<label>N° Pedido:</label><input id="idpedido" type="text">
	<label>Status:</label>
	<select>
		<option>Solicitado</option>
		<option>Andamento</option>
		<option>Pronto</option>
	</select>
	<form>
		<div class="pt1">
			<h2 style="color:#000;">Cliente</h2>
			<label class="margin">CPF</label>
				<input type="text" name="cpf" id="cpf" value="">
				<input type="button" id="cliente" name="cmd"value="Consultar" class="btn">
			<label class="margin">Nome</label>
				<input type="text" style="width:250px;"name="nome" id="nomeCliente" value="">
		</div>
		<div class="pt1">
			<h2 style="color:#000;">Produto</h2>
			<label class="margin">Nome</label>
				<input type="text" name="produto"id="produto" value="">
				<input type="button" id="product"name="cmd" value="BuscarProduto" class="btn">
			<label class="margin">Quantidade</label>
				<input type="number" id="quant"style="width:100px;">
				<label class="margin">Preço</label>
				<input type="text" id="price" style="width:100px;" value="">
			<button type="button" onclick="return addHtmlTableRow1()">Adicionar</button>
			<button type="button" onclick="return editHtmlTbleSelectedRow1()">Editar</button>
		</div>
		<div class="pt1">
			<h2 style="color:#000;">Utensilio</h2>
			<label class="margin">Nome</label>
				<input type="text" id="uten" name="utensilio" value="">
				<input type="button" id="utensilio" name="cmd"value="BuscarUtensilio" class="btn">
			<label class="margin">Quantidade</label>
				<input type="number" id="qtd"style="width:100px;">
			<label class="margin">Preço</label>
				<input type="text" id="preco" style="width:100px;"value="">
			<button type="button" onclick="return addHtmlTableRow()">Adicionar</button>
			<button type="button" onclick="return editHtmlTbleSelectedRow()">Editar</button>
		</div>
		<div class="pt1">
		<table class="table-fill" id="table">
			<tr>
				<th class="text-left">Nome</th>
				<th class="text-left">Qtd</th>
				<th class="text-left">Preco</th>
				<th class="text-left">Ação</th>
			</tr>
			<tr>
				<td class="text-left">Auto Falante</td>
				<td class="text-left">10</td>
				<td class="text-left">150.00</td>
				<td class="text-left"><button type="button"onclick="deleteRow(this)"><i class="far fa-trash-alt"></i></button></a></td>
			</tr>
		</table>
		<table class="table-fill" style="float:right;margin:0px;position:absolute;left:600px;top:510px;" id="table1">
			<thead>
			<tr>
				<th class="text-left">Nome</th>
				<th class="text-left">Qtd</th>
				<th class="text-left">Preco</th>
				<th class="text-left">Acao</th>
			</tr>
			</thead>
			<tbody class="table-hover" id="prods">
			<tr>
				<td class="text-left">Auto Falante</td>
				<td class="text-left">10</td>
				<td class="text-left">R$150.00</td>
				<td class="text-left"><button type="button"onclick="deleteRow1(this)"><i class="far fa-trash-alt"></i></button></a></td>
			</tr>
			</tbody>
		</table>
		</div>
		<input type="submit" cmd="botao" id="salvar" value="Salvar" style="margin:2% 0% 0% 33%;">
	</form>
	<script>
		var rIndex,
	    table = document.getElementById("table");
		
	   function checkEmptyInput()
	   {
	       var isEmpty = false,
	           uten = document.getElementById("uten").value,
	           qtd = document.getElementById("qtd").value;
	       if(uten === ""){
	           alert("Utensilio Vazio, impossivel add");
	           isEmpty = true;
	       }
	       else if(qtd === ""){
	           alert("Quantidade Vazia");
	           isEmpty = true;
	       }
	       return isEmpty;
	   }
	   // add Row
	   function addHtmlTableRow()
	   {
	       // get the table by id
	       // create a new row and cells
	       // get value from input text
	       // set the values into row cell's
	       if(!checkEmptyInput()){
	       var newRow = table.insertRow(table.length),
	           cell1 = newRow.insertCell(0),
	           cell2 = newRow.insertCell(1),
	           cell3=newRow.insertCell(2),
	           cell4=newRow.insertCell(3),
	           uten = document.getElementById("uten").value,
	           qtd = document.getElementById("qtd").value;
	   			var preco= parseFloat(document.getElementById('preco').value, 10);
	   			var qtdC=parseFloat(document.getElementById('qtd').value, 10);
	   			var valorFinal=preco*qtdC;
	   			var lixo = "<td class='text-left'><button type='button'onclick='deleteRow(this)'><i class='far fa-trash-alt'></i></button></a></td>";
	       cell1.innerHTML = uten;
	       cell2.innerHTML = qtd;
	       cell3.innerHTML= valorFinal;
	       cell4.innerHTML=lixo;
	       // call the function to set the event to the new row
	       selectedRowToInput();
	   }
	   }
	   
	   // display selected row data into input text
	   function selectedRowToInput()
	   {
	       for(var i = 1; i < table.rows.length; i++)
	       {
	           table.rows[i].onclick = function()
	           {
	             // get the seected row index
	             rIndex = this.rowIndex;
	             document.getElementById("uten").value = this.cells[0].innerHTML;
	             document.getElementById("qtd").value = this.cells[1].innerHTML;
	             document.getElementById("preco").value = this.cells[2].innerHTML;
	           };
	       }
	   }
	   selectedRowToInput();
       function editHtmlTbleSelectedRow()
       {
           var uten = document.getElementById("uten").value,
               qtd = document.getElementById("qtd").value;
          	 var preco= parseFloat(document.getElementById('preco').value, 10);
  			var qtdC=parseFloat(document.getElementById('qtd').value, 10);
  			var valorFinal=preco*qtdC;
          if(!checkEmptyInput()){
           table.rows[rIndex].cells[0].innerHTML = uten;
           table.rows[rIndex].cells[1].innerHTML = qtd;
           table.rows[rIndex].cells[2].innerHTML = valorFinal;
         }
       }
       
	   function deleteRow(r) {
		    var i = r.parentNode.parentNode.rowIndex;
		    document.getElementById("table").deleteRow(i);
		}
	</script>
	
	
	<script>
		var Index,
	    table1 = document.getElementById("table1");
		 function checkEmptyInput1()
		   {
		       var isEmpty = false,
		           prod = document.getElementById("produto").value,
		           qtd = document.getElementById("quant").value;
		       if(prod === ""){
		           alert("Produto Vazio, impossivel add");
		           isEmpty = true;
		       }
		       else if(qtd === ""){
		           alert("Quantidade Vazia");
		           isEmpty = true;
		       }
		       return isEmpty;
		   }
	   // add Row
	   function addHtmlTableRow1()
	   {
	       // get the table by id
	       // create a new row and cells
	       // get value from input text
	       // set the values into row cell's
	       if(!checkEmptyInput1()){
	       var newRow1 = table1.insertRow(table1.length),
	           cel1 = newRow1.insertCell(0),
	           cel2 = newRow1.insertCell(1),
	           cel3=newRow1.insertCell(2),
	           cel4=newRow1.insertCell(3),
	           prod = document.getElementById("produto").value,
	           quant = document.getElementById("quant").value;
	   			var preco1= parseFloat(document.getElementById('price').value, 10);
	   			var qtdC=parseFloat(document.getElementById('quant').value, 10);
	   			var valorFinal1=preco1*qtdC;
	   			var lixo = "<td class='text-left'><button type='button'onclick='deleteRow1(this)'><i class='far fa-trash-alt'></i></button></a></td>";
	       cel1.innerHTML = prod;
	       cel2.innerHTML = quant;
	       cel3.innerHTML= valorFinal1;
	       cel4.innerHTML=lixo;
	       // call the function to set the event to the new row
	       selectedRowToInput1();
	   }
	   }
	   
	   // display selected row data into input text
	   function selectedRowToInput1()
	   {
	       for(var i = 1; i < table1.rows.length; i++)
	       {
	           table1.rows[i].onclick = function()
	           {
	             // get the seected row index
	             Index = this.rowIndex;
	             document.getElementById("produto").value = this.cells[0].innerHTML;
	             document.getElementById("quant").value = this.cells[1].innerHTML;
	             document.getElementById("price").value = this.cells[2].innerHTML;
	           };
	       }
	   }
	   selectedRowToInput1();
       function editHtmlTbleSelectedRow1()
       {
           var prod = document.getElementById("produto").value,
               quant = document.getElementById("quant").value;
          	 var preco1= parseFloat(document.getElementById('price').value, 10);
  			var qtdC=parseFloat(document.getElementById('quant').value, 10);
  			var valorFinal1=preco1*qtdC;
          if(!checkEmptyInput()){
           table1.rows[rIndex].cells[0].innerHTML = prod;
           table1.rows[rIndex].cells[1].innerHTML = quant;
           table1.rows[rIndex].cells[2].innerHTML = valorFinal1;
         }
       }
       
	   function deleteRow1(r) {
		    var i = r.parentNode.parentNode.rowIndex;
		    document.getElementById("table1").deleteRow(i);
		}
	</script>
	
</body>
</html>