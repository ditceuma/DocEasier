<%@ tag language="java" description="Tag Principal"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Teste</title>
<meta charset="UTF-8">
<link href="<c:url value='/resources/css/bootstrap.min.css'/>"rel="stylesheet" type="text/css">
<link href="<c:url value='/resources/css/bootstrap-timepicker.min.css'/>"rel="stylesheet" type="text/css">
<link href="<c:url value='/resources/css/style.css'/>"rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<div class="logo">
				<img src="<c:url value='/resources/images/uniceuma_logo.jpg'/>"/>
			</div>
			<h1>Documentação de API's - Serviços Online v2</h1>
		</div>
		<jsp:doBody />
	</div>
</body>

	<script type="text/javascript"src="<c:url value='/resources/js/jquery-3.1.1.min.js'/>"></script>
	<script type="text/javascript"src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
	<script type="text/javascript"src="<c:url value='/resources/js/bootstrap-timepicker.min.js'/>"></script>
	<script type="text/javascript"src="<c:url value='/resources/js/ajaxRequest.js'/>"></script>
	<script type="text/javascript"src="<c:url value='/resources/js/jquery.tmpl.js'/>"></script>
	
	<script type="text/javascript">
		$('#hora').timepicker();
	</script>
</html>
