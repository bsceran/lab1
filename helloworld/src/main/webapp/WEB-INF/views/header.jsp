<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>

<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
  	<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />" charset="utf-8"></script>
	<script src="<c:url value="/jsBridge" />"></script>
	<script src="<c:url value="/resources/js/header.js" />"></script>
	
	<c:url value="/logout" var="logoutUrl" />
	<c:url value="/admin/displayAddArticlePage" var="displayAddArticlePage" />
</head>
  
<body>
<div id="login-dialog"></div>
<div id="register-dialog"></div>

<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>

<div id="logo">
	<div id="logo_text">
		<!-- class="logo_colour", allows you to change the colour of the text -->
		<h1>
			<a href="index.html"><span class="logo_colour">SUEDA</span>'nın
				Sayfası</a>
		</h1>
		<h2>Bu sitede Sueda hakkında bilgi ve haberleri bulabilirsiniz.</h2>
	</div>
</div>
<nav>
	<div id="menu_container">
		<ul class="sf-menu" id="nav">
			<li><a href="index.html">Home</a></li>
			<li><a href="examples.html">Examples</a></li>
			<li><a href="page.html">A Page</a>
				<ul>
					<li><a href="#">Drop Down One</a></li>
					<li><a href="#">Drop Down Two</a>
				</ul></li>
			<li><a href="another_page.html">Another Page</a>
			<li><a href="#">Example Drop Down</a>
				<ul>
					<li><a href="#">Drop Down One</a></li>
					<li><a href="#">Drop Down Two</a>
						<ul>
							<li><a href="#">Sub Drop Down One</a></li>
							<li><a href="#">Sub Drop Down Two</a></li>
							<li><a href="#">Sub Drop Down Three</a></li>
							<li><a href="#">Sub Drop Down Four</a></li>
							<li><a href="#">Sub Drop Down Five</a></li>
						</ul></li>
					<li><a href="#">Drop Down Three</a></li>
					<li><a href="#">Drop Down Four</a></li>
					<li><a href="#">Drop Down Five</a></li>
				</ul></li>
			<li><a id="loginButton"></a>
				<ul>
					<li id="addArticleButtonBar"><a id="addArticleButton"
						href="${displayAddArticlePage}">Konu ekle</a></li>
					<li id="logoutButtonBar"><a id="logoutButton"
						href="javascript:document.getElementById('logoutForm').submit()">Çıkış
							yap</a></li>
					<li id="registerButtonBar"><a id="registerButton">Kayıt ol</a></li>
				</ul></li>
		</ul>
	</div>
</nav>

</body>
</html>




