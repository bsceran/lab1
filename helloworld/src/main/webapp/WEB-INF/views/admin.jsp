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

<h2>${userName} 
| <a href='<c:url value="/j_spring_security_logout" />' > Logout</a> 
|   <a href='<c:url value="/index.html" />' > Anasayfa</a>
</h2>



</body>
</html>