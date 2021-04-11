<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Telefones</title>
<link rel="stylesheet" href="resources/css/cadastroTelefones.css">




</head>
<body>

	<div class="menu">
<table class="menu2">
<tr>
<td >	<a href="acessoliberado.jsp"><img alt="home"
		src="resources/img/homie.png"></a></td>
		
		<td>MARKET SYSTEM</td>
		<td><a href="index.jsp"><img alt="logout"
		src="resources/img/logout.png"></a></td>
</tr>

</table>
</div>


	<div class="login-page">
		<h3>${msg}</h3>
		
		<div class="form">
			<h2>Cadastro de telefones</h2>

			<form action="salvarTelefones" method="post" class="login-form"
				id="formUser">
				<table>
					<tr>
						<td>User:</td>
						<td><input type="text" readonly="readonly" id="id" name="id"
							class="field-long" value = "${userEscolhido.id}"></td>

					</tr>
					
					<tr>
						<td>Nome user:</td>
						<td><input type="text" readonly="readonly" id="nome" name="nome"
							class="field-long" value = "${userEscolhido.nome}"></td>

					</tr>
					
						
					<tr>
						<td>Número:</td>
						<td><input type="text" id="numero" name="numero"
							class="field-long"  required="required" placeholder="(DDD) + Número"></td>

					</tr>
					
					
					<tr>
						<td>Tipo:</td>
						<td>
						<select id="tipo" name="tipo">
						 <option>Casa</option>
						 <option>Contato</option>
						 <option>Celular</option>
						
						</select>
						</td>
						
					</tr>

				</table>

				<button type="submit" value="Salvar">Salvar</button>
				<br>
				<br>
				<a href="salvarUsuario?acao=listartodos"><button type="button">Voltar</button></a>
				<br> <br>
				
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
							<th>Número</th>
							<th>Tipo</th>
							<th>Delete</th>

						</tr>
						<c:forEach items="${telefones}" var="fone">
							<tr>

								<td style="width: 150px"><c:out value="${fone.id}"></c:out></td>
								<td style="width: 150px"><c:out value="${fone.numero}"></c:out>
								</td>
								<td style="width: 150px"><c:out value="${fone.tipo}"></c:out></td>
								


								<td><a href="salvarTelefones?acao=deleteFone&foneId=${fone.id}" onclick="return confirm('Confirmar a exclusão?')">
										<img alt="" src="resources/img/favicon.ico" title="Excluir">
								</a></td>
							

							</tr>
						</c:forEach>

					</table>
				</div>
			</div>
		</div>
	</div>



</body>
</html>