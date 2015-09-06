<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>


<div id="articles_container">
	<c:forEach var="article" items="${articles}">
		<div class="content">
			<img style="float: left; vertical-align: middle; margin: 0 10px 0 0;" src="<c:url value="/resources/images/home.png" />" alt="home" />		
			${article.content}
		</div>
	</c:forEach>
</div>
