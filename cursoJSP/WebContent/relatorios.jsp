<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="resources/css/relatorios.css">
<title>Relat�rios</title>
</head>
<body>

	<div class="login-page">

		<div class="form">
			<h3>Relat�rios</h3>

			<table>

				<tr>
					<td><a href="ServletDownloadFile?tipoExportar=pdf"> <img alt="relatorios_usuarios"
							src="resources/img/pdf.png"></a> </td>
					<td><a href="ServletDownloadFile?tipoExportar=xls"> <img alt="relatorios_usuarios"
							src="resources/img/excel.png"></a></td>
				</tr>
				
				<tr>
				<td>Relat�rio de usu�rios(PDF)</td>
					<td>Relat�rio de usu�rios(EXCEL)</td>
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