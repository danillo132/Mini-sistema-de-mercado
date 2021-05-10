<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="resources/javascript/fullcalendar.min.css">
<link href="resources/javascript/fullcalendar.print.min.css"
	rel="stylesheet" media='print' />
<script src='resources/javascript/moment.min.js'></script>
<script src='resources/javascript/jquery.min.js'></script>
<script src='resources/javascript/fullcalendar.min.js'></script>


<title>Calendário</title>

<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	color: #FFFFFF; font-size : 14px;
	background: #212025; /* fallback for old browsers */
	background: -webkit-linear-gradient(center, #FFFFFF, #121214);
	background: -moz-linear-gradient(right, #121214, #121214);
	background: -o-linear-gradient(right, #121214, #8DC26F);
	background: linear-gradient(to left, #121214, #121214);
	font-family: "Roboto", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}

#title {
	font-size: 36px;
	text-align: center;
}
</style>
</head>
<body>

	<h1 id="title">Calendário</h1>
	<div id='calendar'></div>
</body>
<script>


$(document).ready(function() {
	$.get("BuscarCalendariosDatas", function(response) { // inicio ajax get servlet

		
		var  datas = JSON.parse(response);
	
	
	/*datas = {
			title : 'All Day Event',
			start : '2017-02-01'
	};*/
		
		

			$('#calendar').fullCalendar({
				header : {
					left : 'prev,next today',
					center : 'title',
					right : 'month,basicWeek,basicDay'
				},
				defaultDate : '2021-04-28',
				navLinks : true, // can click day/week names to navigate views
				editable : true,
				eventLimit : true, // allow "more" link when too many events
				events : 
					datas
				 
			});
			
		}); ///FIM do ajax get

	});
</script>
</html>