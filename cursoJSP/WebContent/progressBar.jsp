<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Barra de progresso</title>
<link rel="stylesheet" href="resources/css/progressBar.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>

<h1>Exemplo com JavaScript</h1>

<div id="myprogress"> <!--  fundo da barra de progresso -->
<div id="myBar"> <!-- barra de progresso -->

</div>


</div>
<br>
<br>

<button onclick="exibirBarra();"> Iniciar a Barra de progresso</button>


<h1>Barra de progresso com JQuery</h1>
<div  id="progressbar">
	<div class="progress-label">
		Carregando...
	</div>
</div>
</body>

<script type="text/javascript">

// SCRIPT DA BARRA DE PROGRESSO POR JAVASCRIPT

function exibirBarra() {
	
	var elem = document.getElementById("myBar");
	var width  = 1;
	var id = setInterval(frame, 10);
	
	function frame() {
		if(width >= 100){
			clearInterval(id);
		}else{
			width++;
			elem.style.width = width + "%";
		}
		
	}
}

// SCRIPT DE BARRA DE PROGRESSO COM JQUERY

$(function() {
	var progressbar = $("#progressbar"), progresslabel = $(".progress-label");
	progressbar.progressbar ({ // CRIA A BARRA NO DIV
		value : false,
		change : function () {
			progresslabel.text(progressbar.progressbar('value') + "%");
		},
		complete : function () {
			progresslabel.text('Completo!');
		}
	});
	
	function progress() {
		var val = progressbar.progressbar("value") || 0;
		progressbar.progressbar("value", val + 2);
		
		if( val < 99){
			setTimeout(progress, 80);
		}
	}
	
	setTimeout(progress, 2000); // CHAMADO AO ABIR A TELA
	
});

</script>
</html>