<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ page pageEncoding="UTF-8"%>


<div id="articles_container">
	<c:url value="/admin/deleteArticle" var="deleteArticle" />
	
	<c:forEach var="article" items="${articles}">
		<div class="content">
			<img style="float: left; vertical-align: middle; margin: 0 10px 0 0;" src="<c:url value="/resources/images/home.png" />" alt="home" />
			<form name="deleteArticleForm" method="post" action="${deleteArticle}">
				<input name="articleId" type="hidden" value="${article.id}"/>
				<input style="float: right ;" type="submit" value="Sil" style="width: 50px; height: 30px;">		
			</form>
			<input name="displayForEditButton" style="float: right ;" type="button" value="Güncelle" style="width: 100px; height: 30px;">
			${article.content}
		</div>
	</c:forEach>
</div>

<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />" charset="utf-8"></script>
<script src="<c:url value="/jsBridge" />"></script>
<script src="<c:url value="/resources/js/article.js" />"></script>