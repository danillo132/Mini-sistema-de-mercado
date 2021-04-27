<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Produtos</title>
  <script src="resources/javascript/jquery.min.js" type="text/javascript"></script>
  <script src="resources/javascript/jquery.maskMoney.min.js" type="text/javascript"></script>

<link rel="stylesheet" href="resources/css/cadastroProdutos.css">
</head>
<body>

<div class="menu">
<table class="menu2">
<tr>
<td >	<a href="acessoliberado.jsp"><img alt="home"
		src="resources/img/homie.png"></a></td>
		
		<td>MARKET SYSTEM</td>
		<td><a href="salvarProdutos?deslogar=true"><img alt="logout"
		src="resources/img/logout.png"></a></td>
</tr>

</table>
</div>

	<div class="prod-page">
		<h3 style="color: #FFFFFF;">${msg}</h3>
		<div class="form">

			<h2>Cadastro de produtos</h2>
			<form action="salvarProdutos" method="post" class="prod-form"
				id="formProd">
				<table>
					<tr>
						<td>Código:</td>
						<td><input type="text" id="id" name="id" readonly="readonly"
							value="${prod.id}" class="field-long"></td>
					</tr>
					<tr>
						<td>Nome:</td>
						<td><input type="text" id="nome" name="nome"
							required="required" placeholder="Nome do produto"
							value="${prod.nome}" maxlength="100"></td>
					</tr>
					<tr>
						<td>Quantidade:</td>
						<td><input type="text" id="qtd" name="qtd"
							placeholder="total de produtos" required="required"
							value="${prod.qtd}" maxlength="10"></td>
					</tr>
					<tr>
						<td>Valor:</td>
						<td><input type="text" id="valor" name="valor"
							placeholder="Preço do produto" required="required"
							value="${prod.valorEmTexto}" maxlength="12" ></td>
					</tr>

					<tr>
					<td>Categoria:</td>
					<td>
					<select id="categorias" name="categoria_id">
					<c:forEach items="${categoria}" var="cat"> 
					<option value="${cat.id}" id="${cat.id}"
					<c:if test="${cat.id == prod.categoria_id}">
					<c:out value="selected=selected"></c:out>
					</c:if>
					
					
					
					>${cat.nome}</option>
					</c:forEach>
					</select>
					
					</td>
					</tr>

				</table>

				<button type="submit" value="Salvar">Salvar</button>
				<br> <br>
				<button type="submit" value="Cancelar"
					onclick="document.getElementById('formProd').action = 'salvarProdutos?acao=reset'">Cancelar
				</button>

			</form>



		</div>

	</div>
	
		<div class="consult-prod">
		<h3 style="color: white;">${pesquisa}</h3>
		
		<div class="consult-produto">

			<h3>Pesquisar Produto</h3>

			<form action="ServletPesquisaProduto" method="post" class="consult-form"
				id="formConsult" >
				<table>
					<tr>
						<td>Descrição: </td>
						<td> <input  class="descricao" type="text" id="descricaoconsulta" name="descricaoconsulta" placeholder="Nome do Produto"></td>
						<td> <button type="submit" value="pesquisar"> Pesquisar</button> </td>
					</tr>
					


				</table>

				
			
				
			</form>
		</div>
	</div>
	

	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">

					<table class="tabela">
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Quantidade</th>
							<th>Categoria</th>
							<th>Preço</th>
							<th>Excluir</th>
							<th>Editar</th>
						</tr>
						<c:forEach items="${produtos}" var="prod">
							<tr>

								<td style="width: 150px"><c:out value="${prod.id}"></c:out></td>
								<td style="width: 150px"><c:out value="${prod.nome}"></c:out>
								</td>
								<td style="width: 150px"><c:out value="${prod.qtd}"></c:out></td>
								<td style="width: 150px"><c:out value="${prod.categoria_id}"></c:out></td>
								<td style="width: 150px">R$ <fmt:formatNumber type="number" maxFractionDigits="2" value="${prod.preco}">
								</fmt:formatNumber> </td>


								<td><a href="salvarProdutos?acao=delete&prod=${prod.id}" onclick="return confirm('Confirmar a exclusão?')">
										<img alt="" src="resources/img/favicon.ico" title="Excluir">
								</a></td>
								<td><a href="salvarProdutos?acao=editar&prod=${prod.id}">
										<img alt="" src="resources/img/editar.ico" title="Editar">
								</a></td>

							</tr>
						</c:forEach>


					</table>

				</div>
			</div>

		</div>

	</div>




</body>

<script type="text/javascript">

$(function() {
    $('#valor').maskMoney({prefix:'R$ ', allowNegative: true, thousands:'.', decimal:',', affixesStay: false});
  })
  
  $(document).ready(function() {
  $("#qtd").keyup(function() {
      $("#qtd").val(this.value.match(/[0-9]*/));
  });
});

</script>



</html>