<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page pageEncoding="UTF-8"%>


<c:url value="/admin/deleteArticle" var="deleteArticle" />
<c:url value="/admin/publishArticle" var="publishArticle" />
<c:url value="/admin/unpublishArticle" var="unpublishArticle" />
<div class="content">
	<img style="float: left; vertical-align: middle; margin: 0 10px 0 0;" src="<c:url value="/resources/images/home.png" />" alt="home" />
	<form name="publishArticleForm" method="post" action="${publishArticle}">
		<input name="articleId" type="hidden" value="<tiles:getAsString name='articleId'/>"/>
		<input name="articlePublished" type="hidden" value="<tiles:getAsString name='articlePublished'/>"/>
		<input style="float: right ;" type="submit" value="Yayınla" style="width: 50px; height: 30px;">		
	</form>
	<form name="unpublishArticleForm" method="post" action="${unpublishArticle}">
		<input name="articleId" type="hidden" value="<tiles:getAsString name='articleId'/>"/>
		<input name="articlePublished" type="hidden" value="<tiles:getAsString name='articlePublished'/>"/>
		<input style="float: right ;" type="submit" value="Yayından kaldır" style="width: 50px; height: 30px;">		
	</form>
	<form name="deleteArticleForm" method="post" action="${deleteArticle}">
		<input name="articleId" type="hidden" value="<tiles:getAsString name='articleId'/>"/>
		<input style="float: right ;" type="submit" value="Sil" style="width: 50px; height: 30px;">		
	</form>
	<input name="displayForEditButton" style="float: right ;" type="button" value="Güncelle" style="width: 100px; height: 30px;">
	<tiles:insertAttribute name="articleContent" flush="true"/>
</div>
