<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="resources/css/relatorios.css">
<title>Relatórios</title>
</head>
<body>

	<div class="login-page">

		<div class="form">
			<h3>Relatórios</h3>

			<table>

				<tr>
					<td><a href="ServletDownloadFile?tipoExportar=pdf"> <img alt="relatorios_usuarios"
							src="resources/img/pdf.png"></a> </td>
					<td><a href="ServletDownloadFile?tipoExportar=xls"> <img alt="relatorios_usuarios"
							src="resources/img/excel.png"></a></td>
				</tr>
				
				<tr>
				<td>Relatório de usuários(PDF)</td>
					<td>Relatório de usuários(EXCEL)</td>
				</tr>
				<tr>
					<td><a href="acessoliberado.jsp"> <img alt="menu"
							src="resources/img/homie2.png">
					</a></td>
					<td><a href="LoginServlet?deslogar=true"><img alt="logout"
							src="resources/img/logout.png"></a></td>
							
							
				<tr>
					
					<td>Menu</td>
					<td>Sair</td>
				</tr>

			</table>


		</div>


	</div>

</body>
</html>