<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Imagens</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js">
</script>

<link rel="stylesheet" href="resources/css/upload.css">
</head>
<body>

<input type="file" id="file" name="file" onchange="uploadFile();">
<br>
<img alt="imagem" src="" id="target" class="img">
</body>

<script type="text/javascript">

function uploadFile() {
	

	var target = document.querySelector("img");
	var file = document.querySelector("input[type=file]").files[0];
	
	var reader = new FileReader();
	
	reader.onloadend = function () {
		target.src = reader.result;
		
		$.ajax({
			method: "POST",
			url: "FileUpload",  // para qual servlet?
			data: { fileUpload : 	target.src}
		}).done(function(response){ // resposta ok - nenhum erro
			alert("Sucesso " + response);
			//Fazer algo
		}).fail(function (xhr, status, errorThrown) { // resposta erro - problema ocorreu
				alert("Ocorreu um erro: " + xhr.responseText);
				//Fazer algo
		});
	};
	
	if(file){
		reader.readAsDataURL(file);
		
		//----------UPLOAD AJAX
		
		
		
	}else{
		target.src="";
	}
	
}

</script>
</html>