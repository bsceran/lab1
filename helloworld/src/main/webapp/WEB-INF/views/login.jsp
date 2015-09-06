<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body onload='document.loginForm.username.focus();'>

	<div id="login-div">
		<a id="close" href="javascript:displayLoginDialog(false)" style="display:none">X</a>

		<h2>Sisteme Giriş</h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
		    action="<c:url value='login' />" method='POST'>

		    <table>
			<tr>
				<td>Kullanıcı adı</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Şifre</td>
				<td><input type='password' name='password' /></td>
			</tr>
			
			<tr>
				<td></td>
		        <td><input name="submit" type="submit" value="Giriş yap"></td>
			</tr>
		   </table>

		   <input type="hidden" 
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
	
	<input type="hidden" id="contextPath" name="contextPath" value="${contextPath}"/>

<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
  <script src="<c:url value="/resources/js/jquery.easing-sooper.js" />"></script>
  <script src="<c:url value="/resources/js/jquery.sooperfish.js" />"></script>
  <script src="<c:url value="/resources/js/loginform.js" />"></script>
</body>
</html>