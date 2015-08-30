<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
  <title>Sueda'nin Blogu</title>
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>

<body>
	<table cellpadding="2" cellspacing="2">
		<tr>
			<td>Kullanici adi</td>
			<td>${registeredAccount.username}</td>
		</tr>
		<tr>
			<td>Sifre</td>
			<td>${registeredAccount.password}</td>
		</tr>
	</table>
</body>
</html>