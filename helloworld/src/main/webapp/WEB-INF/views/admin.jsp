<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Title: ${title}</h1>
<h1>Message: ${message}</h1>

<c:url value="/logout" var="logoutUrl" />

<form action="${logoutUrl}" method="post" id="logoutForm" >
	<input 	type="hidden"
			name="${_csrf.parameterName}"
			value="${_csrf.token}" />
</form>

<script type="text/javascript">
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>

<h2>${userName} 
| <a href='javascript:formSubmit()' > Logout</a> 
| <a href='<c:url value="/index.html" />' > Anasayfa</a>
</h2>



</body>
</html>