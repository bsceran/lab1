<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<header>
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
				<li><a href="contact.html">Contact Us</a></li>
			</ul>
		</div>
	</nav>
</header>