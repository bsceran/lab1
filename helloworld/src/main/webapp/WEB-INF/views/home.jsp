<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<link href="<c:url value="/resources/css/w35.css" />" rel="stylesheet">
	 <script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
	 <script src="<c:url value="/resources/js/main3.js" />"></script>
	<title>Home</title>
</head>
<body>
<header class="w3-container w3-red">
<h1>MErhabalarrrr523</h1>
</header>

<P>  The time on the servers is ${serverTime}. </P>
<p> THis is the message ${theMessage} </p>
<div id="msg"></div>
</body>
</html>
