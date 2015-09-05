<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
  <title>Sueda'nin Blogu</title>
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>

<body>

	<div id="register-div">
		<a id="close" href="javascript:displayRegisterDialog(false)" style="display:none">X</a>

		<h2>Sisteme Kayıt</h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<c:url value="/registerRequest" var="registerRequest" />
		<s:form id="registerForm" method="post" commandName="account" action="${registerRequest}">

		    <table>
			<tr>
				<td>Kullanıcı adı</td>
				<td><s:input path="username" id="username" /></td>
			</tr>
			<tr>
				<td>Şifre</td>
				<td><s:password path="password" id="password" /></td>
			</tr>
			<tr>
				<td>Şifre tekrar</td>
				<td><s:password path="password2" id="password2" /></td>
			</tr>
			<tr>
				<td></td>
		        <td><input name="submit" type="submit" value="Kayıt ol"></td>
			</tr>
		   </table>

		 <input type="hidden" 
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
	</s:form>
	</div>
</body>
</html>