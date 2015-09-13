<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page pageEncoding="UTF-8"%>


<div id="articles_container">
	<c:forEach var="article" items="${articles}">
		<tiles:insertTemplate template="article_layout.jsp"  flush="false" >
			<tiles:putAttribute name="articleId" value="${article._id}"/>
		    <tiles:putAttribute name="articleContent" value="${article.publishedContent}"/>
		    <tiles:putAttribute name="articlePublished" value="${article.publishable}"/>
		</tiles:insertTemplate>
	</c:forEach>
</div>

<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />" charset="utf-8"></script>
<script src="<c:url value="/jsBridge" />"></script>
<script src="<c:url value="/resources/js/article.js" />"></script>