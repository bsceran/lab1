<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<header>
<c:url value="/logout" var="logoutUrl" />
<c:url value="/admin/displayAddArticlePage" var="displayAddArticlePage" />

<form action="${logoutUrl}" method="post" id="logoutForm" >
	<input 	type="hidden"
			name="${_csrf.parameterName}"
			value="${_csrf.token}" />
</form>

	<div id="logo">
		<div id="logo_text">
			<!-- class="logo_colour", allows you to change the colour of the text -->
			<h1>
				<a href="index.html"><span class="logo_colour">SUEDA</span>'nın Sayfası</a>
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
	                </ul>
				</li>
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
                  </ul>
                </li>
                <li><a href="#">Drop Down Three</a></li>
                <li><a href="#">Drop Down Four</a></li>
                <li><a href="#">Drop Down Five</a></li>
              </ul>
            </li>
				<li >
				 <a  id="loginButton"></a>
				 <ul>
                    <li id="addArticleButtonBar">
                    <a id="addArticleButton" href="${displayAddArticlePage}">Konu ekle</a>
                    </li>
                    <li id="logoutButtonBar">
                    <a id="logoutButton" href="javascript:document.getElementById('logoutForm').submit()">Çıkış yap</a>
                    </li>
                    <li id="registerButtonBar">
                    <a id="registerButton">Kayıt ol</a>
                    </li>
                  </ul>
				</li>
			</ul>
		</div>
	</nav>
</header>


<input type="hidden" id="username" name="username" value="${pageContext.request.userPrincipal.name}"/>