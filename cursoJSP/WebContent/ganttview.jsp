<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="resources/scriptGranttView/jquery-ui-1.8.4.css">
	<link rel="stylesheet" type="text/css" href="resources/scriptGranttView/reset.css" />
	<link rel="stylesheet" type="text/css" href="resources/scriptGranttView/jquery.ganttView.css">

<script type="text/javascript" src="resources/scriptGranttView/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="resources/scriptGranttView/date.js"></script>
	<script type="text/javascript" src="resources/scriptGranttView/jquery-ui-1.8.4.js"></script>
	<script type="text/javascript" src="resources/scriptGranttView/jquery.ganttView.js"></script>

<title>Gantt View</title>

<style type="text/css">
		body {
			font-family: tahoma, verdana, helvetica;
			font-size: 0.8em;
			padding: 10px;
		}
	</style>
</head>
<body>

<h1>Gantt View</h1>


	<div id="ganttChart"></div>
	<br/><br/>
	<div id="eventMessage"></div>
</body>
<script type="text/javascript">



$(document).ready(function() {
$.get("BuscarDatasPlanejamento", function(response) {

  var ganttDataResposta =  JSON.parse(response);
	
	var ganttData =  "";
	ganttData +=  "[";
	
	
		
		
		$.each(ganttDataResposta, function(index, beanProjeto) {
			
			
			ganttData += "{ \"id\": \""+beanProjeto.id+"\", \"name\": \""+beanProjeto.nome+"\", \"series\": [";
			
			
			
			
			$.each(beanProjeto.series, function(idx, serie){
				
				var cores = "#3366FF,#00CC00".split(',');
				
				var cor;
				
				if(idx === 0){
					
					cor = "#CC33CC";
					}else{
						
						cor = Number.isInteger(idx / 2) ? cores[0] : cores[1];
						}
				
				var datainicial = serie.comeco.split('-');
				var datafinal = serie.dataFinal.split('-');
				
				ganttData += "{ \"name\": \""+serie.nome+"\", \"start\":\"" + new Date(datainicial[0], datainicial[1], datainicial[2])+"\", \"end\":\""+ new Date(datafinal[0], datafinal[1], datafinal[2])+"\", \"color\": \""+cor+"\", \"projeto\": \""+serie.projeto+"\", \"serie\": \""+serie.id+"\" }";
				
			
				
				if(idx < beanProjeto.series.length - 1){
					
					ganttData += ",";
					
				}
				
			});
			
			
			ganttData += "]}";
			
			if(index < ganttDataResposta.length - 1 ){
				ganttData += ",";
			}
			
		});
		
	ganttData += "]";
	
	ganttData = JSON.parse(ganttData);
	
	
	/*[ //INICIO
		
		
		{
			id: 1, name: "Projeto Java Web", series: [
				{ name: "Planejado", start: new Date(2021,00,05), end: new Date(2021,00,20) },
				{ name: "Atual", start: new Date(2021,00,06), end: new Date(2021,00,17), color: "#f0f0f0" },
				{ name: "Projetado", start: new Date(2021,00,06), end: new Date(2021,00,17), color: "#e0e0e0" }
			]
		} 
		
	];*/
	//Fim
	
	
		
			$("#ganttChart").ganttView({ 
				data: ganttData,
				slideWidth: 1100,
				behavior: {
					onClick: function (data) { 
						var msg = "Evento de click: { start: " + data.start.toString("M/d/yyyy") + ", end: " + data.end.toString("M/d/yyyy") + " }";
						$("#eventMessage").text(msg);
					},
					onResize: function (data) { 
						
					
						var start = data.start.toString("yyyy-M-d");
						var end = data.end.toString("yyyy-M-d");
						
						$.post( "BuscarDatasPlanejamento", { start: start, end: end, serie: data.serie, projeto: data.projeto });
						
						var msg = "Evento de redimensionar: { start: " + data.start.toString("M/d/yyyy") + ", end: " + data.end.toString("M/d/yyyy") + " }";
						$("#eventMessage").text(msg);
					},
					onDrag: function (data) { 
						
						
						var start = data.start.toString("yyyy-M-d");
						var end = data.end.toString("yyyy-M-d");
						
						$.post( "BuscarDatasPlanejamento", { start: start, end: end, serie: data.serie, projeto: data.projeto });
						
						var msg = "Evento de arrastar: { start: " + data.start.toString("M/d/yyyy") + ", end: " + data.end.toString("M/d/yyyy") + " }";
						$("#eventMessage").text(msg);
					}
				}
			});
			
			// $("#ganttChart").ganttView("setSlideWidth", 600);
	
});
});
	</script>

</html>