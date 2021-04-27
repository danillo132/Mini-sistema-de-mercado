<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DataTable JQuery</title>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script  src="//cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js">
	
</script>

</head>
<body>
	<table id="example" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>LOGIN</th>
				<th>NOME</th>
				<th>FUNÇÃO</th>
				<th>TELEFONE</th>
				<th>SEXO</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				
			</tr>
			
			
		</tbody>
		
	</table>

</body>

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": "CarregarDadosDataTable"
    } );
} );
</script>
</html>