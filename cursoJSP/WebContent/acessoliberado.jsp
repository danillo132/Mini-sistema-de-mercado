<jsp:useBean id="calcula" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page"></jsp:useBean>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Market System</title>
<link rel="stylesheet" href="resources/css/acessoliberado.css">
</head>
<body>






<div class="login-page">

		<div class="form">
		<h3>Bem-vindo ao sistema</h3>
		<table>
		<tr>
		<td>
			<a href="salvarUsuario?acao=listartodos"><img alt="Login" src="resources/img/form.png" class="img"> </a>
			</td>
			<td>
			<a href="salvarProdutos?acao=listarprodutos"><img alt="produtos" src="resources/img/produtos.png" class="img"></a>
			
	</td>
	
	
	<td>
<a href="LoginServlet?deslogar=true"><img alt="logout" src="resources/img/logout.png"></a>
			</td>
			</tr>	
			<tr>
			<td>Cadastro usuários</td><td>Cadastro produtos</td><td>Sair</td><td> <a href="paginaPai.jsp">Load page</a></td>
			<td> <a href="upload.jsp">uploads imgs</a></td>
			<td> <a href="dataTable.jsp">DataTable JQuery</a></td>
			</tr>		
	
</table>

					</div>
	</div>
<br>



</body>
</html>