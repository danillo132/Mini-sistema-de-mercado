
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Market System</title>
<link rel="stylesheet" href="resources/css/estilo.css">
</head>
<body>


	<div class="login-page">

		<div class="form">
		<h3>Market System</h3>
	<img alt="" src="resources/img/carrinho.png">
			<form action="LoginServlet" method="post" class="login-form">
			<input  type="hidden"  readonly="readonly" id="url" name="url" value="<%= request.getParameter("url") %>">
				Login: <input type="text" id="login" name="login"
					placeholder="Email"> <br> Senha: <br>
				<input type="password" id="senha" name="senha"
					placeholder="Password"> <br>
				<button type="submit" value="logar">Logar</button>
			</form>
		</div>
	</div>



</body>
</html>